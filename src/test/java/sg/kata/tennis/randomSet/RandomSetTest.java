package sg.kata.tennis.randomSet;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/sg/kata/tennis/randomSet", strict = true, monochrome = true, plugin = { "pretty", "html:report/randomSet" }) 
public class RandomSetTest {

}
