@fullExecution
Feature: Sing in in the platform

  Description:
  I how to automate tests
  I need to automate the login flow
  To validate successful functionality

  @testCase-03
  Scenario: Login user successfully
    Given Load user information
      | username   | password   |
      | horacioss1 | 1234567890 |
    When I Call service to login user
    Then I Should see the code 200
    And I should get the token authentication


  @testCase-04
  Scenario: Login user failed
    Given Load user information
      | username   | password   |
      | horacioss2 | 1234567890 |
    When I Call service to login user
    Then I Should see the code 200
    And Validate schema request "singInErrorAuthenticateSchema"
    And I Should see that message error is "Wrong password."