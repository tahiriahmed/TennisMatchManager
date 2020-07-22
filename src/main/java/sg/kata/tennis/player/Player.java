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
	private gameScores gameScore = gameScores.zero;
	
	// The set starts with a score of 0 Game for each player
	private int setScore;
	
	//After a Set is won, the winning player must be determined.
	private boolean setWinner;
	
	//After a game is won, the winning player must be determined.
	private boolean gameWinner;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public gameScores getGameScore() {
		return gameScore;
	}

	public void setGameScore(gameScores gameScore) {
		this.gameScore = gameScore;
	}

	public boolean isSetWinner() {
		return setWinner;
	}

	public void setSetWinner(boolean setWinner) {
		this.setWinner = setWinner;
	}

	public boolean isGameWinner() {
		return gameWinner;
	}

	public void setGameWinner(boolean gameWinner) {
		this.gameWinner = gameWinner;
	}

	public int getSetScore() {
		return setScore;
	}

	public void setSetScore(int setScore) {
		this.setScore = setScore;
	}
	
}
