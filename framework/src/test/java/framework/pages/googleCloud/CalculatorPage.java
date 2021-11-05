package framework.pages.googleCloud;

import framework.models.Calculator;
import framework.pages.AbstractPage;
import framework.service.CalculatorCreator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CalculatorPage extends AbstractPage {
    private Calculator calculator = CalculatorCreator.withCredentialsFromProperty();
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
        logger.info("Frame №1 switch - success");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myFrame"));
        logger.info("Frame №2 switch - success");
        return this;
    }

    public CalculatorPage selectTab() {
        WebElement element = (driver.findElement(By.xpath(String.format(
                "//div[@class='name ng-binding' and contains(text(),'%s')]", calculator.getTab()))));
        jsClickElement(element, calculator.getTab().toString());
        return this;
    }

    public CalculatorPage setNumberOfInstances() {
        numberOfInstancesField.sendKeys(String.valueOf(calculator.getNumberOfInstances()));
        logger.info("Set '" + calculator.getNumberOfInstances() + "' instances");
        return this;
    }

    public CalculatorPage setOperatingSystem() {
        makeXpathLocatorAndSetValueFromDropDownList("//md-option[@value='%s']",
                calculator.getOperationSystem(), operationSystemContainer, "operation system");
        return this;
    }

    public CalculatorPage setMachineClass() {
        makeXpathLocatorAndSetValueFromDropDownList("//md-option[@value='%s']",
                calculator.getMachineClass(), machineClassContainer, "machine class");
        return this;
    }

    public CalculatorPage setMachineSeries() {
        makeXpathLocatorAndSetValueFromDropDownList("//md-option[@ng-value='item.value' and @value='%s']",
                calculator.getMachineSeries(), machineSeriesContainer, "machine series");
        return this;
    }

    public CalculatorPage setMachineType() {
        makeXpathLocatorAndSetValueFromDropDownList("//md-option[contains(@value,'%s')]",
                calculator.getMachineType(), machineTypeContainer, "machine type");
        return this;
    }

    public CalculatorPage addGPU() {
        jsClickElement(gpuCheckBox, "Add GPU");
        return this;
    }

    public CalculatorPage setNumberOfGPU() {
        makeXpathLocatorAndSetValueFromDropDownList("//md-option[contains(@ng-repeat,'gpuType') and @value='%s']",
                calculator.getNumberOfGPU(), numberOfGpuContainer, "number of GPU");
        return this;
    }

    public CalculatorPage setGPUType() {
        makeXpathLocatorAndSetValueFromDropDownList("//div[contains(text(),'%s')]",
                calculator.getGpuType(), gpuTypeContainer, "GPU type");
        return this;
    }

    public CalculatorPage setNumberOfSSD() {
        makeXpathLocatorAndSetValueFromDropDownList("//md-option[contains(@ng-repeat,'dynamicSsd') and @value='%s']",
                calculator.getNumberOfSSD(), localSSDContainer, "local SSD");
        return this;
    }

    public CalculatorPage setDataCenter() {
        makeXpathLocatorAndSetValueFromDropDownList("(//div[@class='md-text ng-binding' and contains(text(),'%s')])[1]",
                calculator.getDataCenter(), dataCenterContainer, "data center");
        return this;
    }

    public CalculatorPage setCommittedUsage() {
        makeXpathLocatorAndSetValueFromDropDownList("//md-option/*[text()='%s']",
                calculator.getCommittedUsage(), committedUsageContainer, "committed usage");
        return this;
    }

    public CalculatorResultsPage clickResultsButton() {
        jsClickElement(resultsButton, "results button");
        return new CalculatorResultsPage(driver, wait, executor);
    }

    public <E extends Enum<E>> CalculatorPage makeXpathLocatorAndSetValueFromDropDownList(String path, E enumClass, WebElement container, String containerName) {
        WebElement element = driver.findElement(By.xpath(String.format(path, enumClass)));
        jsClickElement(container, containerName, element, enumClass.toString());
        return this;
    }
}