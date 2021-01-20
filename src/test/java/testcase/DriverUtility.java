package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtility {
    WebDriver driver;

    private DriverUtility() {
        System.setProperty("webdriver.chrome.driver", UrlConstants.CHROME_DRIVER_PATH);
         driver = new ChromeDriver();


    }

    void performTest(String parsedEmailId) throws InterruptedException{
            driver.get(UrlConstants.URL);
            driver.findElement(By.cssSelector("a[href='/forgot-username']")).click();
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("input[type='email']")).sendKeys(parsedEmailId);
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("button[class='btn btn-primary font-weight-bold w-100']")).click();
    }

    void shutdownDriver() {
        driver.quit();
    }

    public static DriverUtility getInstance(){
        return new DriverUtility();
    }

}
