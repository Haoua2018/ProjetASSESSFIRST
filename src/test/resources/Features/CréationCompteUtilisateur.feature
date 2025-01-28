Feature: Création d'un compte utilisateur (personnel/ entreprise)
  sur le site web ASSESSFIRST. Cette feature teste la création de compte sur le
  site web https://welcome.assessfirst.com/register

  Background: Création de compte utilisateur
    Given l'utilisateur navigue sur le site web de création de compte
    And   choisit le mode d'accès <modeaccess>

  Scenario Outline: Création de compte _ Cas passant

    When l'utilisateur crèe un compte en saisissant les informations valides
      | login   | motpasse    | ModeAccess   | Confirmpwd   |
      | <Email> | <Motdepasse | <modeaccess> | <Confirmpwd> |
    Then l'accès est validé,le code de validation est envoyée par mail
    And  donc une proposition de configuration du profil est proposé
    Examples:
      | Email                   | Motdepasse     | modeaccess | Confirmpwd     |
      | MathisPoi@yahoo.fr      | Ploufmoine36.  | Personnel  | Ploufmoine36.  |
      | Gadliss@gmail.com       | Malopride25.   | Personnel  | Malopride25.   |
      | Nounoukiss@github.com   | Poiuytrea256.  | Entreprise | Poiuytrea256.  |
      | Koufraboi@zenity.fr     | Jeunemounir7*  | Entreprise | Jeunemounir7*  |
      | projetpostman@yahoo.com | Poujakirsh895$ | Personnel  | Poujakirsh895$ |

  Scenario Outline: Création de compte _ Cas non passant
    When l'utilisateur crèe un compte en saisissant les informations invalides
      | login   | password     | ModeAccess   | Confirmpwd   |
      | <Email> | <Motdepasse> | <modeaccess> | <Confirmpwd> |
    Then l'accès est invalidé, le message d'erreur s'affiche <Errormessage>
    And le compte n'est pas crée
    Examples:
      | Email                | Motdepasse  | Confirmpwd   | Errormessage                                                  | modeaccess |
      | MathisPoi@.fr        | Ploufmoine. | Ploufmoine.  | L'adresse mail doit avoir le format suivant : nom@exemple.com | Personnel  |
      | Gadlissgmail.com     | Malopride25 | Malopride24  | Mot de passe: Entre 12 et 32 caractères                       | Personnel  |
      | MinusPoli@github.com | pluieorange | pluieorange. | Votre mot de passe doit inclure un caractère majuscule        | Entreprise |




