package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDriverCreator implements WebDriverCreator {
    @Override
    public WebDriver createWebDriver() {
        System.setProperty("webdriver.gecko.driver", "C:\\D\\SeleniumDrivers\\geckodriver-v0.26.0-win32\\geckodriver.exe");
        return new FirefoxDriver();
    }
}
