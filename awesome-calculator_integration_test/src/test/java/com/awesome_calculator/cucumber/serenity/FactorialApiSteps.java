package com.awesome_calculator.cucumber.serenity;

import com.awesome_calculator.utils.ApiBase;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FactorialApiSteps extends ApiBase {

  Logger logger = LoggerFactory.getLogger(this.getClass());
  RequestSpecification request = SerenityRest.given().log().all();

  @Step("Set base url for the request: {0}")
  public void assignUrl(String Uri) {

    logger.info("Setting up the base url: {}", Uri);
    request = request.baseUri(Uri);

  }

  @Step("Send get request for factorial")
  public void getRequestFactorial(String Number, String Url) {

    response = request
      .with().queryParam("number", Number)
      .when().get(Url);
  }

  @Step("verify the response")
  public void verifyResponseCode(String Status) {

    logger.info("The status code is {}", getStatusCode());
    if (Status.equalsIgnoreCase("success")) {
      logger.info("Verifying the success codes");
      validateSuccessReposeStatusCode();
    } else {
      logger.info("failure return code");
      validateFailureReposeStatusCode();
    }
  }

  @Step("Find and verify the factorial from the response")
  public void getFactorialFromResponse(String expectedNumber) {

    String actualNumber = getResponseValueFrom("data.number");
    assertThat(actualNumber, is(expectedNumber));
  }

  @Step("Verify the Message from the response")
  public void verifyMessageFromResponse(String expectedMessage) {

    String actualMessage = getResponseValueFrom("error");
    assertThat(actualMessage, is(expectedMessage));
  }

}
