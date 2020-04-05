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

  @FindBy(xpath = "//span[@style='display:block;margin-left:53px']")
  private WebElementFacade txtOptionNext;

  @FindBy(xpath = "//span[@style='display:block;margin-right:35px;clear:right']")
  private WebElementFacade txtOptionPrevious;

  @FindBy(xpath = "//td[@class='YyVfkd']")
  private WebElementFacade txtPageToBe;

  @FindBy(xpath = "//a[@class='q qs']")
  private List<WebElement> lstSearchOptionLink;

  @FindBy(xpath = "//div[@class='hdtb-mitem hdtb-msel hdtb-imb']")
  private WebElementFacade txtSearchOptionNews;

  @FindBy(xpath = "//span[@class='rQEFy NZmxZe']")
  private WebElementFacade txtSearchOptionImages;

  @FindBy(xpath = "//div[@class='hdtb-mitem hdtb-msel hdtb-imb']")
  private WebElementFacade txtSearchOptionVideos;

  private String txtResults = "//h3[contains(text(),'result')]";

  private String txtTitleFirstPage =
          "//title[contains(text(),'result1') and contains(text(),'result2')]";

  private String txtTitles = "//div[@id='search']//child::h3[1][text()='result']";

  private String txtPageToGo = "//tr[@valign='top']//a[@aria-label='Page ";

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
    for (int i = 0; i < lstSearch.size(); i++) {
      String search = lstSearch.get(i);
      for (int i1 = 0; i1 < lstSearch2.size(); i1++) {
        String s = lstSearch2.get(i1);
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

  public void clickOnTheOptionNext() { txtOptionNext.click(); }

  public void clickOnTheOptionPrevious() { txtOptionPrevious.click(); }

  public void clickOnNumberOfPage(int intPageToGo) {
    String title = txtPageToGo + intPageToGo + "']";
    WebElementFacade txtTittle = find(By.xpath(title));
    txtTittle.click();
  }

  public boolean goToThatSearchResultsPage(int intPageToGo) {
    return txtPageToBe.getText().equals(String.valueOf(intPageToGo));
  }

  public void searchOptionLink(String strSearchOptionEng, String strSearchOptionEsp) {
    for (int i = 0; i<lstSearchOptionLink.size(); i++) {
      WebElement search = lstSearchOptionLink.get(i);
      if (search.getText().equals(strSearchOptionEng) || search.getText().equals(strSearchOptionEsp)) search.click();
    }


  }

  public boolean searchOptionPage(String strSearchOptionEng, String strSearchOptionEsp) {

    switch (strSearchOptionEng){
      case "News": if (txtSearchOptionNews.isPresent())       return true;
      case "Images": if (txtSearchOptionImages.isPresent())   return true;
    }
    switch (strSearchOptionEsp){
      case "Noticias": if (txtSearchOptionNews.isPresent())   return true;
      case "Imágenes": if (txtSearchOptionImages.isPresent()) return true;
      default: return false;
    }
  }
}
