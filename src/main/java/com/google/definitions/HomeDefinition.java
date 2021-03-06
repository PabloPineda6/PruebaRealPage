package com.google.definitions;

import com.google.steps.SearchStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class HomeDefinition {
  @Steps SearchStep searchStep;

  @Given("^I'm on the homepage$")
  public void iMOnTheHomepage() {
    searchStep.openHome();
  }

  @When("^I type (.*) into the search field$")
  public void iTypeIntoTheSearchField(String strWhatToSearch) {
    searchStep.typeYourSearch(strWhatToSearch);
  }

  @When("^I click the Google Search button$")
  public void iClickTheGoogleSearchButton() {
    searchStep.getResults();
  }

  @Then("^I go to the search result page$")
  public void iGoToTheSearchPage() { searchStep.searchResults(); }

  @Then("^the first result is (.*)$")
  public void theFirstResultIs(String strFirstResult) {
    searchStep.getFirstResult(strFirstResult);
  }

  @When("^I click on the first result link$")
  public void iClickOnTheFirstResultLink() {
    searchStep.enterTheFirstResult();
  }

  @Then("^I go to the (.*) - (.*) page$")
  public void iGoToThePage(String strInsideFirstPage1, String strInsideFirstPage2) {
    searchStep.searchResults(strInsideFirstPage1, strInsideFirstPage2);
  }

  @And("^the suggestions list is displayed$")
  public void theSuggestionsListIsDisplayed() {
    searchStep.sugestionList();
  }

  @And("^I click on the first suggestion in the list$")
  public void iClickOnTheFirstSuggestionInTheList() {
    searchStep.clickSugestion();
  }

  @And("^I click on the I'm Feeling Lucky button$")
  public void iClickOnTheIMFeelingLuckyButton() { searchStep.feelingLucky(); }

  @When("^I add (.*) to the search field content$")
  public void iAddPatrickRothfussToTheSearchFieldContent(String strAddToSearch) {searchStep.addToSearch(strAddToSearch);
  }

  @When("^I click on the the first related search at the bottom of the page$")
  public void iClickOnTheTheFirstRelatedSearchAtTheBottomOfThePage() { searchStep.relatedSearches(); }

  @Then("^I go to the search results page of that related option$")
  public void iGoToTheSearchResultsPageOfThatRelatedOption() { searchStep.relatedResults(); }

  @Then("^The search doesn't return any result$")
  public void theSearchDoesnTReturnAnyResult() { searchStep.noResult(); }

  @Then("^I am on the homepage$")
  public void iAmOnTheHomepage() { searchStep.iAmOnTheHomepage(); }

  @Then("^In the search result page no result will say (.*)$")
  public void inTheSearchResultPageNoResultWillSay(String strNoResultWillSay) { searchStep.noResultWillSay(strNoResultWillSay); }

  @And("^all results will say (.*)$")
  public void allResultsWillSay(String strAllResultsWillSay) { searchStep.allResultsWillSay(strAllResultsWillSay); }

  @When("^I click on the option Next at the bottom of the page$")
  public void iClickOnTheOptionNextAtTheBottomOfThePage() { searchStep.clickOnTheOptionNext(); }

  @Then("^I go to the search results page number (\\d+)$")
  public void iGoToTheSearchResultsPageNumber(int  intPageToGo) { searchStep.goToThatSearchResultsPage(intPageToGo); }

  @When("^I click on the option Previous at the bottom of the page$")
  public void iClickOnTheOptionPreviousAtTheBottomOfThePage() { searchStep.clickOnTheOptionPrevious(); }

  @When("^I click on the number (\\d+) at the bottom of the page$")
  public void iClickOnTheNumberAtTheBottomOfThePage(int intPageToGo) { searchStep.clickOnNumberOfPage(intPageToGo); }

  @When("^I click on the (.*) or (.*) search option link$")
  public void iClickOnTheSearchOptionLink(String strSearchOptionEng, String strSearchOptionEsp) { searchStep.searchOptionLink(strSearchOptionEng, strSearchOptionEsp); }

  @Then("^I go to the (.*) or (.*) search option page$")
  public void iGoToTheSearchOptionPage(String strSearchOptionEng, String strSearchOptionEsp) { searchStep.searchOptionPage(strSearchOptionEng, strSearchOptionEsp); }
}