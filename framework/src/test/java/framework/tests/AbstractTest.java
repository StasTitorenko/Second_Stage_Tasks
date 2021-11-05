package framework.tests;

import framework.driver.DriverSingleton;
import framework.models.Calculator;
import framework.pages.googleCloud.CalculatorResultsPage;
import framework.pages.googleCloud.HomePage;
import framework.service.CalculatorCreator;
import framework.util.FormatFields;
import framework.util.TestListener;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.time.Duration;

@Listeners({TestListener.class})
public class AbstractTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor executor;
    protected CalculatorResultsPage calculatorResultsPage;
    protected String costFromGoogleCalculator;
    protected Calculator calculator = CalculatorCreator.withCredentialsFromProperty();

    @BeforeSuite(alwaysRun = true)
    public void setupBrowser() {
        driver = DriverSingleton.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        executor = (JavascriptExecutor) driver;
    }

    @BeforeClass(alwaysRun = true)
    public void openGooglePricingCalculatorAndFillInFields() {
        calculatorResultsPage = new HomePage(driver, wait, executor)
                .openPage()
                .clickSearchButton()
                .inputSearchQuery()
                .goToCalculatorPage()
                .frameSwitch()
                .selectTab()
                .setNumberOfInstances()
                .setOperatingSystem()
                .setMachineClass()
                .setMachineSeries()
                .setMachineType()
                .addGPU()
                .setNumberOfGPU()
                .setGPUType()
                .setNumberOfSSD()
                .setDataCenter()
                .setCommittedUsage()
                .clickResultsButton();
        costFromGoogleCalculator = new FormatFields()
                .refactorTotalCost(calculatorResultsPage.getTotalCost());
    }

    @AfterSuite(alwaysRun = true)
    public void closeBrowser() {
        DriverSingleton.closeDriver();
    }
}
