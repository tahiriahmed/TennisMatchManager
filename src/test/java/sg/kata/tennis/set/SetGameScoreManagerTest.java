package sg.kata.tennis.set;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/sg/kata/tennis/set", strict = true, monochrome = true, plugin = { "pretty", "html:rapport/Set" }) 
public class SetGameScoreManagerTest {

}
