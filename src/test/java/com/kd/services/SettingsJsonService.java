package com.kd.services;

import io.restassured.response.Response;

import java.security.PublicKey;

import static io.restassured.RestAssured.given;

public class SettingsJsonService extends BaseTest{
    public Response getSettings(){
        Response response = given()
                .log().all()
                .when()
                .get("https://cdn-dev-kahvedunyasi.mncdn.com/settings/settings.json");
        response
                .then()
                .statusCode(200)
                .log().all();
        return response;
    }
    public Response getMyWidgetSettings(){
        Response response = given()
                .log().all()
                .when()
                .accept("application/json, text/javascript, */*; q=0.01")
                .header("Accept-Language", "tr-TR,tr;q=0.9,en-US;q=0.8,en;q=0.7")
                .header("priority", "u=1, i")
                .queryParam("widget_key", "ddcfe043f377497dee037003d5fde39cd8fab9f61d68ed071a2958e7302ea3daecdca207f1715c14242afc7b76cef3b1b612a36dd83bd03ce73a085cfa399d63fd405feba823be7357c74088e362f3a4593f3e4519a1466db0c86c5aaff621a8991add4efeec")
                .queryParam("escapeHtml", false)
                .get("https://kahvedunyasi.alo-tech.com/chat/get_my_widget_settings");
        response
                .then()
                .statusCode(200)
                .log().all();
        return response;
    }
}
