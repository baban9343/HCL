@MyProfile
Feature: Validate all the functionalities of My Profile section on WordPress.com


Background: User is logged in
Given the user is on the login page of WordPress.com
When the user enters "baban9343@gmail.com" in the Email Address
And the user clicks on Continue button
And the user enters "Subho@93" in the Password textbox
And the user clicks on Login button
Then the MyProfileIcon is displayed
@TC01_Navigation_to_MyProfile
Scenario: Validate whether the My Profile page is successfully displayed
When the user clicks on the MyProfileIcon
Then the MyProfile page is displayed
And the user clicks on the Logout
Then the Login Icon is displayed

@TC02_Fields_Validation_in_MyProfile
Scenario: Validate whether all the necessary fields are displayed in the My Profile page
When the user clicks on the MyProfileIcon
Then the MyProfile page is displayed
And the various fields-First Name,Last Name,Public display name,About me should be displayed
And the user clicks on the Logout
Then the Login Icon is displayed
@TC03_Validation_of_SaveProfileDetails_Button_when_no_changeOfData_is_present
Scenario: Validate whether the SaveProfile Details button is disabled when no data are changed
When the user clicks on the MyProfileIcon
Then the MyProfile page is displayed
And the user notes the value of FirstName
When the user enters the noted FirstName in the First Name textbox
Then the Save profile details button should be disabled
And the user clicks on the Logout
Then the Login Icon is displayed
@TC04_Validation_of_SaveProfileDetails_Button_when_a_data_is_changed
Scenario: Validate whether the SaveProfile Details button is enabled when a data is changed
When the user clicks on the MyProfileIcon
Then the MyProfile page is displayed
And the user notes the value of FirstName
When the user enters "ChangedValue" in the First Name textbox
Then the Save profile details button should be enabled
@TC05_Validate_whether_FirstName_changed_successfully
Scenario: Validate whether the FirstName can be changed successfully
When the user clicks on the MyProfileIcon
Then the MyProfile page is displayed
And the user notes the value of FirstName
When the user enters "ChangedValue" in the First Name textbox
Then the Save profile details button should be enabled
And the user clicks on Save profile details button
And the user clicks on the Logout
Then the Login Icon is displayed
And the user clicks on the Login Icon
When the user enters "baban9343@gmail.com" in the Email Address
And the user clicks on Continue button
And the user enters "Subho@93" in the Password textbox
And the user clicks on Login button
Then the MyProfileIcon is displayed
When the user clicks on the MyProfileIcon
Then the MyProfile page is displayed
And the value of FirstName should be "ChangedValue"
When the user enters the noted FirstName in the First Name textbox
Then the Save profile details button should be enabled
And the user clicks on Save profile details button
And the user clicks on the Logout
Then the Login Icon is displayed

@TC06_Validate_whether_LastName_changed_successfully
Scenario: Validate whether the LastName can be changed successfully
When the user clicks on the MyProfileIcon
Then the MyProfile page is displayed
And the user notes the value of LastName
When the user enters "ChangedValue" in the Last Name textbox
Then the Save profile details button should be enabled
And the user clicks on Save profile details button
And the user clicks on the Logout
Then the Login Icon is displayed
And the user clicks on the Login Icon
When the user enters "baban9343@gmail.com" in the Email Address
And the user clicks on Continue button
And the user enters "Subho@93" in the Password textbox
And the user clicks on Login button
Then the MyProfileIcon is displayed
When the user clicks on the MyProfileIcon
Then the MyProfile page is displayed
And the value of LastName should be "ChangedValue"
When the user enters the noted LastName in the Last Name textbox
Then the Save profile details button should be enabled
And the user clicks on Save profile details button
And the user clicks on the Logout
Then the Login Icon is displayed

@TC07_Validate_whether_PublicDisplayName_changed_successfully
Scenario: Validate whether the PublicDisplayName can be changed successfully
When the user clicks on the MyProfileIcon
Then the MyProfile page is displayed
And the user notes the value of PublicDisplayName
When the user enters "ChangedValue9234" in the PublicDisplayName textbox
Then the Save profile details button should be enabled
And the user clicks on Save profile details button
And the user clicks on the Logout
Then the Login Icon is displayed
And the user clicks on the Login Icon
When the user enters "baban9343@gmail.com" in the Email Address
And the user clicks on Continue button
And the user enters "Subho@93" in the Password textbox
And the user clicks on Login button
Then the MyProfileIcon is displayed
When the user clicks on the MyProfileIcon
Then the MyProfile page is displayed
And the value of PublicDisplayName should be "ChangedValue9234"
And the value of Avatar Username should be changed to "ChangedValue9234"
When the user enters the noted PublicDisplayName in the PublicDisplayName textbox
Then the Save profile details button should be enabled
And the user clicks on Save profile details button
And the user clicks on the Logout
Then the Login Icon is displayed