package com.google.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static com.google.steps.SearchStep.TO_SEARCH;

public class ResultsPage extends PageObject {

  private String txtResults = "//h3[contains(text(),'result')]";

  @FindBy(xpath = "//div[@id='search']//child::h3[1]")
  private WebElementFacade txtFirstResult;

  @FindBy(name = "q")
  private WebElementFacade txtSearch;

  @FindBy(xpath = "//div[@class='brs_col']//child::a[1]")
  private WebElementFacade txtrelatedSearches;

  @FindBy(xpath = "//p[@role='heading']//child::em")
  private WebElementFacade txtNoResultPage;

  @FindBy(xpath = "//h3[@class='LC20lb DKV0Md']")
  private List<WebElement> lstAllResults;

  @FindBy(xpath = "//span[@class='st']//em")
  private List<WebElement> lstAllResultsContent;

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

  public void addToSearch(String strAddToSearch) {
    txtSearch.sendKeys(strAddToSearch);
  }

  public void relatedSearches() {
    txtrelatedSearches.click();
  }

  public boolean relatedResults() {
    List<String> lstSearch = Arrays.asList(txtSearch.getValue().toLowerCase().split(" "));
    List<String> lstSearch2 = Arrays.asList(txtFirstResult.getText().toLowerCase().split(" "));
    int count = lstSearch.size() / 2;
    for (String search : lstSearch) {
      for (String s : lstSearch2) {
        if (count == 0) {
          return true;
        }
        if (search.equals(s)) {
          count--;
          break;
        }
      }
    }
    return false;
  }

  public boolean noResult() { return txtNoResultPage.isPresent(); }

  public boolean noResultWillSay(String strNoResultWillSay) {

    for (WebElement search : lstAllResults) {
      if ((((String)search.getText()).contains(strNoResultWillSay))) {
        return true;
      }
    }
    return false;
  }

  public boolean allResultsWillSay(String strAllResultsWillSay) {

    for (int i = 0; i<lstAllResults.size(); i++) {
      WebElement search = lstAllResults.get(i);
      if (!(((String)search.getText()).contains(strAllResultsWillSay)) &&
              !(((String) lstAllResultsContent.get(i).getText()).contains(strAllResultsWillSay))) {
        return false;
      }
    }
    return true;
  }
}
