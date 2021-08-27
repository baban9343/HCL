package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.GetDrivers;
import junit.framework.Assert;
import reusableFunctions.Reusable;

public class Login {
Reusable reusable=new Reusable();

public Login(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

@FindBy(xpath=".//*[text()='Log in to your account']")
WebElement LoginHeader;

@FindBy(xpath=".//*[text()='Email Address or Username']//following::input[1]")
WebElement EmailAddress;

@FindBy(xpath=".//*[text()='Continue']")
WebElement Continue;

@FindBy(xpath=".//*[text()='Password']//following::input[1]")
WebElement Password;

@FindBy(xpath=".//*[@alt='My Profile']")
WebElement MyProfileIcon;

@FindBy(xpath=".//*[text()='Profile']")
WebElement Profileheader;
@FindBy(xpath=".//*[text()='Log In']")
WebElement LogIN;
@FindBy(xpath=".//*[text()='Log out']")
WebElement Logout;
@FindBy(xpath=".//*[text()='Log In']")
WebElement LoginElement;
public void verifyLoginisDisplayed()
{
	reusable.waitForElementtoBeVisible(LoginHeader);
	
	boolean elementPresent=LoginHeader.isDisplayed();
	Assert.assertEquals(true, elementPresent);
	reusable.takesScreenshot(System.currentTimeMillis());
}

public void enterText(String text)
{
	reusable.enterText(text, EmailAddress);
}

public void enterPassword(String text)
{
	reusable.enterText(text, Password);
}
public void clickContinue()
{
	reusable.clickElement(Continue);
}
public void clickLogin()
{
	reusable.clickElement(LogIN);
}

public void clickLogout()
{
	reusable.clickElement(Logout);
}

public void verifymyProfileiconisDisplayed()
{
	reusable.waitForElementtoBeVisible(MyProfileIcon);
	
	boolean elementPresent=MyProfileIcon.isDisplayed();
	Assert.assertEquals(true, elementPresent);
	
	reusable.takesScreenshot(System.currentTimeMillis());
}
public void clickProfileIcon()
{
	reusable.clickElement(MyProfileIcon);
}

public void verifyProfileisdisplayed()
{
	reusable.waitForElementtoBeVisible(Profileheader);
	
	boolean elementPresent=Profileheader.isDisplayed();
	Assert.assertEquals(true, elementPresent);
	reusable.takesScreenshot(System.currentTimeMillis());
}

public void verifyLoginIconisDisplayed()
{
	reusable.waitForElementtoBeVisible(LoginElement);
	
	boolean elementPresent=LoginElement.isDisplayed();
	Assert.assertEquals(true, elementPresent);
	reusable.takesScreenshot(System.currentTimeMillis());
}

public void clickLoginicon()
{
	reusable.clickElement(LoginElement);
}
}
