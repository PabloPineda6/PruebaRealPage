
Feature: Google Homepage Search

  Scenario: User can search with "Google Search" but doesn't find desired page
    Given I'm on the homepage
    When I type The name of the wind into the search field
    And I click the Google Search button
    Then I go to the search result page
    And the first result is The Name of the Wind - Patrick Rothfuss
    When I click on the first result link
    Then I go to the The Books - Patrick Rothfuss page

  Scenario: User can search with "Google Search"
    Given I'm on the homepage
    When I type The Books - Patrick Rothfuss into the search field
    And I click the Google Search button
    Then I go to the search result page
    And the first result is The Books - Patrick Rothfuss
    When I click on the first result link
    Then I go to the The Books - Patrick Rothfuss page

  Scenario: User can search by using the suggestions
    Given I'm on the homepage
    When I type The Books - Patrick Roth into the search field
    And the suggestions list is displayed
    And I click on the first suggestion in the list
    Then I go to the search result page
    And the first result is The Books - Patrick Rothfuss
    When I click on the first result link
    Then I go to the Patrick Rothfuss - The Books page

  Scenario: User can go directly to the first result of the search
    Given I'm on the homepage
    When I type The Books - Patrick Rothfuss into the search field
    And I click on the I'm Feeling Lucky button
    Then I go to the The Books - Patrick Rothfuss page

  Scenario: User can correct input and re-search
    Given I'm on the homepage
    When I type The Books into the search field
    And I click the Google Search button
    Then I go to the search result page
    When I add  - Patrick Rothfuss to the search field content
    And the suggestions list is displayed
    And I click on the first suggestion in the list
    Then I go to the search result page
    And the first result is The Books - Patrick Rothfuss
    When I click on the first result link
    Then I go to the Patrick Rothfuss - The Books page

  Scenario: User can pick from related searches
    Given I'm on the homepage
    When I type The Books - Patrick Rothfuss into the search field
    And I click the Google Search button
    Then I go to the search result page
    When I click on the the first related search at the bottom of the page
    Then I go to the search results page of that related option

  Scenario: User tries to search an incomprehensible text
    Given I'm on the homepage
    When I type /%$#/ into the search field
    And I click the Google Search button
    Then The search doesn't return any result

  Scenario: User tries to search without an input
    Given I'm on the homepage
    When I click the Google Search button
    And I click the Google Search button
    And I click the Google Search button
    Then I am on the homepage

  Scenario: User searches using Google's search operators
    Given I'm on the homepage
    When I type -The -Books Patrick AND Rothfuss into the search field
    And I click the Google Search button
    Then In the search result page no result will say The Books
    And all results will say Patrick Rothfuss
