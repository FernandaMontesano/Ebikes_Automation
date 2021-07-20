package account;

import org.testng.annotations.Test;

import base.SeleniumTestBase;
import pageObjects.Page;
import util.PropertiesFileReader;

public class VerifyCreateAccount extends SeleniumTestBase{
	
  PropertiesFileReader propertyReader = new PropertiesFileReader();
	
  @Test (groups = "Regression", enabled = true )
  public void testCreateAccount() throws Exception {
  
	  Page page = new Page(driver);
	  page.userLogIn(driver, propertyReader.getUserName(), propertyReader.getUserPassword());
	  
	

  }
}
