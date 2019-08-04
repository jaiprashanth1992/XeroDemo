package utils;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class openBrowser {
    WebDriver driver;
    readConfigFile prop = new readConfigFile();

    /**
     * @param browser is passed to choose a browser type as Google chrome
     * @return driver
     */
    public WebDriver selectBrowserType(String browser) {
        try {
            if (browser.equalsIgnoreCase("chrome") || browser.equalsIgnoreCase("CHROME") || browser.equalsIgnoreCase("CH")) {
                System.setProperty("webdriver.chrome.driver", prop.getPropValue("ChromeDriver"));
                driver = new ChromeDriver();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }

    /**
     * This method hits the target Url
     *
     * @param Url is passed to lauch the webpage
     */
    public void hitUrl(String Url) {
        driver.get(Url);
    }

    /**
     * This method maximizes the window
     */
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    /**
     * This method helps to scroll the webpage
     * @param driver
     */
    public void verticalScrollDOwn(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,3000)");
    }

    /**
     * This method waits and manages the timeouts until the webpage loaded
     *
     * @param driver
     */
    public void wait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    /**
     * this method closes the browser
     *
     * @param driver
     */
    public void closeBrowser(WebDriver driver) {
        driver.quit();
    }

    /**
     * This method waits until the expected element is visible
     * @param by is passed
     */
    public void Explicitwait(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * This method captures the screenshot throughout the test and saves based on date and time of the run
     * which is stored in HtmlOutput folder
     * @param driver
     * @param screenshotName
     * @return
     * @throws Exception
     */
    public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/HtmlOutput/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }

    /**
     * This method generates a html report based on ExtentReports format
     * @return
     */
    public synchronized static ExtentReports getExtentReports() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyy.MM.dd.HH.mm.ss");
        ExtentReports extent = new ExtentReports(System.getProperty("user.dir") + "/HtmlOutput/AddAccount_" + sdf.format(System.currentTimeMillis()) + ".html", true, DisplayOrder.OLDEST_FIRST);
        return extent;
    }
}

