package noPageObjectModel;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.SeleniumTestBase;
import pageObjects.AccountPage;
import util.PropertiesFileReader;
import util.UIUtilities;

public class VerifyAccountRequiredFieldsNoPom extends SeleniumTestBase{
	
	PropertiesFileReader propertyReader = new PropertiesFileReader();
	String appName = "E-Bikes";
	String tabName = "Accounts";
	String accountName = "Test_ACcount_"+RandomStringUtils.randomAlphanumeric(16);
	
	
	@Test (groups = { "Regression", "Account" }, enabled = true )
	public void AccountRequiredFieldsNoPom() throws Exception {
		
		UIUtilities util = new UIUtilities(driver);
		AccountPage ap = new AccountPage(driver);
			
		try {
			
			ap.userLogIn(driver, propertyReader.getUserName(), propertyReader.getUserPassword(), appName );
			ap.openTab(tabName, driver);
			util.waitForElementToBeDisplayed(driver, driver.findElement(By.xpath("//a[@title = 'New']/..")));
			driver.findElement(By.xpath("//a[@title = 'New']/..")).click();
			util.waitForElementToBeDisplayed(driver,driver.findElement(By.xpath("//button[@name = 'SaveEdit']")));
			driver.findElement(By.xpath("//button[@name = 'SaveEdit']")).click();
			Assert.assertTrue((driver.findElement(By.xpath("//div[@class='genericNotification']/following-sibling::ul//a")).getText().contains("Account Name")), "The Account Name is a required field");

		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		} 
		finally {
			System.out.println("VerifyCreateAccount Test Completed");
		}
	}
}
