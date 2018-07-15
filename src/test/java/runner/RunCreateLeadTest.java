package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@CucumberOptions(features = "src/test/java/feature/CreateLeads.feature", 
glue = "loginsteps", 
monochrome = true,
tags = "@smoke and @sanity or @regression ~@integration")

@RunWith(Cucumber.class)

public class RunCreateLeadTest
{
	
}
