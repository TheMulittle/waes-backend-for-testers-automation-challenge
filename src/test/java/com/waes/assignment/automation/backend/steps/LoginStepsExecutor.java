package com.waes.assignment.automation.backend.steps;

import net.thucydides.core.annotations.Step;

import static com.waes.assignment.automation.backend.model.Endpoints.LOG_IN;

public class LoginStepsExecutor {

    ApiHandler apiHandler = ApiHandler.getInstance();

    @Step("When I login with user {0}")
    public void loginWithUser(String username, String password) {
        apiHandler.lastResponse = apiHandler.withAuth(username, password).getRequest(LOG_IN.getURI());
    }
}
