package org.GenericMethod;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.ScreenshotType;
import com.microsoft.playwright.options.WaitForSelectorState;

import org.hooks.AppHooks;

import java.nio.file.Path;
import java.util.List;

public class GenericMethod {

    private Page page;

    public GenericMethod() {
        this.page = AppHooks.page;  // use global Playwright page
    }

    // ---------------------- VISIBILITY METHODS ----------------------

    public boolean checkVisibilityFlag(List<Locator> elements) {
        for (Locator ele : elements) {
            if (ele.isVisible()) 
            	return true;
        }
        return false;
    }

    public Locator checkVisibleElement(List<Locator> elements) {
        for (Locator ele : elements) {
            if (ele.isVisible()) return ele;
        }
        return null;
    }


    // ---------------------- SCROLL METHODS --------------------------

    public void scrollToCenter() {
        page.mouse().wheel(0, 1200);
    }

    public void scrollToTop() {
        page.mouse().wheel(0, -1200);
    }

    public void scrollToElement(Locator ele) {
        ele.scrollIntoViewIfNeeded();
    }

    public void scrollToElementAndClick(Locator ele) {
        ele.scrollIntoViewIfNeeded();
        ele.click(new Locator.ClickOptions().setTimeout(5000));
    }


    // ---------------------- WAIT FOR LOADER -------------------------

    public void waitUntilLoadComplete() {
        Locator loader = page.locator("//div[@class='oxd-loading-spinner-container']/div");
        loader.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN));
    }


    // ---------------------- SCREENSHOT ------------------------------

    public void takeScreenshot() {
        byte[] ss = page.screenshot(new Page.ScreenshotOptions().setType(ScreenshotType.PNG));
        String name = AppHooks.scenario.getName().replaceAll(" ", "") + ".png";
        AppHooks.scenario.attach(ss, "image/png", name);
    }


    // ---------------------- ERROR MESSAGE ---------------------------

    public String checkErrorMessage(Page page2) {
        Locator msg = page.locator(
                "//div[text()='Warning: No match for E-Mail Address and/or Password.']|" +".//div[contains(@style,'color: red')] | " +".//span[text()='Required'] | " +".//span[text()='Should be at least 5 characters'] |" +
                        ".//span[text()='Passwords do not match'] |" +
                        ".//span[text()='Invalid']"
        );

        if (msg.isVisible()) {
            return msg.innerText();
        }
        return null;
    }


    // ---------------------- LIST CLICK ------------------------------

    public void listClick(List<Locator> list) {
        for (Locator ele : list) {
            if (ele.isVisible()) {
                ele.click();
                break;
            }
        }
    }


    // ---------------------- INPUT FIELD FILL -------------------------

    public void inputField(String label, String data) {
        Locator field = page.locator("//label[text()='" + label + "']/following::input[1]");
        field.fill("");
        field.fill(data);
    }

    public void textAreaInput(String placeholder, String data) {
        Locator area = page.locator("textarea[placeholder='" + placeholder + "']");
        if (area.isVisible()) area.fill(data);
    }


    // ---------------------- BUTTON CLICK -----------------------------

    public void buttonClick(String btnName) {
        Locator button = page.locator("//button[normalize-space(text())='" + btnName + "']");
        button.click();
    }


    // ---------------------- TABLE ACTIONS -----------------------------

    public void deleteRow(String uniqueText) {
        Locator deleteBtn = page.locator(
                "//div[text()='" + uniqueText + "']/following::div/button/i[contains(@class,'bi-trash')]"
        );

        deleteBtn.click();
        page.locator("//button[text()=' Yes, Delete ']").click();
    }

    public void editRow(String uniqueText) {
        Locator editBtn = page.locator(
                "//div[text()='" + uniqueText + "']/following::div/button[2]/i[contains(@class,'bi-pencil')]"
        );

        editBtn.click();
    }


    // ---------------------- ALERT CHECK ------------------------------

  




    // ---------------------- SUCCESS MESSAGE --------------------------

    public String successMessage() {
        Locator msg = page.locator(
                "//div[@class='oxd-toast-content oxd-toast-content--success']/p"
        );

        if (msg.isVisible()) return msg.innerText();
        return "";
    }


    // ---------------------- FILE UPLOAD ------------------------------

    public void fileUpload(String selector, Path filePath) {
        Locator uploadBtn = page.locator(selector);
        uploadBtn.setInputFiles(filePath);
    }


    // ---------------------- WINDOW HANDLES ---------------------------

    public void switchToNewWindow() {
        Page newPage = page.waitForPopup(() -> {});
        AppHooks.page = newPage; // set new page globally
    }

}
