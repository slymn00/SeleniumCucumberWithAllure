Feature: Kullanici yukarı kisimdaki sliderin kullanilabilirliigini dogrular

  @slider
  Scenario: Kullanici istediği bir slider menusune gecis yapar

    Given kullanici trendyol anasayfasina gider
    Then yukari kisimdaki slider menuden "Bershka" sayfasina gecer
    And gelen urun sonuclarinin "Bershka" icerdigini dogrular
    Then sayfayi kapatir