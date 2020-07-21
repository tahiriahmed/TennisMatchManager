Feature: Manage a tennis GAME within a set of a tennis match

  Scenario: If the 2 players reach the score 40, the DEUCE rule is activated
    Given Game started
    When the first player won a point
    And the first player won a point
    And the first player won a point
    And the second player won a point
    And the second player won a point
    And the second player won a point
    Then DEUCE rule is activated

  Scenario: If the score is DEUCE , the player who win the point take the ADVANTAGE
    Given Game started
    When the first player won a point
    And the first player won a point
    And the first player won a point
    And the second player won a point
    And the second player won a point
    And the second player won a point
    And the first player won a point
    Then The first player take the ADVANTAGE

  Scenario: If the player who has the ADVANTAGE win the point, he win the game
    Given Game started
    When the first player won a point
    And the first player won a point
    And the first player won a point
    And the second player won a point
    And the second player won a point
    And the second player won a point
    And the first player won a point
    And the first player won a point
    Then The first player won the game

  Scenario: If the score is DEUCE , the player who win the point take the ADVANTAGE
    Given Game started
    When the first player won a point
    And the first player won a point
    And the first player won a point
    And the second player won a point
    And the second player won a point
    And the second player won a point
    And the first player won a point
    And The first player lose a point
    Then DEUCE rule is activated
