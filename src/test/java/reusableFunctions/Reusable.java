package reusableFunctions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;

import drivers.GetDrivers;
import drivers.StaticVariables;
import junit.framework.Assert;

public class Reusable {
	ConfigFileReader config = new ConfigFileReader();
	int maxWaitTime = Integer.parseInt(config.getPropertyfromPropertiesFile("MaxWaitTime"));
	public void waitForElementtoBeVisible(WebElement element)
	{
		GetDrivers.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(GetDrivers.driver, maxWaitTime);
		wait.until(ExpectedConditions.visibilityOf(element));
		GetDrivers.driver.manage().timeouts().implicitlyWait(maxWaitTime, TimeUnit.SECONDS);
	}
	
	public static void takesScreenshot(long ms)
	{
		TakesScreenshot ts=(TakesScreenshot) GetDrivers.driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File(StaticVariables.CurrentHomeDirectory+"//Automation//Screenshots//"+ms+".jpg");
		
		
		try {
			FileUtils.copyFile(source, destination);
			Reporter.addScreenCaptureFromPath(destination.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enterText(String expectedText,WebElement element)
	{
		waitForElementtoBeVisible(element);
		Actions action=new Actions(GetDrivers.driver);
		element.clear();
		action.moveToElement(element).build().perform();
		element.sendKeys(expectedText);
	}
	
	public void clickElement(WebElement element)
	{
		waitForElementtoBeVisible(element);
		Actions action=new Actions(GetDrivers.driver);
		action.moveToElement(element).click().build().perform();
	}
	
	public void highlightElement(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) GetDrivers.driver;
		js.executeScript("arguments[0].setAttribute('style',  'border: 2px solid green;');", element);
	}
	
	public void elementdisplayedorNot(WebElement element)
	{
		boolean elementPresent=element.isDisplayed();
		if(elementPresent)
		{
			System.out.println("Element is displayed");
			highlightElement(element);
			takesScreenshot(System.currentTimeMillis());
			Assert.assertEquals(true, elementPresent);
		}else
		{
			System.out.println("Element is not displayed");
			
			takesScreenshot(System.currentTimeMillis());
			Assert.assertEquals(true, elementPresent);
		}
	}
	
	public boolean elementEnabledorNot(WebElement element)
	{
		Actions action=new Actions(GetDrivers.driver);
		action.moveToElement(element).build().perform();
		boolean elementPresent=element.isEnabled();
		if(elementPresent)
		{
			System.out.println("Element is enabled");
			highlightElement(element);
			takesScreenshot(System.currentTimeMillis());
			return true;
		}else
		{
			System.out.println("Element is disabled");
			
			takesScreenshot(System.currentTimeMillis());
			return false;
		}
	}
	
	public String getElementAttribute(WebElement element,String propertyValue)
	{
		Actions action=new Actions(GetDrivers.driver);
		action.moveToElement(element).build().perform();
		String elementText=element.getAttribute(propertyValue);
		return elementText;
	}
}
