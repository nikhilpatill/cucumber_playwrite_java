@smoke
Feature: register Functionality

 Background:
 Given user_is_on_registerPage

   Scenario: verify register page
   Then varify RegisterPage "Url" IsDisplayed "https://tutorialsninja.com/demo/index.php?route=account/login"
   When click  RegisterPage continoue_button
   Then varify RegisterPage "Url" IsDisplayed "https://tutorialsninja.com/demo/index.php?route=account/register"
   
 
  Scenario Outline: TC_RF_001_Verify Registering an Account by providing only the Mandatory fields
     When click  RegisterPage continoue_button
     When click  RegisterPage Register_Accountcontinoue_button
     When User enters Error_Msg "<Error_Msg>"
 
Examples:
  | Error_Msg |                       
  | First Name must be between 1 and 32 characters! |
  | Last Name must be between 1 and 32 characters!  |
  | E-Mail Address does not appear to be valid!     |
  | Telephone must be between 3 and 32 characters!  |
  | Password must be between 4 and 20 characters!   |
  
  
 Scenario: TC_RF_002_Verify'Thank you for registering' email is sent to the registered email address as a confirmation for registering the account 
  When click  RegisterPage continoue_button
  When Enter the all details of registered_account
  When click  RegisterPage Register_Accountcontinoue_button
  Then varify RegisterPage "text" IsDisplayed "Your Account Has Been Created!"
   
 Scenario Outline: TC_RF_004_Verify Registering an Account by providing only the Mandatory fields
  When click  RegisterPage continoue_button
  When click  RegisterPage Register_Accountcontinoue_button
  When User enters Error_Msg "<Error_Msg>"
 
Examples:
  | Error_Msg |                       
  | First Name must be between 1 and 32 characters! |
  | Last Name must be between 1 and 32 characters!  |
  | E-Mail Address does not appear to be valid!     |
  | Telephone must be between 3 and 32 characters!  |
  | Password must be between 4 and 20 characters!   |
  
 
 Scenario: TC_RF_005_Verify Registering an Account when 'Yes' option is selected for Newsletter field
  When click  RegisterPage continoue_button
  When Enter the all details of registered_account
  When when 'Subscribe' option is selected "yes"
  When click  RegisterPage Register_Accountcontinoue_button
  
  
 Scenario: TC_RF_006_Verify Registering an Account when 'No' option is selected for Newsletter field
  When click  RegisterPage continoue_button
  When Enter the all details of registered_account
  When when 'Subscribe' option is selected "No"
  When click  RegisterPage Register_Accountcontinoue_button
  
  
  Scenario: TC_RF_007_Verify different ways of navigating to 'Register Account' page
  When click  RegisterPage continoue_button
  When click  RegisterPage Register_link
  Then varify RegisterPage "Url" IsDisplayed "https://tutorialsninja.com/demo/index.php?route=account/register"
   
  
  Scenario Outline: TC_RF_008_Verify Registering an Account by entering different passwords into 'Password' and 'Password Confirm' fields
  When click  RegisterPage continoue_button
  When Enter the all details of registered_account_different_passwords
  When when 'Subscribe' option is selected "No"
  When click  RegisterPage Register_Accountcontinoue_button
  When User enters Error_Msg "<Error_Msg>"
  
 Examples:
  | Error_Msg |                       
  | Password confirmation does not match password!|
  
 
  Scenario Outline: TC_RF_009_Verify Registering an Account by providing the existing account details (i.e. existing email address)
  When click  RegisterPage continoue_button
  When Enter the all details of existing_account_details
  When click  RegisterPage Register_Accountcontinoue_button
  When User enters Error_Msg "<Error_Msg>"
  
  Examples:
  | Error_Msg |                       
  | Warning: E-Mail Address is already registered!|
  
  
  
  Scenario Outline: TC_RF_010_Verify Registering an Account by providing an invalid email address into the E-Mail field
  When click  RegisterPage continoue_button
  When User enters "firstname" "<firstname>"
  And User enters "lastname" "<lastname>"
  And User enters "email" "<email>"
  And User enters "telephone" "<telephone>"
  And User enters "password" "<password>"
  And User enters "confirm" "<confirm>"
  When click  RegisterPage Register_Accountcontinoue_button
  Then varify RegisterPage "Url" IsDisplayed "https://tutorialsninja.com/demo/index.php?route=account/register"
   
 
Examples:
  | firstname | lastname |email          |telephone | password | confirm |
  |nikhil     | patil    |amotoori       |7788270678| arun@123 | arun@123|
  |nikhil     | patil    |amotoori@      |7788270678| arun@123 | arun@123|
  |nikhil     | patil    |amotoori@gmail |7788270678| arun@123 | arun@123|
  |nikhil     | patil    |amotoori@gmail.|7788270678| arun@123 | arun@123|
  
   @nik 
  Scenario: TC_RF_013_Verify all the fields in the Register Account page have the proper placeholders
  When click  RegisterPage continoue_button
  When placeholders "First Name" 
  And placeholders "Last Name" 
  And placeholders "E-Mail" 
  And placeholders "Telephone" 
  And placeholders "Password" 
  And placeholders "Password Confirm" 
 
  
  
  