@Show
Feature: search

  Background:
    Given the user is on in "https://www.emag.bg/homepage"

  Scenario: search for item
    When user enters search criteria "Фигура Funko - Harry Potter - Dumbledore with Wand POP! Movies"
    Then the user can see the results "Фигура Funko - Harry Potter - Dumbledore with Wand POP! Movies"

    Scenario: search in category second time
      When user enters search criteria "Harry Potter funko"
      And click on "Фигурки"
      And find and open "Фигурка Funko POP! Harry Potter: Wizarding World - Albus Dumbledore with Baby Harry #115"
      Then add the funko figure "Фигурка Funko POP! Harry Potter: Wizarding World - Albus Dumbledore with Baby Harry #115" to favorite


      Scenario:
        When user enters search criteria "cougar"
        And click on "Компютърни кутии"
        And choose one item and opens its view page
        And add the item to the favorites list
        And opens the favorites list
        Then the users adds the item to the basket