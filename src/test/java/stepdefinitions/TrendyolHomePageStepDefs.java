package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AllPages;
import utility.Driver;
import utility.GetData;
import utility.SeleniumBase;

public class TrendyolHomePageStepDefs extends AllPages{

    SeleniumBase lib=new SeleniumBase();


    @Given("kullanici browser tipi olarak {string} secer")
    public void kullaniciBrowserTipiOlarakSecer(String browser) {
        lib.selectBrowserVariety(browser);
    }
    @Given("kullanici trendyol anasayfasina gider")
    public void kullanici_trendyol_anasayfasina_gider() {
        lib.navigateTo(GetData.Url.TRENDYOL_URL);
        trendyolPage().btnModalClose.click();
        lib.control(lib.getTitle().equals("En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da")
                &&lib.isDisplayed(trendyolPage().mainLogo),"Anasayfa basarili bir sekilde acildi.","Anasayfa acilamadi!");
    }
    @Then("yukari kisimdaki slider menuden {string} sayfasina gecer")
    public void yukari_kisimdaki_slider_menuden_sayfasina_gecer(String string) {
        WebElement expectedElement=trendyolPage().sliderTop.findElement(By.xpath("//span[contains(text(),'"+string+"')]"));
        lib.moveElementAndClick(expectedElement);

        lib.refreshThePage();


    }
    @Then("gelen urun sonuclarinin {string} icerdigini dogrular")
    public void gelen_urun_sonuclarinin_icerdigini_dogrular(String string) {

        for (int i = 0; i < trendyolSearchPage().textsSellerStoreName.size() ; i++) {
            lib.control(lib.getTextOfElement(trendyolSearchPage().textsSellerStoreName.get(i)).contains(string),(i+1)+". urunun dogrulamasi basarili."
                    ,(i+1)+". urunun dogrulamasi basarisiz, Expected -> "+string+" Actual -> "+lib.getTextOfElement(trendyolSearchPage().textsSellerStoreName.get(i)));

        }

    }

    @Then("sayfayi kapatir")
    public void sayfayiKapatir() {
        Driver.closeDriver();
    }
}
