package com.waes.assignment.automation.backend.steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import static org.hamcrest.Matchers.is;

public class CommonStepsDefinition {

    @Steps
    CommonStepsExecutor commonSteps;

    @Then("I should receive a (\\d+) status code")
    public void checkStatusCode(int statusCode){
        Assert.assertThat(commonSteps.getStatusCode(), is(statusCode));
    }

    @Then("^I should see the user information in the JSON response$")
    public void iShouldSeeTheInformationInTheJSONResponse(DataTable information) throws Throwable {
        commonSteps.allUserInformationMatchTheJSON(information);
    }

    @Then("^I should see the error information in the JSON response$")
    public void iShouldSeeTheErrorInformationInTheJSONResponse(DataTable information) throws Throwable {
        commonSteps.allErrorInformationMatchTheJSON(information);
    }

    @Given("^I have (.*?) already registered in the system$")
    public void iHaveUserPasswordAlreadyRegisteredInTheSystem(String dummyParam) {
        //This step is written for clarity, we already have the users in the system =)
    }
}
