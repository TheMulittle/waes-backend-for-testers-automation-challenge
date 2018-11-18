package com.waes.assignment.automation.backend.steps;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static com.waes.assignment.automation.backend.model.Endpoints.LOG_IN;

public class LoginStepsExecutor extends BaseStep {

    @Step("When I login with user {0}")
    public void loginWithUser(String username, String password) {
        SerenityRest.given().auth().basic(username, password)
                    .when().get(LOG_IN.getURI());
    }

    @Step("Then I should receive the correct information for user {0}")
    public void assertUserInformation(String username, String password) {

    }
}
