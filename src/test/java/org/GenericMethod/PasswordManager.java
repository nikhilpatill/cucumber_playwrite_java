package org.GenericMethod;

import org.hooks.AppHooks;

import com.microsoft.playwright.Page;

public class PasswordManager {

	private static Page page;

	public PasswordManager() {
		this.page = AppHooks.page; // use global Playwright page
	}

	// Initial password for first login
	public static String currentPassword = "Welcome@123";

	// Generate a new predictable password every run
	public static String generateNewPassword() {
		return "Welcome@" + (System.currentTimeMillis() % 10000);
	}

	public static void resetprevious_Password() {

		page.locator("//a[text()='Change your password']").click();
		page.locator("//input[@name='password']").fill("Welcome@123");
		page.locator("//input[@name='confirm']").fill("Welcome@123");

		// submit button
		page.locator("//input[@type='submit']").click();

	}

}
