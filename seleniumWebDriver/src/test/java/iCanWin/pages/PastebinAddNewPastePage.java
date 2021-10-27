package iCanWin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinAddNewPastePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//*[@class='textarea']")
    WebElement resultData;

    public PastebinAddNewPastePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public String checkOfCreateNewPaste() {
        wait.until(ExpectedConditions.visibilityOf(resultData));
        return resultData.getText();
    }
}
