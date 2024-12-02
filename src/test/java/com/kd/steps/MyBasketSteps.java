package com.kd.steps;

import com.kd.services.MyBasketService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class MyBasketSteps {
    MyBasketService myBasketService = new MyBasketService();
    String getToken = myBasketService.token,
            tenantId = myBasketService.tenantId,
            basketId = myBasketService.basketId,
            basketType = myBasketService.tenantType,
            tenantType = basketType;
    Response myBasketServiceRes,
            approveServiceRes,
            shipmentOptionsRes;

    @Given("Kullanici Sepetim iconuna tiklar")
    public void clickProfile() {
        System.out.println("Kullanıcı Sepetim iconuna tıklar...");
    }

    @When("Kullanici Sepete Git butonuna tiklar")
    public void getMyBasketPage() {
        myBasketServiceRes = myBasketService.getMyBasket(getToken, tenantId);
        approveServiceRes = myBasketService.postApprove(getToken, basketType, basketId);
        shipmentOptionsRes = myBasketService.postShipmentOptions(getToken, tenantType, basketId);
    }

    @Then("Sepetim sayfasinin acildigi kontrol edilir")
    public void myBasketControl() {
        Assertions.assertEquals("Success", myBasketServiceRes.jsonPath().getString("processStatus"), "My Basket processStatus does not match!");
        Assertions.assertEquals("Success", approveServiceRes.jsonPath().getString("processStatus"), "Approve processStatus does not match!");
        Assertions.assertEquals("Success", shipmentOptionsRes.jsonPath().getString("processStatus"), "Shipment Options processStatus does not match!");
    }
}
