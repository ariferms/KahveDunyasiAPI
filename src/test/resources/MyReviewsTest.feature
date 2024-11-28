Feature: Degerlendirmelerim sayfasinin kontrolleri
  Background:
    Given Access Token alinir
  Scenario: Degerlendirmelerim sayfasinin goruntulenmesi
    Given Kullanici profilim iconuna tiklar
    When Degerlendirmelerim tab'ine tiklar
    Then Degerlendirmelerim sayfasinin acildigi kontrol edilir