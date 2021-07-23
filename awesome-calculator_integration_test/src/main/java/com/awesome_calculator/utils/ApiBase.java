package com.awesome_calculator.utils;

import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matcher;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isOneOf;
import static org.hamcrest.Matchers.not;

public class ApiBase {

  public static final Matcher<Integer> statusCodeOK = isOneOf(200, 201, 202, 203, 204, 205, 206);
  public static ResponseOptions<Response> response;

  @Step("Get value from the request")
  public String getResponseValueFrom(String key) {

    return response.getBody().jsonPath().get(key).toString();

  }

  @Step("Validate a success response")
  public void validateSuccessReposeStatusCode() {

    assertThat(response.getStatusCode(), statusCodeOK);

  }

  @Step("Validate a failure response")
  public void validateFailureReposeStatusCode() {

    assertThat(response.getStatusCode(), not(statusCodeOK));


  }

  public int getStatusCode(){
      return response.getStatusCode();
  }
}
