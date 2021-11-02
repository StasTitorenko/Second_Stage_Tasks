package bringItOn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewPastePage extends AbstractPage{
    @FindBy(xpath = "//div[@class='info-top']/*")
    private WebElement pasteName;

    @FindBy(xpath = "//div[@class='left']/*")
    private WebElement pasteSyntax;

    @FindBy(xpath = "//textarea")
    private WebElement resultData;

    public NewPastePage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    public String getNewPasteName() {
        wait.until(ExpectedConditions.visibilityOf(pasteName));
        return pasteName.getText();
    }

    public String getNewPasteSyntax() {
        return pasteSyntax.getText();
    }

    public String getNewPasteCode() {
        return resultData.getText();
    }
}
