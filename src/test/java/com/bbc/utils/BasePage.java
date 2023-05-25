package com.bbc.utils;

import com.bbc.steps.GeneralStepDefs;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BasePage {
    static final String USER_DIR = System.getProperty("user.dir");
    private final String chrome_driverPath = USER_DIR+"/browser-drivers/chromedriver.exe";
    public static WebDriver driver;

    public BasePage() {
        setup();
    }

    public void setup() {
        if (driver == null) {
            String defaultBrowser = ConfigUtils.getASpecificProperty("browser");
            String headlessFlag = ConfigUtils.getASpecificProperty("browser-headless");
            switch (defaultBrowser) {
                case "chr":
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", chrome_driverPath);
                    ChromeOptions options = new ChromeOptions();
                    //options.addArguments(new String[]{"--headless", headlessFlag});
                    driver = new ChromeDriver(options);
                    break;
                default:
                    System.out.println("invalid browser or check test.properties for correct configurations");
                    driver = null;
            }
        }
    }

    public static void teardown() {
        if (driver != null) {
            if (GeneralStepDefs.getCurrentScenario().isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                GeneralStepDefs.getCurrentScenario().attach(screenshot, "image/png", "failed_" + GeneralStepDefs.getCurrentScenario().getName());
            }
            driver.quit();
            driver = null;
        }
    }
}
