@e2e
Feature: Kullanici yukarı kisimdaki sliderin kullanilabilirliigini dogrular

  Background:
    Given kullanici browser tipi olarak "chrome" secer
    Given kullanici houseoftest anasayfasina gider


  Scenario: Kullanici yukarı kisimdaki sliderin kullanilabilirliigini dogrular
    Given Title "Expert Software Testing Services | House of Test Switzerland" oldugunu dogrular
    Given House of test logosunun goruldugunu dogrula
    Given Ustteki navigation alanının "SERVICES" "COURSES" "BLOGS" "JOIN US" "ABOUT US" kontrolu yapilir
    Given Ust navbardaki Services butonuna tıkla
    Given "OUR SERVICES" yazisinin gorundugunu dogrula
    Given Ust navbardaki Blogs butonuna tıkla
    Given Blog sayfasindaki en son blog yazisi gorunur oldugunu kontrol et
    Given Ust navbardaki dropdownda contact us butonuna tıkla
    Given "First name" "Last name" "Email" "Mobile phone number" "Company name" "Message" alanlarının gorundugunu dogrula
    And Firstname textboxa "Test" texti gonder
    And Lastname textboxa "User" texti gonder
    And Email textboxa "testss123@gmail.com" texti gonder
    And Mobile Phone textboxa "5555555555" texti gonder
    And Company Name textboxa "TestCompany" texti gonder
    And Message textboxa "Merhaba, hizmetleriniz hakkında bilgi almak istiyorum." texti gonder
    Given Tüm checkboxlara tıkla
    Given Submit butonuna tıkla
    Given Captcha koruması hatasıyla "Failed to validate Captcha. Please try again." karsilastigini dogrula
    Given sayfayi kapatir

