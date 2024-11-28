Feature: Favorilerim sayfasinin kontrolleri
  Background:
    Given Access Token alinir
  Scenario: Favorilerim sayfasinin goruntulenmesi
    Given Kullanici profilim iconuna tiklar
    When Favorilerim tab'ine tiklar
    Then Favorilerim sayfasinin acildigi kontrol edilir