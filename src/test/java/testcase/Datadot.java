package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Datadot {
    WebDriver driver;
    DriverUtility driverUtility;
    @BeforeMethod
    void utSetUp() throws Exception{
        driverUtility = DriverUtility.getInstance();
    }

    @Test
    void dataDot() throws Exception {
        driverUtility.performTest("prajjawal.123@gmail.com");
    }

    @Test
    void Digits() throws Exception {
        driverUtility.performTest("123452@gmail.com");
    }
    @Test
    void capital() throws Exception {
        driverUtility.performTest("PRAJJAWAL1@gmail.com");
    }
    @Test
    void plus() throws Exception {
        driverUtility.performTest("prajjawal+123@gmail.com");
    }
    @Test
    void chardigit() throws Exception {
        driverUtility.performTest("prajjawal123@gmail.com");
    }
    @Test
    void chars() throws Exception {
        driverUtility.performTest("prajjawal@gmail.com");
    }
    @Test
    void desh() throws Exception {
        driverUtility.performTest("prajjawal-123@gmail.com");
    }
    @Test
    void underscore() throws Exception {
        driverUtility.performTest("prajjawal_123@gmail.com");
    }

    @AfterMethod
    void tearDown() {
        driverUtility.shutdownDriver();
    }

}
