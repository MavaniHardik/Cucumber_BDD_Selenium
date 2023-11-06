
Feature: Search Functionality
  As a end user
  I want to search for a Product
  so that I can view thev search result

  Scenario:Search for a Product
    Given I am on home page
    When  I search for a product "Nike"
    Then I should be able to see the result
