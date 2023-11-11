@Login
Feature: Login Functionality
  As a End user
  I want to login to the website
  so that I can check my account

  Scenario: Validate Login page
    Given I am on Homepage
    When  I click On login button
    Then I should see "Welcome, Please Sign In!" text on login page
    And  the URL should contain with "/login"

    Scenario: Login with valid details
      Given I am on Homepage
      When  I click On login button
      And I enter Valid Email "hardik@gmail.com" and Password "Hardik123"
      And  I click On login button on Login Page
      Then I Should see Logout button is displayed

  Scenario Outline: Login with different valid details
    Given I am on Homepage
    When  I click On login button
    And I enter Valid Email "<myEmail>" and Password "<myPassword>"
    And  I click On login button on Login Page
    Then I Should see Logout button is displayed

Examples:
    |myEmail|myPassword|
    |       |          |
|       |          |
    |       |          |