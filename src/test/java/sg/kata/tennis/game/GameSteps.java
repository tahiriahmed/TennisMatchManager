package sg.kata.tennis.game;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sg.kata.tennis.constants.Constants.gameScores;
import sg.kata.tennis.constants.Constants.player;

public class GameSteps {
	
	GameScoreManager game;
    
	@Given("^Game started$")
	public void game_started() throws Throwable {		
		game = new GameScoreManager();
		
	}

	@When("^the first player won a point$")
	public void the_first_player_won_a_point() throws Throwable {
		game.winPoint(player.first);
	}
	
	@When("^the second player won a point$")
	public void the_second_player_won_a_point() throws Throwable {
		game.winPoint(player.second);
	}

	@Then("^The first player won the match$")
	public void the_first_player_won_the_match() throws Throwable {
		Assert.assertTrue(gameScores.win.equals(game.getFirstPlayerScore()));
	}
	
	@Then("^The second player won the match$")
	public void the_second_player_won_the_match() throws Throwable {
		Assert.assertTrue(gameScores.win.equals(game.getSecondPlayerScore()));
	}

}
