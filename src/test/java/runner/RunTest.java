package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@CucumberOptions(features = "src/test/java/feature/login.feature", glue = "loginsteps", monochrome = true)

@RunWith(Cucumber.class)

public class RunTest
{
	
}
