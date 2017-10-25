package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FirstPage extends Page {

    @FindBy(name = "q")
    private WebElement searchField;

    @FindBy(xpath = "//a[contains(@href, 'products')]")
    private WebElement jetBrainsProductLink;

    @FindBy(xpath = "//a[contains(@href, 'download') ]")
    private WebElement downloadIdeaLink;

    public FirstPage(WebDriver driver) {
        super(driver);
    }

    public FirstPage findJetBrainsProductlink() {
        searchField.sendKeys("jet brains");
        searchField.sendKeys(Keys.ENTER);
        return new FirstPage(driver);
    }

    public boolean isProductLinkPresented() {
        return jetBrainsProductLink.isDisplayed();
    }

    public FirstPage findIdeaDownloadLink() {
        searchField.clear();
        searchField.sendKeys("intellij idea");
        searchField.sendKeys(Keys.ENTER);
        return new FirstPage(driver);
    }

    public boolean isDownloadLinkPresented() {
        return downloadIdeaLink.isDisplayed();
    }
}