package framework.util;

import framework.driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {
    private Logger logger = LogManager.getRootLogger();

    @Override
    public void onTestStart(ITestResult result) {
        saveScreenShot();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        saveScreenShot();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenShot();

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        saveScreenShot();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        saveScreenShot();
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        saveScreenShot();
    }

    @Override
    public void onStart(ITestContext context) {
        saveScreenShot();
    }

    @Override
    public void onFinish(ITestContext context) {
        saveScreenShot();
    }

    public void saveScreenShot() {
        File screenCapture = ((TakesScreenshot) DriverSingleton
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(".//target/screenshots/"
                    + getCurrentTimeAsString()
                    + ".png"));
        } catch (IOException e) {
            logger.error("Не удалось сохранить снимок экрана" + e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}