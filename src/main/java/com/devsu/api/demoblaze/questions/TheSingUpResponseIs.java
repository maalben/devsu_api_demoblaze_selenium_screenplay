package com.devsu.api.demoblaze.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class TheSingUpResponseIs implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse("The response service is empty",
                        response -> response.assertThat()
                                .equals("")
                ));
        return true;
    }

    public static TheSingUpResponseIs empty() {
        return new TheSingUpResponseIs();
    }

}
