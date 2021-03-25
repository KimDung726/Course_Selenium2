package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static helper.DriverHelper.*;

public class BasePage {

    /***
     * Click on Element based on locator
     * @param locator : locator of Element that to click on it
     */
    public void clickOnElement(By locator) {
        WebElement element = getWebDriver().findElement(locator);
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
        getWebDriver().findElement(locator).sendKeys(value);
    }

    /***
     * Clear data of element
     * @param locator : String
     */
    public void clearData(By locator) {
        getWebDriver().findElement(locator).clear();
    }

    /***
     * Check that element is display or not
     * @param locator : locator of element
     * @return : true if element is displayed otherwise false
     */
    public boolean isElementDisplayed(By locator) {
        return getWebDriver().findElements(locator).size() > 0;
    }

}
