package sg.kata.tennis.game;

import sg.kata.tennis.constants.Constants.gameScores;
import sg.kata.tennis.player.Player;

/**
 * @author a.tahiri
 *
 */
public class GameScoreManager {
	
	protected Player firstPlayer;
	
	protected Player secondPlayer;
	

	/**
	 * @param firstPlayer
	 * @param secondPlayer
	 */
	public GameScoreManager(Player firstPlayer, Player secondPlayer) {
		super();
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
	}

	/**
	 * @param player
	 * @return
	 */
	public gameScores winPoint(Player player) {

		Player winningPlayer = player;
		Player losingPlayer = (winningPlayer.equals(firstPlayer)) ? secondPlayer : firstPlayer;

		// nothing to do if the player already win
		if (!winningPlayer.isGameWinner()) {
			// this treats the normal cases when scores of both players are less than forty
			if (winningPlayer.getGameScore().ordinal() < gameScores.forty.ordinal()
					&& losingPlayer.getGameScore().ordinal() < gameScores.forty.ordinal()) {
				// we get the index of the next score
				int nextScore = winningPlayer.getGameScore().ordinal() + 1;
				// we replace the current score by the following one
				winningPlayer.setGameScore(gameScores.values()[nextScore]);
			}
			// this treats the case of when one player win directly because the score of the
			// other one is less than forty
			else if (losingPlayer.getGameScore().ordinal() < gameScores.forty.ordinal()) {
				winningPlayer.setGameScore(gameScores.win);
			}
			// this treats the cases of deuce and advantage.
			else {
				handleDeuceCase(player);
			}
		}
		
		winningPlayer.setGameWinner(gameScores.win.equals(winningPlayer.getGameScore()));

		return winningPlayer.getGameScore();
	}

	/**
	 * @param player
	 */
	public void handleDeuceCase(Player player) {

		Player winningPlayer = player;
		Player losingPlayer = (winningPlayer.equals(firstPlayer)) ? secondPlayer : firstPlayer;

		// this treats the case of deuce, means when a player has just gain forty points
		// but the other one has already forty points also.
		if (winningPlayer.getGameScore().ordinal() < gameScores.forty.ordinal()
				&& losingPlayer.getGameScore().equals(gameScores.forty)) {
			winningPlayer.setGameScore(gameScores.deuce);
			losingPlayer.setGameScore(gameScores.deuce);
		}
		// this treats the transition from deuce status to advantage and win.
		else {
			// we get the index of the next score
			int nextScore = winningPlayer.getGameScore().ordinal() + 1;
			// we replace the current score by the following one
			winningPlayer.setGameScore(gameScores.values()[nextScore]);
		}
	}

	/**
	 * @param player
	 * @return
	 */
	public gameScores losePoint(Player losingPlayer) {

		// this deals with the case when a score becomes deuce before it was advantage
		if (losingPlayer.getGameScore().equals(gameScores.advantage)) {
			losingPlayer.setGameScore(gameScores.deuce);
		}

		return losingPlayer.getGameScore();
	}

	public Player getFirstPlayer() {
		return firstPlayer;
	}

	public void setFirstPlayer(Player firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	public Player getSecondPlayer() {
		return secondPlayer;
	}

	public void setSecondPlayer(Player secondPlayer) {
		this.secondPlayer = secondPlayer;
	}

}
