package hardcore.pages.tempMail;

import hardcore.pages.AbstractPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class EmailPage extends AbstractPage {
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

    public EmailPage openPage(String url) {
        driver.get(url);
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
        jsScrollElementIntoViewAndClickIt(headerOfMail);
        jsScrollElementIntoViewAndClickIt(totalCost);
        return this;
    }

    public String getTotalCost() {
        return ("Total " + totalCost.getText() + " per 1 month");
    }
}


