package pageObjects;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageConstants.AccountPageConstants;

public class AccountPage extends Page{

	public AccountPage (WebDriver driver) {
		super(driver);
	}
	public AccountPage init(WebDriver driver)throws MalformedURLException {
		AccountPage accountPage = PageFactory.initElements(driver, AccountPage.class);
		accountPage.setDriver(driver);
		return accountPage;
	}
	/*
	 * Create Account Page elements
	 */	
	
	@FindBy(xpath = AccountPageConstants.ACCOUNT_CP_ACCOUNT_NAME)
	private WebElement accountCPAccountName;
	public WebElement getAccountCPAccountName() {
		return accountCPAccountName;
	}
	
	@FindBy(xpath = AccountPageConstants.ACCOUNT_CP_RATE)
	private WebElement accountCPRate;
	public WebElement getAccountCPRate() {
		return accountCPRate;
	}
	@FindBy(xpath = AccountPageConstants.ACCOUNT_CP_RATE_OPTION)
	private WebElement accountCPRateOption;
	public WebElement getAccountCPRateOption(String option, WebDriver driver) {
		return accountCPRateOption = driver.findElement(By.xpath(AccountPageConstants.ACCOUNT_CP_RATE_OPTION.replace("+@RATE+", option)));
	}
	@FindBy(xpath = AccountPageConstants.ACCOUNT_CP_SAVE_BTN)
	private WebElement accountCPSaveBtn;
	public WebElement getAccountCPSaveBtn() {
		return accountCPSaveBtn;
	}
	
	@FindBy(xpath = AccountPageConstants.ACCOUNT_CP_ERROR_MESSAGE)
	private WebElement accountCPErrorMsg;
	public WebElement getAccountCPErrorMsg() {
		return accountCPErrorMsg;
	}
	
	
	/*
	 * Account Detail Page elements
	 */	
	
	/*
	 * Account Edit Page elements
	 */	
	
	/*
	 *Account Related Tab Page elements
	 */
	
}
