Feature: manage a Tennis SET within a tennis match

  Scenario: If a player reach the Set score of 6 and the other player has a Set score of 4 or lower, the player win the Set
    Given The set started
    When The first player won a game
    And The first player won a game
    And The first player won a game
    And The first player won a game
    And The first player won a game
    And The second player won a game
    And The first player won a game
    Then The first player win the Set

  Scenario: If a player win a Game and reach the Set score of 6 and the other player has a Set score of 5, a new Game must be played and the first player who reach the score of 7 wins the match
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
    And The first player won a game
    And The first player won a game
    And The first player won a game
    And The first player won a game
    And The first player won a game
    And The first player won a game
    Then The first player win the Set
