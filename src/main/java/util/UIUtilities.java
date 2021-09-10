package util;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	public  String getXpathFromWebElement(WebElement webElement){
	String strXpath = webElement.toString();
	if(strXpath.contains("xpath: ")){

	return (webElement.toString().substring((webElement.toString().indexOf("xpath: ")+7),(webElement.toString().length()-1)).trim());
	}
	return strXpath.trim();
	}

}
