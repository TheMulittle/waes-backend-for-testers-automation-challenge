package com.waes.assignment.automation.backend.steps;

import com.waes.assignment.automation.backend.model.Endpoints;
import cucumber.api.DataTable;
import net.thucydides.core.annotations.Step;

import java.util.Map;

import static com.waes.assignment.automation.backend.model.Endpoints.USER_INFORMATION;
import static org.hamcrest.Matchers.*;

public class DetailsStepsExecutor extends BaseStep {

    @Step("Then I should receive the correct information for user {0}")
    public void assertUserInformation(String username, String password) {

    }

    @Step
    public void retrieveUserDetails(String userName) {
        getRequest(USER_INFORMATION.getURI(), userName);
    }
}
