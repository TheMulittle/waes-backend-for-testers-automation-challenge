Feature: Signup
  API should be able to register user

  Scenario: A new signed up hero should return the hero information
    Given I do not have brave / world already registered in the system
    When I sign-up hero with following information:
      |username  |pw   |dateOfBirth|email          |isAdmin|name  |superpower|
      |brave     |world|1984-07-26 |brave@world.com|false  |A Name|Be a book |
    Then I should receive a 200 status code
    Then I should see the user information in the JSON response
      |dateOfBirth|email          |isAdmin|name  |superpower|
      |1984-07-26 |brave@world.com|false  |A Name|Be a book |

  Scenario Outline: Hero should not be able to sign-up with missing data
    Given I do not have <username> / pass already registered in the system
    When I sign-up hero with following information:
      |username  |pw  |dateOfBirth  |email  |isAdmin  |name  |superpower  |
      |<username>|<pw>|<dateOfBirth>|<email>|<isAdmin>|<name>|<superpower>|
    Then I should receive a 400 status code
    Then I should see the error information in the JSON response
      |errorCode  |errorMessage                                      |
      |400        |                                                  |

  Examples:
  |username|pw  |dateOfBirth |email                    |isAdmin|name         |superpower          |
  |        |pass|1984-07-26  |aldous0@bravenewworld.com|true   |Amazing Admin|Write awesome books |
  |aldous1 |    |1984-07-26  |aldous1@bravenewworld.com|true   |Amazing Admin|Write awesome books |
  |aldous2 |pass|            |aldous2@bravenewworld.com|true   |Amazing Admin|Write awesome books |
  |aldous3 |pass|1984-07-26  |                         |true   |Amazing Admin|Write awesome books |
  |aldous4 |pass|1984-07-26  |aldous3@bravenewworld.com|       |Amazing Admin|Write awesome books |
  |aldous5 |pass|1984-07-26  |aldous4@bravenewworld.com|true   |             |Write awesome books |
  |aldous6 |pass|1984-07-26  |aldous5@bravenewworld.com|true   |Amazing Admin|                    |


  Scenario Outline: Hero should not be able to sign-up with already registered username or email

    Given I have <user> already registered in the system
    When I sign-up hero with following information:
      |username|pw      |dateOfBirth  |email  |isAdmin  |name  |superpower  |
      |<user>  |<pw>    |<dateOfBirth>|<email>|<isAdmin>|<name>|<superpower>|
    Then I should receive a 409 status code
    Then I should see the error information in the JSON response
      |errorCode  |errorMessage                                      |
      |409        |                                                  |

    Examples:
      |user |pw  |dateOfBirth |email                    |isAdmin|name         |superpower          |
      |admin|pass|1984-07-26  |aldous0@bravenewworld.com|true   |Amazing Admin|Write awesome books |
      |xx   |pass|1984-07-26  |a.admin@wearewaes.com    |true   |Amazing Admin|Write awesome books |