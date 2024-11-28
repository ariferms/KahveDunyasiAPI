Feature: Siparislerim sayfasinin kontrolleri
  Background:
    Given Refresh token alinir
  Scenario: Siparislerim sayfasinin goruntulenmesi
    Given Kullanici profilim iconuna tiklar
    When Siparis gecmisim tab'ine tiklar
    Then Sayfanin acildigi kontrol edilir