package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class SeleniumTestBase {

	public WebDriver driver = null;

	
	@BeforeMethod(alwaysRun = true)
	public void testSetup() {
		WebDriverFactory webdrivermanager = new WebDriverFactory();
		driver = webdrivermanager.CreateBrowser();		
	}

	public WebDriver getDriver() {
		return driver;
	}
	public void setDrvier(WebDriver driver) {
		this.driver = driver;
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {

		driver.quit();
	
	}
	
}
