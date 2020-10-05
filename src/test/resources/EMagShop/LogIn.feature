Feature: Log in to account

  #this test requires manual ascendancy because at certain point there is CAPCHA verification required, run in debug

  Scenario Outline: login with existing account
    Given the user is on in "https://www.emag.bg/homepage"
    And clicks on user icon located on the navigational bar
    When the user is redirected to the login page of EMag
    And enter his "<Email>"
    And clicks on continue button
    And enters the necessary "<password>"
    And clicks on continue button
    Then the user is logged in EMag webShop
    Examples:
      | Email                     | password    |
      | dimitar.kirov@estafet.com | Password123 |