
 
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
    Then varify LoginPage "txt" IsDisplayed "Forgot Your Password?"
    

    Scenario: TC_LF_007_Verify logging into the Application using Keyboard keys (Tab and Enter)
    Then varify LoginPage "Url" IsDisplayed "https://tutorialsninja.com/demo/index.php?route=account/login"
    When Enter LoginPage Username_field
    When Enter LoginPage Password_field
    When Enter LoginPage submitBtn
    Then varify LoginPage "txt" IsDisplayed "My Account"
    
   
    Scenario: TC_LF_008_Verify E-Mail Address and Password text fields in the Login page have the place holder text 
    Then varify LoginPage "Url" IsDisplayed "https://tutorialsninja.com/demo/index.php?route=account/login"
    Then varify LoginPage "plassholder_txt" IsDisplayed "E-Mail Address"
    Then varify LoginPage "plassholder_txt" IsDisplayed "Password"
    
    
    #Scenario: TC_LF_009_Verify Logging into the Application and browsing back using Browser back button
    #Then varify LoginPage "Url" IsDisplayed "https://tutorialsninja.com/demo/index.php?route=account/login"
    #When Enter LoginPage Username_field
    #When Enter LoginPage Password_field
    #When Enter LoginPage submitBtn_Enterpress
    #Then varify LoginPage "txt" IsDisplayed "My Account"
    #When Click on Browser back button 
    #Then varify LoginPage "Url" IsDisplayed "https://tutorialsninja.com/demo/index.php?route=account/login"
    
   
    Scenario: TC_LF_011_Verify logging into the Application using inactive credentials
    Then varify LoginPage "Url" IsDisplayed "https://tutorialsninja.com/demo/index.php?route=account/login"
    When Enter LoginPage invalidUsername_field
    When Enter LoginPage Password_field
    When Enter LoginPage submitBtn
    Then varify LoginPage "Url" IsDisplayed "https://tutorialsninja.com/demo/index.php?route=account/login"
    
   
  Scenario Outline: TC_LF_012_Verify the number of unsucessful login attemps 
  When User enters username "<username>"
  And User enters password "<password>"
  When Enter LoginPage submitBtnn
  Then varify LoginPage "Warning_message" IsDisplayed "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour."

Examples:
  | username                        | password        |
  | nikhilpatil1230@gmail.com       | success@123     |
  
  
   Scenario: TC_LF_013_Verify the text into the Password field is toggled to hide its visibility
    Then varify LoginPage "Url" IsDisplayed "https://tutorialsninja.com/demo/index.php?route=account/login"
    When Enter LoginPage Password_fieldd
    
    
    #Scenario: TC_LF_014_Verify the copying of the text entered into the Password field
    #Then varify LoginPage "Url" IsDisplayed "https://tutorialsninja.com/demo/index.php?route=account/login"
    #When Enter LoginPage copyPassword_fieldd
    
    
  
  Scenario: TC_LF_015_Verify Logging into the Application after changing the password 
  When Enter LoginPagee Username_field
  When Enter LoginPagee Password_field
  When Enter LoginPagee submitBtn
  Then click on Change_your_password_link
  Then user changes the password
  Then user logs in with updated password
 
 
  Scenario: TC_LF_017_Verify Logging into the Application, closing the Browser without loggingout and opening the application in the Browser again
  Then varify LoginPage "Url" IsDisplayed "https://tutorialsninja.com/demo/index.php?route=account/login"
    When Enter LoginPage Username_field
    When Enter LoginPage Password_field
    When Enter LoginPage submitBtn
    Then Close the Browser
    Then Open the Browser and launch the application "URL"
 
  @nik 
  Scenario: TC_LF_019_Verify user is able to navigate to different pages from Login page (options like (Right Column options, Header options, Menu Options, Footer options and any other options)
  Then varify LoginPage "Url" IsDisplayed "https://tutorialsninja.com/demo/index.php?route=account/login"
  Then Click on Continue button under New Customer
  
  
    