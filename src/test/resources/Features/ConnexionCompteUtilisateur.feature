Feature: Connexion au compte utilisateur à travers les informations de création de profil


  Scenario Outline: Connexion au compte utilisateur_Cas passant
    Given l'utilisateur navigue sur la page connexion
    When l'utilisateur se connecte en saisissant les informations valides
      | login   | motpasse    | ModeAccess   |
      | <Email> | <Motdepasse | <modeaccess> |
    Then il accède à la page d'acceuil du site
    And son profil est disponible
    Examples:
      | Email                   | Motdepasse     | modeaccess |
      | MathisPoi@yahoo.fr      | Ploufmoine36.  | Personnel  |
      | Nounoukiss@github.com   | Poiuytrea256.  | Entreprise |
      | Koufraboi@zenity.fr     | Jeunemounir7*  | Entreprise |
      | projetpostman@yahoo.com | Poujakirsh895$ | Personnel  |

  Scenario Outline: Connexion au compte utilisateur_Cas non passant
    Given l'utilisateur navigue sur la page connexion
    When l'utilisateur se connecte avec des informations invalides
      | login   | motpasse    | ModeAccess   |
      | <Email> | <Motdepasse | <modeaccess> |
    Then un message d'erreur s'affiche indiquant l'erreur produit
    Examples:
      | Email                | Motdepasse    | modeaccess |
      | MathisPoi@.fr        | Ploufmoine36. | Personnel  |
      | Gadlissgmail.com     | Malopride25.  | Entreprise |
      | MinusPoli@github.com | pluieorange   | Entreprise |