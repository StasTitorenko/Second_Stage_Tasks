package framework.pages.tempMail;

import framework.pages.AbstractPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.ArrayList;

public class EmailPage extends AbstractPage {
    private static final String EMAIL_URL = "https://tempmail.plus/";

    @FindBy(id = "pre_copy")
    private WebElement copyEmailAddressButton;

    @FindBy(xpath = "//div[@class='row no-gutters']")
    private WebElement incomingEmail;

    @FindBy(xpath = "//div[text()='Google Cloud Platform Price Estimate']")
    private WebElement headerOfMail;

    @FindBy(xpath = "//h2[contains(text(),'USD')]")
    private WebElement totalCost;


    public EmailPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor executor) {
        super(driver, wait, executor);
    }

    public EmailPage openPage() {
        driver.get(EMAIL_URL);
        return this;
    }

    public EmailPage clickButtonToCopyRandomEmailAddressToClipboard() {
        wait.until(ExpectedConditions.elementToBeClickable(copyEmailAddressButton));
        copyEmailAddressButton.click();
        return this;
    }

    public void switchToResultsPage() {
        ArrayList<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(0));
    }

    public EmailPage openMailFromGoogleCalculatorAndScrollToCost() {
        wait.until(ExpectedConditions.visibilityOf(incomingEmail));
        incomingEmail.click();
        wait.until(ExpectedConditions.visibilityOf(headerOfMail));
        jsScrollElementIntoViewAndClickIt(headerOfMail , "Email Header");
        jsScrollElementIntoViewAndClickIt(totalCost , "Total Cost");
        return this;
    }

    public String getTotalCost() {
        return ("Total " + totalCost.getText() + " per 1 month");
    }
}


