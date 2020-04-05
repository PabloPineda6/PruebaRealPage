package com.google.pages;

import static com.google.steps.SearchStep.TO_SEARCH;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class ResultsPage extends PageObject {

  private String txtResults = "//h3[contains(text(),'result')]";

  @FindBy(xpath = "//div[@id='search']//child::h3[1]")
  private WebElementFacade txtFirstResult;

  private String txtTitleFirstPage =
      "//title[contains(text(),'result1') and contains(text(),'result2')]";
  private String txtTitles = "//div[@id='search']//child::h3[1][text()='result']";

  public Boolean searchResults() {
    String title = txtResults.replace("result", Serenity.sessionVariableCalled(TO_SEARCH));
    WebElementFacade txtResults = find(By.xpath(title));
    return txtResults.isPresent();
  }

  public boolean getFirstResult(String strFirstResult) {
    String title = txtTitles.replace("result", strFirstResult);
    WebElementFacade txtTittle = find(By.xpath(title));
    return txtTittle.isPresent();
  }

  public void enterFirstResult() {
    txtFirstResult.click();
  }

  public boolean checkFirstResult(String strInsideFirstPage1, String strInsideFirstPage2) {
    String title =
        txtTitleFirstPage
            .replace("result1", strInsideFirstPage1)
            .replace("result2", strInsideFirstPage2);
    WebElementFacade txtTitleFirst = find(By.xpath(title));
    return txtTitleFirst.isPresent();
  }
}
