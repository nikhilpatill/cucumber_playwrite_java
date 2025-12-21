package org.hooks;

import com.microsoft.playwright.*;
import io.cucumber.java.*;

public class AppHooks {

    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;
    public static Scenario scenario;

    @Before(order = 1)
    public void initScenario(Scenario scn) {
        scenario = scn;
    }

    @Before(order = 2)
    public void launchBrowser() {

        String url = "https://tutorialsninja.com/demo/index.php?route=account/login";

        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );

        context = browser.newContext(
                new Browser.NewContextOptions().setIgnoreHTTPSErrors(true)
        );

        page = context.newPage();
        page.navigate(url);
    }

    @AfterStep
    public void afterEachStep(Scenario scenario) {

        if (scenario.isFailed() && page != null) {
            byte[] screenshot = page.screenshot(
                    new Page.ScreenshotOptions().setFullPage(true)
            );
            scenario.attach(screenshot, "image/png", "Step Screenshot");
        }
    }

    @After(order = 20)
    public void tearDown() {

        if (page != null) page.close();
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
