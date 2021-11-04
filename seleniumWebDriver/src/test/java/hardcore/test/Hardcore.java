package hardcore.test;

import hardcore.featuredCategories.*;
import hardcore.pages.googleCloud.CalculatorResultsPage;
import hardcore.pages.googleCloud.HomePage;
import hardcore.pages.tempMail.EmailPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class Hardcore {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor executor;
    private CalculatorResultsPage calculatorResultsPage;
    private EmailPage emailPage;
    private String costResultFromGoogleCalculator;
    private String costResultFromMail;
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private static final String EMAIL_URL = "https://tempmail.plus/";
    private static final String SEARCH_QUERY = "Google Cloud Platform Pricing Calculator";
    private static final Tabs TABS = Tabs.COMPUTE_ENGINE;
    private static final int NUMBER_OF_INSTANCES = 4;
    private static final OperationSystem OPERATION_SYSTEM = OperationSystem.FREE_DEBIAN_CENTOS_COREOS_UBUNTU_OR_BYOL;
    private static final MachineClass MACHINE_CLASS = MachineClass.REGULAR;
    private static final MachineSeries MACHINE_SERIES = MachineSeries.N1;
    private static final MachineType MACHINE_TYPE = MachineType.N1_STANDARD_8;
    private static final NumberOfGPU NUMBER_OF_GPUS = NumberOfGPU.ONE;
    private static final GPUType GPU_TYPE = GPUType.NVIDIA_TESLA_V100;
    private static final NumberOfSSD NUMBER_OF_SSD = NumberOfSSD.TWO_X_375_GB;
    private static final DataCenter DATA_CENTER = DataCenter.IOWA;
    private static final CommittedUsage COMMITTED_USAGE = CommittedUsage.ONE_YEAR;

    @BeforeSuite(alwaysRun = true)
    public void setupBrowser() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        executor = (JavascriptExecutor) driver;
    }

    @BeforeClass(alwaysRun = true)
    public void openGooglePricingCalculatorAndFillInFields() {
        calculatorResultsPage = new HomePage(driver, wait, executor)
                .openPage(HOMEPAGE_URL)
                .clickSearchButton()
                .inputSearchQuery(SEARCH_QUERY)
                .goToCalculatorPage()
                .frameSwitch()
                .selectTab(TABS)
                .setNumberOfInstances(NUMBER_OF_INSTANCES)
                .setOperatingSystem(OPERATION_SYSTEM)
                .setMachineClass(MACHINE_CLASS)
                .setMachineSeries(MACHINE_SERIES)
                .setMachineType(MACHINE_TYPE)
                .addGPU()
                .setNumberOfGPU(NUMBER_OF_GPUS)
                .setGPUType(GPU_TYPE)
                .setNumberOfSSD(NUMBER_OF_SSD)
                .setDataCenter(DATA_CENTER)
                .setCommittedUsage(COMMITTED_USAGE)
                .clickResultsButton();
        costResultFromGoogleCalculator = (calculatorResultsPage.getTotalCost());
        costResultFromGoogleCalculator = costResultFromGoogleCalculator.substring(0, 16) + "Monthly "
                + costResultFromGoogleCalculator.substring(16);
    }

    @BeforeClass(alwaysRun = true, dependsOnMethods = "openGooglePricingCalculatorAndFillInFields")
    public void createNewEmailTabAndCopyRandomGeneratedEmailToClipboard() {
        emailPage = calculatorResultsPage.createNewEmailTab()
                .openPage(EMAIL_URL)
                .clickButtonToCopyRandomEmailAddressToClipboard();
    }

    @BeforeClass(alwaysRun = true, dependsOnMethods = "createNewEmailTabAndCopyRandomGeneratedEmailToClipboard")
    public void switchToPricingCalculatorTabAndSendEmail() {
        emailPage.switchToResultsPage();
        calculatorResultsPage.clickEmailEstimateButton()
                .insertEmailAddressFromClipboardToInputField()
                .clickEmailSendButton();
    }

    @BeforeClass(alwaysRun = true, dependsOnMethods = "switchToPricingCalculatorTabAndSendEmail")
    public void switchToEmailTabAndReceiveMail() {
        calculatorResultsPage.SwitchToEmailTab();
        costResultFromMail = emailPage.openMailFromGoogleCalculatorAndScrollToCost()
                .getTotalCost();
    }

    @Test(description = "Compare the cost received on the website and in the letter")
    public void compareTotalCost() {
        Assert.assertEquals(costResultFromGoogleCalculator, costResultFromMail, "wrong");
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}
