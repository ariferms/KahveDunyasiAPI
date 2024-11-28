Feature: Kazanimlarim sayfasinin kontrolleri
  Background:
    Given Access Token alinir
  Scenario: Kazanimlarim sayfasinin goruntulenmesi
    Given Kullanici profilim iconuna tiklar
    When Kazanimlarim tab'ine tiklar
    Then Kazanimlarim sayfasinin acildigi kontrol edilir