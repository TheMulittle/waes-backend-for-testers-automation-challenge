package com.waes.assignment.automation.backend.steps;


import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LoginStepsDefinition {

    @Steps
    LoginStepsExecutor loginSteps;

    @When("^I login with the following credentials: (.*?) / (.*?)$")
    public void loginWithCredentials(String user, String password) {
        loginSteps.loginWithUser(user, password);
    }
}
