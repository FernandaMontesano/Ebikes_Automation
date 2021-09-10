package noPageObjectModel;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import base.SeleniumTestBase;
import pageObjects.AccountPage;
import util.PropertiesFileReader;
import util.UIUtilities;

public class CreateAccountNoPom extends SeleniumTestBase{
	
	PropertiesFileReader propertyReader = new PropertiesFileReader();
	String appName = "E-Bikes";
	String tabName = "Accounts";
	String accountName = "Test_ACcount_"+RandomStringUtils.randomAlphanumeric(16);
	
	
	@Test (groups = { "Regression", "Account" }, enabled = true )
	public void testCreateAccountNoPom() throws Exception {
		
		UIUtilities util = new UIUtilities(driver);
		AccountPage ap = new AccountPage(driver);
			
		try {
			
			ap.userLogIn(driver, propertyReader.getUserName(), propertyReader.getUserPassword(), appName );
			ap.openTab(tabName, driver);
			WebElement newAccountBtn = driver.findElement(By.xpath("//a[@title = 'New']/.."));
			util.waitForElementToBeDisplayed(driver, newAccountBtn);
			newAccountBtn.click();
			util.waitForElementToBeDisplayed(driver, driver.findElement(By.xpath("//label[text()='Account Name']/following-sibling::div/input")));
			driver.findElement(By.xpath("//label[text()='Account Name']/following-sibling::div/input")).click();
			driver.findElement(By.xpath("//label[text()='Account Name']/following-sibling::div/input")).sendKeys(accountName);
			util.waitForElementToBeDisplayed(driver,driver.findElement(By.xpath("//button[@name = 'SaveEdit']")));
			driver.findElement(By.xpath("//button[@name = 'SaveEdit']")).click();
			System.out.println("The account has been created: "+ accountName );

		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		} 
		finally {
			System.out.println("VerifyCreateAccount Test Completed");
		}
	}
}
