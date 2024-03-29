package com.waes.assignment.automation.backend.steps;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waes.assignment.automation.backend.model.User;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;

public class CommonStepsDefinition {

    @Steps
    CommonStepsExecutor commonSteps;

    @Given("^I have (.*?) already registered in the system$")
    public void iHaveUserPasswordAlreadyRegisteredInTheSystem(String dummyParam) {
        //This step is written for clarity, we already have the users in the system =)
    }

    @Then("I should receive a {int} status code")
    public void checkStatusCode(int statusCode){
        Assert.assertThat(commonSteps.getStatusCode(), is(statusCode));
    }

    @Then("^I should see the hero information in the JSON response$")
    public void iShouldSeeTheInformationInTheJSONResponse(DataTable information) {
        User user = convertDataTableToUser(information);
        commonSteps.allUserInformationMatchTheJSON(user);
    }

    @Then("^I should see the error information in the JSON response$")
    public void iShouldSeeTheErrorInformationInTheJSONResponse(DataTable information) {
        commonSteps.allErrorInformationMatchTheJSON(information);
    }


    @Then("^I should see that hero (.*?) is in the JSON response$")
    public void iShouldSeeThatHeroAdminIsInTheJSONResponse(String userName, DataTable information) {
        User user = convertDataTableToUser(information);
        commonSteps.userInformationShouldBeInJSON(user, userName);
    }

    private User convertDataTableToUser(DataTable userInformation) {
        final ObjectMapper mapper = new ObjectMapper().disable(MapperFeature.AUTO_DETECT_IS_GETTERS);
        return mapper.convertValue(userInformation.asMaps(String.class,String.class).get(0), User.class);
    }
}
