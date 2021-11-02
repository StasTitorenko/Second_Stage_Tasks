package iCanWin.pages;

import iCanWin.featuredCategories.PasteExpiration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {
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

    public HomePage setPasteExpiration(PasteExpiration pasteExpiration) {
        actions.moveToElement(btnCreateNewPaste).perform();
        wait.until(ExpectedConditions.elementToBeClickable(pasteExpirationContainer));
        pasteExpirationContainer.click();
        String pasteLocator = String.format("//*[@class='select2-results__option' and text()='%s']",
                pasteExpiration);
        driver.findElement(By.xpath(pasteLocator)).click();

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
