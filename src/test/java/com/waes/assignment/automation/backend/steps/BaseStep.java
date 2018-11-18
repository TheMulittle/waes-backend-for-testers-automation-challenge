package com.waes.assignment.automation.backend.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;


public abstract class BaseStep {

    public Response getRequest(String URI) {
        return SerenityRest.when().get(URI);
    }

    public BaseStep authenticate(String user, String password) {
        SerenityRest.basic(user, password);
        return this;
    }

}
