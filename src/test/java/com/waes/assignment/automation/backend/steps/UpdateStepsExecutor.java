package com.waes.assignment.automation.backend.steps;

import com.google.common.net.MediaType;
import com.waes.assignment.automation.backend.model.User;
import net.thucydides.core.annotations.Step;

import static com.waes.assignment.automation.backend.model.Endpoints.UPDATE;

public class UpdateStepsExecutor extends BaseStepExecutor {

    public void updateUser(String userName, String oldPw, User user) {
        apiHandler.addRegisteredUser(user);
        apiHandler.withAuth(userName, oldPw).withContentType(MediaType.JSON_UTF_8).putRequest(UPDATE.getURI(), user);
    }
}
