package com.waes.assignment.automation.backend.steps;

import com.google.common.net.MediaType;
import com.waes.assignment.automation.backend.model.User;
import net.thucydides.core.annotations.Step;

import static com.waes.assignment.automation.backend.model.Endpoints.SIGN_UP;

public class SignUpStepsExecutor extends BaseStepExecutor {

    public void signUpUser(User user) {
        apiHandler.addRegisteredUser(user);
        apiHandler.withHeader("username", user.getUsername())
                .withContentType(MediaType.JSON_UTF_8)
                .postRequest(SIGN_UP.getURI(), user);
    }

}
