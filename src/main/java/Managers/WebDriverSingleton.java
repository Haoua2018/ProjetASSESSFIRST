package Managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {
    private static WebDriver driver;

    public static WebDriver getInstance() {
        WebDriverSingleton instance;
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void destroy() {
        driver.quit();
        driver = null;

    }
}
