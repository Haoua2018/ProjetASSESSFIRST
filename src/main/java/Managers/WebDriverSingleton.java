package Managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverSingleton {
    private static WebDriver driver;

    public static WebDriver getInstance( String choix) {
        WebDriverSingleton instance;
        switch (choix) {
            case "Google":
                if (driver == null) {
                    driver = new ChromeDriver();
                }
            case "Firefox":
                if (driver == null) {
                    driver = new FirefoxDriver();
                }
        }
        return driver;
    }

    public static void destroy() {
        driver.quit();
        driver = null;

    }
}
