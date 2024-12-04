package com.kd.steps;

import com.fasterxml.jackson.databind.JsonNode;
import com.kd.services.CorporateGiftsService;
import com.kd.services.MyBasketService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class CorporateGiftsSteps {
    CorporateGiftsService corporateGiftsService = new CorporateGiftsService();
    String getToken = corporateGiftsService.token,
            corporateBody;
    Response corporateGiftsRes;
    JsonNode corporateJson;

    @Given("Kullanici Kurumsal Hediyeler butonuna tiklar")
    public void clickCorporateGiftsButton() {
        System.out.println("Kullanici Kurumsal Hediyeler butonuna tiklar...");
    }
    @Given("Kullanici formu doldurur")
    public void inputTheForm() throws IOException {
        corporateJson = corporateGiftsService.readJsonToFile("src/test/java/com/kd/jsonRequest/corporateGiftsRequest.json");
        corporateBody = corporateJson.toString();
    }

    @When("Kullanici Gonder butonuna tiklayarak formu gonderir")
    public void postTheForm() {
        corporateGiftsRes = corporateGiftsService.corporateGifts(getToken, corporateBody);
    }

    @Then("Formun gonderildigi kontrol edilir")
    public void controlOfForm() {
        Assertions.assertEquals("Success", corporateGiftsRes.jsonPath().getString("processStatus"), "Corporate Gifts processStatus does not match!");
    }
}
