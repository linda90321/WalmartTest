package walmartTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementHelper {
	WebDriver _driver;
	WebDriverWait _wait;

	public WebElementHelper(WebDriver driver, WebDriverWait wait) {
		_driver = driver;
		_wait = wait;
	}
	
	public void waitForLoad() {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		_wait.until(pageLoadCondition);
	}
	
	public WebElement getWebElement(String xPath) {
		_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
		WebElement webElement = _driver.findElement(By.xpath(xPath));
		return webElement;
	}
	
	public void webElementClick(String xPath) {
		WebElement elem = getWebElement(xPath);
		if (elem != null) {
			elem.click();
		}
	}
		
	public boolean isAttr(WebElement element, String attribute) {
		Boolean flag = false;
		try {
			String value = element.getAttribute(attribute);
			if (value != null) {
				flag = true;
			}
		} catch (Exception e) {
		}

		return flag;
	}
}