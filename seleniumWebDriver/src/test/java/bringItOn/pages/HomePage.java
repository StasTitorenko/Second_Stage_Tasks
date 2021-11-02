package bringItOn.pages;

import bringItOn.featuredCategories.PasteExpiration;
import bringItOn.featuredCategories.SyntaxHighlighting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {
    @FindBy(id = "select2-postform-format-container")
    private WebElement syntaxHighlightingContainer;

    @FindBy(id = "postform-text")
    private WebElement textField;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement pasteExpirationContainer;

    @FindBy(id = "postform-name")
    private WebElement pasteNameField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnCreateNewPaste;

    public HomePage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    public HomePage openPage(String homepageURL) {
        driver.get(homepageURL);
        wait.until(ExpectedConditions.visibilityOf(btnCreateNewPaste));
        return this;
    }

    public HomePage enterPaste(String pasteCode) {
        textField.sendKeys(pasteCode);
        return this;
    }

    public HomePage moveToSyntaxHighlightingContainerAndClickIt() {
        actions.moveToElement(btnCreateNewPaste).perform();
        syntaxHighlightingContainer.click();
        return this;
    }

    public HomePage moveToPasteExpirationContainerAndClickIt() {
        actions.moveToElement(btnCreateNewPaste).perform();
        pasteExpirationContainer.click();
        return this;
    }

    public HomePage setContainerValue(String value) {
        String locator = String.format("//*[@class='select2-results__option' and text()='%s']",
                value);
        driver.findElement(By.xpath(locator)).click();
        return this;
    }

    public HomePage setPasteName(String pasteName) {
        pasteNameField.sendKeys(pasteName);
        return this;
    }

    public NewPastePage createNewPaste() {
        btnCreateNewPaste.submit();
        return new NewPastePage(driver, wait, actions);
    }
}