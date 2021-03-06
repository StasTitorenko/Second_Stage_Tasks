package iCanWin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewPastePage extends AbstractPage {
    @FindBy(xpath = "//*[@class='textarea']")
    WebElement resultData;

    public NewPastePage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    public String getNewPasteCode() {
        wait.until(ExpectedConditions.visibilityOf(resultData));
        return resultData.getText();
    }
}
