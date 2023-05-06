package com.devsu.api.demoblaze.stepdefinitions;

import com.devsu.api.demoblaze.exceptions.AssertionsServices;
import com.devsu.api.demoblaze.models.TestData;
import com.devsu.api.demoblaze.questions.TheLoginIs;
import com.devsu.api.demoblaze.taks.Create;
import com.devsu.api.demoblaze.taks.SingInPost;
import com.devsu.api.demoblaze.util.resource.WebServiceEndPoints;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static com.devsu.api.demoblaze.exceptions.AssertionsServices.THE_LOGIN_IS_NOT_SUCCESSFUL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SingInStepdefinitions {

    @When("I Call service to login user")
    public void iCallServiceToLoginUser() {
        theActorInTheSpotlight().attemptsTo(
                Create.messageBody("singIn.json", TestData.getData())
        );
        theActorInTheSpotlight().attemptsTo(
                SingInPost.service(WebServiceEndPoints.URI_SINGIN.getUrl())
        );
    }

    @Then("I should get the token authentication")
    public void iShouldGetTheTokenAuthentication() {
        theActorInTheSpotlight()
                .should(seeThat(TheLoginIs.successful())
                        .orComplainWith(AssertionsServices.class,
                                THE_LOGIN_IS_NOT_SUCCESSFUL)
                );
    }

//    @Then("I Should see that message error is {string}")
//    public void iShouldSeeThatMessageErrorIs(String message) {
//
//        theActorInTheSpotlight()
//                .should(seeThat(TheExistUser.message(), equalTo(message))
//                        .orComplainWith(AssertionsServices.class,
//                                THE_MESSAGE_ERROR_IS_NOT_EXPECTED)
//                );
//    }
}