package product;

import org.testng.annotations.Test;

import base.SeleniumTestBase;
import pageObjects.AccountPage;
import pageObjects.ProductExplorerPage;
import util.PropertiesFileReader;

public class VerifyProductExplorerFilter extends SeleniumTestBase{
	PropertiesFileReader propertyReader = new PropertiesFileReader();
	String appName = "E-Bikes";
	@Test (groups = { "Regression", "Product" }, enabled = true )
	public void testProductExplorerFilter() throws Throwable {
		ProductExplorerPage pe	 = new ProductExplorerPage(driver);
		pe.userLogIn(driver, propertyReader.getUserName(), propertyReader.getUserPassword(), appName );
		System.out.println("Inside of VerifyProductExplorerFilter class ");
		

	}

}
