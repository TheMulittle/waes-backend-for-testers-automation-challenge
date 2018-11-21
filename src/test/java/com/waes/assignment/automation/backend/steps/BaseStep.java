package com.waes.assignment.automation.backend.steps;

import com.google.common.net.MediaType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;


public abstract class BaseStep {

    private static final String BASE_URI = "http://localhost:8081/waesheroes/api/v1/";

    static Response lastResponse;

    static RequestSpecification spec = SerenityRest.given().log().all();

    public BaseStep withAuth(String hero, String password) {
        spec = spec.auth().preemptive().basic(hero, password);
        return this;
    }

    public BaseStep withHeader(String header, String value) {
        spec = spec.given().header(header, value);
        return this;
    }

    /*public Response getRequest(String URI) {
        lastResponse = spec.when().log().all().get(BASE_URI+ URI);
        spec = SerenityRest.given().log().all();
        return lastResponse;
    }*/

    public Response getRequest(String URI, String... parameters) {
        lastResponse = spec.when().log().all().get(BASE_URI+ URI, parameters);
        spec = SerenityRest.given().log().all();
        return lastResponse;
    }

    public Response postRequest(String URI, Object body) {
        lastResponse = spec.given().body(body).when().log().all().post(BASE_URI+ URI);
        spec = SerenityRest.given().log().all();
        return lastResponse;
    }

    public Response deleteRequest(String URI) {
        lastResponse = spec.given().when().log().all().delete(BASE_URI+ URI);
        spec = SerenityRest.given().log().all();
        return lastResponse;
    }

    protected BaseStep withContentType(MediaType contentType) {
        spec = spec.contentType(contentType.toString());
        return this;
    }
}
