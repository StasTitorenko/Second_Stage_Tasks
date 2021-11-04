package hurtMePlenty.test;

import hurtMePlenty.featuredCategories.*;
import hurtMePlenty.pages.CalculatorResultsPage;
import hurtMePlenty.pages.HomePage;
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

public class HurtMePlenty {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor executor;
    private CalculatorResultsPage calculatorResultsPage;
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
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
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        executor = (JavascriptExecutor) driver;
    }

    @BeforeClass(alwaysRun = true)
    public void openSiteAndFillInFields() {
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
    }

    @Test(description = "Compare Number Of Instances obtained from the site with the given one")
    public void compareNumberOfInstance() {
        Assert.assertEquals(calculatorResultsPage.getNumberOfInstances(),
                NUMBER_OF_INSTANCES + " x",
                "Number of instances are not equals");
    }

    @Test(description = "Compare Region obtained from the site with the given one")
    public void compareRegion() {
        Assert.assertEquals(calculatorResultsPage.getDataCenter(),
                "Region: " + DATA_CENTER,
                "Data centers are not equals");
    }

    @Test(description = "Compare Commitment Term obtained from the site with the given one")
    public void compareCommitmentTerm() {
        Assert.assertEquals(calculatorResultsPage.getCommitmentTerm(),
                "Commitment term: " + COMMITTED_USAGE,
                "Committed usages are not equals");
    }

    @Test(description = "Compare Machine Class obtained from the site with the given one")
    public void compareVMClass() {
        Assert.assertEquals(calculatorResultsPage.getMachineClass(),
                "VM class: " + MACHINE_CLASS,
                "Machine classes are not equals");
    }

    @Test(description = "Compare Machine type obtained from the site with the given one")
    public void compareMachineType() {
        Assert.assertEquals(calculatorResultsPage.getInstanceType(),
                "Instance type: " + MACHINE_TYPE.toString().toLowerCase() + "\nCommitted Use Discount applied",
                "Machine types are not equals");
    }

    @Test(description = "Compare Operation System obtained from the site with the given one")
    public void compareOperationSystem() {
        Assert.assertEquals(calculatorResultsPage.getOperationSystem(),
                "Operating System / Software: " + (Character.toUpperCase(OPERATION_SYSTEM.toString().charAt(0)) + OPERATION_SYSTEM.toString().substring(1)),
                "Operation systems are not equals");
    }

    @Test(description = "Compare GPU obtained from the site with the given one")
    public void compareGPU() {
        Assert.assertEquals(calculatorResultsPage.getGPU(),
                "GPU dies: " + NUMBER_OF_GPUS + " " + GPU_TYPE.toString().replaceFirst("Tesla", "TESLA") + "\nCommitted Use Discount applied",
                "GPU are not equal");
    }

    @Test(description = "Compare SSD obtained from the site with the given one")
    public void compareSSD() {
        Assert.assertEquals(calculatorResultsPage.getSSD(),
                "Local SSD: " + NUMBER_OF_SSD + "x375 GiB\nCommitted Use Discount applied",
                "SSD are not equals");
    }

    @Test(description = "Compare Total cost obtained from the site with the given one")
    public void compareTotalCost() {
        Assert.assertTrue(calculatorResultsPage.getTotalCost().contains("USD 5,413.06 per 1 month"),
                "Cost is not USD 5,413.06 per 1 month");

    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}
