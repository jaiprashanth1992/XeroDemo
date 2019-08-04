package PageObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class loginPO {
    WebDriver driver;

    By loginOptinBtn = By.linkText("Login");
    By emailAddress = By.id("email");
    By enterPassword = By.id("password");
    By clickOnLoginBtn = By.id("submitButton");

    /**
     * This method is used to initialises the webelements of page webpage
     * @param driver
     */
    public loginPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**This method identifies the elements of Login button in welcome screen
     * and clicks it
     */
    public void clickLogInBtnOption() {
        driver.findElement(loginOptinBtn).click();
    }

    /**This method identifies the elements of email address text box and
     * enter the key values as per get property value method
     */
    public void enterEmailAddress(String email) {
        driver.findElement(emailAddress).sendKeys(email);
    }

    /**This method identifies the elements of password text box and
     * enter the key values as per get property value method
     */
    public void enterPassword(String password) {
        driver.findElement(enterPassword).sendKeys(password);
    }

    /**This method identifies the elements of Login button and clicks it
     */
    public void clickLoginBtn() {
        driver.findElement(clickOnLoginBtn).click();
    }
}
