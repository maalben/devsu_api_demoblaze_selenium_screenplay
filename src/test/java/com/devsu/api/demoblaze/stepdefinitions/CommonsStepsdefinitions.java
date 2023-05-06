package com.devsu.api.demoblaze.stepdefinitions;

import com.devsu.api.demoblaze.exceptions.AssertionsServices;
import com.devsu.api.demoblaze.questions.StatusCode;
import com.devsu.api.demoblaze.questions.TheSchemaIs;
import com.devsu.api.demoblaze.taks.Load;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.util.List;
import java.util.Map;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CommonsStepsdefinitions {

    @Given("Load user information")
    public void loadUserInformation(List<Map<String, String>> clientDetails) {
        theActorInTheSpotlight().wasAbleTo(
                Load.testData(clientDetails.get(0))
        );
    }

    @Then("I Should see the code {int}")
    public void iShouldSeeTheCode(int responseCode) {
        theActorInTheSpotlight()
                .should(seeThat(StatusCode.is(responseCode))
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.THE_STATUS_CODE_SERVICE_IS_NOT_EXPECTED)
                );
    }

    @Then("Validate schema request {string}")
    public void validateSchemaRequest(String schemaResponse) {
        theActorInTheSpotlight()
                .should(seeThat(TheSchemaIs.expected(schemaResponse))
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.SCHEMA_SERVICE_IS_NOT_EXPECTED)
                );
    }

}
