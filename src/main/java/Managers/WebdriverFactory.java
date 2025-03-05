package Managers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebdriverFactory {

        private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

        public static WebDriver getDriver(String browser) {
            if (driver.get() == null) {
                WebDriver webDriver = null;
                if (browser.equalsIgnoreCase("chrome")) {
                    webDriver = new ChromeDriver();
                } else if (browser.equalsIgnoreCase("firefox")) {
                    webDriver = new FirefoxDriver();
                }
                driver.set(webDriver);
            }
            return driver.get();
        }

        public static void quitDriver() {
            if (driver.get() != null) {
                driver.get().quit();
                driver.remove();
            }
        }
    }


