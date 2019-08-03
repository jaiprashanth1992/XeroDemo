package utility;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.jetty9.security.SpnegoUserIdentity;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class openBrowser {
WebDriver driver;
readConfigFile prop = new readConfigFile();
    public openBrowser(){
        this.driver=driver;
    }
    public WebDriver selectBrowserType(String browser){
    try {
        if (browser.equalsIgnoreCase("chrome") || browser.equalsIgnoreCase("CHROME") || browser.equalsIgnoreCase("CH")) {
            System.setProperty("webdriver.chrome.driver", prop.getPropValue("ChromeDriver"));
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox") || browser.equalsIgnoreCase("FIREFOX") || browser.equalsIgnoreCase("FF")) {

        }
    }catch (Exception e){
        e.printStackTrace();
    }
    return driver;
    }
    public void hitUrl(String Url){
        driver.get(Url);
    }
    public void maximizeWindow(){
        driver.manage().window().maximize();

    }

    public void verticalScrollDOwn(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,3000)");
    }
    public void wait(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void closeBrowser(WebDriver driver){
        driver.quit();
    }
    public void Explicitwait(By by){
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }
    public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        //after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/src/HtmlOutput/"+screenshotName+dateName+".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }

    public synchronized static ExtentReports getExtentReports()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyy.MM.dd.HH.mm.ss");

        ExtentReports extent = new ExtentReports(System.getProperty("user.dir") + "/src/HtmlOutput/AddAccount_"+sdf.format(System.currentTimeMillis())+".html",true, DisplayOrder.OLDEST_FIRST);
        return extent;
    }
    }

