package framework.pages.googleCloud;

import framework.pages.AbstractPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private static final String SEARCH_QUERY = "Google Cloud Platform Pricing Calculator";

    @FindBy(xpath = "//div[@class='devsite-searchbox']")
    private WebElement searchButton;

    @FindBy(name = "q")
    private WebElement searchInputField;

    public HomePage(WebDriver driver, WebDriverWait wait, JavascriptExecutor executor) {
        super(driver, wait, executor);
    }

    public HomePage openPage() {
        driver.get(HOMEPAGE_URL);
        logger.info("Google homepage is opened");
        return this;
    }

    public HomePage clickSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        logger.info("Waiting until visible of 'search button' - success");
        jsScrollElementIntoViewAndClickIt(searchButton, "search button");
        return this;
    }

    public SearchResultsPage inputSearchQuery() {
        wait.until(ExpectedConditions.visibilityOf(searchInputField));
        logger.info("Waiting until visible of 'search input field' - success");
        jsScrollElementIntoViewAndClickIt(searchInputField, "search input field");
        searchInputField.sendKeys(SEARCH_QUERY, Keys.ENTER);
        logger.info("Searching is started ");
        return new SearchResultsPage(driver, wait, executor);
    }
}