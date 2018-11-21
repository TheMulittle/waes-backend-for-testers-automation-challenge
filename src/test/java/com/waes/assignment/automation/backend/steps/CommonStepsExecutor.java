package com.waes.assignment.automation.backend.steps;

import com.waes.assignment.automation.backend.model.User;
import cucumber.api.DataTable;
import net.thucydides.core.annotations.Step;

import java.util.Map;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class CommonStepsExecutor extends BaseStep {

    @Step("Then I should receive the correct information for user {0}")
    public void assertUserInformation(String username, String password) {

    }

    @Step
    public int getStatusCode() {
        lastResponse.getBody().prettyPrint();
        return lastResponse.getStatusCode();
    }

    public void allUserInformationMatchTheJSON(User user) {
        lastResponse.then().body("dateOfBirth", is(user.getDateOfBirth()))
                .body("email",       is(user.getEmail()))
                .body("isAdmin",     is(user.isAdmin()))
                .body("name",        is(user.getName()))
                .body("superpower",  is(user.getSuperpower()));
    }

    public void allErrorInformationMatchTheJSON(DataTable information) {
        Map<String,String> informationMap = information.asMaps(String.class, String.class).get(0);
        lastResponse.then().body("errorCode", is(Integer.valueOf(informationMap.get("errorCode"))))
                .body("errorMessage", containsString(informationMap.get("errorMessage")));
    }
}
