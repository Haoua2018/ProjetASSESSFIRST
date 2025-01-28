package StepsDefinitions;

import io.cucumber.java.en.*;

public class CreationCompteStepdefs {

    @Given("l'utilisateur navigue sur le site web de création de compte")
    public void lUtilisateurNavigueSurLeSiteWebDeCréationDeCompte() {

    }

    @And("choisit le mode d'accès <modeaccess>")
    public void choisitLeModeDAccèsModeaccess( String modeaccess) {

    }

    @When("l'utilisateur crèe un compte en saisissant les informations valides")
    public void lUtilisateurCrèeUnCompteEnSaisissantLesInformationsValides() {
    }

    @Then("l'accès est validé,le code de validation est envoyée par mail")
    public void lAccèsEstValidéLeCodeDeValidationEstEnvoyéeParMail() {
    }

    @And("donc une proposition de configuration du profil est proposé")
    public void doncUnePropositionDeConfigurationDuProfilEstProposé() {
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

}
