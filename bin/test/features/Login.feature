Feature: Login
  API should be able to give data to a authenticated user

  Scenario Outline: An already existing user should be able to login
    Given I have <user> already registered in the system
    When I login with the following credentials: <user> / <password>
    Then I should receive a 200 status code
    Then I should see the hero information in the JSON response
      |dateOfBirth  |email  |isAdmin  |name  |superpower  |
      |<dateOfBirth>|<email>|<isAdmin>|<name>|<superpower>|

  Examples:
  |user |password|dateOfBirth |email                  |isAdmin|name            |superpower                        |
  |admin|hero    |1984-04-16  |a.admin@wearewaes.com  |true   |Amazing Admin   |Change the course of a waterfall. |
  |dev  |wizard  |1999-10-10  |zd.dev@wearewaes.com   |false  |Zuper Dooper Dev|Debug a repellent factory storage.|

  Scenario Outline: User should not be able to login with invalid credentials
    When I login with the following credentials: <user> / <password>
    Then I should receive a 401 status code
    Then I should see the error information in the JSON response
      |errorCode  |errorMessage                                      |
      |401        |Invalid credentials: Invalid username or password |

  Examples:
    |user |password|
    |admin|        |
    |     |wizard  |