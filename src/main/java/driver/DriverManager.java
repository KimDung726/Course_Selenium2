package driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    protected abstract WebDriver createDriver();

    /***
     * Get driver from outside
     * @return : driver
     */
    public WebDriver getDriver() {
        if (null == drivers.get()) {
            drivers.set(this.createDriver());
        }
        drivers.get().manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);

        return drivers.get();
    }

    /***
     * Quit Web driver
     */
    public void quitDriver() {
        if (null != drivers.get()) {
            try {
                drivers.get().quit();
                drivers.remove();
            } catch (Exception e) {
                System.out.println("Unable to gracefully quit WebDriver: " + e);
            }

        }
    }

    /***
     * Navigate to base URL
     */
    public void navigateToUrl(String url) {
        getDriver().navigate().to(url);
    }

}