package StepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfileConfigStepdefs {
    @Given("l{string}activation du compte personnel")
    public void lUtilisateurSeTrouveSurLaPageDActivationDuComptePersonnel() {
    }

    @And("il récupère le code d'activation sur le compte email de la création de compte <Email>")
    public void ilRécupèreLeCodeDActivationSurLeCompteEmailDeLaCréationDeCompteEmail() {
    }

    @When("l'utilisateur saisit le code <code> et valide")
    public void lUtilisateurSaisitLeCodeCodeEtValide() {
    }

    @Then("le compte est crée avec ce message de bienvenu <prenom>")
    public void leCompteEstCréeAvecCeMessageDeBienvenuPrenom() {
    }

    @Given("l{string}activation du compte Entreprise")
    public void lUtilisateurNavigueSurLaPageDActivationDuCompteEntreprise() {
    }

    @Then("le passage vers la page configuration du profil est effectuée")
    public void lePassageVersLaPageConfigurationDuProfilEstEffectuée() {
    }

    @When("l'utilisateur saisit le code <code> erroné et valide")
    public void lUtilisateurSaisitLeCodeCodeErronéEtValide() {
    }

    @Then("le compte n{string}erreur <erreur>")
    public void leCompteNEstPasCréeAvecCeMessageDErreurErreur() {
    }

    @Given("l'utilisateur se trouve sur la page de configuration")
    public void lUtilisateurSeTrouveSurLaPageDeConfiguration() {
    }

    @When("l'utilisateur saisit le <nom> et le <prénom>")
    public void lUtilisateurSaisitLeNomEtLePrénom() {
    }

    @And("il saisit le numéro de téléphone <numero_telephone> et coche le cgu")
    public void ilSaisitLeNuméroDeTéléphoneNumero_telephoneEtCocheLeCgu() {
    }

    @Then("Le profil est validé")
    public void leProfilEstValidé() {
    }

    @Given("l'utilisateur navigue sur la page")
    public void lUtilisateurNavigueSurLaPage() {
    }

    @When("il complète son profil")
    public void ilComplèteSonProfil() {
    }

    @Then("le profil est au complet donc l'utilisateur peut utiliser son site")
    public void leProfilEstAuCompletDoncLUtilisateurPeutUtiliserSonSite() {
    }

    @And("Il accède au questionnaire")
    public void ilAccèdeAuQuestionnaire() {
    }
}
