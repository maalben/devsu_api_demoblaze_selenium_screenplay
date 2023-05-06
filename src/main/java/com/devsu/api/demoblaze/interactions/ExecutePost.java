package com.devsu.api.demoblaze.interactions;

import com.devsu.api.demoblaze.exceptions.ErrorServicesException;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.apache.http.HttpStatus;
import static com.devsu.api.demoblaze.util.constants.Constants.EXCEPTION_ERROR_CONSUMPTION_SERVICE;
import static io.restassured.http.ContentType.JSON;

public class ExecutePost implements Interaction {
    private final String resource;
    private final String body;

    public ExecutePost(String resource, String body) {
        this.resource = resource;
        this.body = body;
    }

    public static ExecutePost service(String resource, String body) {
        return Tasks.instrumented(ExecutePost.class, resource, body);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        actor.attemptsTo(
                Post.to(resource)
                        .with(request -> request.
                                contentType(JSON)
                                .body(body)
                                .relaxedHTTPSValidation()
                        )
        );

        if(SerenityRest.lastResponse().statusCode() != HttpStatus.SC_OK){
            throw new ErrorServicesException(EXCEPTION_ERROR_CONSUMPTION_SERVICE);
        }
    }
}
