package test;

import io.qameta.allure.Description;
import objects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Constants;

import static utilities.Log.info;
import static utilities.Log.startTestCase;

public class DemoTest extends BaseTest {
    public LoginPage loginPage;

    @BeforeMethod
    public void setupPageObject() {
        loginPage = new LoginPage(getDriver());
    }

    @Test(priority = 0, description = "Search in Google")
    @Description("Test Description: Demo Search in Google")
    public void TC_Demo_001() {
        loginPage.search(Constants.DEMO_TEXT);
    }

    @Test(priority = 0, description = "Test Case 01")
    @Description("Test Description: Demo Test case 01")
    public void TC_001() {
        Assert.assertEquals(2, 3);
    }

    @Test(priority = 0, description = "Test Case 02")
    @Description("Test Description: Demo Test case 02")
    public void TC_002() {
        Assert.assertEquals(2, 2);
    }

    @Test(priority = 0, description = "Test Case 03")
    @Description("Test Description: Demo Test case 03")
    public void TC_003() {
        Assert.assertTrue(true, "This test should be failed");
    }

    @Test(priority = 0, description = "Test Case 04")
    @Description("Test Description: Demo Test case 04")
    public void TC_004() {
        Assert.fail("This test should be failed");
    }

}
