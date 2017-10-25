package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
    @Test(description = "Find JetBrains Product link")
    public void findProductLink(WebDriverTypes browserName) {
        driver = Browser.getWrappedDriver(browserName);
        driver.get(BASE_URL);
        firstPage = new FirstPage(driver);
        firstPage.findJetBrainsProductlink();
        boolean jetBrainsLinkIsPresented = firstPage.isProductLinkPresented();
        Assert.assertTrue(jetBrainsLinkIsPresented, "Link is not presented");
    }

    @Parameters("browserName")
    @Test(description = "Find IntellijIdea download link", dependsOnMethods = "findProductLink")
    public void secondTest() {
        firstPage.findIdeaDownloadLink();
        boolean ideaLinkIsPresented = firstPage.isDownloadLinkPresented();
        Assert.assertTrue(ideaLinkIsPresented, "Link is not presented");
    }
}