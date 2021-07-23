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
	@Test (groups = "Regression", enabled = true )
	public void testCreateAccount() throws Exception {

		UIUtilities util = new UIUtilities(driver);
		AccountPage ap = new AccountPage(driver);
		try {
			ap.userLogIn(driver, propertyReader.getUserName(), propertyReader.getUserPassword(), appName );
			ap.openTab(tabName, driver);
			util.waitAndClick(ap.getNewRecordBtn(), driver);
			util.waitAndClick(ap.getAccountCPSaveBtn(), driver);
			Assert.assertTrue(ap.getAccountCPErrorMsg().getText().contains("Account Name"), "The Account Name is a required field");
			util.waitAndClick(ap.getAccountCPAccountName(), driver);
			ap.getAccountCPAccountName().sendKeys(accountName);
			util.waitAndClick(ap.getAccountCPSaveBtn(), driver);

		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			System.out.println("Test Completed");
		}
	}

}
