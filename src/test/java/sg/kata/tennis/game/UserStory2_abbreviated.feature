Feature: Manage a tennis GAME within a set of a tennis match (abbreviated senario)

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
    Given The score is DEUCE
    When the first player won a point
    Then The first player take the ADVANTAGE

  Scenario: If the player who has the ADVANTAGE win the point, he win the game
    Given The score is DEUCE
    When the first player won a point
    And the first player won a point
    Then The first player won the match

  Scenario: If the player who has the ADVANTAGE loose the point, the score is DEUCE
    Given The score is DEUCE
    When the first player won a point
    When The first player lose a point
    Then DEUCE rule is activated
