package org.stepDefinations;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hooks.AppHooks;
import org.pages.LoginPage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LoginStepDef {

	private Page page;
	private LoginPage loginPage;
	SoftAssert sa = new SoftAssert();

	String Username;
	String Password;

	@Given("user_is_on_LoginPage")
	public void user_is_on_login_page() {
		page = AppHooks.page; // Playwright Page
		loginPage = new LoginPage(page); // Initialize Playwright Page Object
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

	@When("Enter LoginPage invalidUsername_field")
	public void enter_login_page_invalid_username_field() {

		loginPage.invalidgmail();

	}

	@When("Enter LoginPage invalidPassword_field")
	public void enter_login_page_invalid_password_field() {

		loginPage.invalidPassword();

	}

	@When("Enter LoginPage Forgotten_Passwordlink")
	public void enter_login_page_forgotten_passwordlink() {

		loginPage.ForgetPasswordlink();

	}

	// -------------------------- VALIDATIONS --------------------------

	@Then("varify LoginPage {string} IsDisplayed {string}")
	public void varify_login_page_is_displayed(String field, String expectedValue) {

		switch (field) {

		case "Url":
			Assert.assertEquals(page.url(), expectedValue);
			// AppHooks.scenario.log("Forget Password Button Clicked");
			AppHooks.scenario.log("Actual URL is: " + page.url());
			break;

		case "Title":
			Assert.assertEquals(page.title(), expectedValue);
			sa.assertEquals(page.title(), expectedValue);
			break;
		case "txt":

			if (expectedValue.equalsIgnoreCase("My Account")) {
				sa.assertEquals(loginPage.My_Accounttxt(), expectedValue);
				AppHooks.scenario.log("Actual text is: " + loginPage.My_Accounttxt());
				break;
			} else if (expectedValue.equalsIgnoreCase("Forgot Your Password?")) {
				sa.assertEquals(loginPage.ForgetPasswordtxt(), expectedValue);
				AppHooks.scenario.log("Actual text is: " + loginPage.ForgetPasswordtxt());
				break;
			}

		case "error_message":
			sa.assertEquals(loginPage.Error_message(), expectedValue);
			AppHooks.scenario.log("Actual text is: " + loginPage.Error_message());
			break;

		default:
			Assert.fail("Invalid verification element: " + field);
		}
	}
}