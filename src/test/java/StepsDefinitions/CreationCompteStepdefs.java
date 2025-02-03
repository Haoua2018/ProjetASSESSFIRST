package StepsDefinitions;

import PageObjects.PageCreationCompte;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.testng.Assert;

import java.util.List;

public class CreationCompteStepdefs {
    PageCreationCompte Pcrea = new PageCreationCompte();

    @Given("l'utilisateur navigue sur le site web de création de compte")
    public void lUtilisateurNavigueSurLeSiteWebDeCréationDeCompte() throws InterruptedException {
        Pcrea.NavigateToregisterpage();
    }

    @Then("l'accès est validé,le code de validation est envoyée par mail")
    public void lAccèsEstValidéLeCodeDeValidationEstEnvoyéeParMail( ) {
       Pcrea.ValidationInfoCompte();
    }

    @And("donc une proposition de configuration du profil est proposé")
    public void doncUnePropositionDeConfigurationDuProfilEstProposé() {
        Pcrea.ConfigProfil();
    }

    @When("l'utilisateur crèe un compte en saisissant les informations invalides")
    public void lUtilisateurCrèeUnCompteEnSaisissantLesInformationsInvalides() {
    }

    @Then("l'acces est invalidé, le message d'erreur s'affiche <Errormessage>")
    public void lAccèsNEstValidéUnMessageDErreurSAfficheErrormessage() {
    }

    @And("le compte n'est pas crée")
    public void leCompteNEstPasCrée() {
    }

    @And("Il choisit le mode d'accès {string}")
    public void ilChoisitLeModeDAccès(String mot) throws InterruptedException {
        Pcrea.Profilchoice("personnel");
        if (mot.equals("personnel")) {
            Assert.assertEquals(Pcrea.ReturncurrentURL(Pcrea.currentURL), Pcrea.ReturncurrentURL(Pcrea.personURL));
        } else {
            Assert.assertEquals(Pcrea.ReturncurrentURL(Pcrea.currentURL), Pcrea.ReturncurrentURL(Pcrea.entrepriseURL));
        }


         }

    @When("L'utilisateur crèe un compte en saisissant les informations valides")
    public void lUtilisateurCrèeUnCompteEnSaisissantLesInformationsValides( DataTable dataTable) throws InterruptedException {
        String modeaccess,mail, pwd,pwd2;
      List<List<String>> InfoTable= dataTable.asLists(String.class);
        System.out.println(InfoTable.getFirst().size());
      //for (List <String> e : InfoTable)
     //  { modeaccess= e.getText();
        //  Pcrea.WriteInformationaccount(modeaccess, mail, pwd, pwd2);}
    //    if (modeaccess.equals("personnel")) {
     //       Assert.assertEquals(Pcrea.ReturncurrentURL(Pcrea.currentURL), Pcrea.ReturncurrentURL(Pcrea.SIGNUPperso));
       // }
    }
    //}
}
