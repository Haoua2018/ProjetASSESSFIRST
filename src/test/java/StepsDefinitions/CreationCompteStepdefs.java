package StepsDefinitions;

import Managers.WebdriverFactory;
import PageObjects.PageCreationCompte;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.List;
import java.util.Random;

import static Managers.WebDriverSingleton.*;

//import static PageObjects.Page.browser;
//@Parameters( { "browser" } )

@Parameters({"browser"})

public class CreationCompteStepdefs {
    PageCreationCompte Pcrea;
    String browser;
    private static final Logger logf = LogManager.getLogger(CreationCompteStepdefs.class);
    public String Choixprofil;

    @Before
    //public void setUp(String browser) {
    public void setUp() {
        if (browser == null) {
            browser = "chrome";
        }
        driver = WebdriverFactory.getDriver(browser);  // Choisir le navigateur
        driver.get(BASEURL);
        //loginPage = new LoginPage(driver);
        Pcrea = new PageCreationCompte(driver);

    }

    public void initilization() {
        // PageCreationCompte loginPage = new PageCreationCompte();
    }

    @Given("l'utilisateur navigue sur le site web de création de compte")
    public void lUtilisateurNavigueSurLeSiteWebDeCréationDeCompte() throws Exception {
        Pcrea.NavigateToregisterpage();
        Thread.sleep(5000);
        Assert.assertEquals(Pcrea.ReturnTitle(), "Épanouissement personnel ou réussite professionnelle | AssessFirst");
        Thread.sleep(3000);
        logf.debug("Navigation réussit");
    }

    @And("Il choisit le mode d'accès {string}")
    public void ilChoisitLeModeDAccès(String mot) throws InterruptedException {
        Random random = new Random();
        String Access1 = "Personnel";
        String Access2 = "Entreprise";

        mot = random.nextBoolean() ? Access1 : Access2;
        Reporter.log(mot);
        Pcrea.Profilchoice(mot);
        Thread.sleep(3000);
        if (mot.equalsIgnoreCase("Personnel")) {

            Assert.assertEquals(Pcrea.currentURL, Pcrea.personURL);
            Thread.sleep(6000);
            // Assert.assertEquals(Pcrea.currentURL,Pcrea.ReturncurrentURL(RegisterURL));
            //    Thread.sleep(3000);

        } else {
            //  Thread.sleep(3000);
            Thread.sleep(3000);
            Assert.assertEquals(Pcrea.currentURL, Pcrea.entrepriseURL);
            Thread.sleep(3000);
            //  Thread.sleep(3000);

        }

    }

    @When("L'utilisateur crèe un compte en saisissant les informations valides")
    public void lUtilisateurCrèeUnCompteEnSaisissantLesInformationsValides(DataTable dataTable) throws
            InterruptedException {
        String modeaccess, mail, pwd, pwd2;
        //
        List<List<String>> InfoTable = dataTable.asLists(String.class);
        Thread.sleep(3000);
        mail = String.valueOf(InfoTable.get(1).getFirst());
        modeaccess = Choixprofil;
        //String.valueOf(InfoTable.get(1).get(2));
        pwd = String.valueOf(InfoTable.get(1).get(2));
        pwd2 = String.valueOf(InfoTable.get(1).getLast());
        if (modeaccess == null) {
            Random random = new Random();
            String Access1 = "Personnel";
            String Access2 = "Entreprise";

            modeaccess = random.nextBoolean() ? Access1 : Access2;
        }
        Pcrea.WriteInformationaccount(modeaccess, mail, pwd, pwd2);
        Thread.sleep(3000);
        logf.info(" Ecriture du login en cours");
        if (modeaccess.equalsIgnoreCase("Personnel")) {
            Assert.assertEquals(Pcrea.currentURL, Pcrea.SIGNUPperso);
        } else {
            Assert.assertEquals(Pcrea.currentURL, Pcrea.entrepriseURL);

        }
        logf.info(" Fin de l'écriture");
    }


    @Then("l'accès est validé,le code de validation est envoyée par mail")
    public void lAccèsEstValidéLeCodeDeValidationEstEnvoyéeParMail() throws InterruptedException {
        Pcrea.ValidationInfoCompte();
        Thread.sleep(3000);
        Assert.assertEquals(Pcrea.ReturnTitle(), "Pourquoi s'inscrire sur AssessFirst ? | AssessFirst");
    }

    @And("donc une proposition de configuration du profil est proposé")
    public void doncUnePropositionDeConfigurationDuProfilEstProposé() throws InterruptedException {
        Pcrea.ConfigProfil();
        Thread.sleep(3000);
        Assert.assertEquals(Pcrea.ReturnTitle(), "Introduction - Créez mon compte | AssessFirst");
        Thread.sleep(3000);

    }

    @When("l'utilisateur crèe un compte en saisissant les informations invalides")
    public void lUtilisateurCrèeUnCompteEnSaisissantLesInformationsInvalides() {
    }

    @Then("l'acces est invalidé, le message d'erreur s'affiche <Errormessage>")
    public void lAccèsNEstValidéUnMessageDErreurSAfficheErrormessage() {
    }


    //}
    @And("le compte n'est pas crée")
    public void leCompteNEstPasCrée() {
    }

    @After
    public void tearDown() {
        WebdriverFactory.quitDriver();
    }

}
