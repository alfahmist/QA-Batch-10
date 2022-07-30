package qaautomation.july2022;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import qaautomation.july2022.pages.LoginPage;
import qaautomation.july2022.pages.LoginPageFactory;
import qaautomation.july2022.pages.ProfilePage;
import qaautomation.july2022.pages.ProfilePageFactory;

public class WebTestPageFactory extends BaseWebTest {
	
	
	String username = "tomsmith";
	String password = "SuperSecretPassword!";
	String wrongUsername = "tomsmith";
	String wrongPassword = "SuperSecretPassword!";
	
	@Test
	private void testLogin() {
		// TODO Auto-generated method stub
		LoginPageFactory loginPage = new LoginPageFactory(driver, explicitWait);
		ProfilePageFactory profilePage = new ProfilePageFactory(driver, explicitWait);
		
		driver.get().get("http://the-internet.herokuapp.com/login");
		loginPage.loginWeb(username, password);
		String actualText = profilePage.getProfileText();
		String expectedText = "You";
		String expectedText1 = "logged";
		String expectedText2 = "secure";
		Assert.assertTrue(actualText.contains(expectedText));
		Assert.assertTrue(actualText.contains(expectedText1));
		Assert.assertTrue(actualText.contains(expectedText2));

	}
	
	@Test
	public void testLoginWrongUserName() {
		LoginPageFactory loginPage = new LoginPageFactory(driver, explicitWait);
		ProfilePageFactory profilePage = new ProfilePageFactory(driver, explicitWait);

		driver.get().get("http://the-internet.herokuapp.com/login");
		loginPage.loginWeb(wrongUsername, password);
		String actualText = profilePage.getProfileText();
		String expectedText = "Your username is invalid";
		Assert.assertTrue(actualText.contains(expectedText));

	}
	
	@Test
	public void testLoginWrongPassword() {
		LoginPageFactory loginPage = new LoginPageFactory(driver, explicitWait);
		ProfilePageFactory profilePage = new ProfilePageFactory(driver, explicitWait);

		driver.get().get("http://the-internet.herokuapp.com/login");
		loginPage.loginWeb(username, wrongPassword);
		String actualText = profilePage.getProfileText();
		String expectedText = "Your password is invalid";
		Assert.assertTrue(actualText.contains(expectedText));

	}
	@Test
	public void testLoginWrongUsernameAndPassword() {
		LoginPageFactory loginPage = new LoginPageFactory(driver, explicitWait);
		ProfilePageFactory profilePage = new ProfilePageFactory(driver, explicitWait);

		driver.get().get("http://the-internet.herokuapp.com/login");
		loginPage.loginWeb(wrongUsername, wrongPassword);
		String actualText = profilePage.getProfileText();
		String expectedText = "Your username is invalid";
		Assert.assertTrue(actualText.contains(expectedText));

		
	}
}

// bikin beberapa test case penting

// positive test case username benar password benar

// negative test case username benar password salah
// negative test case username salah password benar
// negative test case username salah password salah
