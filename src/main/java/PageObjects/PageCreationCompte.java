package PageObjects;

import Managers.WebdriverFactory;
import PageObjects.Page;
import Managers.WebDriverSingleton;
import org.apache.logging.log4j.*;
//Assert;
import org.openqa.selenium.*;
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

import static Managers.WebDriverSingleton.*;
import static Managers.WebDriverSingleton.driver;

@Parameters({"browser"})

public class PageCreationCompte extends Page {
    static org.apache.logging.log4j.Logger log = LogManager.getLogger(WebdriverFactory.class);
    private static final Logger log2 = LoggerFactory.getLogger(PageCreationCompte.class);
    //@FindBy(xpath = "//a[@data-cy='register-personal-card']")
    private WebElement Personnel;
    //  @FindBy(linkText = "https://welcome.assessfirst.com/register/business")
    @FindBy(xpath = "//button[@data-cy='sign-up-button']")
    private WebElement InscriptionCredBtnperso;

    //@FindBy(className="grid_gap-4")
    @FindBy(css = "div.grid.gap-4>a")
    private List<WebElement> divEnt;
    //@FindBy(xpath = "//a[@data-cy='register-business-card']")
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
    @FindBy(name = "email")
    private WebElement InputEmailEnterprise;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public String currentURL, personURL, entrepriseURL;
    //private WebDriver driverG;
    PageCreationCompte creapage;
    //if ()
    final public String RegisterURL = "https://welcome.assessfirst.com/register";

    public PageCreationCompte(WebDriver drver) {

        super(drver);
        //this.driver=driver;
        log.info("Page crée");
    }

    public void NavigateToregisterpage() throws Exception {
        //driver;
        //driver = WebDriverSingleton.getInstance(browser);
        //driver.get(BASEURL);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //  driver.navigate().to(RegisterURL);
        if (driver == null) {
            Reporter.log("driver is null");
        }
        driver.navigate().to(RegisterURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        Thread.sleep(6000);
        log2.info("Validation cookies en cours");
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

    public String ReturnTitle() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.getTitle();

    }

    public void Profilchoice(String choix) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        personURL = "https://welcome.assessfirst.com/register/personal";
        entrepriseURL = "https://welcome.assessfirst.com/register/business";
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //wait.until(ExpectedConditions.elementToBeClickable(By.className("div.grid.gap-4")));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("div.grid.gap-4")));
        Personnel = divEnt.getFirst();
        Entreprise = divEnt.getLast();
        switch (choix) {
            case "Personnel":
                Thread.sleep(3000);
                clickOn(Personnel);
                log.info("¨Profil compte choisie");
                Thread.sleep(3000);
                currentURL = driver.getCurrentUrl();
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                clickOn(CpartiBtnperso);
                Thread.sleep(3000);
                clickOn(InscriveBtnperso);
                break;

            case "Entreprise":
                //Thread.sleep(3000);
                clickOn(Entreprise);
                currentURL = driver.getCurrentUrl();
                Thread.sleep(3000);
                log.info("¨Profil compte Entreprise choisie");
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                clickOn(CpartiBtnperso);
                Thread.sleep(3000);
                clickOn(InscriveBtnperso);

                break;
            default:
                throw new IllegalStateException("Valeur inappropriée: " + choix);
        }
    }

    public String ReturncurrentURL(String toreturn) {
        return toreturn;
    }

    public void WriteInformationaccount(String choix, String emailtxt, String mdptxt, String confirmpwd) throws InterruptedException {
        //driverG = creapage.driverG;

        driver.get(RegisterURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        switch (choix) {
            case "Personnel":
//                clickOn(CpartiBtnperso);
//                Thread.sleep(3000);
//                clickOn(InscriveBtnperso);
//                Thread.sleep(5000);
                driver.get(CREATIONPersoURL);
                writeText(InputEmail, emailtxt);
                writeText(InputMotpasse, mdptxt);
                writeText(InputConfirmMotpasse, confirmpwd);
                clickOn(InscrireBtn);
                currentURL = driver.getCurrentUrl();

            case "Entreprise":
//                clickOn(CpartiBtnperso);
//                Thread.sleep(3000);
//                clickOn(InscriveBtnperso);
//                Thread.sleep(3000);
                driver.get(CREATIONEnterpriseURL);
                Thread.sleep(4000);

                writeText(InputEmailEnterprise, emailtxt);
                writeText(InputMotpasse, mdptxt);
                writeText(InputConfirmMotpasse, confirmpwd);
                clickOn(InscrireBtn);
                currentURL = driver.getCurrentUrl();

                // break;
            default:
                throw new IllegalStateException("Aucun choix de profil : " + choix);
        }
    }

    public void ValidationInfoCompte() {
        System.out.println(ReturnTitle());
        clickOn(InscriptionCredBtnperso);
        currentURL = driver.getCurrentUrl();
    }

    public void ConfigProfil() throws InterruptedException {
        Thread.sleep(6000);
        
    }

    public Page getCreapage() {
        return creapage;
    }
}
