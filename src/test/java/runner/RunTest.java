package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features",
				 glue = {"steps","hooks"},
			     plugin = {"pretty", "html:target/cucumber-reports.html"},
				 monochrome = true
				 //dryRun=true
				 )

public class RunTest extends AbstractTestNGCucumberTests{

}

