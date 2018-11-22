package com.waes.assignment.automation.backend.steps;

import com.waes.assignment.automation.backend.model.User;
import cucumber.api.DataTable;
import net.thucydides.core.annotations.Step;

import java.util.Map;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class CommonStepsExecutor extends BaseStepExecutor {

    public void assertUserInformation(String username, String password) {

    }

    public int getStatusCode() {
        apiHandler.lastResponse.getBody().prettyPrint();
        return apiHandler.lastResponse.getStatusCode();
    }

    public void allUserInformationMatchTheJSON(User user) {
        apiHandler.lastResponse.then().body("dateOfBirth", is(user.getDateOfBirth()))
                .body("email",       is(user.getEmail()))
                .body("isAdmin",     is(user.isAdmin()))
                .body("name",        is(user.getName()))
                .body("superpower",  is(user.getSuperpower()));
    }

    public void allErrorInformationMatchTheJSON(DataTable information) {
        Map<String,String> informationMap = information.asMaps(String.class, String.class).get(0);
        apiHandler.lastResponse.then().body("errorCode", is(Integer.valueOf(informationMap.get("errorCode"))))
                .body("errorMessage", containsString(informationMap.get("errorMessage")));
    }

    public void userInformationShouldBeInJSON(User user, String userName) {
        apiHandler.lastResponse.then().root(userName)
                .body("email",       is(user.getEmail()))
                .body("isAdmin",     is(user.isAdmin()))
                .body("name",        is(user.getName()))
                .body("superpower",  is(user.getSuperpower()));
    }
}
