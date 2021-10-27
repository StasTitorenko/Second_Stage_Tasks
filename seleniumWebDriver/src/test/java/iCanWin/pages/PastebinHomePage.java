package iCanWin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinHomePage {
    private static final String HOMEPAGE_URL = "https://pastebin.com";
    private static final String PASTE = "Hello from WebDriver";
    private static final String PASTE_NAME = "helloweb";
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions actions;

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

    public PastebinHomePage(WebDriver driver, WebDriverWait wait, Actions actions) {
        this.driver = driver;
        this.wait = wait;
        this.actions = actions;
        PageFactory.initElements(driver, this);
    }

    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        wait.until(ExpectedConditions.visibilityOf(btnCreateNewPaste));
        return this;
    }

    public PastebinHomePage enterPaste() {
        textField.sendKeys(PASTE);
        return this;
    }

    public PastebinHomePage setPasteExpiration() {
        actions.moveToElement(btnCreateNewPaste).perform();
        wait.until(ExpectedConditions.elementToBeClickable(pasteExpirationContainer));
        pasteExpirationContainer.click();
        pasteExpiration.click();
        return this;
    }

    public PastebinHomePage setPasteName() {
        pasteName.sendKeys(PASTE_NAME);
        return this;
    }

    public PastebinAddNewPastePage createNewPaste() {
        btnCreateNewPaste.submit();
        return new PastebinAddNewPastePage(driver, wait);
    }
}
