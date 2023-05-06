package com.devsu.api.demoblaze.stepdefinitions.hook;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import static com.devsu.api.demoblaze.util.constants.Constants.*;
import static java.lang.System.getProperty;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Hook {
    private EnvironmentVariables environmentVariables;

    @Before
    public void configureBaseUrl() {

        OnStage.setTheStage(new OnlineCast());
        theActorCalled(ACTOR);
        String theRestApiBaseUrl = environmentVariables.getProperty(ENVIRONMENT+getProperty("env")+BASE_URL);
        theActorInTheSpotlight().whoCan(CallAnApi.at(theRestApiBaseUrl));
    }
}