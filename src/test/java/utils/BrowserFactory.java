package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import steps.PageInitializers;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    private BrowserFactory() {
    }

    public static WebDriver get() {
        if (driverPool.get() == null) {
            ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
            switch (ConfigReader.getPropertyValue("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
                default:
                    throw new RuntimeException("Invalid Browser Name");
            }
            driverPool.get().get(ConfigReader.getPropertyValue("url"));
            driverPool.get().manage().deleteAllCookies();
            driverPool.get().manage().window().maximize();
            driverPool.get().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        }
        return driverPool.get();
    }

    public static void closeBrowser() {
        driverPool.get().quit();
        driverPool.remove();
    }
}
