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

    By clickOnAuthLoginBtn =  By.xpath("//button[contains(text(),'Log in')]");


    public AuthenticationPO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void clickOnUseAnotherAuthenticationMethodlink(){
        driver.findElement(clickOnUseAnotherAuthenticationMethodBtn).click();
    }
    public void clickSecuirtyQuestionBtn(){
        driver.findElement(securityQuestionsBtn).click();

    }

    public String getFirstQuestionText(){

       return driver.findElement(checkFirstQuestiontext).getText();

    }

    public String getSecondQuestionText(){

        return driver.findElement(checkSecondQuestiontext).getText();
    }


    public void SetFirstAnswerText(String text){

        driver.findElement(checkFirstAnswertext).sendKeys(text);
    }


    public void SetSecondAnswerText(String text){

        driver.findElement(checkSecondAnswertext).sendKeys(text);
    }
    public void clickAuthLoginBtn(){

        driver.findElement(clickOnAuthLoginBtn).click();
    }

}
