package org.stepDefinations;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitUntilState;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.GenericMethod.GenericMethod;
import org.GenericMethod.PasswordManager;
import org.hooks.AppHooks;
import org.pages.LoginPage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LoginStepDef {

	private Page page;
	private LoginPage loginPage;
	SoftAssert sa = new SoftAssert();
	GenericMethod GN = new GenericMethod();

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

	@When("Enter LoginPage Password_fieldd")
	public void enter_login_page_password_fieldd() {
		String type = page.getAttribute("//input[@name='password']", "type");

		System.out.println("Password field type is: " + type);

		// Assert.assertEquals(type, "password", "Password is not hidden!");
		sa.assertEquals(type, "password", "Password is not hidden!");
		AppHooks.scenario.log("Password is not hidden!" + type);
	}

	@When("Enter LoginPage copyPassword_fieldd")
	public void enter_login_page_copyPassword_fieldd() {
		// String type = page.getAttribute("//input[@name='password']", "type");

		String selector = "input[name='password']";

		// Type password
		page.fill(selector, "wrong123");

		// Add copy-blocking event safely
		page.evaluate(
				"document.querySelector(\"input[name='password']\").addEventListener('copy', (e)=>{ e.preventDefault(); });");

		// Select all text
		page.click(selector);
		page.keyboard().press("Control+A");

		// Try copying
		page.keyboard().press("Control+C");

		// Read clipboard
		String clip = page.evaluate("navigator.clipboard.readText()").toString();

		// Assertion
		Assert.assertTrue(clip.isEmpty(), "Password text SHOULD NOT be copied, but it was copied!");

	}

	@When("User enters username {string}")
	public void enterUsername(String username) {
		page.locator("//input[@name='email']").fill(username);
	}

	@When("User enters password {string}")
	public void enterPassword(String password) {
		page.locator("//input[@name='password']").fill(password);
	}

	@When("User enters usernamee {string}")
	public void enterUsernamee(String username) {
		page.locator("//input[@name='email']").fill(username);
	}

	@When("User enters passwordd {string}")
	public void enterPasswordd(String password) {
		page.locator("//input[@name='password']").fill(password);
	}

	@When("Enter LoginPage submitBtn")
	public void enter_login_page_submit_btn() {
		loginPage.clickSubmit();
	}
	
	
	@Then("Close the Browser")
	public void close_the_browser() {
		
		GenericMethod.closeBrowser();
	}
	@Then("Open the Browser and launch the application {string}")
	public void open_the_browser_and_launch_the_application(String string) {
		
		GenericMethod.openBrowser("https://tutorialsninja.com/demo/");
	}

	@When("Enter LoginPage submitBtnn")
	public void enter_login_page_submit_btnn() {

		for (int i = 0; i <= 5; i++) {
			loginPage.clickSubmit();
		}

	}

	@When("Enter LoginPagee submitBtn")
	public void enter_login_pagee_submit_btn() {

		loginPage.clickSubmit();

	}

	@Then("click on Change_your_password_link")
	public void click_on_change_your_password_link() {

		page.locator("//a[text()='Change your password']").click();

	}

	@When("Enter LoginPagee Username_field")
	public void enter_login_pagee_username_field() {

		page.locator("//input[@name='email']").fill("nikhilpatil1010@gmail.com");
	}

	@When("Enter LoginPagee Password_field")
	public void enter_login_pagee_password_field() {

		page.locator("//input[@name='password']").fill(PasswordManager.currentPassword);
	}

	@Then("user changes the password")
	public void user_changes_the_password() {

		// generate new password
		String newPass = PasswordManager.generateNewPassword();

		// fill old password
		// page.locator("#oldPassword").fill(PasswordManager.currentPassword);

		// fill new password
		page.locator("//input[@name='password']").fill(newPass);
		page.locator("//input[@name='confirm']").fill(newPass);

		// submit button
		page.locator("//input[@type='submit']").click();
		// update memory
		PasswordManager.currentPassword = newPass;

		AppHooks.scenario.log("New password updated in memory: " + PasswordManager.currentPassword);
		System.out.println("New password updated in memory: " + PasswordManager.currentPassword);
		
	}

	@Then("user logs in with updated password")
	public void user_logs_in_with_updated_password() {
		page.locator("//a[@title='My Account']").click();
		page.locator("(//a[text()='Logout'])[1]").click();
		page.locator("//a[text()='Continue']").click();
		page.locator("//a[@title='My Account']").click();
		page.locator("//a[text()='Login']").click();

		page.locator("//input[@name='email']").fill("nikhilpatil1010@gmail.com");
		page.locator("//input[@name='password']").fill(PasswordManager.currentPassword);
		page.locator("//input[@type='submit']").click();
		sa.assertEquals(page.url(), "https://tutorialsninja.com/demo/index.php?route=account/account");
		AppHooks.scenario.log("Actual URL is: " + page.url());
		
		page.locator("//a[text()='Change your password']").click();
		page.locator("//input[@name='password']").fill("Welcome@123");
		page.locator("//input[@name='confirm']").fill("Welcome@123");

		// submit button
		page.locator("//input[@type='submit']").click();
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

	@When("Click on Browser back button")
	public void click_on_browser_back_button() {

		loginPage.click_on_browser_back_button();
	}
	
	
	@Then("Click on Continue button under New Customer")
	public void click_on_continue_button_under_new_customer() {
	   
		GenericMethod.navigateToLoginPage();
	}

	// -------------------------- VALIDATIONS --------------------------

	@Then("varify LoginPage {string} IsDisplayed {string}")
	public void varify_login_page_is_displayed(String field, String expectedValue) {

		switch (field) {

		case "Url":
			Assert.assertEquals(page.url(), expectedValue);
			// AppHooks.scenario.log("Forget Password Button Clicked");
			sa.assertEquals(page.url(), expectedValue);
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

		case "plassholder_txt":

			if (expectedValue.equalsIgnoreCase("E-Mail Address")) {
				sa.assertEquals(loginPage.plassholder_Email_txt(), expectedValue);
				String name1 = loginPage.plassholder_Email_txt();
				System.out.println(name1);
				AppHooks.scenario.log("Actual text is: " + name1);
				break;
			} else if (expectedValue.equalsIgnoreCase("Password")) {

				sa.assertEquals(loginPage.plassholder_Email_txt(), expectedValue);
				String name1 = loginPage.plassholder_Email_txt();
				System.out.println(name1);
				AppHooks.scenario.log("Actual text is: " + name1);
				break;

			}

		case "error_message":
			sa.assertEquals(loginPage.Error_message(), expectedValue);
			AppHooks.scenario.log("Actual text is: " + loginPage.Error_message());
			break;

		case "Warning_message":
			sa.assertEquals(loginPage.Warning_message(), expectedValue);
			AppHooks.scenario.log("Actual text is: " + loginPage.Warning_message());
			break;

		default:
			Assert.fail("Invalid verification element: " + field);
		}
	}
}