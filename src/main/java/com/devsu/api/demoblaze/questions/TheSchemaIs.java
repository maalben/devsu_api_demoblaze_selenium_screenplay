package com.devsu.api.demoblaze.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static com.devsu.api.demoblaze.util.constants.Constants.VALIDATION_SCHEMA;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class TheSchemaIs implements Question<Boolean> {

    private final String structure;

    public TheSchemaIs(String structure) {
        this.structure = structure;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse(VALIDATION_SCHEMA,
                        response -> response.assertThat()
                                .body(matchesJsonSchemaInClasspath("schemas/"+structure+".json"))
                )
        );
        return true;
    }

    public static TheSchemaIs expected(String structure) {
        return new TheSchemaIs(structure);
    }
}
