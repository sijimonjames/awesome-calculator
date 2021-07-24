Feature: Factorial page tests
  user wants to find the factorial in chrome browser

  @smoke @regression
  Scenario Outline: Verify the factorial of numbers
    Given usser is in factorial home page
    When user gives number '<Number>' as input
    And clicks the calculate button
    Then user should see the factorial '<Expected factorial>' of number

    Examples:
      | Number | Expected factorial |
      | 0      | 1                  |
      | 1      | 1                  |
      | 10     | 3628800            |
      | 15     | 1307674368000      |

  @regression
  Scenario: Verify the Error message for special characters
    Given usser is in factorial home page
    When user gives number '2!' as input
    And clicks the calculate button
    Then user should see the message 'input should be an integer'

