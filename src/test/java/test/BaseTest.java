package test;

import driver.DriverFactory;
import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import utilities.*;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

public class BaseTest {

    private String strTestResult;

    protected static DriverManager driverManager;

    @BeforeMethod
    @Parameters("browser")
    protected void setupTest(String browser) {
        Constants.BROWSER = browser;
        initializeDriverManager(Constants.BROWSER);
        driverManager.navigateToUrl(Constants.BASE_URL);
    }

    private void initializeDriverManager(String driverName) {
        if (null == driverManager) {
            driverManager = DriverFactory.valueOf(driverName).getDriverManager();
        } else {
            driverManager.getDriver();
        }
    }

    @AfterMethod
    protected void cleanupTest(ITestResult result) {
        printTestResult(result);
        driverManager.quitDriver();
    }

    protected WebDriver getDriver() {
        return driverManager.getDriver();
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
