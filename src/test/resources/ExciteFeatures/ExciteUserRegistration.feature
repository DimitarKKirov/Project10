@CreateAccount @Excite @Show
Feature: user registration page

  Scenario: user registration
    Given user is on registration page
    When user enters the necessary data in all fields
    And user clicks complete registration
    Then  the user is redirected to the login page