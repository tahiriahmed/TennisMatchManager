package sg.kata.tennis.set;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sg.kata.tennis.player.Player;

public class SetGameSteps {

	private SetGameScoreManager set;

	@Given("^The set started$")
	public void the_set_started() throws Throwable {
		set = new SetGameScoreManager(new Player(), new Player());
	}

	@When("^The first player won a game$")
	public void the_first_player_won_a_game() throws Throwable {
		set.winPoint(set.getFirstPlayer());
		set.winPoint(set.getFirstPlayer());
		set.winPoint(set.getFirstPlayer());
		set.winPoint(set.getFirstPlayer());
	}

	@When("^The second player won a game$")
	public void the_second_player_won_a_game() throws Throwable {
		set.winPoint(set.getSecondPlayer());
		set.winPoint(set.getSecondPlayer());
		set.winPoint(set.getSecondPlayer());
		set.winPoint(set.getSecondPlayer());
	}

	@Then("^The first player win the Set$")
	public void the_first_player_win_the_Set() throws Throwable {
		Assert.assertTrue(set.getFirstPlayer().isSetWinner());
	}

	@Then("^The Tie-Break rule is activated$")
	public void the_Tie_Break_rule_is_activated() throws Throwable {
		set.isTieBreak();
	}

	@Given("^The score is Tie-Break$")
	public void the_score_is_Tie_Break() throws Throwable {
		set = new SetGameScoreManager(new Player(), new Player());
		set.getFirstPlayer().setGamesWon(6);
		set.getSecondPlayer().setGamesWon(6);
		set.setTieBreak(true);
	}

}
