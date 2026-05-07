package com.example.tests.api;

import io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import com.example.helpers.api.ApiClient;


public class DogApiTest {

    private final String imageRandomEndpoint = "/api/breeds/image/random";

    private final ApiClient apiClient = new ApiClient();

    @Test
    void getRandomDogImage() {
       Response getRandomDogImageResponse = apiClient.get(imageRandomEndpoint);
       apiClient.verifyStatusCode(getRandomDogImageResponse, apiClient.SUCCESS_STATUS_CODE);
    }
}
