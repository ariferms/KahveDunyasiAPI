Feature: Promosyonlarım sayfasinin kontrolleri
  Background:
    Given Access Token alinir
  Scenario: Promosyonlarım sayfasinin goruntulenmesi
    Given Kullanici profilim iconuna tiklar
    When Promosyonlarım tab'ine tiklar
    Then Promosyonlarım sayfasinin acildigi kontrol edilir