package qaautomation.july2022.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePageFactory extends BasePageFactory {

	@FindBy(xpath = "//div[@id='flash']")
	private WebElement profileText;
	public ProfilePageFactory(ThreadLocal<WebDriver> driver,ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver.get(), this);
	}
	
	public String getProfileText() {
		return profileText.getText();
	}

}
