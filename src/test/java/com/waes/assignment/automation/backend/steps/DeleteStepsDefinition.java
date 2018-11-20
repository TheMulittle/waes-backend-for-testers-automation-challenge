package com.waes.assignment.automation.backend.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.apache.http.HttpStatus;

import static com.waes.assignment.automation.backend.model.Endpoints.DELETE;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;


public class DeleteStepsDefinition {

    @Steps
    DeleteStepsExecutor deleteSteps;

    @Given("^I do not have (.*?) / (.*?) already registered in the system$")
    public void iDoNotHaveUserAlreadyRegisteredInTheSystem(String userName, String password) {
        deleteSteps.withAuth(userName, password)
                .deleteRequest(DELETE.getURI())
                .then().statusCode(anyOf(is(HttpStatus.SC_OK),is(HttpStatus.SC_NOT_FOUND), is(HttpStatus.SC_UNAUTHORIZED)));
    }

    @When("^I try to delete hero (.*?) / (.*?)$")
    public void iDeleteUser(String userName, String password) {
        deleteSteps.withAuth(userName, password)
                .deleteRequest(DELETE.getURI());
    }

    @When("^I try to call delete endpoint without authentication$")
    public void iTryToCallDeleteEndpointWithoutAuthentication() throws Throwable {
        deleteSteps.deleteRequest(DELETE.getURI());
    }
}
