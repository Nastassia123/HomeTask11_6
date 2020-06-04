package decorator.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class WebDriverDecoratorUsage {

    private WebDriver driver;

    @Test
    public void testCustomDriver() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\D\\SeleniumDrivers\\chromedriver_win32\\chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        driver = new ChromeDriver(capabilities);
        driver = new WebDriverDecorator(driver);
        driver.navigate().to("https://4frag.ru/");
        driver.findElement(By.xpath("//span[text() = 'Корзина']"));
                Thread.sleep(1000);
                driver.quit();
    }
}
