package com.kd.services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LoginKDService extends BaseTest {
    public Response phoneNumber(String phoneNumberBody){
        Response response = given(spec)
                .when()
                .contentType(ContentType.JSON)
                .accept("application/json, text/plain, */*")
                .body(phoneNumberBody)
                .post("v1/auth/account/register/phone-number");
        response
                .then()
                .statusCode(200);
        return response;
    }
    public Response loginKd(String loginBody){
        Response response = given()
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .accept("application/json, text/plain, */*")
                .body(loginBody)
                .post("http://web-dev.apps.kahvedunyasi02.kahvedunyasi.local/api/login");
        response
                .then()
                .statusCode(200)
                .log().all();
        return response;
    }
}
