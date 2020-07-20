package sg.kata.tennis.game;

import sg.kata.tennis.constants.Constants;
import sg.kata.tennis.constants.Constants.gameScores;
import sg.kata.tennis.constants.Constants.player;

/**
 * @author a.tahiri
 *
 */
public class GameScoreManager 
{
	
	private gameScores[] playersScores = {gameScores.zero,gameScores.zero}; 
	
	/**
	 * @param player
	 * @return
	 */
	public gameScores winPoint(player player) {
		
		int winningPlayer = player.ordinal();
		
		// nothing to do if the player already win
		if (!playersScores[winningPlayer].equals(gameScores.win)) {
			// we get the index of the next score
			int nextScore = playersScores[winningPlayer].ordinal()+1;
			// we replace the current score by the following one
			playersScores[winningPlayer] = gameScores.values()[nextScore];
		}
		
		return playersScores[winningPlayer];
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
