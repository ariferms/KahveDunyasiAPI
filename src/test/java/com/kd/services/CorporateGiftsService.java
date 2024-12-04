package com.kd.services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CorporateGiftsService extends BaseTest{
    public Response corporateGifts(String token, String corporateBody){
        Response response = given(spec)
                .when()
                .accept("application/json, text/plain, */*")
                .header("Authorization", "Bearer " + token)
                .header("X-Language-Id", "tr-TR")
                .header("Accept-Language", "tr-TR,tr;q=0.9,en-US;q=0.8,en;q=0.7")
                .contentType(ContentType.JSON)
                .body(corporateBody)
                .post("v1/main/contact/corporate-gifts");
        response
                .then()
                .statusCode(200);
        return response;
    }
}
