package hardcore.pages.googleCloud;

import hardcore.pages.AbstractPage;
import hardcore.pages.tempMail.EmailPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class CalculatorResultsPage extends AbstractPage {
    @FindBy(xpath = "//*[@id='cloud-site']/*/*")
    private WebElement mainFrame;

    @FindBy(xpath = "//b[@class='ng-binding' and contains(text(),'Total Estimated Cost')]")
    private WebElement totalCost;

    @FindBy(xpath = "//button[contains(text(),'Email Estimate')]")
    private WebElement emailEstimateButton;

    @FindBy(xpath = "//input[@ng-model='emailQuote.user.email']")
    private WebElement emailInputField;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement emailSendButton;

    public CalculatorResultsPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor executor) {
        super(driver, wait, executor);
    }

    public String getTotalCost() {
        return totalCost.getText();
    }


    public EmailPage createNewEmailTab() {
        driver.switchTo().newWindow(WindowType.TAB);
        return new EmailPage(driver, wait, executor);
    }


    public void SwitchToEmailTab() {
        ArrayList<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
    }

    public CalculatorResultsPage clickEmailEstimateButton() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(mainFrame));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myFrame"));
        wait.until(ExpectedConditions.elementToBeClickable(emailEstimateButton));
        jsClickElement(emailEstimateButton);
        return this;
    }

    public CalculatorResultsPage insertEmailAddressFromClipboardToInputField() {
        emailInputField.sendKeys(Keys.LEFT_CONTROL, "v");
        return this;
    }

    public CalculatorResultsPage clickEmailSendButton() {
        wait.until(ExpectedConditions.elementToBeClickable(emailSendButton));
        jsClickElement(emailSendButton);
        return this;
    }
}