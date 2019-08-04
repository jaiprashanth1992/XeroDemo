package PageObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AuthenticationPO {
    WebDriver driver;

    By clickOnUseAnotherAuthenticationMethodBtn = By.xpath("//button[contains(.,'Use another authentication method')]");
    By securityQuestionsBtn = By.xpath("//button[contains(.,'Security questions')]");
    By checkFirstQuestiontext = By.xpath("//*[@id='auth-splashpage']/div/div/form/label[1]/span");
    By checkSecondQuestiontext = By.xpath("//*[@id='auth-splashpage']/div/div/form/label[2]/span");
    By checkFirstAnswertext = By.xpath("//div[contains(@data-automationid,'auth-firstanswer')]/input");
    By checkSecondAnswertext = By.xpath("//div[contains(@data-automationid,'auth-secondanswer')]/input");
    By clickOnAuthLoginBtn = By.xpath("//button[contains(text(),'Log in')]");

    /**
     * This method is used initialises the webelements of page object
     * @param driver is passed as the parameter of the method
     */
    public AuthenticationPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * This method identifies the element of Click on another
     * authentication method button in 2FAuthentication screen
     */
    public void clickOnUseAnotherAuthenticationMethodlink() {
        driver.findElement(clickOnUseAnotherAuthenticationMethodBtn).click();
    }

    /**
     * This method identifies the element of Security
     * question button and Clicks it
     */
    public void clickSecuirtyQuestionBtn() {
        driver.findElement(securityQuestionsBtn).click();
    }

    /**
     * This method identifies and gets the text of first security question
     * @return
     */
    public String getFirstQuestionText() {
        return driver.findElement(checkFirstQuestiontext).getText();
    }

    /**
     * This method identifies and gets the text of Second security question
     * @return
     */
    public String getSecondQuestionText() {
        return driver.findElement(checkSecondQuestiontext).getText();
    }

    /**
     * This method identifies the first answer text box and send
     * the answer referring key values
     */
    public void SetFirstAnswerText(String text) {
        driver.findElement(checkFirstAnswertext).sendKeys(text);
    }

    /**
     * This method identifies the second answer text box and send
     * answer referring key values
     */
    public void SetSecondAnswerText(String text) {
        driver.findElement(checkSecondAnswertext).sendKeys(text);
    }

    /**
     * This method identifies login button 2FAuthenticar screen
     */
    public void clickAuthLoginBtn() {
        driver.findElement(clickOnAuthLoginBtn).click();
    }

}
