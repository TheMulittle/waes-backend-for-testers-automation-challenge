package com.waes.assignment.automation.backend.model;

import javax.print.DocFlavor;

public enum Endpoints {

    USER_INFORMATION("users/details?username={userName}"),
    ALL_USERS("users/all"),
    LOG_IN("users/access"),
    SIGN_UP("users"),
    UPDATE("users"),
    DELETE("users");

    private String URI;

    Endpoints(String URI) {
        this.URI = URI;
    }

    public String getURI() {
        return this.URI;
    }
}
