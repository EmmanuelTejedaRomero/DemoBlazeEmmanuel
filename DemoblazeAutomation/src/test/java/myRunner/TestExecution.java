package myRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="src/test/java/features/StepsByDemoBlze.feature", glue = "stepsDefinition")
public class TestExecution extends AbstractTestNGCucumberTests{

}
