package bringItOn.test;

import bringItOn.featuredCategories.PasteExpiration;
import bringItOn.featuredCategories.SyntaxHighlighting;
import bringItOn.pages.HomePage;
import bringItOn.pages.NewPastePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class BringItOn {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private NewPastePage newPastePage;
    private static final String HOMEPAGE_URL = "https://pastebin.com";
    private static final String PASTE_CODE = """
            git config --global user.name  "New Sheriff in Town"
            git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
            git push origin master --force""";
    private static final SyntaxHighlighting SYNTAX_HIGHLIGHTING = SyntaxHighlighting.BASH;
    private static final String PASTE_NAME = "how to gain dominance among developers";
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
                .moveToSyntaxHighlightingContainerAndClickIt()
                .setContainerValue(SYNTAX_HIGHLIGHTING.toString())
                .moveToPasteExpirationContainerAndClickIt()
                .setContainerValue(PASTE_EXPIRATION.toString())
                .setPasteName(PASTE_NAME)
                .createNewPaste();
    }

    @Test(description = "Comparison of the paste name received from the site and the given one")
    public void comparePasteName() {
        Assert.assertEquals(newPastePage.getNewPasteName(), PASTE_NAME,
                "Paste name are not equal");
    }

    @Test(description = "Comparison of the paste syntax received from the site and the given one")
    public void comparePasteSyntax() {
        Assert.assertEquals(newPastePage.getNewPasteSyntax(), SYNTAX_HIGHLIGHTING.toString(),
                "Paste syntax are not equal");
    }

    @Test(description = "Comparison of the paste code received from the site and the given one")
    public void comparePasteCode() {
        Assert.assertEquals(newPastePage.getNewPasteCode(), PASTE_CODE,
                "Paste syntax are not equal");
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}