package pageObjects;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ResellerOrderPage extends Page {

	public ResellerOrderPage(WebDriver driver) {
		super(driver);
	}
	public ResellerOrderPage init(WebDriver driver)throws MalformedURLException {
		ResellerOrderPage resellerOrderPage = PageFactory.initElements(driver, ResellerOrderPage.class);
		resellerOrderPage.setDriver(driver);
		return resellerOrderPage;
	}


}
