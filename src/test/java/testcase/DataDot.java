package testcase;

import Util.FileUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class DataDot {
    @BeforeMethod
    void utSetUp() throws Exception {
    }

    @BeforeClass
    void setUp() throws Exception {

    }

    @Test
    void runTest() throws Exception {
        boolean testFailed = false;
        DriverUtility driverUtility = DriverUtility.getInstance();
        FileUtil fileUtil = new FileUtil();
        List<String> emailList = fileUtil.readFile();
        for (int i = 0; i < emailList.size(); i++) {
            try {
                driverUtility.performTest(emailList.get(i));
            } catch (RuntimeException e) {
                testFailed = true;
                System.out.println("Test case " + (i + 1) + " failed with error :" + e);
            }
            if (!testFailed) {
                System.out.println("Test case " + (i + 1) + " executed successfully ");
            }
        }
        driverUtility.shutdownDriver();
    }

    @AfterMethod
    void tearDown() {
    }

}
