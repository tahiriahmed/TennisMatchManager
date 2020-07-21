package sg.kata.tennis.game;

import java.util.Random;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sg.kata.tennis.constants.Constants.gameScores;
import sg.kata.tennis.player.Player;

public class GameSteps {
	
	private GameScoreManager game;
    
	@Given("^Game started$")
	public void game_started() throws Throwable {
		game = new GameScoreManager(new Player(),new Player());
		
	}

	@When("^the first player won a point$")
	public void the_first_player_won_a_point() throws Throwable {
		game.winPoint(game.getFirstPlayer());
	}
	
	@When("^the second player won a point$")
	public void the_second_player_won_a_point() throws Throwable {
		game.winPoint(game.getSecondPlayer());
	}

	@Then("^The first player won the game$")
	public void the_first_player_won_the_match() throws Throwable {
		Assert.assertTrue(gameScores.win.equals(game.getFirstPlayer().getScore()));
	}
	
	@Then("^The second player won the match$")
	public void the_second_player_won_the_match() throws Throwable {
		Assert.assertTrue(gameScores.win.equals(game.getSecondPlayer().getScore()));
	}
	
	//us2
	
	@Then("^DEUCE rule is activated$")
	public void deuce_rule_is_activated() throws Throwable {
		Assert.assertTrue(gameScores.deuce.equals(game.getFirstPlayer().getScore()));
	}
	
	@Then("^The first player take the ADVANTAGE$")
	public void the_first_player_take_the_ADVANTAGE() throws Throwable {
		Assert.assertTrue(gameScores.advantage.equals(game.getFirstPlayer().getScore()));
	}
	
	@When("^The first player lose a point$")
	public void the_first_player_lose_a_point() throws Throwable {
		game.losePoint(game.getFirstPlayer());
	}
	
	@When("^The score is DEUCE$")
	public void the_score_is_DEUCE() throws Throwable {
		game = new GameScoreManager(new Player(),new Player());
		game.getFirstPlayer().setScore(gameScores.deuce);
		game.getSecondPlayer().setScore(gameScores.deuce);
	}
	
	@When("^The game is in progress and the two players are scoring each one against his opponent\\.$")
	public void the_game_is_in_progress_and_the_two_players_are_scoring_each_one_against_his_opponent() throws Throwable {
		
		Random random = new Random();
		
		//The set must be finished with a winner.
		while ((!gameScores.win.equals(game.getFirstPlayer().getScore()) && !gameScores.win.equals(game.getSecondPlayer().getScore()))) {
			
			//Players must be able to score points.
			if (random.nextBoolean()) {
				game.winPoint(game.getFirstPlayer());
			} else {
				game.winPoint(game.getSecondPlayer());
			}
			
		}
	}

	@Then("^The game is over$")
	public void the_game_is_over() throws Throwable {
		Assert.assertTrue(gameScores.win.equals(game.getFirstPlayer().getScore()) || gameScores.win.equals(game.getSecondPlayer().getScore()));
	}

	@Then("^the winning player had being determined$")
	public void the_winning_player_had_being_determined() throws Throwable {
		Assert.assertTrue(gameScores.win.equals(game.getFirstPlayer().getScore()) ^ gameScores.win.equals(game.getSecondPlayer().getScore()));
	}

}
