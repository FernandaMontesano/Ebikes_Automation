package account;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import base.SeleniumTestBase;
import pageObjects.AccountPage;
import util.PropertiesFileReader;
import util.UIUtilities;

public class VerifyCreateAccount extends SeleniumTestBase{

	PropertiesFileReader propertyReader = new PropertiesFileReader();
	String appName = "E-Bikes";
	String tabName = "Accounts";
	String accountName = "Test_ACcount_"+RandomStringUtils.randomAlphanumeric(16);
	
	
	@Test (groups = { "Regression", "Account" }, enabled = true )
	public void testCreateAccount() throws Exception {
		
		UIUtilities util = new UIUtilities(driver);
		AccountPage ap = new AccountPage(driver);
		
		try {
			ap.userLogIn(driver, propertyReader.getUserName(), propertyReader.getUserPassword(), appName );
			ap.openTab(tabName, driver);
			util.waitForElementToBeDisplayed(driver, ap.getNewRecordBtn());
			ap.getNewRecordBtn().click();
			util.waitForElementToBeDisplayed(driver, ap.getAccountCPAccountName());
			ap.getAccountCPAccountName().click();
			ap.getAccountCPAccountName().sendKeys(accountName);
			util.waitForElementToBeDisplayed(driver, ap.getAccountCPSaveBtn());
			ap.getAccountCPSaveBtn().click();

		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		} 
		finally {
			System.out.println("VerifyCreateAccount Test Completed");
		}
	}

}
