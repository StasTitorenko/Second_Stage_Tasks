package hardcore.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class MailHomePage extends AbstractPage {
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    private static final String URL = "https://10minemail.com/ru/";

    @FindBy(xpath = "//div[contains(@class ,'input-box')]/button[contains(@class ,'click')]")
    private WebElement copyMailAddressButton;

    @FindBy(xpath = "//div[@class='col-box']/a[contains(@href,'10mine')]")
    private WebElement mail;

    @FindBy(xpath = "//h2[contains(text(),'Cost')]")
    private WebElement costFromMail;

    public MailHomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public MailHomePage openPage() {
        driver.get(URL);
        return this;
    }

    public MailHomePage clickButtonToCopyEmailAddressToClipBoard() {
        wait.until(ExpectedConditions.elementToBeClickable(copyMailAddressButton));
        copyMailAddressButton.click();
        return this;
    }

    public void switchToResultsPage() {
        ArrayList<String> browserTabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(0));
    }

    public MailHomePage openMailFromGoogleCalculator() {
        wait.until(ExpectedConditions.elementToBeClickable(mail));
        executor.executeScript("arguments[0].scrollIntoView()", mail);
        mail.click();
        return this;
    }

    public String getMailText() {
        executor.executeScript("arguments[0].scrollIntoView()", costFromMail);
        return costFromMail.getText();
    }
}
