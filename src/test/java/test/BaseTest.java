package test;

import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

import utilities.Log;
import utilities.Constants;
import helper.DriverHelper;

public class BaseTest {

    private String strTestResult;

    @BeforeMethod
    @Parameters("browser")
    public void startBrowser(String browser) {
        Constants.BROWSER = browser;
        DriverHelper.startBrowser(DriverHelper.convertStringToEnum(Constants.BROWSER));
        DriverHelper.navigateToUrl(Constants.BASE_URL);
    }

    @AfterMethod
    public void quitDriver(ITestResult result) {
        printTestResult(result);
        DriverHelper.quitWebDriver();
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
