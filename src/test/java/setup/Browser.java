package setup;

import org.openqa.selenium.WebDriver;

import static setup.DriverFactory.getWebDriverInstance;

public class Browser {
    private static WebDriver driver;

    public static WebDriver getWrappedDriver(WebDriverTypes browserName) {
        new Browser(browserName);
        return driver;
    }

    private Browser(WebDriverTypes browserName) {
        if (driver == null) {
            try {
                driver = getWebDriverInstance(browserName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}