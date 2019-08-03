package PageObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddOrganisationPO {

    WebDriver driver;

    By clickOnAddOrgnaisation = By.xpath("//a[contains(@href,'/!xkcD/Organisation/Setup')]");

    By setNameOfOrg = By.xpath("//input[contains(@data-automationid,'organisation-name--input')]");

    By clickOnOrgTaxesDropDownIcon = By.xpath("//label[contains(.,'Where does your organisation pay taxes?')]/../div/div");

    By OrgPayTaxes = By.xpath("//span[contains(@class,'xui-pickitem--text')]/span[contains(.,'New Zealand')]");

    By orgDoDropDownIcon = By.xpath("//input[contains(@data-automationid,'industry-autocompleter--input')]");

    By orgDoDropDownselectOption = By.xpath("//span[@class='xui-pickitem--text']/span");

    By clickonSelectOnelistDropDown = By.xpath("//span[contains(.,'Select one from the list')]");

    By selectBankLinkOption = By.xpath("//li[contains(@id,'Banklink')]");

    By clickOnStartTrailBtn = By.xpath("//button[contains(.,'Start trial')]");

    By clickOnPreviousSOftQues = By.xpath("//button[contains(@data-automationid,'previous-software-question---button')]");

    public AddOrganisationPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void setClickOnPreviousSOftQuesBtn() {
        driver.findElement(clickOnPreviousSOftQues).click();
    }

    public void clickOnAddOrgBtn() {
        driver.findElement(clickOnAddOrgnaisation).click();
    }

    public void SetNameOfOrg(String text) {
        driver.findElement(setNameOfOrg).sendKeys(text);
    }

    public void setOrgPayTaxesDD() {
        driver.findElement(clickOnOrgTaxesDropDownIcon).click();
    }

    public void setOrgPayTaxes() {

        driver.findElement(OrgPayTaxes).click();
    }

    public void clickOrgIndustryDD(String text) {
        driver.findElement(orgDoDropDownIcon).sendKeys(text);

    }

    public void clickOrgIndustry() {
        driver.findElement(orgDoDropDownselectOption).click();

    }


    public void clickOnDropDown(){
        driver.findElement(clickonSelectOnelistDropDown).click();
    }
    public void clickOnStartTrailBtn(){
        driver.findElement(clickOnStartTrailBtn).click();

    }
    public void clickOnBlankList(){
        driver.findElement(selectBankLinkOption).click();

    }
}
