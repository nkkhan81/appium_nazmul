@regression @hotels
Feature: Verify hotels app features

  Background:
    Given I am on hotels home page

  @hotel-login
  Scenario: Verify invalid login on android hotel app
#    When I scroll down on page
    And I tap on sign in button
    And I fill out invalid username and password
    And I tap on Sign in button on LoginPage
    Then I verify invalid error message

#    @hotel-signup
#    Scenario: Verify successful creation of creating account
#      When I scroll down
#      And I tap on Create Account button
#      And I fill out all required fields
#      And I submit the form
#      Then I verify successful creation of a home page