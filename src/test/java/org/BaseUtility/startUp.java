package org.BaseUtility;

import com.microsoft.playwright.*;

import java.util.ArrayList;
import java.util.List;

public class startUp {

    public Playwright playwright;
    public Browser browser;
    public BrowserContext context;
    public Page page;

    // ******************** BROWSER STARTUP ********************
    public Page startBrowser(String browserName, String url) {

        playwright = Playwright.create();

        if (browserName.equalsIgnoreCase("ch") || browserName.equalsIgnoreCase("chrome")) {
            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );

        } else if (browserName.equalsIgnoreCase("ff") || browserName.equalsIgnoreCase("firefox")) {
            browser = playwright.firefox().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );

        } else if (browserName.equalsIgnoreCase("ed") || browserName.equalsIgnoreCase("edge")) {
            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setChannel("msedge")
                            .setHeadless(false)
            );

        } else {
            System.out.println("Invalid browser name");
        }

        context = browser.newContext();
        page = context.newPage();
        page.navigate(url);

        return page;
    }

    // ******************** NAVIGATION ********************
    public void hitUrl(String url) {
        page.navigate(url);
    }

    // ******************** SCROLL OPERATIONS ********************
    public void scrollByPageDown(int count) {
        for (int i = 0; i < count; i++) {
            page.keyboard().press("PageDown");
        }
    }

    public void scrollIntoView(Locator locator) {
        locator.scrollIntoViewIfNeeded();
    }

    public void scrollByJS(int yPixel) {
        page.evaluate("window.scrollBy(0, " + yPixel + ")");
    }

    // ******************** CLICK (JS equivalent) ********************
    public void clickByJS(Locator locator) {
        locator.evaluate("ele => ele.click()");
    }

    // ******************** GET TEXT / ATTRIBUTE ********************
    public String getElementText(Locator locator) {
        return locator.innerText();
    }

    public String getAttribute(Locator locator, String attributeName) {
        return locator.getAttribute(attributeName);
    }

    // ******************** DROPDOWN UTILITIES ********************
    public ArrayList<String> getAllDropdownText(Locator dropdown) {
        List<String> items = dropdown.locator("option").allInnerTexts();
        return new ArrayList<>(items);
    }

    public int getDropdownCount(Locator dropdown) {
        return dropdown.locator("option").count();
        
    }
    
}
        
        
        
