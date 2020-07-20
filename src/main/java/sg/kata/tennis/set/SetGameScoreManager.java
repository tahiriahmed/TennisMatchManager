package sg.kata.tennis.set;

import sg.kata.tennis.constants.Constants;
import sg.kata.tennis.constants.Constants.player;

public class SetGameScoreManager {

	// The set starts with a score of 0 Game for each player
	private int[] playersSetScores = { 0, 0 };

	private boolean additionalRound = false;

	/**
	 * @param player
	 * @return
	 */
	public int winGame(player player) {

		int winningPlayer = player.ordinal();
		int losingPlayer = (winningPlayer == Constants.firstPlayer) ? Constants.secondPlayer : Constants.firstPlayer;

		// Each time a player win a Game, the Set score changes as follow: 1 -> 2 -> 3
		// -> 4 -> 5 -> 6 (-> 7)
		playersSetScores[winningPlayer] = playersSetScores[winningPlayer] + 1;

		if (!isAdditionalRound()) {
			// If a player win a Game and reach the Set score of 6 and the other player has
			// a Set score of 5, a new Game must be played and the first player who reach
			// the score of 7 wins the match
			if (playersSetScores[winningPlayer] == 6 && playersSetScores[losingPlayer] == 5) {
				playersSetScores[winningPlayer] = 0;
				playersSetScores[losingPlayer] = 0;
				this.setAdditionalRound(true);
			}
		}

		return playersSetScores[winningPlayer];

	}

	public boolean isAdditionalRound() {
		return additionalRound;
	}

	public void setAdditionalRound(boolean additionalRound) {
		this.additionalRound = additionalRound;
	}

	/**
	 * @return
	 */
	public int getFirstPlayerScore() {
		return this.playersSetScores[Constants.firstPlayer];
	}

	/**
	 * @return
	 */
	public int getSecondPlayerScore() {
		return this.playersSetScores[Constants.secondPlayer];
	}

	/**
	 * @param score
	 */
	public void setFirstPlayerScore(int score) {
		this.playersSetScores[Constants.firstPlayer] = score;
	}

	/**
	 * @param score
	 */
	public void setSecondPlayerScore(int score) {
		this.playersSetScores[Constants.secondPlayer] = score;
	}

}
