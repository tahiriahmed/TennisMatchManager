package sg.kata.tennis.player;

import sg.kata.tennis.constants.Constants.gameScores;

/**
 * @author a.tahiri
 *
 */
public class Player {
	
	//Example of some information that this class could contain
	private String nom;
	
	//The game starts with a score of 0 point for each player
	private gameScores score = gameScores.zero;
	
	// The set starts with a score of 0 Game for each player
	private int gamesWon = 0;
	
	//After a game is won, the winning player must be determined.
	private boolean winner; 

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public gameScores getScore() {
		return score;
	}

	public void setScore(gameScores score) {
		this.score = score;
	}

	public boolean isWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

	public int getGamesWon() {
		return gamesWon;
	}

	public void setGamesWon(int gamesWon) {
		this.gamesWon = gamesWon;
	}
	
}
