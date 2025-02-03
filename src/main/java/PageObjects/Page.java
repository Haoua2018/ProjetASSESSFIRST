package PageObjects;

import Managers.WebDriverSingleton;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Page {
    protected static WebDriver driver= WebDriverSingleton.getInstance("");
    final String BASEURL="https://welcome.assessfirst.com";
    final  String RegisterURL="https://welcome.assessfirst.com/register";
    final  String LOGINURL="https://welcome.assessfirst.com/login";
    final String ACTIVECOMPTEURL="https://welcome.assessfirst.com/register/activation";
    final String CONFIGPROFILURLperso="https://welcome.assessfirst.com/register/personal/introduce";
    final String COMPLETUDEPROFILURLperso="https://welcome.assessfirst.com/onboarding/who-are-you";
    public final String SIGNUPperso="https://welcome.assessfirst.com/register/personal/sign-up";
    public Page()
    {
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
