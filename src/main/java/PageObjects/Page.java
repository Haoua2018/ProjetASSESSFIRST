package PageObjects;

import Managers.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static Managers.WebDriverSingleton.driver;
import static Managers.WebDriverSingleton.getInstance;
import static org.openqa.selenium.support.PageFactory.*;

@Parameters( { "browser" } )

public class Page  {
    final public String BASEURL="https://welcome.assessfirst.com";
    final public String RegisterURL="https://welcome.assessfirst.com/register";
    final public String LOGINURL="https://welcome.assessfirst.com/login";
    final public String ACTIVECOMPTEURL="https://welcome.assessfirst.com/register/activation";
    final String CONFIGPROFILURLperso="https://welcome.assessfirst.com/register/personal/introduce";
    final public String COMPLETUDEPROFILURLperso="https://welcome.assessfirst.com/onboarding/who-are-you";
    final public String SIGNUPperso="https://welcome.assessfirst.com/register/personal/sign-up";
final public String CREATIONEnterpriseURL="https://welcome.assessfirst.com/register/business/credentials";
    final public String CREATIONPersoURL="https://welcome.assessfirst.com/register/personal/credentials";

    public static String browser;

   public static WebDriver driver;

    public Page(WebDriver driver1)   {
        driver=driver1;
        initElements(driver,this);
                    }


    public void writeText(WebElement element, String texte){
        element.sendKeys(texte);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickOn(WebElement element){
        element.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
