package sg.kata.tennis.set;

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
				winningPlayer.setGamesWon(0);
				losingPlayer.setGamesWon(0);
				this.setAdditionalRound(true);
			}
		}
		
		//If the 2 players reach the score of 6 Games , the Tie-Break rule is activated
		if (winningPlayer.getGamesWon() == 6 && losingPlayer.getGamesWon() == 6) {
			this.setTieBreak(true);
		}

		return winningPlayer.getGamesWon();

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
