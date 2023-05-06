package com.devsu.api.demoblaze.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheError implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {

        return SerenityRest.lastResponse().body().path("errorMessage");
    }

    public static TheError message() {
        return new TheError();
    }

}
