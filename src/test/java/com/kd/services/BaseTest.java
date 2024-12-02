package com.kd.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class BaseTest {
    RequestSpecification spec;
    public String basketType = "OnlineStore" ,
            tenantType = basketType,
            tenantId = "d0f29b68-329e-423b-8fca-aaab198513c1",
            basketId = "b7c10d94-d7e0-46cb-af76-1fe16c6ff77e";
    public static String token;

    public BaseTest() {
        spec = new RequestSpecBuilder()
                .setBaseUri("http://gateway-dev.apps.kahvedunyasi01.kahvedunyasi.local/api/")
                .addFilters(Arrays.<Filter>asList(new RequestLoggingFilter(), new ResponseLoggingFilter()))
                .build();
    }

    public JsonNode readJsonToFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new File(filePath));
        return rootNode;
    }

    public void writeJsonToFile(String json, String filePath) throws IOException {
        // JSON verisini bir dosyaya yazma
        File file = new File(filePath);
        FileWriter writer = new FileWriter(file);
        writer.write(json);
        writer.close();
        System.out.println("Response JSON yazıldı: " + filePath);
    }

}
