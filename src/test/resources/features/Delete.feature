Feature: User deletion
  API should be able to delete user whenever right credentials are passed by

  Scenario: An already registered user should be deleted

    Given I have hero with following information already registered:
      |username|pw   |dateOfBirth |email              |isAdmin|name         |superpower                                        |
      |Eddard  |Stark|1984-04-11  |winter@iscoming.com|true   |Eddard Stark |The man who passes the sentence, swings the sword |
    When I try to delete hero Eddard / Stark
    Then I should receive a 200 status code
    Then I should see the hero information in the JSON response
      |dateOfBirth |email              |isAdmin|name         |superpower                                        |
      |1984-04-11  |winter@iscoming.com|true   |Eddard Stark |The man who passes the sentence, swings the sword |


  Scenario: Trying to delete a not registered user should return unauthorized
    Given I do not have Eddard / Stark already registered in the system
    When I try to delete hero Eddard / Stark
    Then I should receive a 401 status code
    Then I should see the error information in the JSON response
      |errorCode|errorMessage                                      |
      |401      |Invalid credentials: Invalid username or password.|

  Scenario: Trying to delete without authentication should return unauthorized (?)
    When I try to call delete endpoint without authentication
    Then I should receive a 401 status code
    Then I should see the error information in the JSON response
      |errorCode|errorMessage                                      |
      |401      |Invalid credentials: Invalid username or password.|
