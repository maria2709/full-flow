package com.example.helpers.api;

import io.restassured.RestAssured;
import io.qameta.allure.restassured.AllureRestAssured;

public class RestAssuredConfig {

    private static boolean initialized = false;

    private RestAssuredConfig() {}

    public static void init() {
        if (!initialized) {
            RestAssured.filters(new AllureRestAssured());
            initialized = true;
        }
    }
}
