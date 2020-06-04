package factory;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverCreator implements WebDriverCreator {

    @Override
    public WebDriver createWebDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\D\\SeleniumDrivers\\chromedriver_win32\\chromedriver.exe");
        return new ChromeDriver();
    }
}
