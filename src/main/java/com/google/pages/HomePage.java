package com.google.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Keys;

@DefaultUrl("https://www.google.com/")
public class HomePage extends PageObject {

  @FindBy(name = "q")
  private WebElementFacade txtSearch;

  @FindBy(xpath = "//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']")
  private WebElementFacade btnSearch;

  @FindBy(xpath = "//ul[@role='listbox']//child::div[@class='sbl1'][1]")
  private WebElementFacade txtSugestionList;

  public void typeYourSearch(String strWhatToSearch) {
    txtSearch.sendKeys(strWhatToSearch);
  }

  public void getResults() {
    txtSearch.sendKeys(Keys.TAB);
    btnSearch.click();
  }

  public void sugestionList() {
    txtSugestionList.isPresent();
  }

  public void clickSugestion() {
    txtSugestionList.click();
  }
}
