package com.google.steps;

import com.google.pages.HomePage;
import com.google.pages.ResultsPage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;
import org.testng.asserts.SoftAssert;

public class SearchStep {

  public final static String TO_SEARCH = "Search";

  @Page
  HomePage homePage;

  @Page
  ResultsPage resultsPage;
  SoftAssert softAssert = new SoftAssert();

  public void openHome() {
    homePage.open();
  }

  public void typeYourSearch(String strWhatToSearch) {
    Serenity.setSessionVariable(TO_SEARCH).to(strWhatToSearch);
    homePage.typeYourSearch(strWhatToSearch);
  }

  public void getResults() {
    homePage.getResults();
  }

  @Step
  public void searchResults() {
    MatcherAssert.assertThat("The search was not successful", resultsPage.searchResults());
  }

  @Step
  public void getFirstResult(String strFirstResult) {
    softAssert.assertEquals(
        resultsPage.getFirstResult(strFirstResult),
        true,
        "The first result of the search was not '" + strFirstResult + "'");
  }

  @Step
  public void enterTheFirstResult() {
    resultsPage.enterFirstResult();
  }

  @Step
  public void searchResults(String strInsideFirstPage1, String strInsideFirstPage2) {
    softAssert.assertEquals(
        resultsPage.checkFirstResult(strInsideFirstPage1, strInsideFirstPage2),
        true,
        "The first page of the search was not the expected one");
    softAssert.assertAll();
  }

  public void sugestionList() {
    homePage.sugestionList();
  }

  public void clickSugestion() {
    homePage.clickSugestion();
  }
}
