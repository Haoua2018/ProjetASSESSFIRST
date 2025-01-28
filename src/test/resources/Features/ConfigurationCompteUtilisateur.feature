Feature: Cette feature traite la configuration du compte avant et
  après activation du compte crée. C'est la partie où l’utilisateur renseigne les informations du profil.


  Scenario Outline: Activation du compte utilisateur_ Cas passant
    Given l'utilisateur se trouve sur la page d'activation du compte personnel
    And il récupère le code d'activation sur le compte email de la création de compte <Email>
    When l'utilisateur saisit le code <code> et valide
    Then le compte est crée avec ce message de bienvenu <prenom>

    Examples:
      | prenom  | code  | Email                   |
      | Mathias | 56984 | projetpostman@yahoo.com |

  Scenario Outline: Activation du compte type Entreprise_ Cas passant
    Given l'utilisateur navigue sur la page d'activation du compte Entreprise
    And il récupère le code d'activation sur le compte email de la création de compte <Email>
    When l'utilisateur saisit le code <code> et valide
    Then le passage vers la page configuration du profil est effectuée
    Examples:
      | code  | Email                 ` |
      | 78596 | l'email d'inscription   |

  Scenario Outline: Activation du compte utilisateur_ Cas non passant
    Given l'utilisateur se trouve sur la page d'activation du compte personnel
    And il récupère le code d'activation sur le compte email de la création de compte <Email>
    When l'utilisateur saisit le code <code> erroné et valide
    Then le compte n'est pas crée avec ce message d'erreur <erreur>

    Examples:
      | erreur | code  | Email                   |
      |        | 56984 | projetpostman@yahoo.com |

  Scenario Outline: Configuration du profil personnel_ Cas passant
    Given l'utilisateur se trouve sur la page de configuration
    When l'utilisateur saisit le <nom> et le <prénom>
    And il saisit le numéro de téléphone <numero_telephone> et coche le cgu
    Then Le profil est validé
    Examples:
      | prénom  | nom       | numero_telephone |
      | Mathias | Policere  |                  |
      | Molière | Malicieux | 0695451230       |


  Scenario: Configuration du compte utilisateur Entreprise - Cas passant
    Given l'utilisateur se trouve sur la page de configuration


  Scenario Outline: Complétude du profil utilisateur personnel - Cas passant
    Given l'utilisateur navigue sur la page
    When il complète son profil
      | niveau_etudes | Métier   | NombreExp   | SecteurActivite   | Compétence       | Localisation   | Photo   |
      | <NivEtude>    | <Metier> | <NombreExp> | <SecteurActivite> | <ProfilLinkedIn> | <Localisation> | <Photo> |
    Then le profil est au complet donc l'utilisateur peut utiliser son site
    Examples:
      | NivEtude | Metier     | NombreExp | SecteurActivite             | ProfilLinkedIn        | Localisation | Photo                                                                                                                                                                                             | Visibilité | Préference | Langue   |
      | Doctorat | Soudeur    | 0         | Administration publique     |                       | Paris        |                                                                                                                                                                                                   | Publique   | Il         | Français |
      | Master   | Technicien | 2         | Applications de jeux vidéos | https://linkedin.com/ | Athis-mons   | https://fr.freepik.com/photos-gratuite/gens-assis-regardent-football-dans-lieu-public-nuit_17643925.htm#fromView=keyword&page=1&position=0&uuid=607793d4-62e0-482b-90fb-0d39b9ad243b&query=Public | Privé      | Elle       | Anglais  |
      | Aucun    | Epicier    | 5         | Commerces de détails        |                       | Gennevillier |                                                                                                                                                                                                   |            | Publique   |          |


  Scenario Outline: Complétude du profil utilisateur Entreprise - Cas passant
    Given l'utilisateur navigue sur la page
    When il complète son profil
    Then le profil est au complet donc l'utilisateur peut utiliser son site
    And Il accède au questionnaire
    Examples:
