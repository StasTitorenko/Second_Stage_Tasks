package hurtMePlenty.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage extends AbstractPage {
    @FindBy(xpath = "//a[@class='gs-title' and contains(@href,'/calculator')]")
    private WebElement calculatorLink;

    public SearchResultsPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor executor) {
        super(driver, wait, executor);
    }

    public CalculatorPage goToCalculatorPage() {
        wait.until(ExpectedConditions.visibilityOf(calculatorLink));
        jsScrollElementIntoViewAndClickIt(calculatorLink);
        return new CalculatorPage(driver, wait, executor);
    }
}
