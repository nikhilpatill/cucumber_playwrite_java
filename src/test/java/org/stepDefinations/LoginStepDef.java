package org.stepDefinations;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hooks.AppHooks;
import org.pages.LoginPage;
import org.testng.Assert;

public class LoginStepDef {

    private Page page;
    private LoginPage loginPage;

    String Username;
    String Password;


    @Given("user_is_on_LoginPage")
    public void user_is_on_login_page() {
        page = AppHooks.page;               // Playwright Page
        loginPage = new LoginPage(page);    // Initialize Playwright Page Object
    }

    // -------------------------- CLICK & INPUT --------------------------

   
    @When("Enter LoginPage Username_field")
    public void enter_login_page_username_field() {
        loginPage.enterUsername();
    }

    @When("Enter LoginPage Password_field")
    public void enter_login_page_password_field() {
        loginPage.enterPassword();
    }

    @When("Enter LoginPage submitBtn")
    public void enter_login_page_submit_btn() {
        loginPage.clickSubmit();
    }

  

   
    // -------------------------- VALIDATIONS --------------------------

    @Then("varify LoginPage {string} IsDisplayed {string}")
    public void varify_login_page_is_displayed(String field, String expectedValue) {

        switch (field) {

            case "Url":
                Assert.assertEquals(page.url(), expectedValue);
               //AppHooks.scenario.log("Forget Password Button Clicked");
                AppHooks.scenario.log("Actual URL is: " + page.url());
                break;

            case "Title":
                Assert.assertEquals(page.title(), expectedValue);
                break;

            default:
                Assert.fail("Invalid verification element: " + field);
        }
    }
}