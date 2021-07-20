package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class SeleniumTestBase {

	public WebDriver driver;

	@BeforeMethod
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
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
