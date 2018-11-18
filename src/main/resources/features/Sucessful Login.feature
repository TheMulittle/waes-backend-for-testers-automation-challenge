Feature: Login
  Everybody wants to know when it's Friday

  Scenario: Failed Login
    Given I login with user and password

  Scenario Outline: Successful Login
    Given today is "<day>"
    When I ask whether it's Friday yet
    Then I should be told "<answer>"
    Examples:
      | day | answer |
      | Friday | TGIF |
      | Sunday | Nope |
      | anything else! | Nope |