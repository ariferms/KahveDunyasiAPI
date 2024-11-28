package com.kd.steps;

import com.kd.services.MyReviewsService;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class MyReviewsSteps {
    MyReviewsService myReviewsService = new MyReviewsService();
    String getToken = myReviewsService.token;
    Response myReviewsServiceRes;

    @When("Degerlendirmelerim tab'ine tiklar")
    public void getMyReviews() {
        myReviewsServiceRes = myReviewsService.getMyReviewsPage(getToken);
    }

    @Then("Degerlendirmelerim sayfasinin acildigi kontrol edilir")
    public void myReviewsControl(){
        Assertions.assertEquals("Success", myReviewsServiceRes.jsonPath().getString("processStatus"), "My Reviews processStatus does not match!");
    }
}
