package pageObjects;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductExplorerPage extends Page{

	public ProductExplorerPage (WebDriver driver) {
		super(driver);

	}	

	public ProductExplorerPage init(WebDriver driver)throws MalformedURLException {
		ProductExplorerPage productExplorerPage = PageFactory.initElements(driver, ProductExplorerPage.class);
		productExplorerPage.setDriver(driver);
		return productExplorerPage;
	}
}

