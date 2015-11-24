package walmartTest;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.WebDriver;

public class TestInMac {
	private TestMethod method;
	private WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		method = new TestMethod();
		driver = method.getWebDriver();
	}
	
	@DataProvider
	public Object[][] dp() {
		return new Object[][] {
			new Object[] { 1, "tv" },
			new Object[] { 2, "socks" },
			new Object[] { 3, "dvd" },
			new Object[] { 4, "toys" },
			new Object[] { 5, "iphone" },
		};
	}
	
	@Test(dataProvider = "dp")
	public void f(Integer n, String s) {
		// Sign in
		method.clickSignInNav();
		method.inputUsernameAndPasswordText(Constant.SIGN_IN_USERNAME, Constant.SIGN_IN_PASSWORD);
		method.clickSignInBtn();
					
		// Search item
		method.inputSearchText(s);
		method.clickSearchBtn();

		// Select item
		method.selectProductFromSearchList(s);
		
		// Store the item ID
		String productId = method.getProductId();
					
		// Add item to cart
		method.clickAddToCart();

		// View cart
		method.clickViewCart();

		// Validate item		
		method.validateProduct(productId);
					
		// Remove item from cart and sign out
		method.removeProductFromCart();
		method.signOut();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}