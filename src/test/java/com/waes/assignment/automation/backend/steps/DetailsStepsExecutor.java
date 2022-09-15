package com.waes.assignment.automation.backend.steps;

import com.waes.assignment.automation.backend.model.Endpoints;
import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.Step;

import java.util.Map;

import static com.waes.assignment.automation.backend.model.Endpoints.USER_INFORMATION;
import static org.hamcrest.Matchers.*;

public class DetailsStepsExecutor extends BaseStepExecutor {

    public void retrieveUserDetails(String userName) {
        apiHandler.getRequest(USER_INFORMATION.getURI(), userName);
    }
}
