package com.waes.assignment.automation.backend;

import com.waes.assignment.automation.backend.model.User;
import com.waes.assignment.automation.backend.steps.ApiHandler;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import static com.waes.assignment.automation.backend.model.Endpoints.DELETE;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "classpath:features/")
public class FunctionalTests {

    static ApiHandler apiHandler = ApiHandler.getInstance();

    @AfterClass
    public static void tearDown() {
        System.out.println("-----------TEAR DOWN-------------");
        for (User user : apiHandler.getRegisteredUsers()) {
            apiHandler.withAuth(user.getUsername(), user.getPw()).deleteRequest(DELETE.getURI());
        }
    }
}
