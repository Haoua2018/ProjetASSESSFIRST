package PageObjects;
import PageObjects.Page;
import Managers.WebDriverSingleton;
import org.apache.logging.log4j.*;
        //Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.List;

@Parameters({"browser"})

public class PageCreationCompte extends Page {

    private static final Logger log = LoggerFactory.getLogger(PageCreationCompte.class);
    @FindBy(xpath = "//a[@data-cy='register-personal-card']")
    //      "data-cy='register-personal-card'")
    private WebElement Personnel;
    //  @FindBy(linkText = "https://welcome.assessfirst.com/register/business")
    //@FindBy(xpath = "//a[@data-cy='register-business-desc']")
    //classname="grid_gap-4"
    //@FindBy(css="a[href='/register/business']")
    //@FindBy(className="grid_gap-4")
    //private List <WebElement>   divEnt;
    @FindBy(xpath = "//a[@data-cy='register-business-card']")

    private WebElement Entreprise;
            //= divEnt.getLast();
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
    PageCreationCompte creapage;
    //if ()
    final public String RegisterURL = "https://welcome.assessfirst.com/register";

    public PageCreationCompte() {
        this.driverG=driver;
        /*if(creapage == null){
            creapage=new PageCreationCompte();
        }*/
      log.info("Création 1");
    }

    // public PageCreationCompte() throws Exception {

    //}

    public void NavigateToregisterpage( ) throws Exception {
        driverG = driver;
        creapage = new PageCreationCompte();

                //creapage.driverG;
        //driverG= WebDriverSingleton.getInstance(browser);
        // driverG.get(page.BASEURL);

        if(driverG==null){
            Reporter.log("driver is null");
        }
        driverG.navigate().to(RegisterURL);
        Thread.sleep(6000);

    }

    public String ReturnTitle() {
        driverG = creapage.driverG;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String titre = driverG.getTitle();
        return titre;
    }

    public void Profilchoice(String choix) throws InterruptedException {
        driverG = creapage.driverG;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        switch (choix) {
            case "Personnel":
                Thread.sleep(3000);
                Personnel.click();
                Thread.sleep(3000);

                currentURL = driverG.getCurrentUrl();
                personURL = "https://welcome.assessfirst.com/register/personal";
                Thread.sleep(4000);
            case "Entreprise":
                entrepriseURL = "https://welcome.assessfirst.com/register/business";
                Thread.sleep(3000);
                 Entreprise.click();
                currentURL = driverG.getCurrentUrl();
                Thread.sleep(3000);

        }
    }

    public String ReturncurrentURL(String toreturn) {
        return toreturn;
    }

    public void WriteInformationaccount(String choix, String emailtxt, String mdptxt, String confirmpwd) throws InterruptedException {
        driverG = creapage.driverG;

        driverG.get(RegisterURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        switch (choix) {
            case "personnel":
                clickOn(CpartiBtnperso);
                Thread.sleep(3000);
                clickOn(InscriveBtnperso);
                Thread.sleep(3000);
                writeText(InputEmail, emailtxt);
                writeText(InputMotpasse, mdptxt);
                writeText(InputConfirmMotpasse, confirmpwd);
                clickOn(InscriveBtnperso);
                currentURL = driverG.getCurrentUrl();

            case "entreprise":
                clickOn(CpartiBtnperso);
                Thread.sleep(3000);
                clickOn(InscriveBtnperso);
                Thread.sleep(3000);

        }
    }

    public void ValidationInfoCompte() {

        System.out.println("Accès ok");
    }

    public void ConfigProfil() {

    }

    public Page getCreapage() {
        return creapage;
    }
}
