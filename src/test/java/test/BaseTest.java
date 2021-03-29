package test;


import driver.DriverFactory;
import driver.DriverManager;
import utilities.*;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

import static org.openqa.selenium.remote.BrowserType.CHROME;

public class BaseTest {

    private String strTestResult;

    private DriverManager driverManager = null;

    @BeforeMethod
    @Parameters("browser")
    public void setupTest(String browser) {
        Constants.BROWSER = browser;
        driverManager = DriverFactory.valueOf(Constants.BROWSER).getDriverManager();
        driverManager.getDriver();
        driverManager.navigateToUrl(Constants.BASE_URL);
    }

    @AfterMethod
    public void cleanupTest(ITestResult result) {
        printTestResult(result);
        driverManager.quitDriver();
    }

    /***
     * Print Test Result in Log
     * @param result : ITestResult
     */
    public void printTestResult(ITestResult result) {
        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                strTestResult = "PASS";
                break;

            case ITestResult.FAILURE:
                strTestResult = "FAILED";
                break;

            case ITestResult.SKIP:
                strTestResult = "SKIP";
                break;

            default:
                Log.error("[BaseTest] Invalid status");
        }
        Log.endTestCase(strTestResult);
    }
}
