

  @nik
Feature: Login Functionality

 Background:
 Given user_is_on_LoginPage

  Scenario: verify Login page
    Then varify LoginPage "Url" IsDisplayed "https://tutorialsninja.com/demo/index.php?route=account/login"
    When Enter LoginPage Username_field
    When Enter LoginPage Password_field
    When Enter LoginPage submitBtn
    Then varify LoginPage "Url" IsDisplayed "https://tutorialsninja.com/demo/index.php?route=account/account"
  

  Scenario: TC_LF_001_Verify logging into the Application using valid credentials
    Then varify LoginPage "Url" IsDisplayed "https://tutorialsninja.com/demo/index.php?route=account/login"
    When Enter LoginPage Username_field
    When Enter LoginPage Password_field
    When Enter LoginPage submitBtn
    Then varify LoginPage "txt" IsDisplayed "My Account"
    
   
   Scenario: TC_LF_002_Verify logging into the Application using invalid credentials (i.e. Invalid email address and Invalid Password)
    Then varify LoginPage "Url" IsDisplayed "https://tutorialsninja.com/demo/index.php?route=account/login"
    When Enter LoginPage invalidUsername_field
    When Enter LoginPage invalidPassword_field
    When Enter LoginPage submitBtn
    Then varify LoginPage "error_message" IsDisplayed "Warning: No match for E-Mail Address and/or Password."
    
      
   Scenario: TC_LF_003_Verify logging into the Application using invalid email address and valid Password)
    Then varify LoginPage "Url" IsDisplayed "https://tutorialsninja.com/demo/index.php?route=account/login"
    When Enter LoginPage invalidUsername_field
    When Enter LoginPage Password_field
    When Enter LoginPage submitBtn
    Then varify LoginPage "error_message" IsDisplayed "Warning: No match for E-Mail Address and/or Password."
    
 
   Scenario: TC_LF_004_Verify logging into the Application using valid email address and invalid Password)
    Then varify LoginPage "Url" IsDisplayed "https://tutorialsninja.com/demo/index.php?route=account/login"
    When Enter LoginPage Username_field
    When Enter LoginPage invalidPassword_field
    When Enter LoginPage submitBtn
    Then varify LoginPage "error_message" IsDisplayed "Warning: No match for E-Mail Address and/or Password."
    
   
    Scenario: TC_LF_005_Verify logging into the Application without providing any credentials
    Then varify LoginPage "Url" IsDisplayed "https://tutorialsninja.com/demo/index.php?route=account/login"
    When Enter LoginPage submitBtn
    Then varify LoginPage "error_message" IsDisplayed "Warning: No match for E-Mail Address and/or Password."
    
    Scenario: TC_LF_006_Verify 'Forgotten Password' link is available in the Login page and is working
    Then varify LoginPage "Url" IsDisplayed "https://tutorialsninja.com/demo/index.php?route=account/login"
    When Enter LoginPage Forgotten_Passwordlink
    Then varify LoginPage "error_message" IsDisplayed "Warning: No match for E-Mail Address and/or Password."
    Then varify LoginPage "txt" IsDisplayed "Forgot Your Password?"
    