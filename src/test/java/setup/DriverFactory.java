package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static WebDriver driver;

    private static final String CHROME_DRIVER_PATH = "src/test/java/drivers/chromedriver.exe";
    private static final String FIREFOX_DRIVER_PATH = "src/test/java/drivers/geckodriver.exe";

    private static final int IMPLICIT_WAIT = 10;
    private static final int PAGE_LOAD_TIMEOUT = 10;

    public static WebDriver getWebDriverInstance(WebDriverTypes browserName) throws Exception {
        switch (browserName) {
            case firefox: {
                getFirefoxInstance();
                break;
            }
            case chrome: {
                getChromeInstance();
                break;
            }
            default:
                throw new RuntimeException(browserName.toString() + " is not supported");
        }
        return driver;
    }

    public static WebDriver getFirefoxInstance() {
        System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH);
        driver = new FirefoxDriver();
        prepareTimeouts();
        return driver;
    }

    public static WebDriver getChromeInstance() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        prepareTimeouts();
        return driver;
    }

    private static void prepareTimeouts() {
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    }
}