package hardcore.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class PricingCalculatorResultsPage extends AbstractPage {
    JavascriptExecutor executor = (JavascriptExecutor) driver;

    @FindBy(xpath = "//*[@id='cloud-site']/*/*")
    private WebElement mainFrame;

    @FindBy(xpath = "//b[@class='ng-binding' and contains(text(),'Total Estimated Cost')]")
    private WebElement totalCost;

    @FindBy(xpath = "//button[contains(text(),'Email Estimate')]")
    private WebElement emailEstimateButton;

    @FindBy(xpath = "//input[@name='description' and @type='email']")
    private WebElement emailInputField;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement emailSendButton;

    public PricingCalculatorResultsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String getTotalCost() {
        return totalCost.getText();
    }

    public MailHomePage createNewEmailTabAndSwitchToIt() {
        driver.switchTo().newWindow(WindowType.TAB);
        return new MailHomePage(driver, wait);
    }

    public void SwitchToEmailTab() {
        ArrayList<String> browserTabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
    }

    public PricingCalculatorResultsPage clickEmailEstimateButton() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(mainFrame));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myFrame"));
        wait.until(ExpectedConditions.elementToBeClickable(emailEstimateButton));
        executor.executeScript("arguments[0].click()", emailEstimateButton);
        return this;
    }

    public PricingCalculatorResultsPage insertEmailAddressFromClipBoardToInputField() {
        emailInputField.sendKeys(Keys.LEFT_CONTROL, "v");
        return this;
    }

    public PricingCalculatorResultsPage clickEmailSendButton() {
        wait.until(ExpectedConditions.elementToBeClickable(emailSendButton));
        executor.executeScript("arguments[0].click()", emailSendButton);
        return this;
    }
}