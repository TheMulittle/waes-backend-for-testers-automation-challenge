package com.waes.assignment.automation.backend.steps;

import com.google.common.net.MediaType;
import com.waes.assignment.automation.backend.model.SignUpUser;
import net.thucydides.core.annotations.Step;

import static com.waes.assignment.automation.backend.model.Endpoints.SIGN_UP;

public class SignUpStepsExecutor extends BaseStep {

    @Step
    public void signUpUser(SignUpUser user) {
        this.withHeader("username", user.getUsername())
                .withContentType(MediaType.JSON_UTF_8)
                .postRequest(SIGN_UP.getURI(), user);
    }
}
