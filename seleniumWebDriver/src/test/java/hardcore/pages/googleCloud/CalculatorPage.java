package hardcore.pages.googleCloud;

import hardcore.featuredCategories.*;
import hardcore.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage extends AbstractPage {
    @FindBy(xpath = "//*[@id='cloud-site']/*/*")
    private WebElement mainFrame;

    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstancesField;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.os']")
    private WebElement operationSystemContainer;

    @FindBy(xpath = "//md-select[@placeholder='VM Class']")
    private WebElement machineClassContainer;

    @FindBy(xpath = "//md-select[@placeholder='Series']")
    private WebElement machineSeriesContainer;

    @FindBy(xpath = "//md-select[@placeholder='Instance type']")
    private WebElement machineTypeContainer;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement gpuCheckBox;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGpuContainer;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement gpuTypeContainer;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.ssd']")
    private WebElement localSSDContainer;

    @FindBy(xpath = "//md-select[contains(@ng-model,'computeServer.location')]")
    private WebElement dataCenterContainer;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.cud']")
    private WebElement committedUsageContainer;

    @FindBy(xpath = "//button[contains(@ng-click,'ComputeEngineForm')]")
    private WebElement resultsButton;

    public CalculatorPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor executor) {
        super(driver, wait, executor);
    }

    public CalculatorPage frameSwitch() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(mainFrame));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myFrame"));
        return this;
    }

    public CalculatorPage selectTab(Tabs tab) {
        WebElement element = (driver.findElement(By.xpath(String.format(
                "//div[@class='name ng-binding' and contains(text(),'%s')]", tab))));
        jsClickElement(element);
        return this;
    }

    public CalculatorPage setNumberOfInstances(int numberOfInstances) {
        numberOfInstancesField.sendKeys(String.valueOf(numberOfInstances));
        return this;
    }

    public CalculatorPage setOperatingSystem(OperationSystem operationSystem) {
        makeXpathLocatorAndSetValueFromDropDownList("//md-option[@value='%s']",
                operationSystem, operationSystemContainer);
        return this;
    }

    public CalculatorPage setMachineClass(MachineClass machineClass) {
        makeXpathLocatorAndSetValueFromDropDownList("//md-option[@value='%s']",
                machineClass, machineClassContainer);
        return this;
    }

    public CalculatorPage setMachineSeries(MachineSeries machineSeries) {
        makeXpathLocatorAndSetValueFromDropDownList("//md-option[@ng-value='item.value' and @value='%s']",
                machineSeries, machineSeriesContainer);
        return this;
    }

    public CalculatorPage setMachineType(MachineType machineType) {
        makeXpathLocatorAndSetValueFromDropDownList("//md-option[contains(@value,'%s')]",
                machineType, machineTypeContainer);
        return this;
    }

    public CalculatorPage addGPU() {
        jsClickElement(gpuCheckBox);
        return this;
    }

    public CalculatorPage setNumberOfGPU(NumberOfGPU numberOfGPU) {
        makeXpathLocatorAndSetValueFromDropDownList("//md-option[contains(@ng-repeat,'gpuType') and @value='%s']",
                numberOfGPU, numberOfGpuContainer);
        return this;
    }

    public CalculatorPage setGPUType(GPUType gpuType) {
        makeXpathLocatorAndSetValueFromDropDownList("//div[contains(text(),'%s')]",
                gpuType, gpuTypeContainer);
        return this;
    }

    public CalculatorPage setNumberOfSSD(NumberOfSSD numberOfSSD) {
        makeXpathLocatorAndSetValueFromDropDownList("//md-option[contains(@ng-repeat,'dynamicSsd') and @value='%s']",
                numberOfSSD, localSSDContainer);
        return this;
    }

    public CalculatorPage setDataCenter(DataCenter dataCenter) {
        makeXpathLocatorAndSetValueFromDropDownList("(//div[@class='md-text ng-binding' and contains(text(),'%s')])[1]",
                dataCenter, dataCenterContainer);
        return this;
    }

    public CalculatorPage setCommittedUsage(CommittedUsage committedUsage) {
        makeXpathLocatorAndSetValueFromDropDownList("//md-option[@ng-value='1']/*[text()='%s']",
                committedUsage, committedUsageContainer);
        return this;
    }

    public CalculatorResultsPage clickResultsButton() {
        jsClickElement(resultsButton);
        return new CalculatorResultsPage(driver, wait, executor);
    }

    public <E extends Enum<E>> CalculatorPage makeXpathLocatorAndSetValueFromDropDownList(String path, E enumClass, WebElement container) {
        WebElement element = driver.findElement(By.xpath(String.format(path, enumClass)));
        jsClickElement(container, element);
        return this;
    }
}