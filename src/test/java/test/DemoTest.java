package test;

import objects.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Constants;

import static utilities.Log.info;
import static utilities.Log.startTestCase;

public class DemoTest extends BaseTest {
    public LoginPage loginPage;

    @BeforeMethod
    public void setupPageObject() {
        loginPage = new LoginPage();
    }

    @Test(testName = "Demo_001", description = "Search")
    public void TC_Demo_001() {

        startTestCase("TC_Demo_001");

        info("Search in Google");
        loginPage.search(Constants.DEMO_TEXT);

    }
}
