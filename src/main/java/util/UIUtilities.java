package util;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;



public class UIUtilities {
	public WebDriver driver;
	public WebDriverWait wait;

	public UIUtilities(WebDriver driver) {
		this.driver = driver;
	}


	//IMPLICIT WAIT
	/**
	 * @param millis Time in milliseconds to wait for the page to Load
	 */
	public  void waitForPageToLoad(long seconds) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	// EXPLICIT WAIT
	public  void waitForElementVisible( WebElement element) throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getXpathFromWebElement(element))));
	}
	
	//FLUENT WAIT	

	public  WebDriver waitForElementToBeDisplayed(WebDriver driver,  WebElement webElement){
		final String myElementxpath =getXpathFromWebElement(webElement);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)) 
				.ignoring(NoSuchElementException.class);

		webElement = wait.until(new Function<WebDriver, WebElement>()
		{    
			public WebElement apply(WebDriver driver)
			{   
				return driver.findElement(By.xpath(myElementxpath));
			}
		});  
		return driver;

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


	public  String getXpathFromWebElement(WebElement webElement){
		String strXpath = webElement.toString();
		if(strXpath.contains("xpath: ")){

			return (webElement.toString().substring((webElement.toString().indexOf("xpath: ")+7),(webElement.toString().length()-1)).trim());
		}
		return strXpath.trim();
	}

}
