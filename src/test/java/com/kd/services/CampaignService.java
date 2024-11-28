package com.kd.services;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CampaignService extends BaseTest {
    public Response getMyCampaingPage(String token, String tenantId){
        Response response = given(spec)
                .when()
                .accept("application/json, text/plain, */*")
                .header("Authorization", "Bearer " + token)
                .queryParam("tenantId", tenantId)
                .get("v1/campaign-provider/campaign-coupon");
        response
                .then()
                .statusCode(200);
        return response;
    }
}
