package hurtMePlenty.test;

import hurtMePlenty.pages.CalculatorResultsPage;
import hurtMePlenty.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class HurtMePlenty {
    private WebDriver driver;
    private WebDriverWait wait;
    CalculatorResultsPage calculatorResultsPage;

    @BeforeClass(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        calculatorResultsPage = new HomePage(driver, wait)
                .openPage()
                .clickSearchButton()
                .inputSearchQuery()
                .followCalculatorPage()
                .frameSwitch()
                .choiceChapter()
                .setNumberOfInstances()
                .setOperatingSystem()
                .setMachineClass()
                .setMachineSeries()
                .setMachineType()
                .addGpus()
                .setNumberOfGpus()
                .setGpuType()
                .setNumberOfSSD()
                .setDataCenter()
                .setCommittedUsage()
                .pressResultsButton();
    }

    @Test(description = "Compare Number Of Instances")
    public void compareNumberOfInstance() {
        Assert.assertTrue(calculatorResultsPage.getNumberOfInstances().contains("4"), "Number of instances are not 4");
    }

    @Test(description = "Compare Region")
    public void compareRegion() {
        Assert.assertTrue(calculatorResultsPage.getRegion().contains("Iowa"), "Region is not Iowa");
    }

    @Test(description = "Compare Commitment Term")
    public void compareCommitmentTerm() {
        Assert.assertTrue(calculatorResultsPage.getCommitmentTerm().contains("1 Year"), "Committed term is not 1 year");
    }

    @Test(description = "Compare VM Class")
    public void compareVMClass() {
        Assert.assertTrue(calculatorResultsPage.getVMClass().contains("regular"), "VM class is not regular");
    }

    @Test(description = "Compare Instance type")
    public void compareInstanceType() {
        Assert.assertTrue(calculatorResultsPage.getInstanceType().contains("n1-standard-8"), "Instance type is not n1-standard-8");
    }

    @Test(description = "Compare Operation System")
    public void compareOperationSystem() {
        Assert.assertEquals(calculatorResultsPage.getOperationSystem(), "Operating System / Software: Free", "Number of instance are not equals");
    }

    @Test(description = "Compare GPU")
    public void compareGPU() {
        Assert.assertTrue(calculatorResultsPage.getGPU().contains("1 NVIDIA TESLA V100"), "GPU is not 1x NVIDIA TESLA V100");
    }

    @Test(description = "Compare SSD")
    public void compareSSD() {
        Assert.assertTrue(calculatorResultsPage.getSSD().contains("2x375 GiB"), "SSD is not 2x375 GiB");
    }

    @Test(description = "Compare Total cost")
    public void compareTotalCost() {
        Assert.assertTrue(calculatorResultsPage.getTotalCost().contains("USD 5,413.06 per 1 month"), "Cost is not USD 5,413.06 per 1 month");
    }

    @AfterClass(alwaysRun = true)
    public void browserClose() {
        driver.quit();
        driver = null;
    }
}
