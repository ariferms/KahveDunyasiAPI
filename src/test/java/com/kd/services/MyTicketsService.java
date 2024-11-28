package com.kd.services;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class MyTicketsService extends BaseTest{
    public Response getMyTicketsPage(String token){
        Response response = given(spec)
                .when()
                .accept("application/json, text/plain, */*")
                .header("Authorization", "Bearer " + token)
                .queryParam("Page", "1")
                .queryParam("PageSize", "5")
                .get("v1/main/ticket/my-tickets");
        response
                .then()
                .statusCode(200);
        return response;
    }
}
