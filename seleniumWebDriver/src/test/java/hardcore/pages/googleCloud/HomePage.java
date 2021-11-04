package hardcore.pages.googleCloud;

import hardcore.pages.AbstractPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {
    @FindBy(xpath = "//div[@class='devsite-searchbox']")
    private WebElement searchButton;

    @FindBy(name = "q")
    private WebElement searchInputField;

    public HomePage(WebDriver driver, WebDriverWait wait, JavascriptExecutor executor) {
        super(driver, wait, executor);
    }

    public HomePage openPage(String homepageURL) {
        driver.get(homepageURL);
        return this;
    }

    public HomePage clickSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        jsScrollElementIntoViewAndClickIt(searchButton);
        return this;
    }

    public SearchResultsPage inputSearchQuery(String searchQuery) {
        wait.until(ExpectedConditions.visibilityOf(searchInputField));
        jsScrollElementIntoViewAndClickIt(searchInputField);
        searchInputField.sendKeys(searchQuery, Keys.ENTER);
        return new SearchResultsPage(driver, wait, executor);
    }
}