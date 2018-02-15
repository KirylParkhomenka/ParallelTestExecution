package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.FirstPage;
import setup.Browser;
import setup.WebDriverTypes;

public class FirstTest {

    private static final String BASE_URL = "https://google.com/";
    private FirstPage firstPage;
    private WebDriver driver;

    @Parameters("browserName")
    @BeforeClass
    public void initBrowser(WebDriverTypes browserName) {
        driver = Browser.getWrappedDriver(browserName);
        firstPage = new FirstPage(driver);
    }

    @Test(description = "Find JetBrains Product link")
    public void findProductLink(/*WebDriverTypes browserName*/) {
        driver.get(BASE_URL);
        firstPage.findJetBrainsProductlink();
        boolean jetBrainsLinkIsPresented = firstPage.isProductLinkPresented();
        Assert.assertTrue(jetBrainsLinkIsPresented, "Link is not presented");
    }

    @Test(description = "Find IntellijIdea download link", dependsOnMethods = "findProductLink")
    public void secondTest() {
        firstPage.findIdeaDownloadLink();
        boolean ideaLinkIsPresented = firstPage.isDownloadLinkPresented();
        Assert.assertTrue(ideaLinkIsPresented, "Link is not presented");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}