package PageObjects;

import Managers.WebdriverFactory;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.List;

@Parameters({"browser"})

public class PageInscriptionCompte extends Page {
    static org.apache.logging.log4j.Logger log = LogManager.getLogger(WebdriverFactory.class);
    private static final Logger log2 = LoggerFactory.getLogger(PageInscriptionCompte.class);

    @FindBy(tagName = "placeholder='Entrez votre mot de passe'")
    private WebElement InputMotpasse;

    @FindBy(tagName = "placeholder='utilisateur@email.com'")
    private WebElement InputEmailLogin;

    @FindBy(tagName = "data-cy='login-button'")
    private WebElement BoutonLogin;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public String currentURL, personURL, entrepriseURL;

    PageInscriptionCompte Inscripage;

    public PageInscriptionCompte(WebDriver drver) {

        super(drver);
        log.info("Page inscription OK");
    }

    public void ValidationCookies() {
        try {
            // Attente explicite pour que le bouton "Accepter" soit visible
            WebElement acceptButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("axeptio_btn_acceptAll")));

            // Clique sur le bouton des cookies
            acceptButton.click();
            System.out.println("Cookies acceptés.");
        } catch (Exception e) {
            System.out.println("Erreur lors de la validation des cookies: " + e.getMessage());
        }
    }

    public void NavigateToInscrivepage() throws Exception {

        if (driver == null) {
            Reporter.log("driver is null");
        }
        driver.navigate().to(LOGINURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        Thread.sleep(6000);
        log2.info("Validation cookies en cours");
        ValidationCookies();
    }

    public String ReturnTitle() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.getTitle();

    }

//    public void Profilchoice(String choix) throws InterruptedException {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        personURL = "https://welcome.assessfirst.com/register/personal";
//        entrepriseURL = "https://welcome.assessfirst.com/register/business";
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        //wait.until(ExpectedConditions.elementToBeClickable(By.className("div.grid.gap-4")));
//        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("div.grid.gap-4")));
//        Personnel = divEnt.getFirst();
//        Entreprise = divEnt.getLast();
//        switch (choix) {
//            case "Personnel":
//                Thread.sleep(3000);
//                clickOn(Personnel);
//                log.info("¨Profil compte choisie");
//                Thread.sleep(3000);
//                currentURL = driver.getCurrentUrl();
//                js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
//                clickOn(CpartiBtnperso);
//                Thread.sleep(3000);
//                clickOn(InscriveBtnperso);
//                break;
//
//            case "Entreprise":
//                //Thread.sleep(3000);
//                clickOn(Entreprise);
//                currentURL = driver.getCurrentUrl();
//                Thread.sleep(3000);
//                log.info("¨Profil compte Entreprise choisie");
//                js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
//                clickOn(CpartiBtnperso);
//                Thread.sleep(3000);
//                clickOn(InscriveBtnperso);
//
//                break;
//            default:
//                throw new IllegalStateException("Valeur inappropriée: " + choix);
//        }
//    }

    public String ReturncurrentURL(String toreturn) {
        return toreturn;
    }

    public void WriteInformationaccount(String choix, String emailtxt, String mdptxt, String confirmpwd) throws InterruptedException {
        //driverG = creapage.driverG;
        //driver.get(RegisterURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        switch (choix) {
            case "Personnel":
                // driver.get(CREATIONURL);
                writeText(InputEmailLogin, emailtxt);
                writeText(InputMotpasse, mdptxt);
                clickOn(BoutonLogin);
                currentURL = driver.getCurrentUrl();

            case "Entreprise":

                writeText(InputEmailLogin, emailtxt);
                writeText(InputMotpasse, mdptxt);
                clickOn(BoutonLogin);
                currentURL = driver.getCurrentUrl();
                // break;
            default:
                throw new IllegalStateException("Aucun choix de profil : " + choix);
        }
    }

//    public void ValidationInfoCompte() {
//        System.out.println(ReturnTitle());
//        clickOn(InscriptionCredBtnperso);
//        //System.out.println("Accès ok");
//        currentURL = driver.getCurrentUrl();
//    }

    public void ConfigProfil() {

    }

     //    public Page getCreapage() {
    //      return creapage;
    //}
}
