package Managers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;


public class WebDriverSingleton {
    private static WebDriver driver;
    final public static String BASEURL = "https://assessfirst.com";
    final public static String RegisterURL = "https://welcome.assessfirst.com/register";
    static Logger log = LogManager.getLogger(WebDriverSingleton.class);

    @Parameters({"browser"})

    public static WebDriver getInstance(String browser) throws Exception {
        WebDriverSingleton instance;
        //browser = System.getProperty("browserName");
        if (browser == null) {
            browser = "chrome";
        }

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            Thread.sleep(1000);
            driver.get(BASEURL);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.navigate().to(RegisterURL);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
           // Reporter.log("Chrome Launched", true);
        }

        //Check if parameter passed as 'chrome'
        else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            Thread.sleep(1000);
            driver.get(BASEURL);
//            Thread.sleep(1000);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.navigate().to(RegisterURL);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();

            Reporter.log("Firefox Launched", true);
        }
        //Check if parameter passed as 'Edge'

        else {
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        log.debug("Réussite ouverture page acceuil");

        return driver;

    }

    public static void destroy() {
        driver.quit();
        log.info("Fermeture web driver réussit ");

        driver = null;

    }
}
