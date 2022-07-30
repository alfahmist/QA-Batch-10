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

public class WebTestAfterRefactor extends BaseWebTest {

	@Test
	private void testLogin() {
		// TODO Auto-generated method stub

		driver.get().get("https://google.com");
		driver.get().get("http://the-internet.herokuapp.com/login");
		driver.get().findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
		driver.get().findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
		driver.get().findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.get().findElement(By.xpath("//div[@id='flash']")).getText();
		String expectedText = "You logged into a secure area";
		Assert.assertTrue(actualText.contains(expectedText));

	}
	
	@Test
	public void testLoginWrongUserName() {

		driver.get().get("http://the-internet.herokuapp.com/login");
		driver.get().findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmithxx");
		driver.get().findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
		driver.get().findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.get().findElement(By.xpath("//div[@id='flash']")).getText();
		String expectedText = "Your username is invalid";
		Assert.assertTrue(actualText.contains(expectedText));

	}
	
	@Test
	public void testLoginWrongPassword() {

		driver.get().get("http://the-internet.herokuapp.com/login");
		driver.get().findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
		driver.get().findElement(By.xpath("//input[@id='password']")).sendKeys("xx123456");
		driver.get().findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.get().findElement(By.xpath("//div[@id='flash']")).getText();
		String expectedText = "Your password is invalid";
		Assert.assertTrue(actualText.contains(expectedText));

	}
	@Test
	public void testLoginWrongUsernameAndPassword() {

		driver.get().get("http://the-internet.herokuapp.com/login");
		driver.get().findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmithxx");
		driver.get().findElement(By.xpath("//input[@id='password']")).sendKeys("xx123456");
		driver.get().findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.get().findElement(By.xpath("//div[@id='flash']")).getText();
		String expectedText = "Your username is invalid";
		Assert.assertTrue(actualText.contains(expectedText));

		
	}
}

// bikin beberapa test case penting

// positive test case username benar password benar

// negative test case username benar password salah
// negative test case username salah password benar
// negative test case username salah password salah
