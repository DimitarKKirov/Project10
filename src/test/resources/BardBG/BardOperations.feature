@Show
Feature: Bard

  Background:
    Given the user is on "https://www.bard.bg"

  Scenario: search for a product
    When the user enters search for "Убийства в рая" in the search field
    And clicks on the search button
    And the user is presented with the search result
    Then the user adds the item in favorites


  Scenario: add book to the basket
    And the user enters search for "Убийства в рая" in the search field
    And clicks on the search button
    When the user clicks on order
    Then the book is added to My Orders


  Scenario:
    And the user enters search for "Убийства в рая" in the search field
    And clicks on the search button
    And the user clicks on order
    And opens Shopping cart
    When the user rise the quantity of the item to be bought with "2"
    And the user clicks the recalculating button
    Then the price of the item is update

  Scenario Outline: discount level check
    And the user enters search for "Убийства в рая" in the search field
    And clicks on the search button
    And the user clicks on order
    And opens Shopping cart
    When the user changes the quantity of items to "<number>"
    And the user meats the requirement for "<first>" level treasure points
    Then the user will receive "<percent>" from the total amount to his treasure wallet
    Examples:
      | first             | percent | number |
      | 2-ро ниво поръчка | 5%      | 2      |
      | 3-то ниво поръчка | 7%      | 4      |
      | 4-то ниво поръчка | 10%     | 10     |