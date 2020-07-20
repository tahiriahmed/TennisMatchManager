package sg.kata.tennis.set;

import org.junit.Assert;

import cucumber.api.PendingException;
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
		Assert.assertTrue(
				// If a player win a Game and reach the Set score of 6 and the other player has
				// a Set score of 5, a new Game must be played and the first player who reach
				// the score of 7 wins the match
				(set.isAdditionalRound() && set.getFirstPlayerScore() == 7)
						// If a player reach the Set score of 6 and the other player has a Set score of
						// 4 or lower, the player win the Set
						|| (!set.isAdditionalRound() && set.getFirstPlayerScore() >= 6
								&& set.getSecondPlayerScore() <= 4)
						// The Tie-Break ends as soon as a player gets a least 6 points and gets 2
						// points more than his opponent
						|| (set.isTieBreak() && (set.getFirstPlayerScore() - set.getSecondPlayerScore() >= 2)));
	}

	@Then("^The Tie-Break rule is activated$")
	public void the_Tie_Break_rule_is_activated() throws Throwable {
		set.isTieBreak();
	}

	@Given("^The score is Tie-Break$")
	public void the_score_is_Tie_Break() throws Throwable {
		set = new SetGameScoreManager();
		set.setFirstPlayerScore(6);
		set.setSecondPlayerScore(6);
		set.setTieBreak(true);
	}

}
