package com.waes.assignment.automation.backend.steps;

import cucumber.api.DataTable;
import net.thucydides.core.annotations.Step;
import org.apache.http.HttpStatus;

import java.util.Map;

import static com.waes.assignment.automation.backend.model.Endpoints.DELETE;
import static org.hamcrest.Matchers.*;

public class DeleteStepsExecutor {

    ApiHandler apiHandler = ApiHandler.getInstance();

    @Step("Then I should receive the correct information for user {0}")
    public void assertUserInformation(String username, String password) {

    }

    @Step
    public int getStatusCode() {
        apiHandler.lastResponse.getBody().prettyPrint();
        return  apiHandler.lastResponse.getStatusCode();
    }

    public void allUserInformationMatchTheJSON(DataTable information) {
        Map<String,String> informationMap = information.asMaps(String.class, String.class).get(0);
        apiHandler.lastResponse.then().body("dateOfBirth", containsString(informationMap.get("dateOfBirth")))
                          .body("email",       containsString(informationMap.get("email")))
                          .body("isAdmin",     equalTo(Boolean.valueOf(informationMap.get("isAdmin"))))
                          .body("name",        containsString(informationMap.get("name")))
                          .body("superpower",  containsString(informationMap.get("superpower")));
    }

    public void allErrorInformationMatchTheJSON(DataTable information) {
        Map<String,String> informationMap = information.asMaps(String.class, String.class).get(0);
        apiHandler.lastResponse.then().body("errorCode", is(Integer.valueOf(informationMap.get("errorCode"))))
                .body("errorMessage", containsString(informationMap.get("errorMessage")));
    }

    public void authenticatedDelete(String userName, String password) {
        apiHandler.withAuth(userName, password)
                .deleteRequest(DELETE.getURI());
    }

    public void callDelete() {
        apiHandler.deleteRequest(DELETE.getURI());
    }
}
