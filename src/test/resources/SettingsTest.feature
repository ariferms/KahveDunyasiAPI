Feature: Settings servislerinin kontrolleri
  Scenario: Settings servislerinin kontrol edilmesi
    Given Kullanici Settings servislerinin toplar
    When Kullanici Settings servislerine istek atar
    Then Settings servislerinden response dondugu kontrol edilir