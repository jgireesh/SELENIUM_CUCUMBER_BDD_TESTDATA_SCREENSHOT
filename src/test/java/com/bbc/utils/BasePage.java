package com.bbc.utils;

import cucumber.api.Scenario;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BasePage {
    static final String USER_DIR = System.getProperty("user.dir");
    private String chrome_driverPath = USER_DIR+"\\browser-drivers\\chromedriver.exe";
    public static WebDriver driver;


    public WebDriver getRemoteDriverDynamic() {
        String defaultBrowser = ConfigUtils.getASpecificProperty("browser");
        String headlessFlag = ConfigUtils.getASpecificProperty("browser-headless");
        switch (defaultBrowser) {
            case "chr":
            case "chrome":
                System.setProperty("webdriver.chrome.driver", chrome_driverPath);
                ChromeOptions options = new ChromeOptions();
                options.addArguments(new String[]{"--headless", headlessFlag});
                driver = new ChromeDriver(options);
                break;
            default:
                System.out.println("invalid browser or check test.properties for correct configurations");
                driver = null;
        }
        return driver;
    }
}
