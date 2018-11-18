package com.waes.assignment.automation.backend.steps;

import cucumber.api.DataTable;
import net.thucydides.core.annotations.Step;

import java.util.Map;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CommonStepsExecutor extends BaseStep {

    @Step("Then I should receive the correct information for user {0}")
    public void assertUserInformation(String username, String password) {

    }

    @Step
    public int getStatusCode() {
        lastReponse.getBody().prettyPrint();
        return lastReponse.getStatusCode();
    }

    public void allUserInformationMatchTheJSON(DataTable information) {
        Map<String,String> informationMap = information.asMaps(String.class, String.class).get(0);
        lastReponse.then().body("dateOfBirth", containsString(informationMap.get("dateOfBirth")))
                          .body("email",       containsString(informationMap.get("email")))
                          .body("isAdmin",     equalTo(Boolean.valueOf(informationMap.get("isAdmin"))))
                          .body("name",        containsString(informationMap.get("name")))
                          .body("superpower",  containsString(informationMap.get("superpower")));
    }

    public void allErrorInformationMatchTheJSON(DataTable information) {
        Map<String,String> informationMap = information.asMaps(String.class, String.class).get(0);
        lastReponse.then().body("errorCode", is(Integer.valueOf(informationMap.get("errorCode"))))
                .body("errorMessage", containsString(informationMap.get("errorMessage")));
    }
}
