package singleton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSingleton {

    private static final String RESOURCE_PATH = "src\\test\\recources";
    protected static WebDriver driver;

    protected DriverSingleton() {
    }

   /*
    public static WebDriver getDriver() {
        if (null == driver) {
            switch (System.getProperty("browser")) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

*/

    public static WebDriver getWebDriverInstance() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\D\\SeleniumDrivers\\chromedriver_win32\\chromedriver.exe");
            capabilities.setPlatform(Platform.WINDOWS);
            capabilities.setBrowserName("chrome");
            driver = new ChromeDriver(capabilities);
        }
        return driver;
    }


    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}