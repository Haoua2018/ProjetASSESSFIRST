package PageObjects;

import Managers.WebDriverSingleton;
import org.apache.logging.log4j.plugins.util.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageCreationCompte extends Page {

    @FindBy (xpath ="//a[@data-cy='register-personal-card']")
      //      "data-cy='register-personal-card'")
    private WebElement Personnel;
    //  @FindBy(linkText = "https://welcome.assessfirst.com/register/business")
    @FindBy(tagName = "data-cy='register-business-desc'")
    private WebElement Entreprise;
    @FindBy(linkText = "C'est parti !")
    private WebElement CpartiBtnperso;
    @FindBy(linkText = "Inscrivez-vous avec un email")
    private WebElement InscriveBtnperso;
    @FindBy(name = "email")
    private WebElement InputEmail;
    @FindBy(name = "password")
    private WebElement InputMotpasse;
    @FindBy(name = "password_confirmation")
    private WebElement InputConfirmMotpasse;
    @FindBy(xpath = "/html/body/div[2]/div/div[1]/div/form/button")
    private WebElement InscrireBtn;
    @FindBy(tagName = "placeholder='utilisateur@email.com'")
    private WebElement InputEmailEnterprise;

    public String currentURL, personURL, entrepriseURL;
    private WebDriver driverG;
    Page page = new Page();

    public void NavigateToregisterpage() throws InterruptedException {
        driverG = WebDriverSingleton.getInstance("Google");
        // driverG.get(page.BASEURL);
        driverG.navigate().to(RegisterURL);
        Thread.sleep(3000);
        driverG.manage().window().maximize();

    }

    public void Profilchoice(String choix) throws InterruptedException {
        switch (choix) {
            case "personnel":
                Thread.sleep(3000);
                Personnel.click();
                currentURL = driverG.getCurrentUrl();
                personURL = "https://welcome.assessfirst.com/register/personal";
                Thread.sleep(3000);
            case "entreprise":
                entrepriseURL = "https://welcome.assessfirst.com/register/business";
                Entreprise.click();
                currentURL = driverG.getCurrentUrl();
                Thread.sleep(3000);

        }
    }

    public String ReturncurrentURL(String toreturn) {
        return toreturn;
    }

    public void WriteInformationaccount(String choix, String emailtxt, String mdptxt, String confirmpwd) throws InterruptedException {
        // driverG.get(page.RegisterURL);
        switch (choix) {
            case "personnel":
                page.clickOn(CpartiBtnperso);
                Thread.sleep(3000);
                page.clickOn(InscriveBtnperso);
                Thread.sleep(3000);
                page.writeText(InputEmail, emailtxt);
                page.writeText(InputMotpasse, mdptxt);
                page.writeText(InputConfirmMotpasse, confirmpwd);
                page.clickOn(InscriveBtnperso);
                currentURL = driverG.getCurrentUrl();

            case "entreprise":
                page.clickOn(CpartiBtnperso);
                Thread.sleep(3000);
                page.clickOn(InscriveBtnperso);
                Thread.sleep(3000);

        }
    }

    public void ValidationInfoCompte() {
        System.out.println("Accès ok");
    }

    public void ConfigProfil() {

    }

}
