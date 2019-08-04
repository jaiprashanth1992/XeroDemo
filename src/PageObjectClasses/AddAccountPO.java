package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAccountPO {
    WebDriver driver;

    public By clickOnAddAccountBtn = By.xpath("//a[@href='/Banking/Account/']");
    By selectBank = By.xpath("//li[1][contains(.,'ANZ (NZ)')]");
    By addDataView = By.xpath("//*[@id='dataview-1021']/li[1]");
    By addAccountName = By.id("accountname-1037-inputEl");
    By findAccountTypeBtn = By.xpath("//div[contains(@id,'accounttype-') and contains(@class,'x-form-trigger x-form-trigger-default ba-combo-trigger ba-combo-trigger-default ')]");
    By selectAccountTypeOption = By.xpath("//li[@class='ba-combo-list-item'][contains(.,'Everyday (day-to-day)')]");
    By getAccountNumbertxtbox = By.xpath("//div[@class='x-field ba-field-group-item ba-field--large x-form-item x-form-item-default x-form-type-text ba-accountnumber x-field-default x-autocontainer-form-item x-form-item-no-label']//input[contains(@id,'accountnumber')]");
    By clickContinueBtn = By.xpath("//a[contains(@id,'common-button-submit-')]");
    public By iHaveFormBtn = By.xpath("//a[@data-automationid='connectbank-buttonIHaveAForm']/span");
    By uploadLaterBtn = By.xpath("//a[@data-automationid='uploadForm-uploadLaterButton']");
    By clickOnNameIcon = By.xpath("//*[@id='header']/header/div/ol[2]/li[4]/button/div/abbr");
    By logoutBtn = By.xpath("//a[contains(.,'Log out')]");

    /**
     * This method is used to initialises the webelements of webpage
     *
     * @param driver
     */
    public AddAccountPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * This method identifies and CLick on Add Account button
     */
    public void clickOnAddAccountBtn() {
        driver.findElement(clickOnAddAccountBtn).click();
    }

    /**
     * This method identifies and CLick on Logout button
     */
    public void setclickLogoutBtn() {
        driver.findElement(logoutBtn).click();

    }

    /**
     * This method identifies and CLick on Name Icon of the account
     */
    public void setClickOnNameIcon() {
        driver.findElement(clickOnNameIcon).click();
    }

    /**
     * This method identifies and CLick on "Upload Later" button
     */
    public void setUploadLaterBtn() {
        driver.findElement(uploadLaterBtn).click();
    }

    /**
     * This method identifies and click on "i have the form" button
     */
    public void setiHaveFormBtn() {
        driver.findElement(iHaveFormBtn).click();
    }

    /**
     * This method identifies and CLick on "Continue" button
     */
    public void setClickContinueBtn() {
        driver.findElement(clickContinueBtn).click();
    }

//    /**
//     * This method identifies and CLick on Select bank button
//     */
//    public void setClickOnBank(){
//        driver.findElement(selectBank).click();
//    }


    /**
     * This method identifies and Selects the account type
     */
    public void setSelectAccountTypeOption() {
        driver.findElement(selectAccountTypeOption).click();
    }

    /**
     * This method adds the account name of the account
     */
    public void setAccountName(String text) {
        driver.findElement(addDataView).click();
        driver.findElement(addAccountName).sendKeys(text);
    }

    /**
     * This method adds the account number to the text box
     */
    public void setAccountNumbertxtbox(String text) {
        driver.findElement(getAccountNumbertxtbox).sendKeys(text);

    }

    /**
     * This method clicks on the account type button
     */
    public void clickonAccountTypeBtn() {
        driver.findElement(findAccountTypeBtn).click();

    }
}
