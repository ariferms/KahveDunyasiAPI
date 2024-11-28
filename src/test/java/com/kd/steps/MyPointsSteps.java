package com.kd.steps;

import com.kd.services.MyPointsService;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class MyPointsSteps {
    MyPointsService myPointsService = new MyPointsService();
    String getToken = myPointsService.token;
    Response myPointsServiceRes;

    @When("Kazanimlarim tab'ine tiklar")
    public void getMyPoints() {
        myPointsServiceRes = myPointsService.getMyPointsPage(getToken);
    }

    @Then("Kazanimlarim sayfasinin acildigi kontrol edilir")
    public void myPointsControl(){
        Assertions.assertEquals("Success", myPointsServiceRes.jsonPath().getString("processStatus"), "My Points processStatus does not match!");
    }
}
