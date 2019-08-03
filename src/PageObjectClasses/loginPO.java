package PageObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.openBrowser;

public class loginPO {
    WebDriver driver;

    By loginOptinBtn= By.linkText("Login");

    By emailAddress=By.id("email");

    By enterPassword = By.id("password");

    By clickOnLoginBtn = By.id("submitButton");


    public loginPO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void clickLogInBtnOption(){
              driver.findElement(loginOptinBtn).click();
    }
    public void setenterEmailAddress(String email){
        driver.findElement(emailAddress).sendKeys(email);
    }

    public void setenterPassword(String password){
        driver.findElement(enterPassword).sendKeys(password);
    }

    public void clickLoginBtn(){
        driver.findElement(clickOnLoginBtn).click();
    }

}
