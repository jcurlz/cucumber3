package com.tem.testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags="@Scenario1",
		features ={"classpath:com.tem.features"},
		glue = {"com.tem.stepDefinitions","com.tem.testUtils"},
		plugin = {"pretty",
				"html:target/html-report.html",
				"json:target/json-report/cucumber.json"},
		dryRun=false
		)

public class Runner {

}
