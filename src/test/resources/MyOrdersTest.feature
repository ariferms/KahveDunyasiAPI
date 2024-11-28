Feature: Siparislerim sayfasinin kontrolleri
  Background:
    Given Access Token alinir
  Scenario: Siparislerim sayfasinin goruntulenmesi
    Given Kullanici profilim iconuna tiklar
    When Siparis gecmisim tab'ine tiklar
    Then Siparislerim sayfasinin acildigi kontrol edilir