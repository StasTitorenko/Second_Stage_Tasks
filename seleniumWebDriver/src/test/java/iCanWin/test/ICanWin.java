package iCanWin.test;

import iCanWin.featuredCategories.PasteExpiration;
import iCanWin.pages.HomePage;
import iCanWin.pages.NewPastePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class ICanWin {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private NewPastePage newPastePage;
    private static final String HOMEPAGE_URL = "https://pastebin.com";
    private static final String PASTE_CODE = "Hello from WebDriver";
    private static final String PASTE_NAME = "helloweb";
    private static final PasteExpiration PASTE_EXPIRATION = PasteExpiration.TEN_MINUTES;

    @BeforeClass(alwaysRun = true)
    public void SetupBrowser() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        driver.manage().window().maximize();
    }

    @BeforeClass(alwaysRun = true)
    public void openSiteAndFillInPasteFields() {
        newPastePage = new HomePage(driver, wait, actions)
                .openPage(HOMEPAGE_URL)
                .enterPaste(PASTE_CODE)
                .setPasteExpiration(PASTE_EXPIRATION)
                .setPasteName(PASTE_NAME)
                .createNewPaste();
    }

    @Test(description = "Comparison of the paste received from the site and the given one")
    public void comparePasteResult() {
        Assert.assertEquals(newPastePage.getNewPasteCode(), PASTE_CODE, "Pastes are not equal");
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}
