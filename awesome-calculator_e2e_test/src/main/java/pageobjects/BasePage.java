package pageobjects;

import net.serenitybdd.core.pages.PageObject;

public class BasePage extends PageObject {


  public void navigateToHomePage() {
    open();
  }

  public void verifyTextToAppear(String text) {
    waitForTextToAppear(text);
  }
}
