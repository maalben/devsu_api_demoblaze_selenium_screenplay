package com.devsu.api.demoblaze.stepdefinitions;

import com.devsu.api.demoblaze.exceptions.AssertionsServices;
import com.devsu.api.demoblaze.models.TestData;
import com.devsu.api.demoblaze.questions.TheError;
import com.devsu.api.demoblaze.questions.TheSingUpResponseIs;
import com.devsu.api.demoblaze.taks.Create;
import com.devsu.api.demoblaze.taks.SingUpPost;
import com.devsu.api.demoblaze.util.resource.WebServiceEndPoints;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.devsu.api.demoblaze.exceptions.AssertionsServices.THE_MESSAGE_ERROR_IS_NOT_EXPECTED;
import static com.devsu.api.demoblaze.exceptions.AssertionsServices.THE_SERVICE_RESPONSE_IS_NOT_EMPTY;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class SingUpStepdefinitions {

    @When("I Call service to create new user")
    public void iCallServiceToCreateNewUser() {
        theActorInTheSpotlight().attemptsTo(
                Create.messageBody("singUp.json", TestData.getData())
        );
        theActorInTheSpotlight().attemptsTo(
                SingUpPost.service(WebServiceEndPoints.URI_SIGNUP.getUrl())
        );
    }

    @Then("I Should see that response is empty")
    public void iShouldSeeThatResponseIsEmpty() {
        theActorInTheSpotlight()
                .should(seeThat(TheSingUpResponseIs.empty())
                        .orComplainWith(AssertionsServices.class,
                                THE_SERVICE_RESPONSE_IS_NOT_EMPTY)
                );
    }

    @Then("I Should see that message error is {string}")
    public void iShouldSeeThatMessageErrorIs(String message) {

        theActorInTheSpotlight()
                .should(seeThat(TheError.message(), equalTo(message))
                        .orComplainWith(AssertionsServices.class,
                                THE_MESSAGE_ERROR_IS_NOT_EXPECTED)
                );
    }
}