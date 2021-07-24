package com.calculator.cucumber.steps;

import com.calculator.cucumber.serenity.FactorialSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.nashorn.internal.objects.annotations.Getter;
import net.thucydides.core.annotations.Steps;

public class FactorialUserActions {
  @Steps
  FactorialSteps factorialSteps;

  @Given("usser is in factorial home page")
  public void userIsInFactorialHomePage(){
      factorialSteps.goToFactorialHomePage();
  }

  @When("user gives number {string} as input")
  public void userGivesNumberAsInput(String number) {

    factorialSteps.inputNumber(number);

  }

  @When("clicks the calculate button")
  public void clicksTheCalculateButton() {
    factorialSteps.clickCalculateButton();

  }

  @Then("user should see the factorial {string} of number")
  public void userShouldSeeTheFactorialExpectedFactorialOfNumber(String expectedFactorial) {
    factorialSteps.getVisibleFactorialMessage();
    factorialSteps.verifyFactorial(expectedFactorial);
  }

  @Then("user should see the message {string}")
  public void userShouldSeeTheMessageInputShouldBeAnInteger(String message) {
    factorialSteps.getVisibleFactorialMessage();
    factorialSteps.verifyErrorMessage(message);
  }
}
