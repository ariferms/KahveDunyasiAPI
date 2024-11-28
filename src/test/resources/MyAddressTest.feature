Feature: Adreslerim sayfasinin kontrolleri
  Background:
    Given Access Token alinir
  Scenario: Adreslerim sayfasinin goruntulenmesi
    Given Kullanici profilim iconuna tiklar
    When Adreslerim tab'ine tiklar
    Then Adreslerim sayfasinin acildigi kontrol edilir