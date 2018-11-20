package com.waes.assignment.automation.backend.steps;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waes.assignment.automation.backend.model.SignUpUser;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SignUpStepsDefinition {

    @Steps
    SignUpStepsExecutor signUpSteps;

    @When("^I sign-up user with following information:$")
    public void iSignUpUserWithFollowingInformation(DataTable userInformation) throws Throwable {
        SignUpUser user = convertDataTableToSingUpUser(userInformation);
        signUpSteps.signUpUser(user);
    }

    @Then("^I should see the new user information in the JSON response$")
    public void iShouldSeeTheNewUserInformationInTheJSONResponse(DataTable userInformation) throws Throwable {
        SignUpUser user = convertDataTableToSingUpUser(userInformation);
        signUpSteps.matchNewUserInformationMatchesJson(user);
    }


    private SignUpUser convertDataTableToSingUpUser(DataTable userInformation) {
        final ObjectMapper mapper = new ObjectMapper().disable(MapperFeature.AUTO_DETECT_IS_GETTERS);
        return mapper.convertValue(userInformation.asMaps(String.class,String.class).get(0), SignUpUser.class);
    }
}
