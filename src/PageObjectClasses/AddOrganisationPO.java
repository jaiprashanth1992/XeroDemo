package PageObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddOrganisationPO {

    WebDriver driver;
    public By clickOnAddOrgnaisation = By.xpath("//a[contains(@href,'/!xkcD/Organisation/Setup')]");
    By setNameOfOrg = By.xpath("//input[contains(@data-automationid,'organisation-name--input')]");
    By clickOnOrgTaxesDropDownIcon = By.xpath("//label[contains(.,'Where does your organisation pay taxes?')]/../div/div");
    By OrgPayTaxes = By.xpath("//span[contains(@class,'xui-pickitem--text')]/span[contains(.,'New Zealand')]");
    By orgDoDropDownIcon = By.xpath("//input[contains(@data-automationid,'industry-autocompleter--input')]");
    By orgDoDropDownselectOption = By.xpath("//span[@class='xui-pickitem--text']/span");
    By clickonSelectOnelistDropDown = By.xpath("//span[contains(.,'Select one from the list')]");
    By selectBankLinkOption = By.xpath("//li[contains(@id,'Banklink')]");
    By clickOnStartTrailBtn = By.xpath("//button[contains(.,'Start trial')]");
    By clickOnPreviousSoftQues = By.xpath("//button[contains(@data-automationid,'previous-software-question---button')]");

    /**
     * This method is used to initialises the webelements of page object
     * @param driver
     */
    public AddOrganisationPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**This method identifies the element of Click on Previous Software used question drop down button
     */
    public void clickOnPrevSoftQuesBtn() {
        driver.findElement(clickOnPreviousSoftQues).click();
    }

    /**This method identifies the element of Click on Add Organisation button
     */
    public void clickOnAddOrgBtn() {
        driver.findElement(clickOnAddOrgnaisation).click();
    }

    /**This method identifies the element name of Org text box and sends the keys based on keys
     */
    public void nameOfOrg(String text) {
        driver.findElement(setNameOfOrg).sendKeys(text);
    }

    /**This method identifies the element  org pay taxes drop down icon
     */
    public void orgPayTaxesDD() {
        driver.findElement(clickOnOrgTaxesDropDownIcon).click();
    }

    /**This method identifies the elements of where to Org pay taxes and clicks it
     */
    public void orgPayTaxes() {
        driver.findElement(OrgPayTaxes).click();
    }

    /**This method identifies the elements of drop down for Organisation Industry field
     * and clicks it
     */
    public void clickOrgIndustryDD(String text) {
        driver.findElement(orgDoDropDownIcon).sendKeys(text);
    }

    /**This method identifies the elements of item in drop down for Organisation Industry field
     * and clicks it
     */
    public void clickOrgIndustry() {
        driver.findElement(orgDoDropDownselectOption).click();

    }

//    /**This method identifies the elements of Login button in welcome screen
//     * and clicks it
//     */
//    public void clickOnDropDown() {
//        driver.findElement(clickonSelectOnelistDropDown).click();
//    }

    /**This method identifies the elements of Start trial button in Organisation creation screen
     */
    public void clickOnStartTrailBtn() {
        driver.findElement(clickOnStartTrailBtn).click();
    }

    /**This method identifies the elements of bank list and clicks it
     */
    public void clickOnBlankList() {
        driver.findElement(selectBankLinkOption).click();

    }
}
