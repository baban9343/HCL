package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import drivers.GetDrivers;
import pageObjects.Login;
import reusableFunctions.ConfigFileReader;

public class LoginStepDefs {

	ConfigFileReader config=new ConfigFileReader();
	Login login=new Login(GetDrivers.driver);
	
	@Given("^the user is on the login page of WordPress\\.com$")
	public void the_user_is_on_the_login_page_of_WordPress_com() throws Throwable {
	GetDrivers.driver.get(config.getPropertyfromPropertiesFile("URL"));
	login.verifyLoginisDisplayed();
	}
	
	@When("^the user enters \"([^\"]*)\" in the Email Address$")
	public void the_user_enters_in_the_Email_Address(String username) throws Throwable {
	  login.enterText(username);
	}

	@When("^the user enters \"([^\"]*)\" in the Password textbox$")
	public void the_user_enters_in_the_Password_textbox(String password) throws Throwable {
	  login.enterPassword(password);
	}

	@When("^the user clicks on Continue button$")
	public void the_user_clicks_on_Continue_button() throws Throwable {
	   login.clickContinue();
	}

	@Then("^the MyProfileIcon is displayed$")
	public void the_MyProfileIcon_is_displayed() throws Throwable {
	 login.verifymyProfileiconisDisplayed();
	}

	@Then("^the user clicks on the MyProfileIcon$")
	public void the_user_clicks_on_the_MyProfileIcon() throws Throwable {
	login.clickProfileIcon();
	}

	@Then("^the MyProfile page is displayed$")
	public void the_MyProfile_page_is_displayed() throws Throwable {
	login.verifyProfileisdisplayed();
	}

	
	@When("^the user clicks on Login button$")
	public void the_user_clicks_on_Login_button() throws Throwable {
	  login.clickLogin();
	}

	@Then("^the user clicks on the Logout$")
	public void the_user_clicks_on_the_Logout() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	login.clickLogout();
	}

	@Then("^the Login Icon is displayed$")
	public void the_Login_Icon_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  login.verifyLoginIconisDisplayed();
	}

	@Then("^the user clicks on the Login Icon$")
	public void the_user_clicks_on_the_Login_Icon() throws Throwable {
	login.clickLoginicon();
	}
}
