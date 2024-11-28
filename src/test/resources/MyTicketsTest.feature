Feature: Biletlerim sayfasinin kontrolleri
  Background:
    Given Access Token alinir
  Scenario: Biletlerim sayfasinin goruntulenmesi
    Given Kullanici profilim iconuna tiklar
    When Biletlerim tab'ine tiklar
    Then Biletlerim sayfasinin acildigi kontrol edilir