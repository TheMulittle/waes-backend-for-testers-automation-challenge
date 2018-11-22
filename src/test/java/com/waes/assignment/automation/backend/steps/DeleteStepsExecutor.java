package com.waes.assignment.automation.backend.steps;

import cucumber.api.DataTable;
import net.thucydides.core.annotations.Step;
import org.apache.http.HttpStatus;

import java.util.Map;

import static com.waes.assignment.automation.backend.model.Endpoints.DELETE;
import static org.hamcrest.Matchers.*;

public class DeleteStepsExecutor extends BaseStepExecutor {

    public void authenticatedDelete(String userName, String password) {
        apiHandler.withAuth(userName, password)
                .deleteRequest(DELETE.getURI());
    }

    public void callDelete() {
        apiHandler.deleteRequest(DELETE.getURI());
    }
}
