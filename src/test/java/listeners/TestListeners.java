package listeners;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import pages.basepagesconfiguration.BasePageClass;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class TestListeners extends BasePageClass implements ITestListener {
    protected static Logger logger = LogManager.getRootLogger();

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("On Test Start " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("On Test Success " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("On Test Failed " + result.getName());
        saveScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }


    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

    private void saveScreenshot() {
        File screenCapture = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(".//target/screenshots/" +
                    getCurrentTimeAsString() +
                    ".png"));
        } catch (IOException e) {
            logger.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }


}