#anguage: en
  #Autor: aroncanicoc@uqvirtual.edu.co

Feature: Demoblaze

  @Register
  Scenario: Successful registration
    Given I am a user without credentials
    When Enter the information needed to create a user
    Then Registration successful


  @Cart
  Scenario: Shopping cart registration
    Given I am a DemoBlaze's user
    When I add two products to the cart
    And the order is placed
    Then purchase successful confirmed