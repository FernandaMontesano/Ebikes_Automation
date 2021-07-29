package util;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;



public class UIUtilities {

	protected WebDriver driver;
	private WebDriverWait wait;
	
	public UIUtilities (WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}

	/**
	 * @param millis Time in milliseconds to wait for the page to Load
	 */
	public  void waitForPageToLoad(long millis) {
		try {
			Thread.sleep(millis);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param driver
	 * @param element 
	 * @throws Exception
	 */
	public  void scrollToViewElement (WebDriver driver, WebElement element)throws Exception {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(500); 
		}catch (Exception e) {
			System.out.println("Error, not able to scroll to view Element");
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @param driver
	 * @param element
	 */
	public void waitForWebElement(WebDriver driver, WebElement element) {

		wait.until(ExpectedConditions.visibilityOf(element));

	}
	/*JavaScript methods*/
	public void waitAndClick (WebElement element, WebDriver driver ) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
}
