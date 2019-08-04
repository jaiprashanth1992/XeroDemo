package Tests.HelperClass;

import PageObjectClasses.AddAccountPO;
import PageObjectClasses.AddOrganisationPO;
import PageObjectClasses.AuthenticationPO;
import PageObjectClasses.loginPO;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import utils.openBrowser;
import utils.readConfigFile;

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

    /**
     * This method is been used for accessing login page and
     * user ensure login page is navigated to 2FA authenticator page
     *
     * @return returns the browser driver
     */
    public WebDriver loginInApplication() {
        try {
            reporter = openBrowser.getExtentReports();
            extentTest = reporter.startTest("LoginPage");
            driver = browser.selectBrowserType(prop.getPropValue("Browser"));
            browser.hitUrl(prop.getPropValue("Url"));
            extentTest.log(LogStatus.PASS, "Homepage Launched");
            String screenshotPath = openBrowser.getScreenhot(driver, "HomeLaunch");
            extentTest.log(LogStatus.INFO, extentTest.addScreenCapture(screenshotPath));
            browser.maximizeWindow();
            login = new loginPO(driver);
            login.clickLogInBtnOption();
            login.enterEmailAddress(prop.getPropValue("Email"));
            login.enterPassword(prop.getPropValue("Password"));
            String screenshotPath2 = openBrowser.getScreenhot(driver, "LoginLaunch");
            extentTest.log(LogStatus.INFO, extentTest.addScreenCapture(screenshotPath2));
            extentTest.log(LogStatus.PASS, "LoginScreen");
            login.clickLoginBtn();
            String screenshotPath3 = openBrowser.getScreenhot(driver, "AuthPage Launched");
            extentTest.log(LogStatus.INFO, extentTest.addScreenCapture(screenshotPath3));
            extentTest.log(LogStatus.PASS, "AuthScreen Launched");
            reporter.endTest(extentTest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }

    /**
     * This method is been used for accessing 2FA Authentication page and
     * validates the user's security details
     *
     * @param driver has been passed to access the browser driver
     */
    public void validateAuthentication(WebDriver driver) {
        try {
            extentTest = reporter.startTest("SecurityVerification");
            auth = new AuthenticationPO(driver);
            auth.clickOnUseAnotherAuthenticationMethodlink();
            auth.clickSecuirtyQuestionBtn();
            String a = auth.getFirstQuestionText();
            String b = auth.getSecondQuestionText();

            if (a.equalsIgnoreCase(firstPet)) {
                auth.SetFirstAnswerText(prop.getPropValue("First_pet"));
            } else if (a.equalsIgnoreCase(firstCar)) {
                auth.SetFirstAnswerText(prop.getPropValue("Dream_car"));
            } else if (a.equalsIgnoreCase(dreamJob)) {
                auth.SetFirstAnswerText(prop.getPropValue("Dream_job"));
            }
            if (b.equalsIgnoreCase(firstPet)) {
                auth.SetSecondAnswerText(prop.getPropValue("First_pet"));
            } else if (b.equalsIgnoreCase(firstCar)) {
                auth.SetSecondAnswerText(prop.getPropValue("Dream_car"));
            } else if (b.equalsIgnoreCase(dreamJob)) {
                auth.SetSecondAnswerText(prop.getPropValue("Dream_job"));
            }
            String screenshotPath4 = openBrowser.getScreenhot(driver, "SecurityCheckLaunched");
            extentTest.log(LogStatus.INFO, extentTest.addScreenCapture(screenshotPath4));
            extentTest.log(LogStatus.INFO, "SecurityAnswersEntered");
            auth.clickAuthLoginBtn();
            String screenshotPath5 = openBrowser.getScreenhot(driver, "AuthPage Verified");
            extentTest.log(LogStatus.INFO, extentTest.addScreenCapture(screenshotPath5));
            extentTest.log(LogStatus.PASS, "Authentication Check Successful and launching Homepage");
            Thread.sleep(2000);
            reporter.endTest(extentTest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is accessed and drives the browser to add a new organisation on the users Xero Account
     *
     * @param driver has been passed to access the browser driver
     */
    public void addOrgnisation(WebDriver driver) {
        try {
            extentTest = reporter.startTest("Add Org");
            org = new AddOrganisationPO(driver);
            browser.wait(driver);
            Thread.sleep(2000);
            String screenshotPath6 = openBrowser.getScreenhot(driver, "Launched MyXero Page");
            extentTest.log(LogStatus.INFO, extentTest.addScreenCapture(screenshotPath6));
            extentTest.log(LogStatus.INFO, "My Xero Page Launched");
            org.clickOnAddOrgBtn();
            org.nameOfOrg(prop.getPropValue("OrgName"));
            browser.wait(driver);
            org.orgPayTaxesDD();
            browser.wait(driver);
            org.orgPayTaxes();
            Thread.sleep(2000);
            org.clickOrgIndustryDD(prop.getPropValue("Industry"));
            org.clickOrgIndustry();
            String screenshotPath7 = openBrowser.getScreenhot(driver, "EnteringOrgDetails");
            extentTest.log(LogStatus.INFO, extentTest.addScreenCapture(screenshotPath7));
            extentTest.log(LogStatus.INFO, "Entering Org Details");
            Thread.sleep(2000);
            browser.verticalScrollDOwn(driver);
            org.clickOnPrevSoftQuesBtn();
            org.clickOnBlankList();
            String screenshotPath8 = openBrowser.getScreenhot(driver, "Entered Org Details");
            extentTest.log(LogStatus.INFO, extentTest.addScreenCapture(screenshotPath8));
            extentTest.log(LogStatus.PASS, "Org Details Entered");
            org.clickOnStartTrailBtn();
            reporter.endTest(extentTest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method drives the driver to add ANZ(NZ) Account in the organisation added
     *
     * @param driver has been passed to access the browser driver
     */
    public void addAcct(WebDriver driver) {
        try {
            extentTest = reporter.startTest("Add ANZ Acct");
            acc = new AddAccountPO(driver);
            browser.Explicitwait(acc.clickOnAddAccountBtn);
            String screenshotPath8 = openBrowser.getScreenhot(driver, "DashboardDisplayed");
            extentTest.log(LogStatus.INFO, extentTest.addScreenCapture(screenshotPath8));
            extentTest.log(LogStatus.INFO, "Org Dashboard Displayed");
            acc.clickOnAddAccountBtn();
            browser.wait(driver);
            Thread.sleep(3000);
            String screenshotPath14 = openBrowser.getScreenhot(driver, "DashboardDisplayed");
            extentTest.log(LogStatus.INFO, extentTest.addScreenCapture(screenshotPath14));
            acc.setAccountName(prop.getPropValue("AcctName"));
            acc.clickonAccountTypeBtn();
            browser.wait(driver);
            Thread.sleep(1000);
            acc.setSelectAccountTypeOption();
            browser.wait(driver);
            Thread.sleep(1000);
            acc.setAccountNumbertxtbox(prop.getPropValue("AccountNumber"));
            browser.wait(driver);
            Thread.sleep(2000);
            String screenshotPath9 = openBrowser.getScreenhot(driver, "AcctbeingEntered");
            extentTest.log(LogStatus.INFO, extentTest.addScreenCapture(screenshotPath9));
            extentTest.log(LogStatus.INFO, "Acct Being Entered");
            acc.setClickContinueBtn();
            Thread.sleep(3000);
            browser.Explicitwait(acc.iHaveFormBtn);
            Thread.sleep(3000);
            String screenshotPath10 = openBrowser.getScreenhot(driver, "AcctbeingAdded");
            extentTest.log(LogStatus.INFO, extentTest.addScreenCapture(screenshotPath10));
            acc.setiHaveFormBtn();
            browser.wait(driver);
            Thread.sleep(3000);
            String screenshotPath16 = openBrowser.getScreenhot(driver, "AcctbeingEntered");
            extentTest.log(LogStatus.INFO, extentTest.addScreenCapture(screenshotPath16));
            browser.verticalScrollDOwn(driver);
            Thread.sleep(2000);
            String screenshotPath11 = openBrowser.getScreenhot(driver, "AcctbeingAdded");
            extentTest.log(LogStatus.INFO, extentTest.addScreenCapture(screenshotPath11));
            acc.setUploadLaterBtn();
            browser.wait(driver);
            Thread.sleep(2000);
            acc.setClickOnNameIcon();
            browser.wait(driver);
            Thread.sleep(2000);
            browser.verticalScrollDOwn(driver);
            String screenshotPath12 = openBrowser.getScreenhot(driver, "AcctbeingAdded");
            extentTest.log(LogStatus.INFO, extentTest.addScreenCapture(screenshotPath12));
            extentTest.log(LogStatus.PASS, "Acct Added Successful");
            reporter.endTest(extentTest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method logs out from xero account and closes the browser
     * @param driver has been passed to access the browser driver
     */
    public void logout(WebDriver driver) {
        acc = new AddAccountPO(driver);
        browser.wait(driver);
        acc.setclickLogoutBtn();
        browser.closeBrowser(driver);
        reporter.close();
    }

}
