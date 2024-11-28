package com.kd.steps;

import com.kd.services.MyOrdersService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class MyOrdersSteps {
    MyOrdersService myOrdersService = new MyOrdersService();
    String getToken = myOrdersService.token,
            tenantId = myOrdersService.tenantId;
    Response myOrdersServiceRes;

    @Given("Kullanici profilim iconuna tiklar")
    public void clickProfile() {
        System.out.println("Kullanıcı profil iconuna tıklar...");
    }

    @When("Siparis gecmisim tab'ine tiklar")
    public void getMyOrderPage() {
        myOrdersServiceRes = myOrdersService.getMyOrders(getToken, tenantId);
    }

    @Then("Sayfanin acildigi kontrol edilir")
    public void myOrderControl(){
        Assertions.assertEquals("Success", myOrdersServiceRes.jsonPath().getString("processStatus"), "MyOrder processStatus does not match!");
    }
}
