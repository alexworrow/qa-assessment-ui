@CalcTests
Feature: ClearScore Savings Calculator

  Scenario: Using the ClearScore savings calculator
    Given I am on the ClearScore savings calculator page
    When I set my current score to 50
    And I set my score goal to 680
    Then my current average interest rate will be 36.5%
    And my current annual cost will be £849
    And my current Credit cards available will be 22
    And my goal average interest rate will be 20%
    And my goal annual cost will be £465
    And my goal Credit cards available will be 241
    And my potential savings will be £384