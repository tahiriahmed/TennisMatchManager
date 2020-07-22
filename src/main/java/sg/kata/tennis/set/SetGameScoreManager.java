package sg.kata.tennis.set;

import sg.kata.tennis.constants.Constants.gameScores;
import sg.kata.tennis.game.GameScoreManager;
import sg.kata.tennis.player.Player;

public class SetGameScoreManager extends GameScoreManager {

	private boolean additionalRound;

	private boolean tieBreak;

	public SetGameScoreManager(Player firstPlayer, Player secondPlayer) {
		super(firstPlayer, secondPlayer);
	}

	/**
	 * @param player
	 * @return
	 */
	public int winGame(Player player) {

		Player winningPlayer = player;
		Player losingPlayer = (winningPlayer.equals(firstPlayer)) ? secondPlayer : firstPlayer;

		winningPlayer.setSetScore(winningPlayer.getSetScore() + 1);

		if (!isAdditionalRound()) {
			if (winningPlayer.getSetScore() == 6 && losingPlayer.getSetScore() == 5) {
				this.setAdditionalRound(true);
			}
		}

		if (winningPlayer.getSetScore() == 6 && losingPlayer.getSetScore() == 6) {
			this.setTieBreak(true);
		}

		return winningPlayer.getSetScore();

	}

	/**
	 * @param player
	 * @return
	 */
	public boolean wonDirect(Player player) {

		Player winningPlayer = player;
		Player losingPlayer = (winningPlayer.equals(firstPlayer)) ? secondPlayer : firstPlayer;

		return (!isAdditionalRound() && winningPlayer.getSetScore() >= 6 && losingPlayer.getSetScore() <= 4);

	}

	public boolean wonAdditionalRound(Player player) {

		return (isAdditionalRound() && player.getSetScore() == 7);

	}

	public boolean wonTieBreak(Player player) {

		Player winningPlayer = player;
		Player losingPlayer = (winningPlayer.equals(firstPlayer)) ? secondPlayer : firstPlayer;

		return (isTieBreak() && (winningPlayer.getSetScore() - losingPlayer.getSetScore() >= 2));

	}

	public boolean isHeTheWinner(Player player) {
		
		return (wonDirect(player) || wonAdditionalRound(player) || wonTieBreak(player));

	}

	/**
	 * A new Game is played
	 */
	public void startNewGame() {
		getFirstPlayer().setGameScore(gameScores.zero);
		getSecondPlayer().setGameScore(gameScores.zero);
		getFirstPlayer().setGameWinner(false);
		getSecondPlayer().setGameWinner(false);
	}

	/**
	 * At the end of the execution of the game score update logic of the mother
	 * class, we execute a new process which allows to update the set score and then
	 * immediately check if there is a winner among the two players.
	 */
	public gameScores winPoint(Player player) {
		gameScores score = super.winPoint(player);
		if (player.isGameWinner()) {
			winGame(player);
			if (isHeTheWinner(firstPlayer)) {
				firstPlayer.setSetWinner(true);
			} else if (isHeTheWinner(secondPlayer)) {
				secondPlayer.setSetWinner(true);
			} else {
				startNewGame();
			}
		}
		return score;
	}

	public boolean isAdditionalRound() {
		return additionalRound;
	}

	public void setAdditionalRound(boolean additionalRound) {
		this.additionalRound = additionalRound;
	}

	public boolean isTieBreak() {
		return tieBreak;
	}

	public void setTieBreak(boolean tieBreak) {
		this.tieBreak = tieBreak;
	}

}
