package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.time.Duration;

public class Driver {

    private Driver() {
    }

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setUp(String browser) {
        DriverOptions driverOptions = new DriverOptions();

        switch (browser.toLowerCase()) {
            case "chrome" -> {
                ChromeOptions options = driverOptions.chromeUp();
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver(options));
            }
            case "firefox" -> {
                FirefoxOptions options = driverOptions.firefoxUp();
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver(options));
            }
            default -> {
                if (browser.matches("(?i)iPhone X|iPhone 6/7/8|iPad|Nexus 5")) {
                    ChromeOptions options = driverOptions.mobileUp(browser);
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver(options));
                } else {
                    throw new RuntimeException("Desteklenmeyen Browser Seçildi: " + browser);
                }
            }
        }

        WebDriver currentDriver = driver.get();
        if (currentDriver != null) {
            currentDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            currentDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeDriver() {
        if (getDriver() != null) {
            getDriver().manage().deleteAllCookies();
            getDriver().quit();
            driver.remove();
        }
    }

    public static void takeScreenShot() {
        takeScreenShot("");
    }

    @Attachment(value = "ScreenShot : {0}", type = "image/png")
    public static byte[] takeScreenShot(String message) {
        if (Driver.getDriver() == null) {
            System.out.println("Driver null olduğu için ekran görüntüsü alınamadı.");
            return null;
        }
        return ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}





