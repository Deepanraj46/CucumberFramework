
Feature: OrangeHRM Login Functionality

  Scenario: Successful Login
    Given I am on the OrangeHRM login page
    When I enter valid username "admin" and valid password "Mes@123"
    And I click the Login button
    Then I should be redirected to the OrangeHRM dashboard
  




