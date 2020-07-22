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

		if (!winningPlayer.isGameWinner()) {
			if (winningPlayer.getGameScore().ordinal() < gameScores.forty.ordinal()
					&& losingPlayer.getGameScore().ordinal() < gameScores.forty.ordinal()) {
				int nextScore = winningPlayer.getGameScore().ordinal() + 1;
				winningPlayer.setGameScore(gameScores.values()[nextScore]);
			}
			else if (losingPlayer.getGameScore().ordinal() < gameScores.forty.ordinal()) {
				winningPlayer.setGameScore(gameScores.win);
			}
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

		if (winningPlayer.getGameScore().ordinal() < gameScores.forty.ordinal()
				&& losingPlayer.getGameScore().equals(gameScores.forty)) {
			winningPlayer.setGameScore(gameScores.deuce);
			losingPlayer.setGameScore(gameScores.deuce);
		}
		else {
			int nextScore = winningPlayer.getGameScore().ordinal() + 1;
			winningPlayer.setGameScore(gameScores.values()[nextScore]);
		}
	}

	/**
	 * @param player
	 * @return
	 */
	public gameScores losePoint(Player losingPlayer) {

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
