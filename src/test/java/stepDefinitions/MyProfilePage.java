package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import drivers.GetDrivers;
import drivers.StaticVariables;

import pageObjects.Profile;

public class MyProfilePage {
	private StepDataClass stepdata;
	
	Profile profile=new Profile(GetDrivers.driver);
	
	@Then("^the various fields-First Name,Last Name,Public display name,About me should be displayed$")
	public void the_various_fields_First_Name_Last_Name_Public_display_name_About_me_should_be_displayed() throws Throwable {
	   
		profile.verifyAllElementsinMyProfile();
	}
	
	@Then("^the user notes the value of FirstName$")
	public void the_user_notes_the_value_of_FirstName() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		StaticVariables.FirstName=profile.getFirstNameText();
		System.out.println("Value stored is "+StaticVariables.FirstName);
	}

	@When("^the user enters the noted FirstName in the First Name textbox$")
	public void the_user_enters_the_noted_FirstName_in_the_First_Name_textbox() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   profile.enterTextinFirstName(StaticVariables.FirstName);
	}

	@Then("^the Save profile details button should be disabled$")
	public void the_Save_profile_details_button_should_be_disabled() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   profile.validateSaveProfileDetailsisdisabled();
	}
	
	@When("^the user enters \"([^\"]*)\" in the First Name textbox$")
	public void the_user_enters_in_the_First_Name_textbox(String text) throws Throwable {
		profile.enterTextinFirstName(text);
	}

	@Then("^the Save profile details button should be enabled$")
	public void the_Save_profile_details_button_should_be_enabled() throws Throwable {
	profile.validateSaveProfileDetailsisenabled();
	}
	
	@Then("^the user clicks on Save profile details button$")
	public void the_user_clicks_on_Save_profile_details_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	profile.clickSaveProfileDetails();
	}

	@Then("^the value of FirstName should be \"([^\"]*)\"$")
	public void the_value_of_FirstName_should_be(String expectedText) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   profile.validateFirstName(expectedText);
	}
	
	@Then("^the user notes the value of LastName$")
	public void the_user_notes_the_value_of_LastName() throws Throwable {
		StaticVariables.LastName=profile.getLastNameText();
		System.out.println("Value stored is "+StaticVariables.LastName);
	}

	@When("^the user enters \"([^\"]*)\" in the Last Name textbox$")
	public void the_user_enters_in_the_Last_Name_textbox(String changedText) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   profile.enterTextinLastName(changedText);
	}

	@Then("^the value of LastName should be \"([^\"]*)\"$")
	public void the_value_of_LastName_should_be(String expectedText) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    profile.validateLastName(expectedText);
	}

	@When("^the user enters the noted LastName in the Last Name textbox$")
	public void the_user_enters_the_noted_LastName_in_the_Last_Name_textbox() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		profile.enterTextinLastName(StaticVariables.LastName);
	}

	@Then("^the user notes the value of PublicDisplayName$")
	public void the_user_notes_the_value_of_PublicDisplayName() throws Throwable {
		StaticVariables.PublicdisplayName=profile.getPublicDisplayName();
		System.out.println("Value stored is "+StaticVariables.PublicdisplayName);
	}

	@When("^the user enters \"([^\"]*)\" in the PublicDisplayName textbox$")
	public void the_user_enters_in_the_PublicDisplayName_textbox(String expectedText) throws Throwable {
	  profile.enterTextinPublicDisplayName(expectedText);
	}

	@Then("^the value of PublicDisplayName should be \"([^\"]*)\"$")
	public void the_value_of_PublicDisplayName_should_be(String expectedText) throws Throwable {
	profile.validatePublicDisplayName(expectedText);
	}

	@Then("^the value of Avatar Username should be changed to \"([^\"]*)\"$")
	public void the_value_of_Avatar_Username_should_be_changed_to(String expectedText) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	 profile.validateProfileAvatar(expectedText);
	}

	@When("^the user enters the noted PublicDisplayName in the PublicDisplayName textbox$")
	public void the_user_enters_the_noted_PublicDisplayName_in_the_PublicDisplayName_textbox() throws Throwable {
		 profile.enterTextinPublicDisplayName(StaticVariables.PublicdisplayName);
	}




}
