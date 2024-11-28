package com.kd.services;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class MyAddressService extends BaseTest{
    public Response getMyAddress(String token){
        Response response = given(spec)
                .when()
                .accept("application/json, text/plain, */*")
                .header("Authorization", "Bearer " + token)
                .get("v1/cdh/user/address/get-by-customer");
        response
                .then()
                .statusCode(200);
        return response;
    }
}
