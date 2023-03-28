package tests;

import driver.Driver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    public final String baseUrl = "https://pigeonhole.at";
    public Driver driver;

    public void goToURL(String path) {
        this.driver.getWebDriver().get(baseUrl + path);
    }


    @Parameters("browser")
    @BeforeClass()
    public void setUp( String browser) {
       this.driver = new Driver(browser);
       this.driver.createWebDriver();
    }

    @AfterTest
    public void afterMethod() {
        if (this.driver.getWebDriver() != null)
            this.driver.getWebDriver().quit();
    }
}
