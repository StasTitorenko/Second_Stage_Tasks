package hardcore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudSearchResultsPage extends AbstractPage {

    @FindBy(xpath = "//a[@class='gs-title' and contains(@href,'/calculator')]")
    private WebElement calculatorLink;

    public GoogleCloudSearchResultsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public PricingCalculatorPage goToCalculatorPage() {
        wait.until(ExpectedConditions.visibilityOf(calculatorLink));
        calculatorLink.click();
        return new PricingCalculatorPage(driver, wait);
    }
}
