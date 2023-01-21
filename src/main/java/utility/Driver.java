package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Driver {

    private Driver() {
    }

    // Sabit bir değişken olduğu için 'final' yapıldı
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static void setUp(String browser) {
        DriverOptions driverOptions = new DriverOptions();
        Capabilities options;
        switch (browser) {
            case "chrome" -> {
                options = driverOptions.chromeUp();
                if (!DriverConfig.getInstance().isGrid()) {
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver((ChromeOptions) options));
                }
            }
            case "firefox" -> {
                options = driverOptions.firefoxUp();
                if (!DriverConfig.getInstance().isGrid()) {
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver((FirefoxOptions) options));
                }
            }
            default -> {
                if (browser.equals("iPhone X") || browser.equals("iPhone 6/7/8") || browser.equals("iPad") || browser.equals("Nexus 5")) {
                    options = driverOptions.mobileUp(browser);
                    if (!DriverConfig.getInstance().isGrid()) {
                        WebDriverManager.chromedriver().setup();
                        driver.set(new ChromeDriver((ChromeOptions) options));
                    }
                } else {
                    throw new RuntimeException("Desteklenmeyen Browser Seçildi");
                }
            }
        }

        if (DriverConfig.getInstance().isGrid()) {
            try {
                URL url = new URL(DriverConfig.getInstance().getGridUrl());
                driver.set(new RemoteWebDriver(url, options));
            } catch (MalformedURLException e) {
                System.out.println("Hata Alındı");
            }
        }

        driver.get()
                .manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(20));
        driver.get()
                .manage()
                .timeouts()
                .pageLoadTimeout(Duration.ofSeconds(40));



    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeDriver() {
        if (getDriver() != null) {
            getDriver().manage().deleteAllCookies(); //ekledigimiz cookieleri silebilmek için eklendi.
            getDriver().quit();
            driver.remove();
        }
    }

    public static void takeScreenShot() {
        takeScreenShot("");
    }

    @Attachment(value = "ScreenShot : {0}" , type = "image/png")
    public static byte[] takeScreenShot(String message) {
        if(Driver.getDriver() == null) {
            System.out.println("Driver null olduğu için ekran görüntüsü alınamadı.");
        }
        return ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
    }


}
