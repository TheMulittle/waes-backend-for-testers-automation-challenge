package com.waes.assignment.automation.backend.steps;

import com.google.common.net.MediaType;
import com.waes.assignment.automation.backend.model.User;
import net.thucydides.core.annotations.Step;

import static com.waes.assignment.automation.backend.model.Endpoints.SIGN_UP;
import static org.hamcrest.Matchers.is;

public class SignUpStepsExecutor {

    ApiHandler apiHandler = ApiHandler.getInstance();

    @Step
    public void signUpUser(User user) {
        apiHandler.registeredUsers.add(user);
        apiHandler.withHeader("username", user.getUsername())
                .withContentType(MediaType.JSON_UTF_8)
                .postRequest(SIGN_UP.getURI(), user);
    }

    @Step
    public void matchNewUserInformationMatchesJson(User user) {
        apiHandler.lastResponse.then()
                .body("isAdmin", is(user.isAdmin()))
                .body("dateOfBirth", is(user.getDateOfBirth()))
                .body("email", is(user.getEmail()))
                .body("name", is(user.getName()))
                .body("superpower", is(user.getSuperpower()));
    }
}
