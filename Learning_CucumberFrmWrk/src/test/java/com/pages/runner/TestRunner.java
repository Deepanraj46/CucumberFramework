package com.pages.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:/features", glue = "com.pages.Step_Definition", dryRun = false, monochrome = true)
public class TestRunner {

}
