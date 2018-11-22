package com.waes.assignment.automation.backend.steps;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waes.assignment.automation.backend.model.User;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class UpdateStepsDefinition {

    @Steps
    UpdateStepsExecutor updateSteps;

    @When("^I update hero with credentials (.*?) / (.*?) to:$")
    public void iUpdateHeroWithCredentials(String userName, String oldPw, DataTable information) throws Throwable {
        User user = convertDataTableToUser(information);
        updateSteps.updateUser(userName, oldPw, user);
    }

    private User convertDataTableToUser(DataTable userInformation) {
        final ObjectMapper mapper = new ObjectMapper().disable(MapperFeature.AUTO_DETECT_IS_GETTERS);
        return mapper.convertValue(userInformation.asMaps(String.class,String.class).get(0), User.class);
    }

}
