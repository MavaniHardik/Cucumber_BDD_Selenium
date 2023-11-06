@BK
Feature: Login Functionality
  As a End user
  I want to login to the website
  so that I can check my account

  Scenario: Validate Login page
    Given I am on Homepage
    When  I click On loing button
    Then I should see"Welcome, Please Sign In!" text on login page
    And  the URL should contain wiht "/login"
