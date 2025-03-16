Feature: Login

  @login @Regression
  Scenario Outline: 01_Verifying Login With Valid Credentials
    Given I am on the login page
    When I enter username  <username> and password <password>
    And I click on the login button
    Then I am logged in and on the dashboard page

    Examples:
      | username                         | password |
      | regulatoryreporting@focusync.com | $Admin#1 |