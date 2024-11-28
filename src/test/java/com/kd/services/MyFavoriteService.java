package com.kd.services;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class MyFavoriteService extends BaseTest{
    public Response getMyFavoritePage(String token, String tenantId){
        Response response = given(spec)
                .when()
                .accept("application/json, text/plain, */*")
                .header("Authorization", "Bearer " + token)
                .queryParam("tenantId", tenantId)
                .get("v1/pim/favorite-product");
        response
                .then()
                .statusCode(200);
        return response;
    }
}
