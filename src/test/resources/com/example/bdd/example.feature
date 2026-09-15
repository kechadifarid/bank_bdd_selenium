Feature: e2e
  Background: 
    Given je suis sur le site "https://parabank.parasoft.com/parabank/index.htm"
  Scenario: inscription
    Given je clique sur le button register 
    When je suis sur le lien d inscription 
    And je rempli le formulaire 
    Then je verifie que le username s affiche bien 
    And je me deconnecte 
    Given je rempli les information de connexion
    When je clique sur le button de connexion
    Then je verifie si je suis bien sur le bon url 
