package resellerOrder;

import org.testng.annotations.Test;

import base.SeleniumTestBase;
import pageObjects.AccountPage;
import util.PropertiesFileReader;

public class VerifyCreateOrder extends SeleniumTestBase{
	PropertiesFileReader propertyReader = new PropertiesFileReader();
	String appName = "E-Bikes";
	@Test (groups = { "Regression", "Orders" }, enabled = true )
	public void testCreateOrder() throws Throwable {

		AccountPage ap = new AccountPage(driver);
		ap.userLogIn(driver, propertyReader.getUserName(), propertyReader.getUserPassword(), appName );
		System.out.println("Inside of VerifyCreateOrder class ");
	}
}
