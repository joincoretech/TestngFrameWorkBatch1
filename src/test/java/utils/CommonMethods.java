package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CommonMethods {
    public static WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public static void setUp(){
        ConfigReader.readProperties(Constants.configurationFilePath);
        switch (ConfigReader.getPropertyValue("browser")){

            case "chrome":
              //  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver2.exe");
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "Firefox":
               // System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name");
        }
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);

    }



    @AfterMethod(alwaysRun = true)
    public void closBrowser(){
        driver.quit();
    }

}
