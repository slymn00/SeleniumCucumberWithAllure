@slider
Feature: Kullanici yukarı kisimdaki sliderin kullanilabilirliigini dogrular

  Background:
    Given kullanici browser tipi olarak "chrome" secer
    Given kullanici trendyol anasayfasina gider

 Scenario Outline: Kullanici istediği bir slider menusune gecis yapar
    Then yukari kisimdaki slider menuden "<sliderName>" sayfasina gecer
    And gelen urun sonuclarinin "<sliderName>" icerdigini dogrular
    Then sayfayi kapatir
    Examples:
      | sliderName |
      | Levi      |
      | Apple     |
      | Bershka   |
      | Karaca    |
      | Puma      |
      | Xiaomi    |