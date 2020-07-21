package sg.kata.tennis.game;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/sg/kata/tennis/game", strict = true, monochrome = true, plugin = { "pretty", "html:report/game" }) 
public class GameScoreManagerTest {

}
