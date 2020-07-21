Feature: The set must be finished and after a game is won, the winning player must be determined.

  Scenario: The set must be finished and the winning player must be determined.
    Given The match started
    When The match is in progress and the two players are scoring each one against his opponent.
    Then The match is over
    And the winning player had being determined
