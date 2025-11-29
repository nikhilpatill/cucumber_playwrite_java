package org.pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import java.util.*;
   // Your custom utility (converted separately)
import propertiesUtility.PropertiesGeneric;
import org.GenericMethod.*;

public class AdminPage {

    private Page page;
    private PropertiesGeneric pro = new PropertiesGeneric();
    private GenericMethod GN = new GenericMethod(); // Converted utility

    // Constructor
    public AdminPage(Page page) {
        this.page = page;
    }

    // ------------------
    //  All Locators
    // ------------------

    private Locator AddBtn() { return page.locator("//button[text()=' Add ']"); }
    private Locator placeholderUsername() { return page.locator("//input[@name='username']"); }
    private Locator placeholderPassword() { return page.locator("//input[@type='password']"); }
    private Locator submitBtn() { return page.locator("//button[@type='submit']"); }
    private Locator dashboadTxt() { return page.locator("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"); }
    private Locator SuccessMessage() { return page.locator("//div[@class='oxd-toast-content']//p"); }

    private Locator AdminBtn() { return page.locator("//span[text()='Admin']"); }
    private Locator UserManagementBtn() { return page.locator("//span[text()='User Management ']"); }
    private Locator UserBtn() { return page.locator("//a[text()='Users']"); }
    private Locator JobBtn() { return page.locator("//nav[@role='navigation']/ul/li[2]/span/i"); }
    private Locator JobTitlesBtn() { return page.locator("//a[normalize-space()='Job Titles']"); }
    private Locator JobWorkShiftsBtn() { return page.locator("//a[text()='Work Shifts']"); }
    private Locator PayGradesBtn() { return page.locator("//a[text()='Pay Grades']"); }

    // List Locators
    private Locator AdminNavOptions() { return page.locator("//nav[@role='navigation']/ul/li"); }
    private Locator QualificationsNavOptions() { return page.locator("//ul[@role='menu']/li/a"); }


    // ------------------
    //  Action Methods
    // ------------------

    public String getDashboardText() {
        return dashboadTxt().textContent().trim();
    }

    public String getSuccessMessage() {
        return SuccessMessage().textContent().trim();
    }

    public String getErrorMessage() {
        return GN.checkErrorMessage(page);
    }

    public void enterUsername() {
        placeholderUsername().fill("Admin");
    }

    public void enterPassword() {
        placeholderPassword().fill("admin123");
    }

    public void clickSubmit() {
        submitBtn().click();
    }

    public void clickAdd() {
        AddBtn().click();
    }

    public void clickAdmin() {
        AdminBtn().click();
    }

    public void clickUserManagement() {
        UserManagementBtn().click();
    }

    public void clickUsers() {
        UserBtn().click();
    }

    public void clickJob() {
        JobBtn().click();
    }

    public void clickJobTitles() {
        JobTitlesBtn().click();
    }

    public void clickPayGrades() {
        PayGradesBtn().click();
    }

    public void clickWorkShifts() {
        JobWorkShiftsBtn().click();
    }

    public void jobTitleInput() {
        page.locator("//label[text()='Job Title']/../../div[2]/input")
                .fill(pro.getPropertiesData("JobTitle"));
    }


    public String getCurrentUrl() {
        return page.url();
    }

    public String getTitle() {
        return page.title();
    }

    public List<String> getAdminNavigationOptions() {
        return AdminNavOptions().allTextContents();
    }

    public List<String> getQualificationsNavigationOptions() {
        return QualificationsNavOptions().allTextContents();
    }

}
