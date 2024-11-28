package com.kd.steps;

import com.fasterxml.jackson.databind.JsonNode;
import com.kd.services.BaseTest;
import io.cucumber.java.en.Given;

import java.io.IOException;

public class TokenGenerate extends BaseTest {

    JsonNode tokenGet;

    @Given("Access Token alinir")
    public void getTokenGenerateFile() throws IOException {
        tokenGet = readJsonToFile("src/test/java/com/kd/jsonResponse/token.json");
        token = tokenGet.path("data")
                .path("payload")
                .path("accessToken")
                .asText();
    }
}
