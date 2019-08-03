package Tests;

import PageObjectClasses.AddAccountPO;
import PageObjectClasses.AddOrganisationPO;
import PageObjectClasses.AuthenticationPO;
import PageObjectClasses.loginPO;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.java.cs.A;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.openBrowser;
import utility.readConfigFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class addAccount {
    WebDriver driver;
    String firstPet = "What was the name of your first pet?";
    String firstCar = "What is your dream car?";
    String dreamJob = "What is your dream job?";

    ExtentReports reporter;
    ExtentTest extentTest;
    loginPO login = null;
    AuthenticationPO auth = null;
    AddOrganisationPO org = null;
    AddAccountPO acc = null;
    openBrowser browser = new openBrowser();
    readConfigFile prop = new readConfigFile();
  /*  @Before
    public void openBrowserMethod(){
        openBrowser browser = new openBrowser();
      driver=  browser.selectBrowserType("CH");
        browser.hitUrl(driver);
        browser.maximizeWindow(driver);
    }


  */
  public WebDriver loginInApplication(){
      try {
         reporter= openBrowser.getExtentReports();
         extentTest= reporter.startTest("Add Account");
        driver=  browser.selectBrowserType("CH");
          browser.hitUrl(prop.getPropValue("Url"));
          extentTest.log(LogStatus.PASS,"TEst");

          String screenshotPath = openBrowser.getScreenhot(driver,"Test");
          //To add it in the extent report
          extentTest.log(LogStatus.INFO, extentTest.addScreenCapture(screenshotPath));

          browser.maximizeWindow();
          login = new loginPO(driver);
          login.clickLogInBtnOption();
          login.setenterEmailAddress(prop.getPropValue("Email"));
          login.setenterPassword(prop.getPropValue("Password"));
          login.clickLoginBtn();
        reporter.endTest(extentTest);

      }catch (Exception e){
          e.printStackTrace();
      }
      return driver;
  }

  public void validateAuthentication(WebDriver driver){

      try {

            auth= new AuthenticationPO(driver);
          auth.clickOnUseAnotherAuthenticationMethodlink();
          auth.clickSecuirtyQuestionBtn();
          String a = auth.getFirstQuestionText();
          String b = auth.getSecondQuestionText();

          if (a.equalsIgnoreCase(firstPet)) {
              auth.SetFirstAnswerText(prop.getPropValue("First_pet"));
          } else if (a.equalsIgnoreCase(firstCar)) {
              auth.SetFirstAnswerText(prop.getPropValue("Dream_car"));
          } else if (a.equalsIgnoreCase(dreamJob)){
              auth.SetFirstAnswerText(prop.getPropValue("Dream_job"));
          }
          if (b.equalsIgnoreCase(firstPet)) {
              auth.SetSecondAnswerText(prop.getPropValue("First_pet"));
          } else if (b.equalsIgnoreCase(firstCar)) {
              auth.SetSecondAnswerText(prop.getPropValue("Dream_car"));
          } else if (b.equalsIgnoreCase(dreamJob)){
              auth.SetSecondAnswerText(prop.getPropValue("Dream_job"));
          }
          auth.clickAuthLoginBtn();
      }catch (Exception e){
          e.printStackTrace();
      }

  }

    public void addOrgnisation(WebDriver driver){
        try {
            org= new AddOrganisationPO(driver);
            browser.wait(driver);
            org.clickOnAddOrgBtn();
            org.SetNameOfOrg(prop.getPropValue("OrgName"));
            browser.wait(driver);
            org.setOrgPayTaxesDD();
            browser.wait(driver);
             org.setOrgPayTaxes();
            browser.wait(driver);
            org.clickOrgIndustryDD(prop.getPropValue("Industry"));
            org.clickOrgIndustry();
            browser.verticalScrollDOwn(driver);
            org.setClickOnPreviousSOftQuesBtn();
            org.clickOnBlankList();
            org.clickOnStartTrailBtn();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public void addAccount(WebDriver driver){
        try {

            acc= new AddAccountPO(driver);
            browser.Explicitwait(acc.clickOnAddAccountBtn);
            acc.setClickOnAddAccountBtn();
            browser.wait(driver);
            acc.setAccountName(prop.getPropValue("AcctName"));
            acc.clickonAccountTypeBtn();
            browser.wait(driver);
            acc.setSelectAccountTypeOption();
            browser.wait(driver);

            acc.setAccountNumbertxtbox(prop.getPropValue("AccountNumber"));
            browser.wait(driver);

            acc.setClickContinueBtn();
            browser.Explicitwait(acc.iHaveFormBtn);

            acc.setiHaveFormBtn();
            browser.wait(driver);

            browser.verticalScrollDOwn(driver);
            acc.setUploadLaterBtn();
            browser.wait(driver);
            acc.setClickOnNameIcon();
            browser.wait(driver);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void logout(WebDriver driver){
        acc= new AddAccountPO(driver);

        browser.wait(driver);
        acc.setclickLogoutBtn();

        browser.closeBrowser(driver);
      reporter.close();
  }





  /*public  void main(String[]agrs) throws Exception{
      //JavascriptExecutor js = (JavascriptExecutor) driver;
      readConfigFile configFile = new readConfigFile();
      configFile.getPropValue("name");

      System.setProperty("webdriver.chrome.driver", ".\\src\\browser\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.xero.com");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("email")).sendKeys("jaiprashanth1992@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Jai09bel514");
        driver.findElement(By.id("submitButton")).click();
      JavascriptExecutor js = (JavascriptExecutor) driver;


      //driver.findElement(By.className("xui-button xui-button-main xui-u-fullwidth")).click();
        driver.findElement(By.xpath("//button[contains(.,'Use another authentication method')]")).click();
        driver.findElement(By.xpath("//button[contains(.,'Security questions')]")).click();
        //driver.findElement(By.className("xui-button xui-button-main xui-u-fullwidth")).click();
       String a= driver.findElement(By.xpath("//*[@id='auth-splashpage']/div/div/form/label[1]/span")).getText();
       String b= driver.findElement(By.xpath("//*[@id='auth-splashpage']/div/div/form/label[2]/span")).getText();

        if(a.equalsIgnoreCase("What was the name of your first pet?")){
            driver.findElement(By.xpath("//div[contains(@data-automationid,'auth-firstanswer')]/input")).sendKeys("Reno");
        }else if(a.equalsIgnoreCase("What is your dream car?")){
            driver.findElement(By.xpath("//div[contains(@data-automationid,'auth-firstanswer')]/input")).sendKeys("Benz");
        }else if(a.equalsIgnoreCase("What is your dream job?")){
            driver.findElement(By.xpath("//div[contains(@data-automationid,'auth-firstanswer')]/input")).sendKeys("Quality Assurance");
        }

        if(b.equalsIgnoreCase("What was the name of your first pet?")){
            driver.findElement(By.xpath("//div[contains(@data-automationid,'auth-secondanswer')]/input")).sendKeys("Reno");
        }else if(b.equalsIgnoreCase("What is your dream car?")){
            driver.findElement(By.xpath("//div[contains(@data-automationid,'auth-secondanswer')]/input")).sendKeys("Benz");
        }else if(b.equalsIgnoreCase("What is your dream job?")){
            driver.findElement(By.xpath("//div[contains(@data-automationid,'auth-secondanswer')]/input")).sendKeys("Quality Assurance");
        }
        driver.findElement(By.xpath("//button[contains(.,'Log in')]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(@href,'/!xkcD/Organisation/Setup')]")).click();
      driver.findElement(By.xpath("//input[contains(@data-automationid,'organisation-name--input')]")).sendKeys("ABCD1r");
      driver.findElement(By.xpath("//label[contains(.,'Where does your organisation pay taxes?')]/../div/div")).click();
      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

      driver.findElement(By.xpath("//span[contains(@class,'xui-pickitem--text')]/span[contains(.,'New Zealand')]")).click();
      driver.findElement(By.xpath("//input[contains(@data-automationid,'industry-autocompleter--input')]")).sendKeys("Eng");
      driver.findElement(By.xpath("//span[@class='xui-pickitem--text']/span")).click();


      js.executeScript("window.scrollBy(0,3000)");

        driver.findElement(By.xpath("//button[contains(@data-automationid,'previous-software-question---button')]")).click();
       driver.findElement(By.xpath("//li[contains(@id,'Banklink')]")).click();
      driver.findElement(By.xpath("//button[contains(.,'Start trial')]")).click();
      WebDriverWait wait=new WebDriverWait(driver, 20);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/Banking/Account/']")));

      // wait=new WebDriverWait(driver, 20);
      // driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
      driver.findElement(By.xpath("//a[@href='/Banking/Account/']")).click();
        driver.findElement(By.xpath("//*[@id='dataview-1021']/li[1]")).click();
        driver.findElement(By.id("accountname-1037-inputEl")).sendKeys("Jay");
      //  driver.findElement(By.id("accounttype-1039-inputEl")).click();
      //Actions actions = new Actions(driver);
      //driver.findElement(By.xpath("//*[contains(text(),'Credit Card')]")).click();

      //WebElement menuOption = driver.findElement(By.xpath("//*[contains(text(),'Credit Card')]"));
      //Mouse hover menuOption 'Music'

      //actions.moveToElement(menuOption).perform();
        driver.findElement(By.xpath("//div[contains(@id,'accounttype-') and contains(@class,'x-form-trigger x-form-trigger-default ba-combo-trigger ba-combo-trigger-default ')]")).click();
      driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".ba-combo-list-item:nth-child(1)")).click();
      driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@class='x-field ba-field-group-item ba-field--large x-form-item x-form-item-default x-form-type-text ba-accountnumber x-field-default x-autocontainer-form-item x-form-item-no-label']//input[contains(@id,'accountnumber')]")).sendKeys("1234567890123456");
        driver.findElement(By.xpath("//a[contains(@id,'common-button-submit-')]")).click();
      driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@data-automationid='connectbank-buttonIHaveAForm']/span")).click();

      js.executeScript("window.scrollBy(0,3000)");
      driver.findElement(By.xpath("//a[@data-automationid='uploadForm-uploadLaterButton']")).click();
      driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);

      driver.findElement(By.xpath("//*[@id='header']/header/div/ol[2]/li[4]/button/div/abbr")).click();
       driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);

      driver.findElement(By.xpath("//a[contains(.,'Log out')]")).click();
  }*/
}
