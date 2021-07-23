package pageConstants;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPageConstants {
	
	/*
	 * CP = Create Page
	 * EP = Edit Page
	 * DP = Detail Page
	 * RT = Related Tab Page
	 */
	
	/*
	 * Create Account Page elements
	 */	
	public static final String ACCOUNT_CP_ACCOUNT_NAME ="//label[text()='Account Name']/following-sibling::div/input";
	public static final String ACCOUNT_CP_RATE ="//label[text()='Rating']/parent::lightning-combobox//input";
	public static final String ACCOUNT_CP_RATE_OPTION ="//span[@title='+@RATE+']";
	public static final String ACCOUNT_CP_SAVE_BTN ="//button[@name = 'SaveEdit']";
public static final String ACCOUNT_CP_ERROR_MESSAGE = "//div[@class='genericNotification']/following-sibling::ul//a";

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
