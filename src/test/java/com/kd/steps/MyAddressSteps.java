package com.kd.steps;

import com.kd.services.MyAddressService;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class MyAddressSteps {
    MyAddressService myAddressService = new MyAddressService();
    String getToken = myAddressService.token;
    Response myAddressRes;
    @When("Adreslerim tab'ine tiklar")
    public void getMyAddress() {
        myAddressRes = myAddressService.getMyAddress(getToken);
    }

    @Then("Adreslerim sayfasinin acildigi kontrol edilir")
    public void myAddressControl(){
        Assertions.assertEquals("Success", myAddressRes.jsonPath().getString("processStatus"), "MyAddress processStatus does not match!");
    }
}
