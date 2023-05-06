@fullExecution
Feature: Sing up in the platform

  Description:
  I how to automate tests
  I need to automate the user creation flow
  To validate successful functionality

  @testCase-01
  Scenario: Create new user successfully
    Given Load user information
      | username    | password |
      | juanadearco | 12345678 |
    When I Call service to create new user
    Then I Should see the code 200
    And I Should see that response is empty


  @testCase-02
  Scenario: Create existing user
    Given Load user information
      | username     | password |
      | juanadearco1 | 12345678 |
    When I Call service to create new user
    Then I Should see the code 200
    And Validate schema request "singUpErrorCreateUserSchema"
    And I Should see that message error is "This user already exist."