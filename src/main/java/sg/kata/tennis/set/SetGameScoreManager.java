package sg.kata.tennis.set;

import sg.kata.tennis.constants.Constants.gameScores;
import sg.kata.tennis.game.GameScoreManager;
import sg.kata.tennis.player.Player;

public class SetGameScoreManager extends GameScoreManager {

	private boolean additionalRound = false;

	private boolean tieBreak = false;

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

		// Each time a player win a Game, the Set score changes as follow: 1 -> 2 -> 3
		// -> 4 -> 5 -> 6 (-> 7)
		winningPlayer.setGamesWon(winningPlayer.getGamesWon() + 1);

		if (!isAdditionalRound()) {
			// If a player win a Game and reach the Set score of 6 and the other player has
			// a Set score of 5, a new Game must be played and the first player who reach
			// the score of 7 wins the match
			if (winningPlayer.getGamesWon() == 6 && losingPlayer.getGamesWon() == 5) {
				this.setAdditionalRound(true);
			}
		}

		// If the 2 players reach the score of 6 Games , the Tie-Break rule is activated
		if (winningPlayer.getGamesWon() == 6 && losingPlayer.getGamesWon() == 6) {
			this.setTieBreak(true);
		}

		return winningPlayer.getGamesWon();

	}

	/**
	 * @param player
	 * @return
	 */
	public boolean wonDirect(Player player) {

		// If a player reach the Set score of 6 and the other player has a Set score of
		// 4 or lower, the player win the Set

		return (!isAdditionalRound() && player.getGamesWon() >= 6 && getSecondPlayer().getGamesWon() <= 4);

	}
	
	public boolean wonAdditionalRound(Player player) {
		
		// If a player win a Game and reach the Set score of 6 and the other player has
		// a Set score of 5, a new Game must be played and the first player who reach
		// the score of 7 wins the match
		
		return (isAdditionalRound() && player.getGamesWon() == 7);
		
	}
	
	public boolean wonTieBreak(Player player) {
		
		Player winningPlayer = player;
		Player losingPlayer = (winningPlayer.equals(firstPlayer)) ? secondPlayer : firstPlayer;
		
		// The Tie-Break ends as soon as a player gets a least 6 points and gets 2
		// points more than his opponent
		
		return (isTieBreak() && (winningPlayer.getGamesWon() - losingPlayer.getGamesWon() >= 2));
		
	}

	public boolean isHeTheWinner(Player player) {
		
		return (wonDirect(player) || wonAdditionalRound(player) || wonTieBreak(player));

	}

	/**
	 * A new Game is played
	 */
	public void startNewGame() {
		getFirstPlayer().setScore(gameScores.zero);
		getSecondPlayer().setScore(gameScores.zero);
	}

	/**
	 *
	 */
	public gameScores winPoint(Player player) {
		gameScores score = super.winPoint(player);
		if (score.equals(gameScores.win)) {
			winGame(player);
			
			if (isHeTheWinner(firstPlayer)) {
				firstPlayer.setWinner(true);
			} else if (isHeTheWinner(secondPlayer)) {
				secondPlayer.setWinner(true);
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
