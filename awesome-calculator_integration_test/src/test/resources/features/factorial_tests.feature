Feature: verify factorial from the api response
  To check the correctness of Factorial algorithm
  developer wants to test all possible combinations

  Background:
    Given Set the end url as 'http://localhost:8080'

  Scenario Outline: verify Positive integers
    When API 'factorial' receives get request with number '<Number>'
    Then API should return 'success' status code
    And should return the value '<Expected factorial>'
    Examples:
      | Number | Expected factorial |
      | 0      | 1                  |
      | 1      | 1                  |
      | 3      | 6                  |
      | 10     | 3628800            |
      # to verify integer overflow
      | 14     | 87178291200        |
      #to identify the long overflow
      | 20     | 121645100408832000 |

  Scenario: verify Negative integers
    When API 'factorial' receives get request with number '-1'
    #this is wrong for a negative scenario
    Then API should return 'success' status code
    And should return message as 'Internal Server Error'

  Scenario Outline: verify numbers with special characters
    When API 'factorial' receives get request with number '<Number>'
    Then API should return 'failed' status code
    And should return message as '<Expected Message>'
    Examples:
      | Number | Expected Message |
      | 2!     | Bad Request      |
