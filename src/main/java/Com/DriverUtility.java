package Com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class DriverUtility {
    WebDriver driver;
    private HashMap<String, String> urlKeys;


    private DriverUtility() throws Exception {
        System.setProperty("webdriver.chrome.driver", OpenBrowser.CHROME_DRIVER_PATH);
        Properties prop = new Properties();
        FileInputStream FileInputStream = new FileInputStream(
                new File("src/main/resources/object.properties"));
        prop.load(FileInputStream);
        urlKeys = new HashMap<>();
        urlKeys.put(OpenBrowser.FORGET_USERNAME_BUTTON_KEY, prop.getProperty(OpenBrowser.FORGET_USERNAME_BUTTON_KEY));
        urlKeys.put(OpenBrowser.ENTER_EMAIL_KEY, prop.getProperty(OpenBrowser.ENTER_EMAIL_KEY));
        urlKeys.put(OpenBrowser.SEND_EMAIL_BUTTON_KEY, prop.getProperty(OpenBrowser.SEND_EMAIL_BUTTON_KEY));
        urlKeys.put(OpenBrowser.ENTER_EMAIL1_KEY, prop.getProperty(OpenBrowser.ENTER_EMAIL1_KEY));
        urlKeys.put(OpenBrowser.SEND_EMAIL1_BUTTON_KEY, prop.getProperty(OpenBrowser.SEND_EMAIL1_BUTTON_KEY));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

    }

    void performTest(String parsedEmailId) throws InterruptedException {
        driver.get(OpenBrowser.URL1);
        driver.findElement(By.cssSelector(urlKeys.get(OpenBrowser.FORGET_USERNAME_BUTTON_KEY))).click();
        driver.findElement(By.cssSelector(urlKeys.get(OpenBrowser.ENTER_EMAIL_KEY))).sendKeys(parsedEmailId);
        driver.findElement(By.cssSelector(urlKeys.get(OpenBrowser.SEND_EMAIL_BUTTON_KEY))).click();
        driver.get(OpenBrowser.URL2);
        driver.findElement(By.cssSelector(urlKeys.get(OpenBrowser.ENTER_EMAIL1_KEY))).clear();
        driver.findElement(By.cssSelector(urlKeys.get(OpenBrowser.ENTER_EMAIL1_KEY))).sendKeys(parsedEmailId);
        driver.findElement(By.cssSelector(urlKeys.get(OpenBrowser.SEND_EMAIL1_BUTTON_KEY))).click();
    }


    void shutdownDriver() {
        driver.quit();
    }

    public static DriverUtility getInstance() throws Exception{
        return new DriverUtility();
    }

}
