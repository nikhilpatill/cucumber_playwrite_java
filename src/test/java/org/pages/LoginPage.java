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
   

    // -----------------------------
    // 2. Constructor
    // -----------------------------
    public LoginPage(Page page) {
        this.page = page;

        usernameInput = page.locator("//input[@name='email']");
        passwordInput = page.locator("//input[@name='password']");
        submitBtn = page.locator("//input[@type='submit']");
       
    }

  

    

    public void enterUsername() {
        usernameInput.fill("nikhilpatil1080@gmail.com");
    }

    public void enterPassword() {
        passwordInput.fill("Welcome@123");
    }

    
    public void clickSubmit() {
        submitBtn.click();
    }

   
    public String getCurrentUrl() {
        return page.url();
    }

    public String getTitle() {
        return page.title();
    }
}
