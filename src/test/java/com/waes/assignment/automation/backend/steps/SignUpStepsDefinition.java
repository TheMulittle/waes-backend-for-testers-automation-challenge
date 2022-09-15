package com.waes.assignment.automation.backend.steps;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waes.assignment.automation.backend.model.User;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SignUpStepsDefinition {

    @Steps
    SignUpStepsExecutor signUpSteps;

    @Given("^I have hero with following information already registered:$")
    @When("^I sign-up hero with following information:$")
    public void iSignUpUserWithFollowingInformation(DataTable userInformation) {
        User user = convertDataTableToSingUpUser(userInformation);
        signUpSteps.signUpUser(user);
    }

    private User convertDataTableToSingUpUser(DataTable userInformation) {
        final ObjectMapper mapper = new ObjectMapper().disable(MapperFeature.AUTO_DETECT_IS_GETTERS);
        return mapper.convertValue(userInformation.asMaps(String.class,String.class).get(0), User.class);
    }
}
