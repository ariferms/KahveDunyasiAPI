package com.kd.steps;

import com.fasterxml.jackson.databind.JsonNode;
import com.kd.services.LoginKDService;
import com.kd.services.WebHomePageService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class LoginSteps {
    LoginKDService loginKDService = new LoginKDService();
    WebHomePageService webHomePageService = new WebHomePageService();
    JsonNode loginBody,
            phoneNumberBody;
    String accessToken,
            basketType = loginKDService.basketType,
            tenantId = loginKDService.tenantId;
    ;
    Response loginKDServiceRes,
            phoneNuberOTPRes,
            webHomePageStoryRes,
            webHomePageUserMeRes,
            webHomePageBasketRes,
            webHomePageGetProductIdsRes;

    @Given("Kullanici login icin telefon numarasini girer")
    public void phoneNumberInsert() throws IOException {
        phoneNumberBody = loginKDService.readJsonToFile("src/test/java/com/kd/jsonRequest/phoneNumber.json");
    }

    @When("Numarayi girdikten sonra devam et butonuna tiklar")
    public void getOTPCode() {
        phoneNuberOTPRes = loginKDService.phoneNumber(phoneNumberBody.toString());
    }

    @When("Telefonuna gelen OTP kodunu girip devam et butonuna tiklar")
    public void loginApp() throws IOException {
        // Login body burada alinir
        loginBody = loginKDService.readJsonToFile("src/test/java/com/kd/jsonRequest/login.json");

        // Login servisine istek atilir
        loginKDServiceRes = loginKDService.loginKd(loginBody.toString());
        loginKDService.writeJsonToFile(loginKDServiceRes.getBody().asString(), "src/test/java/com/kd/jsonResponse/token.json");
        accessToken = loginKDServiceRes.jsonPath().getJsonObject("data.payload.accessToken").toString();

        // Ana sayfa servislerine istek gider ve ana sayfa yuklenir
        webHomePageStoryRes = webHomePageService.story();
        webHomePageUserMeRes = webHomePageService.userMe(accessToken);
        webHomePageBasketRes = webHomePageService.basket(basketType, accessToken);
        webHomePageGetProductIdsRes = webHomePageService.getProductIds(accessToken, tenantId);
    }

    @Then("OTP servisi kontrol edilir")
    public void otpControl() {
        Assertions.assertEquals("Success", phoneNuberOTPRes.jsonPath().getString("processStatus"), "phoneNuberOTP processStatus does not match!");
        Assertions.assertEquals(60, phoneNuberOTPRes.jsonPath().getInt("payload.expiresIn"), "expiresIn does not match!");
    }

    @Then("Kullanicinin login olup olmadigi kontrol edilir")
    public void userLoginControl() {
        Assertions.assertEquals("Success", loginKDServiceRes.jsonPath().getString("data.processStatus"), "Login processStatus does not match!");
        Assertions.assertNotEquals("", loginKDServiceRes.jsonPath().getJsonObject("data.payload.accessToken"), "accessToken is null!");
        Assertions.assertNotEquals("", loginKDServiceRes.jsonPath().getJsonObject("data.payload.refreshToken"), "refreshToken is null!");
        Assertions.assertNotEquals("", loginKDServiceRes.jsonPath().getJsonObject("data.payload.tokenType"), "tokenType is null!");
    }

    @Then("Ana sayfa servisleri kontrol edilir")
    public void homePageServicesControl() {
        Assertions.assertEquals("Success", webHomePageStoryRes.jsonPath().getString("processStatus"), "Story processStatus does not match!");
        Assertions.assertEquals("Success", webHomePageUserMeRes.jsonPath().getString("processStatus"), "UserMe processStatus does not match!");
        Assertions.assertEquals("Success", webHomePageBasketRes.jsonPath().getString("processStatus"), "Basket processStatus does not match!");
        Assertions.assertEquals("Success", webHomePageGetProductIdsRes.jsonPath().getString("processStatus"), "ProductIds processStatus does not match!");
    }
}
