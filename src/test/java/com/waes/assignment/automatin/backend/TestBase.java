package com.waes.assignment.automatin.backend;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


@RunWith(SerenityRunner.class)
public abstract class TestBase{

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8081";
    }

    public Response getRequest(String URI) {
        return RestAssured.when().get(URI);
    }

    public TestBase authenticate(String user, String password) {
        RestAssured.basic(user, password);
        return this;
    }

}
