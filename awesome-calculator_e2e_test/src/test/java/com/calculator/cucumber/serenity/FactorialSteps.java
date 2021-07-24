package com.calculator.cucumber.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pageobjects.BasePage;
import pageobjects.FactorialPage;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyString;

public class FactorialSteps extends ScenarioSteps {
  BasePage basePage;
  FactorialPage factorialPage;

  String factorialNumberText;

  @Step("Navigate to Home page")
  public void goToFactorialHomePage() {
    basePage.navigateToHomePage();
    factorialPage.verifyHomePageIsAppeared();
  }

  public void inputNumber(String number) {
    factorialPage.inputNumber(number);
  }

  public void clickCalculateButton() {
    factorialPage.clickCalculateButton();
  }

  public void getVisibleFactorialMessage() {
    factorialNumberText = factorialPage.getFactorialResultText();
    assertThat(factorialNumberText, not(isEmptyString()));
  }

  public void verifyFactorial(String expectedFactorial) {

    String factorilNumber = factorialNumberText.substring(factorialNumberText.lastIndexOf(":") + 1);
    assertThat(factorilNumber.replaceAll("\\s+",""), is(expectedFactorial));

  }
  public void verifyErrorMessage(String expectedMessage) {

    assertThat(factorialNumberText, is(expectedMessage));

  }
}
