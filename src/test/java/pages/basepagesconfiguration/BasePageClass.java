package pages.basepagesconfiguration;

import org.openqa.selenium.chrome.ChromeDriver;
import singleton.DriverSingleton;
import listeners.TestListeners;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.net.MalformedURLException;
import java.net.URL;

@Listeners({TestListeners.class})
public class BasePageClass extends DriverSingleton
{

    private static final int WAITER_TIME_OUT = 40;
    private static final int DRIVER_WAIT_TIME = 180;

    protected static Logger logger =  LogManager.getRootLogger();

    protected static WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }


   // public WebDriver initializeDriver() {
     //   System.setProperty("webdriver.chrome.singleton", "C:\\D\\SeleniumDrivers\\chromedriver_win32\\chromedriver.exe");
        //DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        //capabilities.setPlatform(Platform.WINDOWS);
      //  capabilities.setBrowserName("chrome");
      //  try {
        //    driver = new RemoteWebDriver(new URL("http://192.168.100.4:4444/wd/hub"), capabilities);
        //} catch (MalformedURLException e) {
          //  e.printStackTrace();
        //}
        // singleton = new ChromeDriver();
        //maximizeWindow();
        //return driver;
   // }





    public WebElement waitForExpectedElement(By webElementLocator) {
        return new WebDriverWait(driver, WAITER_TIME_OUT)
                .until(ExpectedConditions.visibilityOfElementLocated(webElementLocator));
    }

    public WebDriver initializeDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nastassia_Chaliapina\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }


    @BeforeClass
    public void setUp() {
        initializeDriver();
    }

/*    @BeforeClass
    public void setUp() {
        driver = DriverSingleton.getWebDriverInstance();
    }

    @AfterClass
    public void closeDown() {
        DriverSingleton.closeDriver();
    }
*/
@AfterClass
public void closeDown() {
    driver.quit();
}
    /*    @BeforeClass
        public void setUp() {
            initializeDriver();
        }
        @AfterClass
        public void closeDown() {
           singleton.quit();
        }
     */
    public void waitPageIsLoadedAndJQueryIsProcessed() {
        waitPageIsLoaded();
        waitJQueryIsProcessed();
    }

    public void waitPageIsLoaded() {
        try {
            ExpectedCondition<Boolean> expectedCondition = driver -> getDocumentReadyState().equals("complete");
            Wait<WebDriver> wait = new WebDriverWait(getDriver(), DRIVER_WAIT_TIME);
            wait.until(expectedCondition);
        } catch (Exception ex) {
            logger.warn("Fail waiting for document ready state. Current state:" + getDocumentReadyState());
        }
    }

    private String getDocumentReadyState() {
        return (String) ((JavascriptExecutor) getDriver()).executeScript("return document.readyState");
    }

    private void waitJQueryIsProcessed() {
        new WebDriverWait(getDriver(), DRIVER_WAIT_TIME) {
        }.until((ExpectedCondition<Boolean>) driver -> (Boolean) ((JavascriptExecutor) driver)
                .executeScript("return typeof jQuery != 'undefined' && jQuery.active == 0"));
    }


    public void open(String url) {
        driver.get(url);
    }


    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public boolean isElementDisplayed(By element) {
        WebElement foundElement = driver.findElement(element);
        return foundElement != null && foundElement.isDisplayed();
    }

    public boolean isElementClickable(By element) {
        WebElement foundElement = driver.findElement(element);
        return foundElement != null && foundElement.isEnabled();
    }


}