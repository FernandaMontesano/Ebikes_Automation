package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageConstants.PageConstants;
import util.PropertiesFileReader;


public class Page {
	
	protected WebDriver driver;
	
	public Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Salesforce Login Page Methods. 
	
	@FindBy(name =PageConstants.USERNAME_TXT_FIELD)
	private WebElement loginPageUserName;
	public WebElement getLoginPageUserName() {
		return loginPageUserName;
	}
	@FindBy(name = PageConstants.PASSWORD_TXT_FIELD)
	private WebElement loginPagePassword;
	public WebElement getLoginPagePassword() {
		return loginPagePassword;
	}
	@FindBy(name = PageConstants.LOGIN_BTN)
	private WebElement loginPageLoginBtn;
	public WebElement getLoginPageLoginBtn() {
		return loginPageLoginBtn;
	}
	
	public WebDriver userLogIn (WebDriver driver, String username, String password) throws InterruptedException {
		PropertiesFileReader prop = new PropertiesFileReader();
		driver.get(prop.getApplicationUrl());
		getLoginPageUserName().sendKeys(username);
		getLoginPagePassword().sendKeys(password);
		getLoginPageLoginBtn().click();
		return driver;
		
	}

}
