package utility;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class DriverOptions {

    private static final String START_FULLSCREEN = "--start-fullscreen";
    private static final String HEADLESS = "--headless";
    private static final String HEADLESS_USER_AGENT = "user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36";
    private static String driverType;

    public ChromeOptions chromeUp() {
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        chromePrefs.put("plugins.always_open_pdf_externally", true);
        chromePrefs.put("download.default_directory", Paths.get("downloads").toAbsolutePath().toString());

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--whitelisted-ips");
        chromeOptions.addArguments("--disable-gpu", "--ignore-certificate-errors", "--ignore-ssl-errors");
        chromeOptions.addArguments("--enable-features=NetworkServiceInProcess", "--disable-features=NetworkService");
        chromeOptions.addArguments("--aggressive-cache-discard", "--disable-cache", "--disable-application-cache");
        chromeOptions.addArguments("--disable-offline-load-stale-cache", "--disk-cache-size=0", "--dns-prefetch-disable");
        chromeOptions.addArguments("--no-proxy-server", "--silent", "--disable-browser-side-navigation");
        chromeOptions.addArguments("--disable-notifications", "--disable-extensions", "--disable-popup-blocking");
        chromeOptions.addArguments(HEADLESS_USER_AGENT);
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.setExperimentalOption("prefs", chromePrefs);

        setDriverType("chrome");

        if (DriverConfig.getInstance().isChromeHeadless()) {
            chromeOptions.addArguments(HEADLESS, "--window-size=1920x1080");
        } else {
            chromeOptions.addArguments(START_FULLSCREEN);
        }

        return chromeOptions;
    }

    public FirefoxOptions firefoxUp() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        setDriverType("firefox");

        firefoxOptions.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--whitelisted-ips");
        firefoxOptions.addArguments("--disable-gpu", "--disable-notifications", "--disable-extensions", "--disable-popup-blocking");

        if (DriverConfig.getInstance().isFirefoxHeadless()) {
            firefoxOptions.addArguments("--headless");
        } else {
            firefoxOptions.addArguments(START_FULLSCREEN);
        }

        return firefoxOptions;
    }

    public ChromeOptions mobileUp(String device) {
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", device);
        setDriverType("mobile");

        ChromeOptions mobileOptions = new ChromeOptions();
        mobileOptions.addArguments("--disable-dev-shm-usage", "--disable-gpu", "--no-sandbox", "--whitelisted-ips");
        mobileOptions.addArguments("--disable-extensions", "--window-size=1920x1080", HEADLESS_USER_AGENT);
        mobileOptions.addArguments("--ignore-certificate-errors", "--ignore-ssl-errors", "--disable-cache", "--disable-popup-blocking");
        mobileOptions.addArguments("--disable-application-cache", "--disable-offline-load-stale-cache", "--disk-cache-size=0", "--dns-prefetch-disable");
        mobileOptions.addArguments("--no-proxy-server", "--log-level=3", "--silent", "--disable-browser-side-navigation");
        mobileOptions.addArguments("--disable-notifications");
        mobileOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        if (DriverConfig.getInstance().isMobileHeadless()) {
            mobileOptions.addArguments(HEADLESS);
        } else {
            mobileOptions.addArguments(START_FULLSCREEN);
        }

        return mobileOptions;
    }

    public static String getDriverType() {
        return driverType;
    }

    private static void setDriverType(String driverType) {
        DriverOptions.driverType = driverType;
    }
}

