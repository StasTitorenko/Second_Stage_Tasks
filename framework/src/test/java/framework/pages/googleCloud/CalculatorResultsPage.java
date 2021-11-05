package framework.pages.googleCloud;

import framework.pages.AbstractPage;
import framework.pages.tempMail.EmailPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.ArrayList;

public class CalculatorResultsPage extends AbstractPage {
    @FindBy(xpath = "//*[@id='cloud-site']/*/*")
    private WebElement mainFrame;

    @FindBy(xpath = "//button[contains(text(),'Email Estimate')]")
    private WebElement emailEstimateButton;

    @FindBy(xpath = "//input[@ng-model='emailQuote.user.email']")
    private WebElement emailInputField;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement emailSendButton;

    @FindBy(xpath = "//h2[@class='md-toolbar-tools']")
    private WebElement tab;

    @FindBy(xpath = "//span[@class='ng-binding ng-scope']")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding' and contains(text(),'Region:')]")
    private WebElement dataCenter;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding' and contains(text(),'Commitment term:')]")
    private WebElement commitmentUsage;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding' and contains(text(),'VM class:')]")
    private WebElement machineClass;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding cpc-cart-multiline flex' and contains(text(),'Instance type:')]")
    private WebElement machineType;

    @FindBy(xpath = "//div[@class='md-list-item-text flex']")
    private WebElement operationSystem;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding cpc-cart-multiline flex' and contains(text(),'GPU')]")
    private WebElement gpu;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding cpc-cart-multiline flex' and contains(text(),'Local')]")
    private WebElement ssd;

    @FindBy(xpath = "//b[@class='ng-binding' and contains(text(),'Total Estimated Cost')]")
    private WebElement totalCost;


    public CalculatorResultsPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor executor) {
        super(driver, wait, executor);
    }

    public EmailPage createNewEmailTab() {
        driver.switchTo().newWindow(WindowType.TAB);
        logger.info("Create new tab - success");
        return new EmailPage(driver, wait, executor);
    }


    public void SwitchToEmailTab() {
        ArrayList<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
        logger.info("Switch to email tab - success");
    }

    public CalculatorResultsPage clickEmailEstimateButton() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(mainFrame));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myFrame"));
        wait.until(ExpectedConditions.elementToBeClickable(emailEstimateButton));
        jsClickElement(emailEstimateButton, "email estimate button");
        return this;
    }

    public CalculatorResultsPage insertEmailAddressFromClipboardToInputField() {
        emailInputField.sendKeys(Keys.LEFT_CONTROL, "v");
        logger.info("Paste email address - success");
        return this;
    }

    public CalculatorResultsPage clickEmailSendButton() {
        wait.until(ExpectedConditions.elementToBeClickable(emailSendButton));
        jsClickElement(emailSendButton, "email send button");
        return this;
    }

    public String getTab() {
        return tab.getText();
    }

    public String getNumberOfInstances() {
        return numberOfInstances.getText();
    }

    public String getDataCenter() {
        return dataCenter.getText();
    }

    public String getCommitmentUsage() {
        return commitmentUsage.getText();
    }

    public String getMachineClass() {
        return machineClass.getText();
    }

    public String getMachineType() {
        return machineType.getText();
    }

    public String getOperationSystem() {
        return operationSystem.getText();
    }

    public String getGPU() {
        return gpu.getText();
    }

    public String getSSD() {
        return ssd.getText();
    }

    public String getTotalCost() {
        return totalCost.getText();
    }

}