package hurtMePlenty.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor executor;

    public AbstractPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor executor) {
        this.driver = driver;
        this.wait = wait;
        this.executor = executor;
        PageFactory.initElements(driver, this);
    }

    public void jsScrollElementIntoViewAndClickIt(WebElement element) {
        executor.executeScript("arguments[0].scrollIntoView(false)", element);
        element.click();
    }

    public void jsClickElement(WebElement element) {
        executor.executeScript("arguments[0].click()", element);
    }

    public void jsClickElement(WebElement container, WebElement element) {
        executor.executeScript("arguments[0].click(), arguments[1].click()", container, element);
    }
}
