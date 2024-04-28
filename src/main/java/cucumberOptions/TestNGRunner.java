package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/features",tags = "@Test",monochrome = true
,glue = "stepDefinitions",plugin = "json:target/jsonReports/cucumber-report.json")

public class TestNGRunner extends AbstractTestNGCucumberTests {
}
