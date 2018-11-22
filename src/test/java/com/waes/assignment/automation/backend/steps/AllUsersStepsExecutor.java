package com.waes.assignment.automation.backend.steps;

import net.thucydides.core.annotations.Step;

import static com.waes.assignment.automation.backend.model.Endpoints.ALL_USERS;

public class AllUsersStepsExecutor extends BaseStepExecutor {

    public void retrieveAllUserInformation(String username, String password) {
        apiHandler.withAuth(username, password).getRequest(ALL_USERS.getURI());
    }
}
