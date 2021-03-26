package edu.githubproject.app.web.tools.drivers;

import edu.githubproject.app.web.tools.utilities.PropertiesReader;
import org.openqa.selenium.WebDriver;

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
