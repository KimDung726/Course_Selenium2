package objects;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    /***
     * Declare Locator of elements on the Login page
     */
    private final By _inputTxt = By.cssSelector("div.a4bIc input");
    private final By _searchBtn = By.cssSelector("div.hsuHs");

    /***
     * Search by keyword
     * @param strContent : String
     */
    public void search(String strContent) {
        enterData(_inputTxt, strContent);
        clickOnElement(_searchBtn);
    }

}
