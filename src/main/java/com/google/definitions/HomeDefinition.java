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
  public void iGoToTheSearchPage() {
    searchStep.searchResults();
  }

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
}