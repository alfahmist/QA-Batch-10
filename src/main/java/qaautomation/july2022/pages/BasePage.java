package qaautomation.july2022.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();

	BasePage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		this.driver = driver;
		this.explicitWait = explicitWait;
	}

	void clickAndWait(By locator) {
		driver.get().findElement(locator).click();
	}

	void setText(By locator, String text) {
		driver.get().findElement(locator).sendKeys(text);
	}

	String getText(By locator) {
		return driver.get().findElement(locator).getText();
	}
}
