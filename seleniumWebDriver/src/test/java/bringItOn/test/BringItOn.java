package bringItOn.test;

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

    @BeforeClass(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        driver.manage().window().maximize();
        newPastePage = new HomePage(driver, wait, actions)
                .openPage()
                .enterPaste()
                .setSyntaxHighlighting()
                .setPasteExpiration()
                .setPasteName()
                .createNewPaste();
    }

    @Test(description = "Check paste name")
    public void checkPasteName() {
        Assert.assertEquals(newPastePage.getNewPasteName(), HomePage.getPasteName(),
                "Paste name not equals");
    }

    @Test(description = "Check syntax Bash")
    public void checkSyntax() {
        Assert.assertTrue(newPastePage.checkNewPasteSyntax(),
                "Paste Syntax is not Bash");
    }

    @Test(description = "Check code")
    public void checkCode() {
        Assert.assertEquals(newPastePage.getNewPasteText(), HomePage.getPASTE(),
                "Paste code is not equals");
    }

    @AfterClass(alwaysRun = true)
    public void browserClose() {
        driver.quit();
        driver = null;
    }
}
