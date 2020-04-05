
Feature: Google Homepage Search

  Scenario: User can pick results page by next and number
    Given I'm on the homepage
    When I type The Books - Patrick Rothfuss into the search field
    And I click the Google Search button
    Then I go to the search result page
    When I click on the option Next at the bottom of the page
    Then I go to the search results second page
    When I click on the option Previous at the bottom of the page
    Then I go to the search result page
    When I click on the number 4 at the bottom of the page
    Then I go to the search results forth page
