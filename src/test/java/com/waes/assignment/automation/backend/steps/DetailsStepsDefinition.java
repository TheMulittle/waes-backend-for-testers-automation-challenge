package com.waes.assignment.automation.backend.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class DetailsStepsDefinition {

    @Steps
    DetailsStepsExecutor detailsSteps;

    @When("^I retrieve (.*?) hero details$")
    public void iRetrieveAdminHeroDetails(String userName) throws Throwable {
        detailsSteps.retrieveUserDetails(userName);
    }
}
