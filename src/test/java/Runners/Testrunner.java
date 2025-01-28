package Runners;

import Managers.WebDriverSingleton;
import io.cucumber.java.*;
import io.cucumber.testng.*;
import org.testng.*;
import io.cucumber.core.runner.*;
import io.cucumber.java.en.*;
import io.cucumber.core.api.*;
import org.openqa.selenium.WebDriver;
import cucumber.api.*;
//@RunWith

@CucumberOptions
        (
                features = "./src/test/resources/Features",
                glue = {"StepsDefinitions"},
                plugin = {"pretty", "html:target/cucumber-pretty"},
                tags = "@WithMedia"

        )

public class Testrunner extends AbstractTestNGCucumberTests {

    @Before
    public void init() {
        WebDriverSingleton.getInstance();
    }

    @After
    public void quitter() {
        WebDriverSingleton.destroy();
    }
}
