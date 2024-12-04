Feature: Kurumsal Hediyeler Formu kontrolleri
  Background:
    Given Access Token alinir
  Scenario: Kurumsal Hediyeler Formunun gonderilmesi
    Given Kullanici Kurumsal Hediyeler butonuna tiklar
    And Kullanici formu doldurur
    When Kullanici Gonder butonuna tiklayarak formu gonderir
    Then Formun gonderildigi kontrol edilir