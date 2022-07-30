package qaautomation.july2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTest {

	WebDriver driver;

	@Test
	private void testLogin() {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://google.com");
		driver.get("http://the-internet.herokuapp.com/login");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText();
		String expectedText = "You logged into a secure area!";
		Assert.assertTrue(actualText.contains(expectedText));
		driver.quit();
	}

	@Test
	public void testLoginWrongUserName() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://the-internet.herokuapp.com/login");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmithxx");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText();
		String expectedText = "Your username is invalid!";
		Assert.assertTrue(actualText.contains(expectedText));
		driver.quit();
	}

	@Test
	public void testLoginWrongPassword() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://the-internet.herokuapp.com/login");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("xx123456");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText();
		String expectedText = "Your password is invalid!";
		Assert.assertTrue(actualText.contains(expectedText));
		driver.quit();
	}

	@Test
	public void testLoginWrongUsernameAndPassword() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://the-internet.herokuapp.com/login");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmithxx");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("xx123456");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText();
		String expectedText = "Your username is invalid!";
		Assert.assertTrue(actualText.contains(expectedText));
		driver.quit();

	}
}
