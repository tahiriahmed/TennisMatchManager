Feature: Manage a tennis GAME within a set of a tennis match

  Scenario: the first player wins the match
    Given Game started
    When the first player won a point
    And the first player won a point
    And the first player won a point
    And the first player won a point
    Then The first player won the match
