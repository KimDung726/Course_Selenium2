package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Constants;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        setDriver(driver);
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver getDriver() {
        return this.driver;
    }

    /***
     * Get DriverWait from outside
     * @return : driver
     */
    public WebDriverWait getWebDriverWait() {
        return new WebDriverWait(getDriver(), Constants.LONG_TIME);
    }

    /***
     * Wait to be click able
     * @param element : element
     */
    public void waitForClickAble(WebElement element) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    /***
     * Click on Element based on locator
     * @param locator : locator of Element that to click on it
     */
    public void clickOnElement(By locator) {
        WebElement element = getDriver().findElement(locator);
        clickOnElement(element);
    }

    /***
     * Click on Element
     * @param element : element
     */
    public void clickOnElement(WebElement element) {
        waitForClickAble(element);
        element.click();
    }

    /***
     * Enter data for Element follow web locator
     * @param locator :  locator of element
     * @param value : data to input
     */
    public void enterData(By locator, String value) {
        getDriver().findElement(locator).sendKeys(value);
    }

    /***
     * Clear data of element
     * @param locator : String
     */
    public void clearData(By locator) {
        getDriver().findElement(locator).clear();
    }

    /***
     * Check that element is display or not
     * @param locator : locator of element
     * @return : true if element is displayed otherwise false
     */
    public boolean isElementDisplayed(By locator) {
        return getDriver().findElements(locator).size() > 0;
    }

}
