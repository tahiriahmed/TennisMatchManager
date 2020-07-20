package sg.kata.tennis.game;

import sg.kata.tennis.constants.Constants;
import sg.kata.tennis.constants.Constants.gameScores;
import sg.kata.tennis.constants.Constants.player;

/**
 * @author a.tahiri
 *
 */
public class GameScoreManager {

	private gameScores[] playersScores = { gameScores.zero, gameScores.zero };

	/**
	 * @param player
	 * @return
	 */
	public gameScores winPoint(player player) {

		int winningPlayer = player.ordinal();
		int losingPlayer = (winningPlayer == Constants.firstPlayer) ? Constants.secondPlayer : Constants.firstPlayer;

		// nothing to do if the player already win
		if (!playersScores[winningPlayer].equals(gameScores.win)) {
			// this treats the normal cases when scores of both players are less than forty
			if (playersScores[winningPlayer].ordinal() < gameScores.forty.ordinal()
					&& playersScores[losingPlayer].ordinal() < gameScores.forty.ordinal()) {
				// we get the index of the next score
				int nextScore = playersScores[winningPlayer].ordinal()+1;
				// we replace the current score by the following one
				playersScores[winningPlayer] = gameScores.values()[nextScore];
			}
			// this treats the case of when one player win directly because the score of the
			// other one is less than forty
			else if (playersScores[losingPlayer].ordinal() < gameScores.forty.ordinal()) {
				playersScores[winningPlayer] = gameScores.win;
			}
			// this treats the case of deuce, means when a player has just gain forty points
			// but the other one has already forty points also.
			else if (playersScores[winningPlayer].ordinal() < gameScores.forty.ordinal()
					&& playersScores[losingPlayer].equals(gameScores.forty)) {
				playersScores[winningPlayer] = gameScores.deuce;
				playersScores[losingPlayer] = gameScores.deuce;
			}
			// this treats the transition from deuce status to advantage and win.
			else {
				// we get the index of the next score
				int nextScore = playersScores[winningPlayer].ordinal()+1;
				// we replace the current score by the following one
				playersScores[winningPlayer] = gameScores.values()[nextScore];
			}
		}

		return playersScores[winningPlayer];
	}

	/**
	 * @param player
	 * @return
	 */
	public gameScores losePoint(player player) {

		int losingPlayer = player.ordinal();
		// this deals with the case when a score becomes deuce before it was advantage 
		if (playersScores[losingPlayer].equals(gameScores.advantage)) {
			playersScores[losingPlayer] = gameScores.deuce;
		}

		return playersScores[losingPlayer];
	}

	/**
	 * @return
	 */
	public gameScores getFirstPlayerScore() {
		return this.playersScores[Constants.firstPlayer];
	}

	/**
	 * @return
	 */
	public gameScores getSecondPlayerScore() {
		return this.playersScores[Constants.secondPlayer];
	}

	/**
	 * @param score
	 */
	public void setFirstPlayerScore(gameScores score) {
		this.playersScores[Constants.firstPlayer] = score;
	}

	/**
	 * @param score
	 */
	public void setSecondPlayerScore(gameScores score) {
		this.playersScores[Constants.secondPlayer] = score;
	}

}
