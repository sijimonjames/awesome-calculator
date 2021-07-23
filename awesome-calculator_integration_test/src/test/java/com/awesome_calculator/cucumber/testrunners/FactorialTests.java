package com.awesome_calculator.cucumber.testrunners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/",
  glue = "com.awesome_calculator.cucumber.steps", plugin = {"pretty", "json:target/cucumber"}, tags = "not @ignore")

public class FactorialTests {

}
