package sg.kata.tennis.randomSet;

import java.util.Random;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sg.kata.tennis.player.Player;
import sg.kata.tennis.set.SetGameScoreManager;

public class randomSetSteps {
	
	private SetGameScoreManager set;
	
	@Given("^Game started$")
	public void game_started() throws Throwable {
		set = new SetGameScoreManager(new Player(), new Player());
	}

	@When("^The match is in progress and the two players are scoring each one against his opponent\\.$")
	public void the_match_is_in_progress_and_the_two_players_are_scoring_each_one_against_his_opponent() throws Throwable {
		
		Random random = new Random();
		
		//The set must be finished with a winner.
		while ((!set.getFirstPlayer().isWinner() && !set.getSecondPlayer().isWinner())) {
			
			//Players must be able to score points.
			if (random.nextBoolean()) {
				set.winPoint(set.getFirstPlayer());
			} else {
				set.winPoint(set.getSecondPlayer());
			}
			
		}
	}

	@Then("^The match is over$")
	public void the_match_is_over() throws Throwable {
		//The set must be finished with a winner.
		Assert.assertTrue(set.getFirstPlayer().isWinner() || set.getSecondPlayer().isWinner());
	}

	@Then("^the winning player had being determined$")
	public void the_winning_player_had_being_determined() throws Throwable {
		//After a game is won, the winning player must be determined.(XOR)
		Assert.assertTrue(set.getFirstPlayer().isWinner() ^ set.getSecondPlayer().isWinner());
	}

}

