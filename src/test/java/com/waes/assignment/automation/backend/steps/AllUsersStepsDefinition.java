package com.waes.assignment.automation.backend.steps;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class AllUsersStepsDefinition {

    @Steps
    AllUsersStepsExecutor  allUsersSteps;

    @When("^I retrieve all heroes information with (.*?) / (.*?)$")
    public void iRetrieveAllHeroesInformation(String userName, String password) {
        allUsersSteps.retrieveAllUserInformation(userName, password);
    }

}
