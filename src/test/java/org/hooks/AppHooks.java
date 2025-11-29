package org.hooks;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.ScreenshotType;

import java.util.Base64;

import com.aventstack.extentreports.MediaEntityBuilder;


import io.cucumber.java.*;

public class AppHooks {

    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;
    public static Scenario scenario;

    // Store open browsers (if needed)
    private static final java.util.Map<String, BrowserContext> browserInstance = new java.util.HashMap<>();


    // ------------------ BEFORE HOOKS ----------------------

    @Before(order = 1)
    public void initScenario(Scenario scn) {
        scenario = scn;
    }

    @Before(order = 2)
    public void launchBrowser() {

        String url = "https://tutorialsninja.com/demo/index.php?route=account/login";

        if (playwright == null) {
            playwright = Playwright.create();
        }

        if (browser == null) {
            browser = playwright.chromium()
                    .launch(new BrowserType.LaunchOptions().setHeadless(false));
        }

        // Reuse or create new context
        if (browserInstance.containsKey(url)) {
            context = browserInstance.get(url);
            page = context.pages().get(0);
        } else {
            context = browser.newContext(
                    new Browser.NewContextOptions()
                            .setIgnoreHTTPSErrors(true)
            );
            page = context.newPage();
            browserInstance.put(url, context);
        }

        page.navigate(url);
    }


    // ------------------ AFTER HOOKS ----------------------
    
    

    @After(order = 10)
    public void takeScreenshot(Scenario scenario) {
       
    }
    

    @After(order = 20)
    public void closeContext() {
        if (context != null) {
            context.close();
        }
    }

    @AfterAll
    public static void afterAll() {
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
