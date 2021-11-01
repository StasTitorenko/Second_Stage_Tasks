package hardcore.test;

import hardcore.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Hardcore {
    private WebDriver driver;
    private WebDriverWait wait;
    PricingCalculatorResultsPage calculatorResultsPage;
    MailHomePage mailHomePage;
    String costResultFromMail;
    String costResultFromGoogleCalculator;

    @BeforeClass(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        calculatorResultsPage = new GoogleCloudHomePage(driver, wait)
                .openPage()
                .clickSearchButton()
                .inputSearchQuery()
                .goToCalculatorPage()
                .frameSwitch()
                .selectChapter()
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
                .clickResultsButton();
        costResultFromGoogleCalculator = (calculatorResultsPage.getTotalCost())
                .replaceAll("[^\\d.]", "");
        mailHomePage = calculatorResultsPage.createNewEmailTabAndSwitchToIt()
                .openPage()
                .clickButtonToCopyEmailAddressToClipBoard();
        mailHomePage.switchToResultsPage();
        calculatorResultsPage.clickEmailEstimateButton()
                .insertEmailAddressFromClipBoardToInputField()
                .clickEmailSendButton();
        calculatorResultsPage.SwitchToEmailTab();
        costResultFromMail = (mailHomePage.openMailFromGoogleCalculator()
                .getMailText()).replaceAll("[^\\d.]", "");
    }

    @Test(description = "Compare the amount received on the website and in the letter")
    public void compareTotalCost() {
        Assert.assertTrue(costResultFromGoogleCalculator.contains(costResultFromMail));
    }

    @AfterClass(alwaysRun = true)
    public void browserClose() {
        driver.quit();
        driver = null;
    }
}
