Feature: Addition functionality
  As a user,
  I want to be able to perform addition operation,
  So that I can add numbers accurately

  Scenario Outline: Perform addition operation with positive numbers
    Given I have opened the calculator web application
    When I enter <number1> and <number2> to add
    Then I should see the <result> displayed

    Examples: 
      | number1 | number2 | result |
      |       1 |       3 |      4 |
      |       5 |       4 |      9 |
      |      14 |      23 |     37 |
