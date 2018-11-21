Feature: Details
  API should be able to retrieve user information

  Scenario: An already existing hero should be returned when endpoint is called
    Given I have admin already registered in the system
    When I retrieve admin hero details
    Then I should receive a 200 status code
    Then I should see the hero information in the JSON response
      |dateOfBirth |email                  |isAdmin|name            |superpower                        |
      |1984-04-16  |a.admin@wearewaes.com  |true   |Amazing Admin   |Change the course of a waterfall. |

  Scenario: A non existing hero should return "not found" response
    Given I do not have Douglas / Adams already registered in the system
    When I retrieve Douglas hero details
    Then I should receive a 404 status code
    Then I should see the error information in the JSON response
      |errorCode |errorMessage                    |
      |404       |Username Douglas does not exist.|

  Scenario: A just registered hero should be able to be retrieve
    Given I do not have Ford / Prefect already registered in the system
    When I sign-up hero with following information:
      |username|pw      |dateOfBirth |email               |isAdmin |name        |superpower    |
      |Ford    |Prefect |1999-10-10  |ford@betelgeuse5.com|true    |Ford Prefect|To have a towel|
    When I retrieve Ford hero details
    Then I should receive a 200 status code
    Then I should see the hero information in the JSON response
      |dateOfBirth |email               |isAdmin |name        |superpower    |
      |1999-10-10  |ford@betelgeuse5.com|true    |Ford Prefect|To have a towel|