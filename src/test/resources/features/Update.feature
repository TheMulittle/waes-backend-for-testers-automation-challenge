Feature: Update
  API should be able to update user

  Scenario: Hero should be able to be updated when valid information is given
    Given I have hero with following information already registered:
      |username|pw   |dateOfBirth |email       |isAdmin|name    |superpower |
      |Goku    |Son  |1910-01-01  |son@goku.com|true   |Son Goku|Kaioken    |
    When I update hero with credentials Goku / Son to:
      |pw    |dateOfBirth |email          |isAdmin|name   |superpower |
      |Gogita|1922-02-02  |goku@vegito.com|false  |Gogeta |Kaioken  x3|
    Then I should receive a 200 status code
    Then I should see the hero information in the JSON response
      |dateOfBirth |email          |isAdmin|name   |superpower |
      |1922-02-02  |goku@vegito.com|false  |Gogeta |Kaioken  x3|

  Scenario: Hero should't be able to be updated with email of already existing hero
    Given I have hero with following information already registered:
      |username|pw    |dateOfBirth |email       |isAdmin|name    |superpower|
      |Trunks  |Future|1910-01-01  |trunks@a.com|true   |Turnks  |Z Sword   |
    And I have admin already registered in the system
    When I update hero with credentials Trunks / Future to:
      |pw    |dateOfBirth |email                |isAdmin|name   |superpower |
      |Gogita|1922-02-02  |a.admin@wearewaes.com|false  |Gogeta |Kaioken  x3|
    Then I should receive a 409 status code
    Then I should see the error information in the JSON response
      |errorCode  |errorMessage                                                |
      |409        |User registration error: The username 'admin' already exists.|
