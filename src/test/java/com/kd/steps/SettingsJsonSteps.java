package com.kd.steps;

import com.kd.services.SettingsJsonService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

public class SettingsJsonSteps {
    SettingsJsonService settingsJsonService = new SettingsJsonService();
    Response settingsRes,
            myWidgetSettingsRes;

    @Given("Kullanici Settings servislerinin toplar")
    public void getAllSettingsServices() {
        System.out.println("Kullanici Settings servislerinin toplar...");
    }

    @When("Kullanici Settings servislerine istek atar")
    public void getSettingsService() {
        settingsRes = settingsJsonService.getSettings();
        myWidgetSettingsRes = settingsJsonService.getMyWidgetSettings();
    }

    @Then("Settings servislerinden response dondugu kontrol edilir")
    public void settingsServicesControl() {
        // Settings Assertions
        // JSON response'dan değerleri alıyoruz
        String fallbackLanguage = settingsRes.jsonPath().getString("fallbackLanguage");
        String unknownBankUrl = settingsRes.jsonPath().getString("unknownBankUrl");
        String masterpassContractsUrl = settingsRes.jsonPath().getString("masterpassContractsUrl");
        Float storeDistanceRadius = settingsRes.jsonPath().getFloat("storeDistanceRadius");
        List<String> workshopPaths = settingsRes.jsonPath().getList("workshopPaths");

        // Assertions'lar
        Assertions.assertTrue(fallbackLanguage.equals("en-US"), "Fallback language does not match!");
        Assertions.assertTrue(unknownBankUrl != null && !unknownBankUrl.isEmpty(), "Unknown Bank URL is null or empty!");
        Assertions.assertTrue(masterpassContractsUrl != null && !unknownBankUrl.isEmpty(), "Masterpass Contracts URL is null or empty!");
        Assertions.assertTrue(storeDistanceRadius == 10.0, "Store Distance Radius does not match!");
        Assertions.assertTrue(workshopPaths.contains("/atolye"), "Workshop Paths does not contain /atolye!");
        Assertions.assertTrue(workshopPaths.contains("/atolyeler"), "Workshop Paths does not contain /atolyeler!");
        Assertions.assertTrue(workshopPaths.contains("/atolyeler/:id"), "Workshop Paths does not contain /atolyeler/:id!");
        Assertions.assertTrue(workshopPaths.contains("/atolye/sepet"), "Workshop Paths does not contain /atolye/sepet!");
        Assertions.assertTrue(workshopPaths.contains("/atolye/teslimat"), "Workshop Paths does not contain /atolye/teslimat!");
        Assertions.assertTrue(workshopPaths.contains("/atolye/odeme"), "Workshop Paths does not contain /atolye/odeme!");
        Assertions.assertTrue(workshopPaths.contains("/atolye/siparis-detay"), "Workshop Paths does not contain /atolye/siparis-detay!");

        // Nested JSON (availableLanguages)
        List<Map<String, String>> availableLanguages = settingsRes.jsonPath().getList("availableLanguages");
        Assertions.assertTrue(availableLanguages.stream().anyMatch(lang -> lang.get("key").equals("turkish")),
                "Turkish language key is missing!");
        Assertions.assertTrue(availableLanguages.stream().anyMatch(lang -> lang.get("language").equals("en-US")),
                "English language is missing!");

        // Her bir anahtarın varlığını ve null/boş olmadığını kontrol eden assertions'lar
        Map<String, String> clientCDNJsonList = settingsRes.jsonPath().getMap("clientCDNJsonList");

        Assertions.assertTrue(clientCDNJsonList.containsKey("blog"), "clientCDNJsonList does not contain 'blog' key!");
        Assertions.assertTrue(clientCDNJsonList.get("blog") != null && !clientCDNJsonList.get("blog").isEmpty(),
                "Value for 'blog' key is null or empty!");

        Assertions.assertTrue(clientCDNJsonList.containsKey("workshop"), "clientCDNJsonList does not contain 'workshop' key!");
        Assertions.assertTrue(clientCDNJsonList.get("workshop") != null && !clientCDNJsonList.get("workshop").isEmpty(),
                "Value for 'workshop' key is null or empty!");

        Assertions.assertTrue(clientCDNJsonList.containsKey("about_us"), "clientCDNJsonList does not contain 'about_us' key!");
        Assertions.assertTrue(clientCDNJsonList.get("about_us") != null && !clientCDNJsonList.get("about_us").isEmpty(),
                "Value for 'about_us' key is null or empty!");

        Assertions.assertTrue(clientCDNJsonList.containsKey("resources"), "clientCDNJsonList does not contain 'resources' key!");
        Assertions.assertTrue(clientCDNJsonList.get("resources") != null && !clientCDNJsonList.get("resources").isEmpty(),
                "Value for 'resources' key is null or empty!");

        Assertions.assertTrue(clientCDNJsonList.containsKey("masterpass_cards"), "clientCDNJsonList does not contain 'masterpass_cards' key!");
        Assertions.assertTrue(clientCDNJsonList.get("masterpass_cards") != null && !clientCDNJsonList.get("masterpass_cards").isEmpty(),
                "Value for 'masterpass_cards' key is null or empty!");

        Assertions.assertTrue(clientCDNJsonList.containsKey("faqs"), "clientCDNJsonList does not contain 'faqs' key!");
        Assertions.assertTrue(clientCDNJsonList.get("faqs") != null && !clientCDNJsonList.get("faqs").isEmpty(),
                "Value for 'faqs' key is null or empty!");

        Assertions.assertTrue(clientCDNJsonList.containsKey("content_management"), "clientCDNJsonList does not contain 'content_management' key!");
        Assertions.assertTrue(clientCDNJsonList.get("content_management") != null && !clientCDNJsonList.get("content_management").isEmpty(),
                "Value for 'content_management' key is null or empty!");

        Assertions.assertTrue(clientCDNJsonList.containsKey("online_home"), "clientCDNJsonList does not contain 'online_home' key!");
        Assertions.assertTrue(clientCDNJsonList.get("online_home") != null && !clientCDNJsonList.get("online_home").isEmpty(),
                "Value for 'online_home' key is null or empty!");

        Assertions.assertTrue(clientCDNJsonList.containsKey("ready_made_home"), "clientCDNJsonList does not contain 'ready_made_home' key!");
        Assertions.assertTrue(clientCDNJsonList.get("ready_made_home") != null && !clientCDNJsonList.get("ready_made_home").isEmpty(),
                "Value for 'ready_made_home' key is null or empty!");

        Assertions.assertTrue(clientCDNJsonList.containsKey("app_home"), "clientCDNJsonList does not contain 'app_home' key!");
        Assertions.assertTrue(clientCDNJsonList.get("app_home") != null && !clientCDNJsonList.get("app_home").isEmpty(),
                "Value for 'app_home' key is null or empty!");

        Assertions.assertTrue(clientCDNJsonList.containsKey("android_ruleset"), "clientCDNJsonList does not contain 'android_ruleset' key!");
        Assertions.assertTrue(clientCDNJsonList.get("android_ruleset") != null && !clientCDNJsonList.get("android_ruleset").isEmpty(),
                "Value for 'android_ruleset' key is null or empty!");

        Assertions.assertTrue(clientCDNJsonList.containsKey("settings"), "clientCDNJsonList does not contain 'settings' key!");
        Assertions.assertTrue(clientCDNJsonList.get("settings") != null && !clientCDNJsonList.get("settings").isEmpty(),
                "Value for 'settings' key is null or empty!");

        Assertions.assertTrue(clientCDNJsonList.containsKey("general_faq"), "clientCDNJsonList does not contain 'general_faq' key!");
        Assertions.assertTrue(clientCDNJsonList.get("general_faq") != null && !clientCDNJsonList.get("general_faq").isEmpty(),
                "Value for 'general_faq' key is null or empty!");

        Assertions.assertTrue(clientCDNJsonList.containsKey("about_core_faq"), "clientCDNJsonList does not contain 'about_core_faq' key!");
        Assertions.assertTrue(clientCDNJsonList.get("about_core_faq") != null && !clientCDNJsonList.get("about_core_faq").isEmpty(),
                "Value for 'about_core_faq' key is null or empty!");

        Assertions.assertTrue(clientCDNJsonList.containsKey("about_takeaway_faq"), "clientCDNJsonList does not contain 'about_takeaway_faq' key!");
        Assertions.assertTrue(clientCDNJsonList.get("about_takeaway_faq") != null && !clientCDNJsonList.get("about_takeaway_faq").isEmpty(),
                "Value for 'about_takeaway_faq' key is null or empty!");

        Assertions.assertTrue(clientCDNJsonList.containsKey("about_app_faq"), "clientCDNJsonList does not contain 'about_app_faq' key!");
        Assertions.assertTrue(clientCDNJsonList.get("about_app_faq") != null && !clientCDNJsonList.get("about_app_faq").isEmpty(),
                "Value for 'about_app_faq' key is null or empty!");

        Assertions.assertTrue(clientCDNJsonList.containsKey("my_core_info"), "clientCDNJsonList does not contain 'my_core_info' key!");
        Assertions.assertTrue(clientCDNJsonList.get("my_core_info") != null && !clientCDNJsonList.get("my_core_info").isEmpty(),
                "Value for 'my_core_info' key is null or empty!");

        Assertions.assertTrue(clientCDNJsonList.containsKey("one_of_use_info"), "clientCDNJsonList does not contain 'one_of_use_info' key!");
        Assertions.assertTrue(clientCDNJsonList.get("one_of_use_info") != null && !clientCDNJsonList.get("one_of_use_info").isEmpty(),
                "Value for 'one_of_use_info' key is null or empty!");

        Assertions.assertTrue(clientCDNJsonList.containsKey("ios_ruleset"), "clientCDNJsonList does not contain 'ios_ruleset' key!");
        Assertions.assertTrue(clientCDNJsonList.get("ios_ruleset") != null && !clientCDNJsonList.get("ios_ruleset").isEmpty(),
                "Value for 'ios_ruleset' key is null or empty!");

        Assertions.assertTrue(clientCDNJsonList.containsKey("takeAwayCanceledReasonsUrl"), "clientCDNJsonList does not contain 'takeAwayCanceledReasonsUrl' key!");
        Assertions.assertTrue(clientCDNJsonList.get("takeAwayCanceledReasonsUrl") != null && !clientCDNJsonList.get("takeAwayCanceledReasonsUrl").isEmpty(),
                "Value for 'takeAwayCanceledReasonsUrl' key is null or empty!");

        Assertions.assertTrue(clientCDNJsonList.containsKey("onlineStoreCanceledReasonsUrl"), "clientCDNJsonList does not contain 'onlineStoreCanceledReasonsUrl' key!");
        Assertions.assertTrue(clientCDNJsonList.get("onlineStoreCanceledReasonsUrl") != null && !clientCDNJsonList.get("onlineStoreCanceledReasonsUrl").isEmpty(),
                "Value for 'onlineStoreCanceledReasonsUrl' key is null or empty!");

        Assertions.assertTrue(clientCDNJsonList.containsKey("onlineStoreRefundedReasonsUrl"), "clientCDNJsonList does not contain 'onlineStoreRefundedReasonsUrl' key!");
        Assertions.assertTrue(clientCDNJsonList.get("onlineStoreRefundedReasonsUrl") != null && !clientCDNJsonList.get("onlineStoreRefundedReasonsUrl").isEmpty(),
                "Value for 'onlineStoreRefundedReasonsUrl' key is null or empty!");

        // clientCDNJsonList: Tüm anahtarlar için kontrol

        for (String key : clientCDNJsonList.keySet()) {
            String value = clientCDNJsonList.get(key);
            Assertions.assertTrue(value != null && !value.isEmpty(),
                    "Value for key '" + key + "' is null or empty!");
        }

        // My Widget Settings Assertions
        Boolean myWidgetSuccess = myWidgetSettingsRes.jsonPath().getBoolean("success");
        Assertions.assertTrue(myWidgetSuccess == true, "My Widget Settings service is not success!");

        System.out.println("Settings servisleri kontrol edildi...");
    }
}
