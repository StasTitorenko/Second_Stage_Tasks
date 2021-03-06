package hurtMePlenty.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorResultsPage extends AbstractPage {

    @FindBy(xpath = "//span[@class='ng-binding ng-scope']")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding' and contains(text(),'Region:')]")
    private WebElement dataCenter;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding' and contains(text(),'Commitment term:')]")
    private WebElement commitmentTerm;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding' and contains(text(),'VM class:')]")
    private WebElement machineClass;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding cpc-cart-multiline flex' and contains(text(),'Instance type:')]")
    private WebElement instanceType;

    @FindBy(xpath = "//div[@class='md-list-item-text flex']")
    private WebElement operationSystem;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding cpc-cart-multiline flex' and contains(text(),'GPU')]")
    private WebElement gpu;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding cpc-cart-multiline flex' and contains(text(),'Local')]")
    private WebElement ssd;

    @FindBy(xpath = "//b[contains(text(),'Estimated Component Cost')]")
    private WebElement totalCost;

    public CalculatorResultsPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor executor) {
        super(driver, wait, executor);
    }

    public String getNumberOfInstances() {
        return numberOfInstances.getText();
    }

    public String getDataCenter() {
        return dataCenter.getText();
    }

    public String getCommitmentTerm() {
        return commitmentTerm.getText();
    }

    public String getMachineClass() {
        return machineClass.getText();
    }

    public String getInstanceType() {
        return instanceType.getText();
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
