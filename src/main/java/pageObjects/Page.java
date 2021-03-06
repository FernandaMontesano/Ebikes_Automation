package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageConstants.PageConstants;
import util.PropertiesFileReader;
import util.UIUtilities;


public class Page {
	
	protected WebDriver driver;
	
	public Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void getDriver(WebDriver driver) {
		this.driver = driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	//Salesforce Login Page Methods. 
	
	@FindBy(xpath =PageConstants.USERNAME_TXT_FIELD)
	private WebElement loginPageUserName;
	public WebElement getLoginPageUserName() {
		return loginPageUserName;
	}
	
	@FindBy(xpath = PageConstants.PASSWORD_TXT_FIELD)
	private WebElement loginPagePassword;
	public WebElement getLoginPagePassword() {
		return loginPagePassword;
	}
	@FindBy(xpath = PageConstants.LOGIN_BTN)
	private WebElement loginPageLoginBtn;
	public WebElement getLoginPageLoginBtn() {
		return loginPageLoginBtn;
	}
	//Salesforce app launcher
	
	@FindBy(xpath =PageConstants.APP_LAUNCHER_ICON)
	private WebElement appLauncherIcon;
	public WebElement getAppLauncherIcon() {
		return appLauncherIcon;
	}
	@FindBy(xpath =PageConstants.APP_VIEW_ALL_LNK)
	private WebElement appViewAllLnk;
	public WebElement getAppViewAllLnk() {
		return appViewAllLnk;
	}
	@FindBy(xpath =PageConstants.APP_SEARCH_TXT_FIELD)
	private WebElement appSearchField;
	public WebElement getAppSearchField() {
		return appSearchField;
	}
	@FindBy(xpath =PageConstants.APP_SEARCH_FOUND_ITEM)
	private WebElement appSearchFoundItem;
	public WebElement getAppSearchFoundItem() {
		return appSearchFoundItem;
	}
	
	//E-Bike app

	@FindBy(xpath = PageConstants.APP_PAGE_TITLE)
	private WebElement appPageTitle;
	public WebElement getAppPageTitle(String appName, WebDriver driver) {
		return appPageTitle = driver.findElement(By.xpath(PageConstants.APP_PAGE_TITLE.replace("+@APPNAME+", appName)));
	}
	@FindBy(xpath = PageConstants.APP_TAB_NAME)
	private WebElement appTabName;
	public WebElement getAppTabName(String tabName, WebDriver driver) {
		return appTabName = driver.findElement(By.xpath(PageConstants.APP_TAB_NAME.replace("+@TAB+", tabName)));
	}
	
	// Page Buttons
	
	//Create New Record
	
	
	@FindBy(xpath = PageConstants.NEW_RECORD_BTN)
	private WebElement newRecordBtn;
	public WebElement getNewRecordBtn() {
		return newRecordBtn;
	}
	
	
	public  WebDriver userLogIn (WebDriver driver, String username, String password) throws Throwable {
		UIUtilities util = new UIUtilities(driver);
		PropertiesFileReader prop = new PropertiesFileReader();
		driver.get(prop.getApplicationUrl());
		util.waitForElementToBeDisplayed(driver, getLoginPageUserName());
		getLoginPageUserName().sendKeys(username);
		util.waitForElementToBeDisplayed(driver, getLoginPagePassword());
		getLoginPagePassword().sendKeys(password);
		util.waitForElementToBeDisplayed(driver, getLoginPageLoginBtn());
		getLoginPageLoginBtn().click();
		return driver;
		
	}
	public WebDriver userLogIn (WebDriver driver, String username, String password, String appName) throws Exception {
		UIUtilities util = new UIUtilities(driver);
		PropertiesFileReader prop = new PropertiesFileReader();
		String url = prop.getApplicationUrl();
		driver.get(url);
		util.waitForElementToBeDisplayed(driver, getLoginPageUserName());
		getLoginPageUserName().sendKeys(username);
		util.waitForElementToBeDisplayed(driver, getLoginPagePassword());
		getLoginPagePassword().sendKeys(password);
		util.waitForElementToBeDisplayed(driver, getLoginPageLoginBtn());
		getLoginPageLoginBtn().click();
		openSalesforceApp(driver, "E-Bikes");
		return driver;
		
	}
	public void openSalesforceApp(WebDriver driver, String appName) throws Exception {
		UIUtilities util = new UIUtilities (driver);
		util.waitForElementToBeDisplayed(driver, getAppLauncherIcon());
		getAppLauncherIcon().click();
		util.waitForElementToBeDisplayed(driver, getAppViewAllLnk());
		getAppViewAllLnk().click();
		util.waitForElementToBeDisplayed(driver, getAppSearchField());
		getAppSearchField().sendKeys(appName);
		util.waitForElementToBeDisplayed(driver, getAppSearchFoundItem());
		getAppSearchFoundItem().click();
		Assert.assertTrue(getAppPageTitle(appName, driver).isDisplayed(), "There was a problem opening the required app.");
	}
	
	public void openTab(String tabName, WebDriver driver) throws Exception {
		
		UIUtilities util = new UIUtilities (driver);
		util.waitForElementToBeDisplayed(driver, getAppTabName(tabName, driver));
		getAppTabName(tabName, driver).click();
		util.waitForPageToLoad(4000);
		
	}
}
