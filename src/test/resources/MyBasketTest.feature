Feature: Sepetim sayfasinin kontrolleri
  Background:
    Given Access Token alinir
  Scenario: Sepetim sayfasinin goruntulenmesi
    Given Kullanici Sepetim iconuna tiklar
    When Kullanici Sepete Git butonuna tiklar
    Then Sepetim sayfasinin acildigi kontrol edilir