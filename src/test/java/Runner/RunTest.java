package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Feature",
glue = { "stepDefinition","Hooks" },
tags = "@NewUserCheckoutFlow", 
monochrome = true, 
dryRun = false,
plugin = {
		"pretty",
		"me.jvt.cucumber.report.PrettyReports:target/cucumber"
})
public class RunTest {


}
