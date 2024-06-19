Feature: Login

  Scenario Outline: Login with incorrect information
    Given I am on the login page on browser "<browser>"
    When I enter my username "<username>" and password "<password>"
    And I press the login button
    Then I should see an errormessage "<message>"

    Examples:
      | browser | username        |  | password     | message                                                                   |
      | chrome  |                 |  |              | Epic sadface: Username is required                                        |
      | chrome  | standard_user   |  |              | Epic sadface: Password is required                                        |
      | chrome  | standard_user1  |  | secret_sauce | Epic sadface: Username and password do not match any user in this service |
      | chrome  | locked_out_user |  | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |
      | firefox |                 |  |              | Epic sadface: Username is required                                        |
      | firefox | standard_user   |  |              | Epic sadface: Password is required                                        |
      | firefox | standard_user1  |  | secret_sauce | Epic sadface: Username and password do not match any user in this service |
      | firefox | locked_out_user |  | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |