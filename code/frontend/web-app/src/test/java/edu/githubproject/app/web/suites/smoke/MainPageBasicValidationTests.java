package edu.githubproject.app.web.suites.smoke;

import static org.junit.jupiter.api.Assertions.*;

import edu.githubproject.app.web.tools.drivers.Driver;
import edu.githubproject.app.web.tools.pages.MainPage;
import edu.githubproject.app.web.tools.utilities.PropertiesReader;
import org.junit.jupiter.api.Test;

public class MainPageBasicValidationTests {

    final MainPage mainPage = new MainPage();

    @Test
    public void mainPageBasicValidation() {
        Driver.getDriver().get(PropertiesReader.getProperty("baseUrl"));

        assertAll(
                () -> assertTrue(Driver.getDriver().getTitle().startsWith("Explore the Uber Platform")),
                () -> assertTrue(mainPage.getLogo().isDisplayed())
                // TODO validate that web-element is displayed
        );
    }
}
