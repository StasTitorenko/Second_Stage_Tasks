package iCanWin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://pastebin.com";
    private static final String PASTE = "Hello from WebDriver";
    private static final String PASTE_NAME = "helloweb";

    @FindBy(id = "postform-text")
    private WebElement textField;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement pasteExpirationContainer;

    @FindBy(xpath = "//*[@class='select2-results__option' and text()='10 Minutes']")
    private WebElement pasteExpiration;

    @FindBy(id = "postform-name")
    private WebElement pasteName;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnCreateNewPaste;

    public HomePage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    public HomePage openPage() {
        driver.get(HOMEPAGE_URL);
        wait.until(ExpectedConditions.visibilityOf(btnCreateNewPaste));
        return this;
    }

    public HomePage enterPaste() {
        textField.sendKeys(PASTE);
        return this;
    }

    public HomePage setPasteExpiration() {
        actions.moveToElement(btnCreateNewPaste).perform();
        wait.until(ExpectedConditions.elementToBeClickable(pasteExpirationContainer));
        pasteExpirationContainer.click();
        pasteExpiration.click();
        return this;
    }

    public HomePage setPasteName() {
        pasteName.sendKeys(PASTE_NAME);
        return this;
    }

    public NewPastePage createNewPaste() {
        btnCreateNewPaste.submit();
        return new NewPastePage(driver, wait, actions);
    }
}
