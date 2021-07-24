package pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FactorialPage extends BasePage {
  private static final String TEXT_HOME_PAGE = "Best, most awesome factorial calculator!";

  @FindBy(id = "input")
  WebElementFacade textBoxFactorialNumber;

  @FindBy(css = "button.btn-outline-success")
  WebElementFacade buttonCalculate;

  @FindBy(xpath = "//h3[@id = 'output']")
  WebElementFacade textHeaderFactorialResult;

  public void verifyHomePageIsAppeared() {
    verifyTextToAppear(TEXT_HOME_PAGE);
  }

  public void inputNumber(String number) {
    typeInto(textBoxFactorialNumber, number);
  }

  public void clickCalculateButton() {
    clickOn(buttonCalculate);
  }

  public String getFactorialResultText() {

    waitForCondition().until(ExpectedConditions.visibilityOf(textHeaderFactorialResult));
    return textHeaderFactorialResult.getText();
  }

}
