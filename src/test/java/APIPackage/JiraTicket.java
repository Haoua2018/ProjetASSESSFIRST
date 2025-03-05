package APIPackage;//;
//import io.restassured.RestAssured;
import io.restassured.RestAssured;

//import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

public class JiraTicket {
//            @Test
//        public void testCreateIssue() {
//            RestAssured.given()
//                    .auth().preemptive().basic("sangarehawamadiougou@gmail.com", "M@ison2026!")
//                    .contentType("application/json")
//                    .body("{ \"fields\": {\"project\": {\"key\": \"Mon projet Scrum\"}, \"summary\": \"listed by Rest Assured\", \"description\": \"Testing REST API\", \"issuetype\": {\"name\": \"Bug\"} }}")
//                    .when().post("https://your-jira-instance.atlassian.net/rest/api/2/issue")
//                    .then().statusCode(201);
//        }

  // @Test
        public static String getTestTickets() {
            // Définir l'URL de base de Jira
            String baseUrl = "https://sangarehawamadiougou.atlassian.net/";

            // Authentification de base (remplacez par vos identifiants Jira)
            String username = "sangarehawamadiougou@gmail.com";
            String token = "ATATT3xFfGF0L4V_1NnlH8FZUvQ8TC8M4XiAsZWo3EtFbiKEnRbWM6gbQ8jFkYxdBKKmraxifTOD3m4ODLRkdHmIgGCrQd2a4J2AJ5XiwvS_6Qkg9KYfUlnTD-ppsf4og6s_eN-txb0LKI6QYZV44NbH7qRqLK214oPo5hdWBI0l954uZJz9rlE=D7C4BAF3"; // Utiliser un token API au lieu du mot de passe pour une meilleure sécurité

            // Définir le projet et le type d'issue à rechercher
            String projectKey = "Mon projet Scrum"; // Remplacer par la clé de votre projet (en majuscule)
            String issueType = "Test"; // Type d'issue que vous recherchez

            // Construire l'URL de l'API Jira pour récupérer les issues
            String apiUrl = "/rest/api/2/search?jql=project=\"" + projectKey + "\" AND issuetype=\"" + issueType + "\"";

            // Effectuer la requête GET pour récupérer les tickets
            Response response = RestAssured.given()
                    .auth().preemptive().basic(username, token) // Authentification basique
                    .accept("application/json") // Définir le format de la réponse comme JSON
                    .baseUri(baseUrl) // URL de base de Jira
                    .when()
                    .get(apiUrl) // Envoyer la requête GET
                    .then()
                    .statusCode(200) // Vérifier que la réponse est un succès (200 OK)
                    .extract().response(); // Extraire la réponse

            // Afficher la réponse JSON complète
            System.out.println("Response JSON: " + response.asString());

            // Vérifier que nous avons bien des tickets de type Test
            String tickets = response.jsonPath().getString("issues");
            Assert.assertNotNull(tickets, "Aucun ticket de type 'Test' trouvé pour le projet " + projectKey);

            // Vous pouvez aussi analyser le contenu des tickets et vérifier des données spécifiques.
       return tickets;
        }

    public static void main(String[] args) {
        //String ticketId = "TEST-1234";
        String ticketSummary = getTestTickets();
        System.out.println("Ticket Summary: " + ticketSummary);
    }
    }



