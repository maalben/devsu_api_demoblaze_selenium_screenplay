package com.devsu.api.demoblaze.taks;

import com.devsu.api.demoblaze.interactions.ExecutePost;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static com.devsu.api.demoblaze.util.constants.Constants.BODY;

public class SingInPost implements Task {
    private final String resource;

    public SingInPost(String resource) {
        this.resource = resource;
    }

    public static SingInPost service(String resource) {
        return Tasks.instrumented(SingInPost.class, resource);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String body = actor.recall(BODY).toString();
        actor.attemptsTo(ExecutePost.service(resource, body));
    }
}