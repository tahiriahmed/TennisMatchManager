package sg.kata.tennis.player;

import sg.kata.tennis.constants.Constants.gameScores;

/**
 * @author a.tahiri
 *
 */
public class Player {
	
	private String name;
	private gameScores gameScore = gameScores.zero;
	private int setScore;
	private boolean setWinner;
	private boolean gameWinner;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
