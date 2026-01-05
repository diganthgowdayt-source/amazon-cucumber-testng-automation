Feature: Amazon Product Search

  Scenario: Search product and validate product page
    Given user is on Amazon homepage
    When user searches for "laptop"
    And user clicks on first search result
    Then product details page should be displayed
