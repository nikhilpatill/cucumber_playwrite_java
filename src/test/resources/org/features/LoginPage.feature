
 
Feature: Login Functionality

@nik
  Scenario: verify Login page
    Given user_is_on_LoginPage
    Then varify LoginPage "Url" IsDisplayed "https://tutorialsninja.com/demo/index.php?route=account/login"
    When Enter LoginPage Username_field
    When Enter LoginPage Password_field
    When Enter LoginPage submitBtn
     Then varify LoginPage "Url" IsDisplayed "https://tutorialsninja.com/demo/index.php?route=account/accoun"
  

  