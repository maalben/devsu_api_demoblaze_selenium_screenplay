package com.devsu.api.demoblaze.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = SnippetType.CAMELCASE,
        features = "src/test/resources/features/singin.feature",
        glue = {"com.devsu.api.demoblaze.stepdefinitions.hook",
                "com.devsu.api.demoblaze.stepdefinitions"
        }
)
public class SingInRunner {
}
