Feature: manage a Tennis SET within a tennis match

  Scenario: If the 2 players reach the score of 6 Games , the Tie-Break rule is activated
    Given The set started
    When The first player won a game
    And The first player won a game
    And The first player won a game
    And The first player won a game
    And The first player won a game
    And The second player won a game
    And The second player won a game
    And The second player won a game
    And The second player won a game
    And The second player won a game
    And The second player won a game
    And The first player won a game
    Then The Tie-Break rule is activated

  Scenario: The Tie-Break ends as soon as a player gets a least 6 points and gets 2 points more than his opponent ,The player who wins the Tie-Break wins the Set and the match
    Given The score is Tie-Break
    When The first player won a game
    And The second player won a game
    And The first player won a game
    And The first player won a game
    Then The first player win the Set
