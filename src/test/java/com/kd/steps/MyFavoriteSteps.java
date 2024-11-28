package com.kd.steps;

import com.kd.services.MyFavoriteService;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class MyFavoriteSteps {
    MyFavoriteService myFavoriteService = new MyFavoriteService();
    String getToken = myFavoriteService.token,
            tenantId = myFavoriteService.tenantId;
    Response myFavoriteServiceRes;

    @When("Favorilerim tab'ine tiklar")
    public void getMyFavorite() {
        myFavoriteServiceRes = myFavoriteService.getMyFavoritePage(getToken, tenantId);
    }

    @Then("Favorilerim sayfasinin acildigi kontrol edilir")
    public void myFavoriteControl(){
        Assertions.assertEquals("Success", myFavoriteServiceRes.jsonPath().getString("processStatus"), "My Favorite processStatus does not match!");
    }
}
