package com.devsu.api.demoblaze.taks;

import com.devsu.api.demoblaze.util.templates.MergeFrom;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.Date;
import java.util.Map;

import static com.devsu.api.demoblaze.util.constants.Constants.*;

public class Create implements Task {
    private final String template;
    private final Map<String, String> clientData;

    public Create(String template, Map<String, String> clientData) {
        this.template = template;
        this.clientData = clientData;
    }

    public static Create messageBody(String template, Map<String, Object> clientData) {
        return Tasks.instrumented(Create.class, template, clientData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String actualUser = clientData.get(USERNAME);
        if (actualUser.equals(USER_DEFAULT)){
            int timeInteger = (int) (new Date().getTime()/1000);
            clientData.remove(USERNAME);
            clientData.put(USERNAME,actualUser+""+timeInteger);
        }

        String templatePath = String.format(PATH_TEMPLATE, template);
        String body = MergeFrom.template(templatePath).withFieldsFrom(clientData);

        actor.remember(BODY, body);
    }
}
