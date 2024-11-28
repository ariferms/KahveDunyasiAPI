package com.kd.services;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class MyOrdersService extends BaseTest {
    public Response getMyOrders(String token, String tenantId){
        Response response = given(spec)
                .when()
                .accept("application/json, text/plain, */*")
                .header("Authorization", "Bearer " + token)
                .queryParam("tenantId", tenantId)
                .queryParam("Page", "1")
                .queryParam("PageSize", "10")
                .get("v1/main/order/my-orders");
        response
                .then()
                .statusCode(200);
        return response;
    }
}
