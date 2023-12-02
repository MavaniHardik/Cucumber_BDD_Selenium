@Reg
  Feature: Registration
    Registration Functonality
    As a End user
    I want to Registrer to the website
    so that I can Login and view my account

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

#    Scenario Outline: Login with different valid details
#      Given I am on Homepage
#      When  I click On login button
#      And I enter Valid Email "<myEmail>" and Password "<myPassword>"
#      And  I click On login button on Login Page
#      Then I Should see Logout button is displayed
@Datatable
    Scenario Outline: Registration using data table
      Given I am on the home page
      When I click on the "Register"
      And I select gender "Male"
      And I enter following details to register
        | firstName | lastName | email     | password     | confirmPassword     |
        |<firstName> |<lastname>   | <myEmail> | <myPassword> | <myConfirmPassword> |
      When I click on the "RegisterSubmit" on registration page
      Then I should see "Your registration completed" text on registration page
     And the url should contain with "/registerresult"
  And I click on Logout button

      Examples:
       |firstName| lastname| myEmail        | myPassword   | myConfirmPassword |
        |hardik|   m   | hardik@gmail.com | hardik123 | hardik123  |
        |Deep  |1| deep@gmail.com | deep123 | deep123  |
      |Pritesh| p| pritesh@gmail.com| pritesh123|pritesh123|

