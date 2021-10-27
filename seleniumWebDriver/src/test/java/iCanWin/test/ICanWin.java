package iCanWin.test;

import iCanWin.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ICanWin {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        driver.manage().window().maximize();
    }

    @Test(description = "Check new paste creation")
    public void comparePasteResult() {
        String expectedPaste = new HomePage(driver, wait, actions)
                .openPage()
                .enterPaste()
                .setPasteExpiration()
                .setPasteName()
                .createNewPaste()
                .getNewPasteText();
        Assert.assertEquals(expectedPaste, "Hello from WebDriver", "Your Paste is wrong");
    }

    @AfterMethod(alwaysRun = true)
    public void browserClose() {
        driver.quit();
        driver = null;
    }
}
