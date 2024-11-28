package com.kd.services;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class MyPointsService extends BaseTest{
    public Response getMyPointsPage(String token){
        Response response = given(spec)
                .when()
                .accept("application/json, text/plain, */*")
                .header("Authorization", "Bearer " + token)
                .get("v1/cdh/user/my-points");
        response
                .then()
                .statusCode(200);
        return response;
    }
}
