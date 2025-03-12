package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AllPages;
import utility.Driver;
import utility.GetData;
import utility.SeleniumBase;

public class HouseOfTestHomePageStepDefs extends AllPages{

    SeleniumBase lib=new SeleniumBase();


    @Given("kullanici browser tipi olarak {string} secer")
    public void kullaniciBrowserTipiOlarakSecer(String browser) {
        lib.selectBrowserVariety(browser);
    }

    @Given("kullanici houseoftest anasayfasina gider")
    public void kullanici_trendyol_anasayfasina_gider() {
        lib.navigateTo(GetData.Url.HOUSE_OF_TEST_HOMEPAGE_URL);

    }

    @Then("sayfayi kapatir")
    public void sayfayiKapatir() {
        Driver.closeDriver();
    }
}
