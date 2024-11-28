Feature: Login kontrol
  Scenario: Kullanicinin login olup ana sayfayi goruntulemesi
    Given Kullanici login icin telefon numarasini girer
    When Numarayi girdikten sonra devam et butonuna tiklar
    And Telefonuna gelen OTP kodunu girip devam et butonuna tiklar
    Then OTP servisi kontrol edilir
    And Kullanicinin login olup olmadigi kontrol edilir
    And Ana sayfa servisleri kontrol edilir