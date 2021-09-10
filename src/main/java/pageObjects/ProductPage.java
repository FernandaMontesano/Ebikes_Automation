package pageObjects;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends Page{

	public ProductPage(WebDriver driver) {
		super(driver);

	}
	public ProductPage init(WebDriver driver)throws MalformedURLException {
		ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
		productPage.setDriver(driver);
		return productPage;
	}


}
