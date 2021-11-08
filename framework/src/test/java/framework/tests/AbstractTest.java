package framework.tests;

import framework.driver.DriverSingleton;
import framework.util.TestListener;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

@Listeners({TestListener.class})
public class AbstractTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor executor;

    @BeforeClass(alwaysRun = true)
    public void setupBrowser() {
        driver = DriverSingleton.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        executor = (JavascriptExecutor) driver;
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        DriverSingleton.closeDriver();
    }
}
