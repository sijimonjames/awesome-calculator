package com.awesome_calculator.cucumber.steps;

import com.awesome_calculator.cucumber.serenity.FactorialApiSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class FactorialApiActions {

  @Steps
  FactorialApiSteps factorialApiSteps;

  @Given("Set the end url as {string}")
  public void set_the_end_url_as(String url) {
    factorialApiSteps.assignUrl(url);
  }

  @When("API {string} receives get request with number {string}")
  public void api_receives_get_request_with_number(String url, String number) {
    factorialApiSteps.getRequestFactorial(number, url);
  }

  @Then("API should return {string} status code")
  public void apiShouldReturnSuccessStatusCode(String Status) {
    factorialApiSteps.verifyResponseCode(Status);
  }

  @Then("should return the value {string}")
  public void shouldReturnTheValueExpectedFactorial(String ExpectedFactorial) {

    factorialApiSteps.getFactorialFromResponse(ExpectedFactorial);

  }

  @Then("should return message as {string}")
  public void shouldReturnMessageAsInternalServerError(String message) {
    factorialApiSteps.verifyMessageFromResponse(message);
  }
}
