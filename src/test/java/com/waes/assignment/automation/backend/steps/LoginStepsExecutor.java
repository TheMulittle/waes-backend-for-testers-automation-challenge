package com.waes.assignment.automation.backend.steps;

import net.thucydides.core.annotations.Step;

import static com.waes.assignment.automation.backend.model.Endpoints.LOG_IN;

public class LoginStepsExecutor extends BaseStepExecutor {

    public void loginWithUser(String username, String password) {
        apiHandler.lastResponse = apiHandler.withAuth(username, password).getRequest(LOG_IN.getURI());
    }
}
