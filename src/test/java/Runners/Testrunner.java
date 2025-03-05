package Runners;

import Managers.WebDriverSingleton;
import com.thoughtworks.qdox.model.JavaClass;
import io.cucumber.java.Before;
import io.cucumber.testng.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.ServiceLoader;

import org.apache.logging.log4j.core.*;
//import org.apache.logging.log4j.PropertyConfigurator;
import org.apache.logging.log4j.util.*;

import static Managers.WebDriverSingleton.*;

@Parameters( { "browser" } )

@RunWith(Parameterized.class)
@CucumberOptions
        (
                features = "./src/test/resources/Features",
                glue = {"StepsDefinitions"},
                plugin = {  "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm","pretty", "html:target/cucumber-pretty"},
                monochrome = true,
                tags = "@Passing"

        )

public class Testrunner extends AbstractTestNGCucumberTests  {
    ServiceLoader<Appender> appenders = ServiceLoader.load(Appender.class);
   //private static final Logger log = LogManager.getLogger();
//PropertyConfigurator.configure("Lelogger/");
    /*@BeforeMethod
    @Parameters( { "browser" } )

    public void init( String browser ) throws Exception{
        //  WebDriver driver;

       driver=WebDriverSingleton.getInstance(browser);


        log.info("Réussite du void init");
        log.debug("Initialisation web driver réussit ");
        //return driver;
    }

    @AfterTest
    public void quitter() {
        WebDriverSingleton.destroy();
    }

     */
   @Override
   @DataProvider(parallel = false)//parallel = true)
   public Object[][] scenarios() {
       return super.scenarios();
   }



}
