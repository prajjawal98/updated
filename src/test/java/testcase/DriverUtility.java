package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtility {
    WebDriver driver;

    private DriverUtility() {
        System.setProperty("webdriver.chrome.driver", UrlConstants.CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.get(UrlConstants.URL);
    }

     void performTest(String parsedEmailId) throws Exception{
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[1]/div/a[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[1]/form/div/input")).sendKeys(parsedEmailId);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[1]/form/button")).click();
        Thread.sleep(5000);
    }

    void shutdownDriver() {
        driver.quit();
    }

    public static DriverUtility getInstance(){
        return new DriverUtility();
    }

}
