package walmartTest;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TestMethod {
	public final Logger _log = Logger.getLogger(TestMethod.class.getName());
	
	public WebDriver _driver;
	public WebDriverWait _wait;
	public WebElementHelper _elemHelper;

	public TestMethod() {
		// Set up the location of driver
		System.setProperty("webdriver.chrome.driver", Constant.DRIVER_LOCATION);
		_driver = new ChromeDriver();
		// Maximize the window to ensure element access
		_driver.manage().window().maximize();
		// Set wait timeout in seconds
		_wait = new WebDriverWait(_driver, 10);
		_elemHelper = new WebElementHelper(_driver, _wait);
		// Direct to www.walmart.com
		_driver.get(Constant.HOMEPAGE);
		_log.info("Open walmart homepage");
	}
	
	public WebDriver getWebDriver() {
		return _driver;
	}
	
	public void clickSignInNav() {
		//_elemHelper.waitForLoad();
		_elemHelper.webElementClick(Constant.SIGN_IN_NAV);
		
		//_log.info("Click sign in link in navigation bar");
	}

	public void inputUsernameAndPasswordText(String username, String password) {
		WebElement usernameTextField = _elemHelper.getWebElement(Constant.USERNAME_TEXT);
		if (usernameTextField != null) {
			usernameTextField.clear();
			usernameTextField.sendKeys(username);
		}
		
		WebElement passwordTextField = _elemHelper.getWebElement(Constant.PASSWORD_TEXT);
		if (passwordTextField != null)
			passwordTextField.sendKeys(password);
		
		_log.info("Input the username and password");
	}

	public void clickSignInBtn() {
		_elemHelper.webElementClick(Constant.SIGN_IN_BTN);
		
		_log.info("Click sign in button");
	}
	
	public void inputSearchText(String searchText) {
		//_elemHelper.waitForLoad();
		
		_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Constant.WELCOME_ACCOUNT_TEXT)));
		
		WebElement searchTextBar = _elemHelper.getWebElement(Constant.SEARCH_TEXT);
		if (searchTextBar != null) {
			searchTextBar.clear();
			searchTextBar.sendKeys(searchText);
			
			_log.info("Input " + searchText + " into the search bar");
		}	
	}

	public void clickSearchBtn() {
		_elemHelper.webElementClick(Constant.SEARCH_BTN);
		
		_log.info("Click search button");
	}
	
	public void selectProductFromSearchList(String searchText) {
		_elemHelper.waitForLoad();

		try {
			/*Redirect to toys*/
			//_elemHelper.getWebElementAndClick(Constant.VIEW_ITEMS_URL);
			WebElement redirectLink = _driver.findElement(By.xpath(Constant.REDIRECT_URL));
			if (redirectLink != null) {
				redirectLink.click();

				_log.info("Redirect to toys");
			}
		} catch (Exception ex) {
		} finally {
			try {
				_elemHelper.waitForLoad();
				/* For common items, the result is organized in list.
				 * Select the item which does not the color selection.
				 * */
				
				//_elemHelper.getWebElementAndClick(Constant.LIST_CONTAINER_XPATH);	
				List<WebElement> productDisplay = _driver.findElements(By.xpath("//*[@id='tile-container']/div"));
				WebElement productSelected = null;
				int productListIndex = 0;
				try{
					for(productListIndex=1;productListIndex<=productDisplay.size();productListIndex++){
						WebElement productDetail = _driver.findElement(By.xpath("//*[@id='tile-container']/div["+productListIndex+"]/div/div/div[1]"));
						if(productDetail.findElement(By.className("variants")) != null){
							continue;
						}
					}
				} catch(Exception e){					
				}
				productSelected = _driver.findElement(By.xpath("//*[@id='tile-container']/div["+productListIndex+"]/div/div/h4/a"));
				_log.info(" "+productSelected);
				if (productSelected != null) {
					productSelected.click();
					
					_log.info("Select product in " + searchText);
				}
				
			} catch (Exception ex1) {
				try {
					/*For some items, the result is organized in grid*/
					//_elemHelper.getWebElementAndClick(Constant.GRID_CONTAINER_XPATH);
					
					WebElement productSelected = _driver.findElement(By.xpath(Constant.GRID_CONTAINER));
					if (productSelected != null) {
						productSelected.click();
						
						_log.info("Select product in " + searchText);
					}
				} catch (Exception ex2) {
				}
			}
		}
	}

	public String getProductId() {
		//_elemHelper.waitForLoad();
		
		WebElement webElement = _elemHelper.getWebElement(Constant.REVEIEWS_INFO);
		Assert.assertTrue(webElement != null);

		boolean isProductId = _elemHelper.isAttr(webElement,Constant.PRODUCT_ID);
		Assert.assertTrue(isProductId, "Product Id not found");
		
		String productIDAddedToCart = webElement.getAttribute(Constant.PRODUCT_ID);
		
		_log.info("Store product id ");
		
		return productIDAddedToCart;
	}
	
	public void clickAddToCart() {
		_elemHelper.webElementClick(Constant.ADD_TO_CART_BTN);
		_log.info("Click add to cart button ");
	}
	
	public void clickViewCart() {
		_driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		_elemHelper.webElementClick(Constant.VIEW_CART_BTN);
		_log.info("Click view cart button ");
	}
	
	public void validateProduct(String productId) {
		//_elemHelper.waitForLoad();
		
		_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Constant.CART_ITEM_LIST)));
		List<WebElement> cartDisplay = _driver.findElements(By.xpath(Constant.CART_ITEM_LIST));
		Assert.assertTrue(cartDisplay != null && cartDisplay.size() == 1,"Cart can only contain one product!");
			
		WebElement cartItemElement = cartDisplay.get(0);
		Assert.assertTrue(cartItemElement != null);

		WebElement cartItemInfo = cartItemElement.findElement(By.id("CartItemInfo"));
		boolean isProductIdInCart = _elemHelper.isAttr(cartItemInfo,	"data-us-item-id");
		Assert.assertTrue(isProductIdInCart, "Product not found.");

		String productIdInCart = cartItemInfo.getAttribute("data-us-item-id");
		Assert.assertEquals(productIdInCart, productId);
		
		_log.info("Validate product in cart");
	}
	
	public void removeProductFromCart() {
		//_elemHelper.waitForLoad();
		_elemHelper.webElementClick(Constant.REMOVE_BTN);
		
		_log.info("Remove product from cart");
	}
	
	public void signOut() {
		_driver.get(Constant.SIGN_OUT);
	}
}