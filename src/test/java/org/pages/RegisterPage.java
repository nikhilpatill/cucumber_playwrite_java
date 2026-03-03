package org.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitUntilState;

import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;

public class RegisterPage {

	private Page page;
	private Locator Continue;
	private Locator Register_Accountcontinoue_button;

	// -----------------------------
	// 2. Constructor
	// -----------------------------
	public RegisterPage(Page page) {
		this.page = page;

		Continue = page.locator("//a[text()='Continue']");
		Register_Accountcontinoue_button = page.locator("//input[@value='Continue']");

	}

	public void Continue() {
		Continue.click();
	}

	public void Register_Accountcontinoue_button() {
		Register_Accountcontinoue_button.click();
	}
	
	public void Fill_alldetailes_registered_account1(Page page) throws InterruptedException {
		Locator listxpath = page.locator(
				"//input[@name='firstname']|//input[@name='lastname']|//input[@name='email']|//input[@name='telephone']|//input[@name='password']|//input[@name='confirm']");

		List<ElementHandle> elements = listxpath.elementHandles();
         Thread.sleep(1000);
		for (ElementHandle el : elements) {

			String text = el.getAttribute("name").trim();
        
			if (text.equalsIgnoreCase("firstname")) {
				String uniqueUser = "user" + System.currentTimeMillis();
				el.fill(uniqueUser);

			} else if (text.equalsIgnoreCase("lastname")) {
				String uniqueUser = "user2" + System.currentTimeMillis();
				el.fill(uniqueUser);
			} else if (text.equalsIgnoreCase("email")) {
				long timestamp = System.currentTimeMillis();
				String uniqueEmail = "testuser" + timestamp + "@gmail.com";

				el.fill(uniqueEmail);
			} else if (text.equalsIgnoreCase("telephone")) {
				el.fill("7726363656");
			}

			else if (text.equalsIgnoreCase("password")) {
				el.fill("Success@123");
			} else if (text.equalsIgnoreCase("confirm")) {
				el.fill("Success@123");

			}

		}

	}

}
