package com.devsu.api.demoblaze.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheLoginIs implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {

        return SerenityRest.lastResponse().body().asString().contains("Auth_token");
    }

    public static TheLoginIs successful() {
        return new TheLoginIs();
    }

}
