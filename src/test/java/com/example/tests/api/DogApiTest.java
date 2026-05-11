package com.example.tests.api;

import com.example.models.RandomImage;
import io.qameta.allure.Step;
import io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;
import com.example.helpers.api.ApiClient;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class DogApiTest {

    private final String imageRandomEndpoint = "/api/breeds/image/random";
    private final String STATUS_SUCCESS = "success";

    private final ApiClient apiClient = new ApiClient();

    @Test
    void getRandomDogImage() {
        Response getRandomDogImageResponse = apiClient.get(imageRandomEndpoint);
        apiClient.verifyStatusCode(getRandomDogImageResponse, apiClient.SUCCESS_STATUS_CODE);
        RandomImage actualRandomImageBody = getRandomDogImageResponse.as(RandomImage.class);
        assertEquals(actualRandomImageBody.getStatus(), STATUS_SUCCESS);
        assertNotNull(actualRandomImageBody.getStatus());
    }
}
