@Reg
Feature: Registration
  Registration Functonality
  As a End user
  I want to Registrer to the website
  so that I can Login and view my account

  @SingleRegisration
  Scenario: Valid Registration without datatable
    Given I am on the home page
    When I click on the "Register"
    And I select gender "Male"
    And I enter my firstname "Hardik" and lastname "Mavani"
    And I enter my emailid "hardik@gmail.com"
    And I enter my password "Hardik@123"
    And I enter confirm Password "Hardik@123"
    When I click on the "RegisterSubmit" on registration page
    Then I should see "Your registration completed" text on registration page
    And the url should contain with "/registerresult"

  @Registerwithdatatable
  Scenario: Valid Registration using datatable
    Given I am on the home page
    When I click on the "Register"
    And I select gender "Male"
    And I enter following data for registration
      | firstname | lastname | email            | password   | confirmpassword |
      | Hardik    | Mavani   | Hardik@gmail.com | Hardik@123 | Hardik@123      |
    When I click on the "RegisterSubmit" on registration page
    Then I should see "Your registration completed" text on registration page
    And the url should contain with "/registerresult"

  @MultipleRegistrationwithDatatable
  Scenario Outline: Valid Multiple Registration using datatable with scenario outline
    Given I am on the home page
    When I click on the "Register"
    And I select gender "Male"
    And I enter following data for registration
      | firstname     | lastname     | email     | password     | confirmpassword     |
      | <myfirstname> | <mylastname> | <myemail> | <mypassword> | <myconfirmpassword> |
    When I click on the "RegisterSubmit" on registration page
    Then I should see "Your registration completed" text on registration page
    And the url should contain with "/registerresult"

    Examples:
      | myfirstname | mylastname | myemail           | mypassword | myconfirmpassword |
      | hardik      | m          | hardik@gmail.com  | hardik123  | hardik123         |
      | Deep        | 1          | deep@gmail.com    | deep123    | deep123           |
      | Pritesh     | p          | pritesh@gmail.com | pritesh123 | pritesh123        |


