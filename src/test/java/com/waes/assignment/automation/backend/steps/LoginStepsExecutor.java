package com.waes.assignment.automation.backend.steps;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.springframework.beans.factory.annotation.Value;

import static com.waes.assignment.automation.backend.model.Endpoints.LOG_IN;

public class LoginStepsExecutor extends BaseStep {
    @Value("${baseURI:localhost:8081}")
    String baseURI;

    @Step("When I login with user {0}")
    public void loginWithUser(String username, String password) {
        lastReponse = SerenityRest
                .given()
                .auth().preemptive().basic(username, password)
                .when().log().all().get("http://localhost:8081/waesheroes/api/v1/" + LOG_IN.getURI());
    }
}
