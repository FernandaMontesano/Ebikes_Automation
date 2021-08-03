package account;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
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
		UIUtilities util = new UIUtilities();
		AccountPage ap = new AccountPage(driver);
		
		try {
			ap.userLogIn(driver, propertyReader.getUserName(), propertyReader.getUserPassword(), appName );
			ap.openTab(tabName, driver);
			util.waitForElementToBeDisplayed(driver, ap.getNewRecordBtn());
			ap.getNewRecordBtn().click();
			util.waitForElementToBeDisplayed(driver, ap.getAccountCPSaveBtn());
			ap.getAccountCPSaveBtn().click();
			Assert.assertTrue(ap.getAccountCPErrorMsg().getText().contains("Account Name"), "The Account Name is a required field");
			util.waitForElementToBeDisplayed(driver, ap.getAccountCPAccountName());
			ap.getAccountCPAccountName().click();
			ap.getAccountCPAccountName().sendKeys(accountName);
			util.waitForElementToBeDisplayed(driver, ap.getAccountCPSaveBtn());
			ap.getAccountCPSaveBtn().click();

		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			System.out.println("VerifyCreateAccount Test Completed");
		}
	}

}
