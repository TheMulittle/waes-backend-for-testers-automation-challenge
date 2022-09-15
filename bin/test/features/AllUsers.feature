Feature: All Users
  API should be able to retrieve all users from the system with basic autho

  Scenario: An admin should be able to retrieve all users information
    Given I have admin already registered in the system
    When I retrieve all heroes information with admin / hero
    Then I should receive a 200 status code
    Then I should see that hero admin is in the JSON response
      |dateOfBirth|email                  |isAdmin|name            |superpower                        |
      |1984-04-16 |a.admin@wearewaes.com  |true   |Amazing Admin   |Change the course of a waterfall. |
    Then I should see that hero dev is in the JSON response
      |dateOfBirth|email                  |isAdmin|name            |superpower                        |
      |1999-10-10 |zd.dev@wearewaes.com   |false  |Zuper Dooper Dev|Debug a repellent factory storage.|

  Scenario: An non admin should not be able to retrieve all users information
    Given I have dev already registered in the system
    When I retrieve all heroes information with dev / wizard
    Then I should receive a 401 status code
    Then I should see the error information in the JSON response
      |errorCode |errorMessage                                                    |
      |401       |Invalid credentials: You do not have access to this information.|

