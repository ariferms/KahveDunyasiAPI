package com.kd.steps;

import com.kd.services.CampaignService;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class CampaignSteps {
    CampaignService campaignService = new CampaignService();
    String getToken = campaignService.token,
            tenantId = campaignService.tenantId;
    Response campaignServiceRes;

    @When("Promosyonlarım tab'ine tiklar")
    public void getMyCampaign() {
        campaignServiceRes = campaignService.getMyCampaingPage(getToken, tenantId);
    }

    @Then("Promosyonlarım sayfasinin acildigi kontrol edilir")
    public void myCampaignControl(){
        Assertions.assertEquals("Success", campaignServiceRes.jsonPath().getString("processStatus"), "Campaign processStatus does not match!");
    }
}
