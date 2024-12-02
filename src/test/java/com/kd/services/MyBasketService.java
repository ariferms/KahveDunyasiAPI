package com.kd.services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class MyBasketService extends BaseTest{
    public Response getMyBasket(String token, String tenantId){
        Response response = given(spec)
                .when()
                .accept("application/json, text/plain, */*")
                .header("Authorization", "Bearer " + token)
                .queryParam("tenantId", tenantId)
                .get("v1/pim/complementary-products/basket");
        response
                .then()
                .statusCode(200);
        return response;
    }
    public Response postApprove(String token, String basketType, String basketId){
        Response response = given(spec)
                .when()
                .accept("application/json, text/plain, */*")
                .header("Authorization", "Bearer " + token)
                .queryParam("basketType", basketType)
                .queryParam("id", basketId)
                .contentType(ContentType.JSON)
                .body("")
                .post("v1/main/basket/approve");
        response
                .then()
                .statusCode(200);
        return response;
    }
    public Response postShipmentOptions(String token, String tenantType, String basketId){

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("tenantType", tenantType);
        requestBody.put("basketId", basketId);

        Response response = given(spec)
                .when()
                .accept("application/json, text/plain, */*")
                .header("Authorization", "Bearer " + token)
                .header("X-Language-Id", "tr-TR")
                .header("Accept-Language", "tr-TR,tr;q=0.9,en-US;q=0.8,en;q=0.7")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("v1/main/shipment/shipment-options");
        response
                .then()
                .statusCode(200);
        return response;
    }
}
