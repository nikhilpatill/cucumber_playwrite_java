package org.pages;

import com.microsoft.playwright.Page;
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
		ForgetPasswordtxt = page.locator("//h1[text()='Forgot Your Password?']");
		ForgetPasswordlink = page.locator("//a[text()='Forgotten Password']");
	}

	public void enterUsername() {
		usernameInput.fill("nikhilpatil1080@gmail.com");
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

	public void enterPassword() {
		passwordInput.fill("Welcome@123");
	}

	public String My_Accounttxt() {

		return My_Accounttxt.textContent();

	}

	public String ForgetPasswordtxt() {

		return ForgetPasswordtxt.textContent();

	}

	public String Error_message() {

		return Error_message.textContent().trim();

	}

	public String Error_message2() {

		return Error_message2.textContent().trim();

	}

	public void clickSubmit() {
		submitBtn.click();
	}

}
