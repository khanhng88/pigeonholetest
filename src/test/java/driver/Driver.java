package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;


import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;
    private static String browser;
    public static final int globalTimeOut = 5;

    public Driver(String browser) {
        this.browser = browser;
    }


    public static WebDriver createWebDriver() {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = createChromeDriver();
        } else {
            driver = createFirefoxDriver();
        }
        return driver;
    }

    public static WebDriver getWebDriver() {
        if (driver == null) {
            driver = createWebDriver();
        }
        return driver;
    }

    private static ChromeDriver createChromeDriver() {
        String currentProjectLocation = System.getProperty("user.dir");
        String chromeDriverLocation = currentProjectLocation + "\\src\\test\\java\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");

        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(globalTimeOut, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    private static FirefoxDriver createFirefoxDriver() {
        String currentProjectLocation = System.getProperty("user.dir");
        String firefoxDriverLocation = currentProjectLocation + "\\src\\test\\java\\resources\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", firefoxDriverLocation);

        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("webdriver.load.strategy", "unstable");
        options.setProfile(firefoxProfile);

        FirefoxDriver driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(globalTimeOut, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}