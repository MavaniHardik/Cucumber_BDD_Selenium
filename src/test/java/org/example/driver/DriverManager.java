package org.example.driver;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    public static WebDriver driver;
    String browser = "chrome";
    String baseURL = "https://demo.nopcommerce.com/";

    public DriverManager() {
        PageFactory.initElements(driver, this);
    }

    public void runOnLocalBrowser() throws IllegalAccessException {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalAccessException("Unexpected browser");
        }
    }

    public void runInHeadlessBrowser() throws IllegalAccessException {
        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.setHeadless(true);
                options.addArguments("--window-size=1920,1080");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions=new FirefoxOptions();
                firefoxOptions.setHeadless(true);
                firefoxOptions.addArguments("--window-size=1920,1080");
                driver=new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions op=new EdgeOptions();
//                op.addArguments("headless");
                driver= new EdgeDriver(op);
                break;
            default:
                throw new IllegalAccessException("Unexpected browser");
        }
    }

    public void maxBrowser() {
        driver.manage().window().maximize();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }


    public void openUrlMethod() {
        driver.get(baseURL);
    }

    public void closeBrowserMethod() {
        driver.quit();
    }

    public void sleepBrowser(int millisecond) throws InterruptedException {
        Thread.sleep(millisecond);
    }

    public void applyimplicityWait() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public int generateRandomNumber() {
        Random random = new Random();
        // Obtain a number between [0 - 49].
        return random.nextInt(50);
    }

    public static String getRandomString(int length) {
        final String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJLMNOPQRSTUVWXYZ";
        StringBuilder result = new StringBuilder();
        while (length > 0) {
            Random random = new Random();
            result.append(characters.charAt(random.nextInt(characters.length())));
            length--;
        }
        return result.toString();
    }

    public void takeElementscreenshot(WebElement element, String fileName)  {
        File scnFile =element.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scnFile, new File("./target/screenshots/" +fileName+ ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void takeScreenshot(Scenario scenario){

        byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenShot, "image/png");
//take a screen shot
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File("/Users/hardi/OneDrive/Desktop/ScreenShotTest/Error.jpg"));

        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public WebElement waitUntilElementIsClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,30);
        return     wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementVisibility(WebElement element, int timeout, String failureMessage) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.withMessage(failureMessage);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollTo(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}


