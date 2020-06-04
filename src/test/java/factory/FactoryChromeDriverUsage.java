package factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class FactoryChromeDriverUsage {

    protected WebDriver driver;

    @Test
    public void testFacrotyChromeDriver() throws InterruptedException {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        driver = new ChromeDriverCreator().createWebDriver();
        driver.navigate().to("https://4frag.ru/");
        driver.findElement(By.xpath("//span[text() = 'Корзина']"));
        Thread.sleep(1000);
        driver.quit();
    }
}