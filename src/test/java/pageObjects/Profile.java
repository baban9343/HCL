package pageObjects;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;
import reusableFunctions.Reusable;

public class Profile {

	Reusable reusable=new Reusable();

	public Profile(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=".//*[text()='First name']")
	WebElement FirstNameLabel;
	
	@FindBy(xpath=".//*[text()='Last name']")
	WebElement LastName;
	
	@FindBy(xpath=".//*[text()='Public display name']")
	WebElement PublicDisplayName;
	
	@FindBy(xpath=".//*[text()='About me']")
	WebElement AboutMe;
	@FindBy(xpath=".//*[text()='First name']//following::input[1]")
	WebElement FirstNameTextbox;
	@FindBy(xpath=".//*[text()='Last name']//following::input[1]")
	WebElement LastNameTextbox;
	@FindBy(xpath=".//*[text()='Public display name']//following::input[1]")
	WebElement PublicDisplayname;
	@FindBy(xpath=".//*[text()='About me']//following::textarea[1]")
	WebElement Aboutme;
	@FindBy(xpath=".//button[text()='Save profile details']")
	WebElement Saveprofiledetails;
	@FindBy(xpath=".//h2[contains(@class,'profile-gravatar')]")
	WebElement Profileavatar;
	public void verifyAllElementsinMyProfile()
	{
		reusable.elementdisplayedorNot(FirstNameLabel);
		reusable.elementdisplayedorNot(FirstNameTextbox);
		reusable.elementdisplayedorNot(LastName);
		reusable.elementdisplayedorNot(LastNameTextbox);
		reusable.elementdisplayedorNot(PublicDisplayName);
		reusable.elementdisplayedorNot(PublicDisplayname);
		reusable.elementdisplayedorNot(AboutMe);
		reusable.elementdisplayedorNot(Aboutme);
	}
	
	public String getFirstNameText()
	{
		return FirstNameTextbox.getAttribute("value");
	}
	
	public String getLastNameText()
	{
		return LastNameTextbox.getAttribute("value");
	}
	public String getPublicDisplayName()
	{
		return PublicDisplayname.getAttribute("value");
	}
	
	public void enterTextinFirstName(String text)
	{
		reusable.enterText(text, FirstNameTextbox);
	}
	
	public void enterTextinLastName(String text)
	{
		reusable.enterText(text, LastNameTextbox);
	}
	public void enterTextinPublicDisplayName(String text)
	{
		reusable.enterText(text, PublicDisplayname);
	}
	public void validateSaveProfileDetailsisdisabled()
	{
		boolean elementdisabled=reusable.elementEnabledorNot(Saveprofiledetails);
		if(!elementdisabled)
		{
			System.out.println("Save profile details is disabled--Successfully");
			reusable.takesScreenshot(System.currentTimeMillis());
			Assert.assertEquals(false, elementdisabled);
		}else
		{
			System.out.println("Save profile details is enabled--Failed");
			reusable.takesScreenshot(System.currentTimeMillis());
			Assert.assertEquals(false, elementdisabled);
		}
	}
	
	public void validateSaveProfileDetailsisenabled()
	{
		boolean elementdisabled=reusable.elementEnabledorNot(Saveprofiledetails);
		if(elementdisabled)
		{
			System.out.println("Save profile details is enabled--Successfully");
			Assert.assertEquals(true, elementdisabled);
		}else
		{
			System.out.println("Save profile details is disabled--Failed");
			Assert.assertEquals(true, elementdisabled);
		}
	}
	
	public void clickSaveProfileDetails()
	{
		reusable.clickElement(Saveprofiledetails);
	}
	
	public void validateFirstName(String expectedText)
	{
		String elementValue=reusable.getElementAttribute(FirstNameTextbox, "value");
		System.out.println("Expected Text : "+expectedText.trim());
		if(expectedText.trim().contentEquals(elementValue.trim()))
		{
			System.out.println("Actual Text : "+elementValue.trim());
			reusable.takesScreenshot(System.currentTimeMillis());
			Assert.assertEquals(expectedText.trim(), elementValue.trim());
		}else
		{
			System.out.println("Actual Text : "+elementValue.trim());
			reusable.takesScreenshot(System.currentTimeMillis());
			Assert.assertEquals(expectedText.trim(), elementValue.trim());
		}
	}
	
	public void validateLastName(String expectedText)
	{
		String elementValue=reusable.getElementAttribute(LastNameTextbox, "value");
		System.out.println("Expected Text : "+expectedText.trim());
		if(expectedText.trim().contentEquals(elementValue.trim()))
		{
			System.out.println("Actual Text : "+elementValue.trim());
			reusable.takesScreenshot(System.currentTimeMillis());
			Assert.assertEquals(expectedText.trim(), elementValue.trim());
		}else
		{
			System.out.println("Actual Text : "+elementValue.trim());
			reusable.takesScreenshot(System.currentTimeMillis());
			Assert.assertEquals(expectedText.trim(), elementValue.trim());
		}
	}
	
	
	public void validatePublicDisplayName(String expectedText)
	{
		String elementValue=reusable.getElementAttribute(PublicDisplayname, "value");
		System.out.println("Expected Text : "+expectedText.trim());
		if(expectedText.trim().contentEquals(elementValue.trim()))
		{
			System.out.println("Actual Text : "+elementValue.trim());
			reusable.takesScreenshot(System.currentTimeMillis());
			Assert.assertEquals(expectedText.trim(), elementValue.trim());
		}else
		{
			System.out.println("Actual Text : "+elementValue.trim());
			reusable.takesScreenshot(System.currentTimeMillis());
			Assert.assertEquals(expectedText.trim(), elementValue.trim());
		}
	}
	
	
	public void validateProfileAvatar(String expectedText)
	{
		String elementValue=Profileavatar.getText().trim();
		System.out.println("Expected Text : "+expectedText.trim());
		if(expectedText.trim().contentEquals(elementValue.trim()))
		{
			System.out.println("Actual Text : "+elementValue.trim());
			reusable.takesScreenshot(System.currentTimeMillis());
			Assert.assertEquals(expectedText.trim(), elementValue.trim());
		}else
		{
			System.out.println("Actual Text : "+elementValue.trim());
			reusable.takesScreenshot(System.currentTimeMillis());
			Assert.assertEquals(expectedText.trim(), elementValue.trim());
		}
	}
	
	
}
