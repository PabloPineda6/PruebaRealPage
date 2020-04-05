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
        "The first page of the search was not '" + strInsideFirstPage1 + " - " + strInsideFirstPage2 + "' as expected");
    softAssert.assertAll();
  }

  public void sugestionList() {
    homePage.sugestionList();
  }

  public void clickSugestion() {
    homePage.clickSugestion();
  }

  public void feelingLucky() { homePage.feelingLucky(); }

  public void addToSearch(String strAddToSearch) { resultsPage.addToSearch(strAddToSearch); }

  public void relatedSearches() { resultsPage.relatedSearches(); }

  public void relatedResults() {
    softAssert.assertEquals(
            resultsPage.relatedResults(),
            true,
            "The first result doesn't have most of the searched words");
    softAssert.assertAll();
  }

  public void noResult() {
    softAssert.assertEquals(
            resultsPage.noResult(),
            true,
            "The search was expected to return no results, but it did");
    softAssert.assertAll();

  }

  public void iAmOnTheHomepage() {
    softAssert.assertEquals(
            homePage.iAmOnTheHomepage(),
            true,
            "The user was expected to be on the Homepage, but isn't");
    softAssert.assertAll();
  }

  public void noResultWillSay(String strNoResultWillSay) {
    softAssert.assertEquals(
        resultsPage.noResultWillSay(strNoResultWillSay),
        false,
        "The words '" + strNoResultWillSay + "' were not supposed to appear in the search");
    }

  public void allResultsWillSay(String strAllResultsWillSay) {
    softAssert.assertEquals(
        resultsPage.allResultsWillSay(strAllResultsWillSay),
        true,
        "The words '" + strAllResultsWillSay + "' were supposed to appear in every result");
    softAssert.assertAll();
  }

  public void clickOnTheOptionNext() { resultsPage.clickOnTheOptionNext(); }

  public void clickOnTheOptionPrevious() { resultsPage.clickOnTheOptionPrevious(); }

  public void clickOnNumberOfPage(int intPageToGo) { resultsPage.clickOnNumberOfPage(intPageToGo); }

  public void goToThatSearchResultsPage(int intPageToGo) {
    softAssert.assertEquals(
            resultsPage.goToThatSearchResultsPage(intPageToGo),
            true,
            "The result page the user was directed is not the number'" + intPageToGo + "'");
    softAssert.assertAll();
  }

  public void searchOptionLink(String strSearchOptionEng, String strSearchOptionEsp) {
    resultsPage.searchOptionLink(strSearchOptionEng, strSearchOptionEsp);
  }

  public void searchOptionPage(String strSearchOptionEng, String strSearchOptionEsp) {
    softAssert.assertEquals(
            resultsPage.searchOptionPage(strSearchOptionEng, strSearchOptionEsp),
            true,
            "The result page the user was directed to, is not the '" + strSearchOptionEng + "' or '" + strSearchOptionEsp + "' option search page");
    softAssert.assertAll();
  }
}
