@Login
Feature: Login Functionality
  As a End user
  I want to login to the website
  so that I can check my account

  Background:
    Given I am on Homepage
    When  I click On login button
@ValidateLogin
  Scenario: Validate Login page
    Then I should see "Welcome, Please Sign In!" text on login page
    And  the URL should contain with "/login"

  Scenario: Login with valid details
    And I enter Valid Email "hardik@gmail.com" and Password "Hardik123"
    And  I click On login button on Login Page
    Then I Should see Logout button is displayed

  @Multiple
  Scenario Outline: Login with different valid details
    And I enter Valid Email "<myEmail>" and Password "<myPassword>"
    And  I click On login button on Login Page
    And I Should see Logout button is displayed
    Then I click on Logout button

    Examples:
      | myEmail           | myPassword |
      | hardik@gmail.com  | hardik123  |
      | deep@gmail.com    | deep123    |
      | pritesh@gmail.com | pritesh123 |