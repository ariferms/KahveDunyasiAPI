package com.kd.steps;


import com.kd.services.MyTicketsService;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class MyTicketsSteps {
    MyTicketsService myTicketsService = new MyTicketsService();
    String getToken = myTicketsService.token;
    Response myTicketsServiceRes;

    @When("Biletlerim tab'ine tiklar")
    public void getMyTickets() {
        myTicketsServiceRes = myTicketsService.getMyTicketsPage(getToken);
    }

    @Then("Biletlerim sayfasinin acildigi kontrol edilir")
    public void myTicketsControl(){
        Assertions.assertEquals("Success", myTicketsServiceRes.jsonPath().getString("processStatus"), "My Tickets processStatus does not match!");
    }
}
