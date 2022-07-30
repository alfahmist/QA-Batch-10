package qaautomation.july2022;

import org.testng.annotations.Test;

import qaautomation.july2022.pages.CommonPage;

public class CommonTest extends BaseWebTest {

	CommonPage commonPage = new CommonPage(driver, explicitWait);
	
	@Test
	public void testSwitching() {
		commonPage.openUrl("http://the-internet.herokuapp.com/login");
		commonPage.openNewTab();
		commonPage.switchWindow(1);
		commonPage.openUrl("https://google.com");
		commonPage.openNewWindow();
		commonPage.openUrl("https://twitter.com");
	}
}
