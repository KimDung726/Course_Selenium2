package helper;

import utilities.Log;
import utilities.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class DriverHelper {

    private static WebDriver driver;

    public enum DriverType {
        CHROME,
        FIREFOX,
        UNKNOWN
    }

    /***
     * Convert from string to enum
     * @param type : String
     * @return : enum
     */
    public static DriverType convertStringToEnum(String type) {
        try {
            return DriverType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException illEx) {
            Log.error("[DriverHelper] " + illEx);
            return DriverType.UNKNOWN;
        }
    }

    /***
     * Start browser to init driver
     * @param type : Type of DriverType
     */
    public static void startBrowser(DriverType type) {
        switch (type) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                Log.error("[DriverHelper] No browser passed throw exception");
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.SHORT_TIME, TimeUnit.SECONDS);
    }

    /***
     * Navigate to base URL
     */
    public static void navigateToUrl(String url) {
        driver.get(url);
    }

    /***
     * Get driver from outside
     * @return : driver
     */
    public static WebDriver getWebDriver() {
        return driver;
    }

    /***
     * Get DriverWait from outside
     * @return : driver
     */
    public static WebDriverWait getWebDriverWait() {
        return new WebDriverWait(getWebDriver(), Constants.LONG_TIME);
    }

    /***
     * Quit Web driver
     */
    public static void quitWebDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }

    /***
     * Scroll to down of Page to find Element
     * @param locator : locator
     */
    public static void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", element);
    }

    /***
     * Wait for Title displayed
     */
    public static void waitForTitleDisplayed() {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        getWebDriverWait().until(pageLoadCondition);
    }

    /***
     * Wait to be click able
     * @param element : element
     */
    public static void waitForClickAble(WebElement element) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
    }
}
