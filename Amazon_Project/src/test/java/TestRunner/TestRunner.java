package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		features="Features",
		glue={"StepDefinations"},
		plugin= {"html:target/cucumber-html-report"},
		monochrome=false,
		dryRun = false
		)

public class TestRunner {

}
