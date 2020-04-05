package com.google.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/google_homepage_search.feature", glue = "com.google.definitions", snippets = SnippetType.CAMELCASE)


public class HomePageSearchRunner {
  }
