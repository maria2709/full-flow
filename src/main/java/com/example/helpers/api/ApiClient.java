package com.example.helpers.api;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ApiClient {

    private final String baseUrl = "https://dog.ceo";
    public final int SUCCESS_STATUS_CODE = 200;

    private final RequestSpecification spec;

    public ApiClient() {
        this.spec = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .addFilter(new AllureRestAssured())
                .build();
    }

    @Step ("GET request to {endpoint}")
    public Response get(String endpoint) {
        return given()
                    .baseUri(baseUrl)
                .when()
                .get(endpoint);
    }

    @Step ("Verify response status code is {expectedStatusCode}")
    public void verifyStatusCode(Response response, int expectedStatusCode) {
        Allure.attachment("Response", response.getBody().prettyPrint());
        response.then().statusCode(expectedStatusCode);
    }

}