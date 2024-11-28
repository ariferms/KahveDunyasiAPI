package com.kd.services;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class WebHomePageService extends BaseTest {
    public Response story(){
        Response response = given(spec)
                .when()
                .accept("application/json, text/plain, */*")
                .get("v1/story-provider/story");
        response
                .then()
                .statusCode(200);
        return response;
    }
    public Response basket(String basketType, String accessToken){
        Response response = given(spec)
                .when()
                .accept("application/json, text/plain, */*")
                .header("Authorization", "Bearer " + accessToken)
                .queryParam("BasketType", basketType)
                .queryParam("id", "3e35878f-5b29-4f25-96d2-57e2fdc4ac9e")
                .get("v1/main/basket");
        response
                .then()
                .statusCode(200);
        return response;
    }
    public Response userMe(String accessToken){
        Response response = given(spec)
                .when()
                .accept("application/json, text/plain, */*")
                .header("Authorization", "Bearer " + accessToken)
                .get("v1/cdh/user/me");
        response
                .then()
                .statusCode(200);
        return response;
    }
    public Response getProductIds(String accessToken, String tenantId){
        Response response = given(spec)
                .when()
                .accept("application/json, text/plain, */*")
                .header("Authorization", "Bearer " + accessToken)
                .queryParam("tenantId", tenantId)
                .get("v1/pim/favorite-product/get-product-ids");
        response
                .then()
                .statusCode(200);
        return response;
    }
}
