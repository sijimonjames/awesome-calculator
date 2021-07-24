package com.calculator.cucumber.testrunners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/",
  glue = "com.calculator.cucumber.steps", plugin = {"pretty", "json:target/cucumber"}, tags = "not @ignore")

public class FactorialTestRunner {
}
