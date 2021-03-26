package edu.githubproject.frontend.drivers;

import edu.githubproject.frontend.utilities.PropertiesReader;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (PropertiesReader.getProperty("browser").toLowerCase()) {
                default:
                    driver = ChromeWebDriver.loadChromeDriver(Boolean.parseBoolean(PropertiesReader.getProperty("headless")));
                    break;
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver == null)
            return;

        try {
            driver.close();
            driver.quit();
            driver = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
