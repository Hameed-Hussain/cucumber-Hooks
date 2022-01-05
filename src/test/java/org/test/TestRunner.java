package org.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= "src\\test\\resources\\Hooks.feature",glue="org.stepDefs")

public class TestRunner {
	

}
