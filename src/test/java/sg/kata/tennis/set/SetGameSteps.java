package sg.kata.tennis.set;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sg.kata.tennis.constants.Constants.player;

public class SetGameSteps {
	
	private SetGameScoreManager set;
	
	@Given("^The set started$")
	public void the_set_started() throws Throwable {
		set = new SetGameScoreManager();
	}

	@When("^The first player won a game$")
	public void the_first_player_won_a_game() throws Throwable {
		set.winGame(player.first);
	}

	@When("^The second player won a game$")
	public void the_second_player_won_a_game() throws Throwable {
		set.winGame(player.second);
	}

	@Then("^The first player win the Set$")
	public void the_first_player_win_the_Set() throws Throwable {
		//If a player reach the Set score of 6 and the other player has a Set score of 4 or lower, the player win the Set
		Assert.assertTrue((set.isAdditionalRound() && set.getFirstPlayerScore() == 7)||(!set.isAdditionalRound() && set.getFirstPlayerScore() >= 6 && set.getSecondPlayerScore()<= 4));
	}
	
}
