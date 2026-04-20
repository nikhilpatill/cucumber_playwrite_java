package parallel;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitUntilState;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import org.GenericMethod.GenericMethod;
import org.GenericMethod.PasswordManager;
import org.hooks.AppHooks;
import org.pages.LoginPage;
import org.pages.RegisterPage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class RegisterStepDef {

	private Page page;
	private RegisterPage registerPage;
	SoftAssert sa = new SoftAssert();
	GenericMethod GN = new GenericMethod();

	String Username;
	String Password;

	@Given("user_is_on_registerPage")
	public void user_is_on_login_page() {
		page = AppHooks.page; // Playwright Page
		registerPage = new RegisterPage(page); // Initialize Playwright Page Object
	}

	@When("click  RegisterPage continoue_button")
	public void click_register_page_continoue_button() {

		registerPage.Continue();

	}
	
	@When("placeholders {string}")
	public void placeholders(String expected_name) throws InterruptedException {
	    
		String actual_mgs = GN.Register_Account_page_have_the_proper_placeholders(page,expected_name);
		sa.assertEquals(actual_mgs, expected_name);
		AppHooks.scenario.log("Actual ErrorMessage is: " +actual_mgs);
		
		
	}
	
	@When("click  RegisterPage Register_link")
	public void click_register_page_register_link() {
	 
		page.locator("(//a[text()='Register'])[3]").click();
	}
	
	@When("click  RegisterPage Register_Accountcontinoue_button")
	public void click_register_page_Register_Accountcontinoue_button() {

		registerPage.Register_Accountcontinoue_button();

	}
	
	@When("when {string} option is selected {string}")
	public void when_option_is_selected(String filed, String option) {
	   
		if(filed.equalsIgnoreCase("Subscribe")&& option.equalsIgnoreCase("yes"))
		{
			page.locator("(//input[@type='radio'])[2]").click();
		}
		else
		{
			page.locator("(//input[@type='radio'])[3]").click();
		}
		
	}
	
	@When("User enters Error_Msg {string}")
	public void user_enters_error_msg(String expected) {
	   
		String actual_mgs = GN.ErrorMessage_register_page(page,expected);
		sa.assertEquals(actual_mgs, expected);
		AppHooks.scenario.log("Actual ErrorMessage is: " +actual_mgs);
	}
	
	@When("User enters {string} {string}")
	public void user_enters(String field, String inputvalue) throws InterruptedException {
		Thread.sleep(500);
		GN.Fill_alldetailes_different_Gmailid(page,field,inputvalue);
		page.locator("//input[@name='agree']").click();
	}
	
	

	
	@When("Enter the all details of registered_account")
	public void enter_the_all_details_of_registered_account() throws InterruptedException {
		Thread.sleep(1000);
		registerPage.Fill_alldetailes_registered_account1(page);
		page.locator("//input[@name='agree']").click();
		
	}
	
	@When("Enter the all details of existing_account_details")
	public void enter_the_all_details_of_existing_account_details() throws InterruptedException {
		Thread.sleep(1000);
		GN.Fill_alldetailes_existing_account_details(page);
		page.locator("//input[@name='agree']").click();
		
	}
	
	@When("Enter the all details of registered_account_different_passwords")
	public void enter_the_all_details_of_registered_account_different_passwords() throws InterruptedException {
		Thread.sleep(1000);
		GN.Fill_alldetailes_different_password(page);
		page.locator("//input[@name='agree']").click();
		
	}

	@Then("varify RegisterPage {string} IsDisplayed {string}")
	public void varify_register_page_is_displayed(String field, String expected) {

		switch (field) {

		case "Url":
			Assert.assertEquals(page.url(), expected);
			// AppHooks.scenario.log("Forget Password Button Clicked");
			sa.assertEquals(page.url(), expected);
			AppHooks.scenario.log("Actual URL is: " + page.url());
			break;
			
		case "text":
			String actualtxt= page.locator("//h1[text()='Your Account Has Been Created!']").innerText();
			Assert.assertEquals(actualtxt, expected);
			sa.assertEquals(actualtxt, expected);
			AppHooks.scenario.log("Atual txt is :"+ actualtxt);
			break;
			
		default:
			Assert.fail("Invalid verification element: " + field);
		}

	}

	// -------------------------- CLICK & INPUT --------------------------

}