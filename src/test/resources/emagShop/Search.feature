Feature: search

  Background:
    Given the user is on in "https://www.emag.bg/homepage"

  Scenario: search for item
    When user enters search criteria "Harry Potter funko"
    Then the user can see the results

    Scenario: search in category second time
      When user enters search criteria "Harry Potter funko"
      And click on "Фигурки"
      And find and open "Фигурка Funko POP! Harry Potter: Wizarding World - Albus Dumbledore with Baby Harry #115"
      Then add the funko figure "Фигурка Funko POP! Harry Potter: Wizarding World - Albus Dumbledore with Baby Harry #115" to favorite