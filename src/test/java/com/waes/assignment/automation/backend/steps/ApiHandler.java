package com.waes.assignment.automation.backend.steps;

import com.google.common.net.MediaType;
import com.waes.assignment.automation.backend.model.User;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

import java.util.HashSet;
import java.util.Set;

public class ApiHandler {

    private static ApiHandler instance = new ApiHandler();

    public static ApiHandler getInstance() {
        return instance;
    }

    private static final String BASE_URI = "http://localhost:8081/waesheroes/api/v1/";

    static Set<User> registeredUsers = new HashSet<>();

    static Response lastResponse;

    static RequestSpecification spec = SerenityRest.given().log().all();

    public ApiHandler withAuth(String hero, String password) {
        spec = spec.auth().preemptive().basic(hero, password);
        return instance;
    }

    public ApiHandler withHeader(String header, String value) {
        spec = spec.given().header(header, value);
        return instance;
    }

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


    public Response putRequest(String URI, Object body) {
        lastResponse = spec.given().body(body).when().log().all().put(BASE_URI+ URI);
        spec = SerenityRest.given().log().all();
        return lastResponse;
    }

    public Response deleteRequest(String URI) {
        lastResponse = spec.given().when().log().all().delete(BASE_URI+ URI);
        spec = SerenityRest.given().log().all();
        return lastResponse;
    }

    protected ApiHandler withContentType(MediaType contentType) {
        spec = spec.contentType(contentType.toString());
        return instance;
    }

    public Set<User> getRegisteredUsers() {
        return registeredUsers;
    }

    public void addRegisteredUser(User user) {
        registeredUsers.add(user);
    }
}
