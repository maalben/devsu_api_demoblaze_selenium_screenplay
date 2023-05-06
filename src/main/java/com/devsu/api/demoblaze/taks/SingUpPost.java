package com.devsu.api.demoblaze.taks;

import com.devsu.api.demoblaze.interactions.ExecutePost;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import static com.devsu.api.demoblaze.util.constants.Constants.BODY;

public class SingUpPost implements Task {
    private final String resource;

    public SingUpPost(String resource) {
        this.resource = resource;
    }

    public static SingUpPost service(String resource) {
        return Tasks.instrumented(SingUpPost.class, resource);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String body = actor.recall(BODY).toString();
        actor.attemptsTo(ExecutePost.service(resource, body));
    }
}