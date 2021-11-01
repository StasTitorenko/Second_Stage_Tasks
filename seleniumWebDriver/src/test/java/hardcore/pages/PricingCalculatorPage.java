package hardcore.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PricingCalculatorPage extends AbstractPage {
    JavascriptExecutor executor = (JavascriptExecutor) driver;

    @FindBy(xpath = "//*[@id='cloud-site']/*/*")
    private WebElement mainFrame;

    @FindBy(xpath = "//div[@class='name ng-binding' and contains(text(),'Compute Engine')]")
    private WebElement computeEngineButton;

    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstancesField;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.os']")
    private WebElement operationSystemContainer;

    @FindBy(xpath = "//md-option[@value='free']")
    private WebElement operationSystem;

    @FindBy(xpath = "//md-select[@placeholder='VM Class']")
    private WebElement machineClassContainer;

    @FindBy(xpath = "//md-option[@value='regular']")
    private WebElement machineClass;

    @FindBy(xpath = "//md-select[@placeholder='Series']")
    private WebElement seriesContainer;

    @FindBy(xpath = "//md-option[@ng-value='item.value' and @value='n1']")
    private WebElement series;

    @FindBy(xpath = "//md-select[@placeholder='Instance type']")
    private WebElement machineTypeContainer;

    @FindBy(xpath = "//md-option[contains(@value,'N1-STANDARD-8')]")
    private WebElement machineType;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement gpuCheckBox;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGpuContainer;

    @FindBy(xpath = "//md-option[contains(@ng-repeat,'gpuType') and @value='1']")
    private WebElement numberOfGpu;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement gpuTypeContainer;

    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']")
    private WebElement gpuType;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.ssd']")
    private WebElement localSSDContainer;

    @FindBy(xpath = "//md-option[contains(@ng-repeat,'dynamicSsd') and @value='2']")
    private WebElement localSSD;

    @FindBy(xpath = "//md-select[contains(@ng-model,'computeServer.location')]")
    private WebElement dataCenterContainer;

    @FindBy(xpath = "//md-option[contains(@ng-repeat,'dynamicSsd') and @value='2']")
    private WebElement dataCenter;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.cud']")
    private WebElement committedUsageContainer;

    @FindBy(xpath = "//md-option[@ng-value='1']/*[text()='1 Year']")
    private WebElement committedUsage;

    @FindBy(xpath = "//button[contains(@ng-click,'ComputeEngineForm')]")
    private WebElement resultsButton;

    public PricingCalculatorPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public PricingCalculatorPage frameSwitch() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(mainFrame));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myFrame"));
        computeEngineButton.click();
        return this;
    }

    public PricingCalculatorPage selectChapter() {
        computeEngineButton.click();
        return this;
    }

    public PricingCalculatorPage setNumberOfInstances() {
        numberOfInstancesField.sendKeys("4");
        return this;
    }

    public PricingCalculatorPage setOperatingSystem() {
        executor.executeScript("arguments[0].click(), arguments[1].click()",
                operationSystemContainer, operationSystem);
        return this;
    }

    public PricingCalculatorPage setMachineClass() {
        executor.executeScript("arguments[0].click(), arguments[1].click()",
                machineClassContainer, machineClass);
        return this;
    }

    public PricingCalculatorPage setMachineSeries() {
        executor.executeScript("arguments[0].click(), arguments[1].click()",
                seriesContainer, series);
        return this;
    }

    public PricingCalculatorPage setMachineType() {
        executor.executeScript("arguments[0].click(), arguments[1].click()",
                machineTypeContainer, machineType);
        return this;
    }

    public PricingCalculatorPage addGpus() {
        executor.executeScript("arguments[0].click()", gpuCheckBox);
        return this;
    }

    public PricingCalculatorPage setNumberOfGpus() {
        executor.executeScript("arguments[0].click(), arguments[1].click()",
                numberOfGpuContainer, numberOfGpu);
        return this;
    }

    public PricingCalculatorPage setGpuType() {
        executor.executeScript("arguments[0].click(), arguments[1].click()",
                gpuTypeContainer, gpuType);
        return this;
    }

    public PricingCalculatorPage setNumberOfSSD() {
        executor.executeScript("arguments[0].click(), arguments[1].click()",
                localSSDContainer, localSSD);
        return this;
    }

    public PricingCalculatorPage setDataCenter() {
        executor.executeScript("arguments[0].click(), arguments[1].click()",
                dataCenterContainer, dataCenter);
        return this;
    }

    public PricingCalculatorPage setCommittedUsage() {
        executor.executeScript("arguments[0].click(), arguments[1].click()",
                committedUsageContainer, committedUsage);
        return this;
    }

    public PricingCalculatorResultsPage clickResultsButton() {
        executor.executeScript("arguments[0].click()", resultsButton);
        return new PricingCalculatorResultsPage(driver, wait);
    }
}