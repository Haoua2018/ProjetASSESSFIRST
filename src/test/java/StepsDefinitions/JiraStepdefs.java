package StepsDefinitions;

import APIPackage.JiraTicket;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;
import org.testng.Assert;

public class JiraStepdefs {
    public JiraTicket jtiket= new JiraTicket();
   public String ticketSummary;
    @Then("The US list should be available successfully to displayed")
    public void theUSListShouldBeAvailableSuccessfullyToDisplayed() {
         //ticketSummary = JiraTicket.getTestTickets();
        // Ajouter le résumé du ticket au rapport Allure
        Allure.addAttachment("Ticket JIRA: "+"text/plain", ticketSummary);
//Assert.assertTrue( , "Affichage tiket sur Allurre");
        // Vérification du test
        Assert.assertNotNull(ticketSummary,"Aucun tiket jira à retourner");

    }

    @Given("I collect a list of US ticket from Jira")
    public void iCollectAListOfUSTicketFromJira() {
        //getTestTickets();

         ticketSummary = JiraTicket.getTestTickets();
        Assert.assertNotNull(ticketSummary,"Aucun tiket jira à retourner");

    }
}
