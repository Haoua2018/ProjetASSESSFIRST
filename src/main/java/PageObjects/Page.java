package PageObjects;

import Managers.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@Parameters( { "browser" } )

public class Page  {
    final public String BASEURL="https://welcome.assessfirst.com";
    final public String RegisterURL="https://welcome.assessfirst.com/register";
    final  String LOGINURL="https://welcome.assessfirst.com/login";
    final String ACTIVECOMPTEURL="https://welcome.assessfirst.com/register/activation";
    final String CONFIGPROFILURLperso="https://welcome.assessfirst.com/register/personal/introduce";
    final String COMPLETUDEPROFILURLperso="https://welcome.assessfirst.com/onboarding/who-are-you";
    final String SIGNUPperso="https://welcome.assessfirst.com/register/personal/sign-up";

    public static String browser;
         //= String.valueOf(Parameters.class);

    protected static WebDriver driver;

    static {
        try {
            Reporter.log("Browser value");
            System.out.println(browser);
            driver = WebDriverSingleton.getInstance(browser);
            if (driver==null)
            {Reporter.log("Echec création driver dans page");}
            else
            { Reporter.log("Réussite de la création du driver page");
            System.out.println(driver); }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Page()   {
        PageFactory.initElements(driver,this);
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
