Feature: The game must be finished and after a game is won, the winning player must be determined.

  Scenario: The game must be finished and the winning player must be determined.
    Given Game started
    When The game is in progress and the two players are scoring each one against his opponent.
    Then The game is over
    And the winning player had being determined
