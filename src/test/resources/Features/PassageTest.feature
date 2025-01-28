Feature: Passage du test - remplissage de questionnaire

  Scenario Outline: Passage du test afin de déterminer le profil candidat_ Cas passant
    Given l'utilisateur navigue sur le portail des questionnaires
    When l'utilisateur choisit son questionnaire <Question>
    Then Il passe le questionnaire
    And le questionnaire est validé

    Examples:
      | Question | Durée  |
      | SWIPE    | 30 mn  |
      | DRIVE    | 90 mn  |
      | BRAIN    | 10 mn  |

  Scenario Outline: Passage du  questionnaire SWIPE_ Cas passant
    Given l'utilisateur navigue sur le portail du questionnaire SWIPE
    When l'utilisateur répond aux différents questions
    Then Il valide le questionnaire
    Examples:
      | | |


  Scenario Outline: Passage du  questionnaire BRAIN_ Cas passant
    Given l'utilisateur navigue sur le portail du questionnaire BRAIN
    When l'utilisateur répond aux différents questions
    Then Il valide le questionnaire
    Examples:
      | | |