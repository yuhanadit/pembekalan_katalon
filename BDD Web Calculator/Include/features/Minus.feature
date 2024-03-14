Feature: Substract functionality
  As a user,
  I want to be able to perform substract operation,
  So that I can substract numbers accurately

  Scenario Outline: Perform substract operation with positive numbers
    Given I have opened the calculator web application
    When I enter <number1> and <number2> to substract
    Then I should see the <result> displayed

    Examples: 
      | number1 | number2 | result |
      |       3 |       1 |      2 |
      |       5 |       4 |      1 |
      |      14 |      23 |     -9 |
