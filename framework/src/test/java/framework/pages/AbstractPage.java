package framework.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AbstractPage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor executor;
    protected Logger logger;

    public AbstractPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor executor) {
        this.driver = driver;
        this.wait = wait;
        this.executor = executor;
        logger = LogManager.getRootLogger();
        PageFactory.initElements(driver, this);
    }

    public void jsScrollElementIntoViewAndClickIt(WebElement element, String elementName) {
        executor.executeScript("arguments[0].scrollIntoView(false)", element);
        element.click();
        logger.info("Element '" + elementName + "' scrolled and clicked");
    }

    public void jsClickElement(WebElement element, String elementName) {
        executor.executeScript("arguments[0].click()", element);
        logger.info("Element '" + elementName + "' clicked");
    }

    public void jsClickElement(WebElement container, String containerName, WebElement element, String elementName) {
        executor.executeScript("arguments[0].click(), arguments[1].click()", container, element);
        logger.info("Element '" + elementName + "' in container '" + containerName + "' is selected");
    }
}
