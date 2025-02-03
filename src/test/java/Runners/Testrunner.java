package Runners;

import Managers.WebDriverSingleton;
import io.cucumber.java.*;
import io.cucumber.testng.*;
import org.testng.*;
import io.cucumber.core.runner.*;
import io.cucumber.java.en.*;
import io.cucumber.core.api.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
//@RunWith

@CucumberOptions
        (
                features = "./src/test/resources/Features",
                glue = {"StepsDefinitions"},
                plugin = {  "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm","pretty", "html:target/cucumber-pretty"},
                tags = "@Passing"

        )

public class Testrunner extends AbstractTestNGCucumberTests {

    @BeforeTest
    public void init() {
        WebDriverSingleton.getInstance("");
    }

    @AfterTest
    public void quitter() {
        WebDriverSingleton.destroy();
    }
}
