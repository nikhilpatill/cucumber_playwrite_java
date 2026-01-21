package org.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitUntilState;
import com.microsoft.playwright.Locator;

public class LoginPage {

	private Page page;

	// -----------------------------
	// 1. LOCATORS (Playwright)
	// -----------------------------

	private Locator usernameInput;
	private Locator passwordInput;
	private Locator submitBtn;
	private Locator My_Accounttxt;
	private Locator ForgetPasswordtxt;
	private Locator Error_message;
	private Locator Error_message2;
	private Locator ForgetPasswordlink;
	private Locator plassholder_Email_txt;
	private Locator plassholder_Password_txt;
	private Locator Warning_message;

	// -----------------------------
	// 2. Constructor
	// -----------------------------
	public LoginPage(Page page) {
		this.page = page;

		usernameInput = page.locator("//input[@name='email']");
		passwordInput = page.locator("//input[@name='password']");
		submitBtn = page.locator("//input[@type='submit']");
		My_Accounttxt = page.locator("//h2[text()='My Account']");
		Error_message = page.locator("//div[text()='Warning: No match for E-Mail Address and/or Password.']");
		Error_message2 = page.locator("//div[text()='Warning: No match for E-Mail Address and/or Password.']");
		Warning_message = page.locator("//div[text()='Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.']");
		ForgetPasswordtxt = page.locator("//h1[text()='Forgot Your Password?']");
		ForgetPasswordlink = page.locator("(//a[text()='Forgotten Password'])[1]");
		plassholder_Email_txt = page.locator("//input[@placeholder='E-Mail Address']");
		plassholder_Password_txt = page.locator("//input[@placeholder='Password']");
	}

	public void enterUsername() {
		usernameInput.hover();
		usernameInput.fill("nikhilpatil1080@gmail.com");
		usernameInput.press("Tab");
	}

	public void invalidgmail() {
		usernameInput.fill("nikhilpatil1834@gmail.com");
	}

	public void invalidPassword() {
		passwordInput.fill("Wel232332323");
	}

	public void ForgetPasswordlink() {
		ForgetPasswordlink.click();
	}

	public void click_on_browser_back_button() {

		   // Check if page has history
	    String currentUrl = page.url();

	    page.goBack();
	    page.goBack();

	    page.waitForTimeout(1500);

	    // If Playwright went to blank page → restore previous URL
	    if (page.url().equals("about:blank")) {
	        page.navigate("https://tutorialsninja.com/demo/index.php?route=account/login");
	        page.navigate("https://tutorialsninja.com/demo/index.php?route=account/login");
	    }
	
	}

	public void enterPassword() {

		passwordInput.fill("Welcome@123");
	}

	public String My_Accounttxt() {

		return My_Accounttxt.textContent();

	}
	
	public String Warning_message() {

		return Warning_message.textContent();

	}
	
	

	public String ForgetPasswordtxt() {

		return ForgetPasswordtxt.textContent();

	}

	public String Error_message() {

		return Error_message.textContent();

	}

	public String plassholder_Email_txt() {

		return plassholder_Email_txt.getAttribute("placeholder");

	}

	public String plassholder_Password_txt() {

		return plassholder_Password_txt.getAttribute("placeholder");

	}

	public String Error_message2() {

		return Error_message2.textContent().trim();

	}

	public void clickSubmit() {
		submitBtn.click();
	}

	public void clickSubmit_Enter_Press() {
		submitBtn.press("Enter");
	}

}
