package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AllPages;
import utility.Driver;
import utility.GetData;
import utility.SeleniumBase;

public class HouseOfTestHomePageStepDefs extends AllPages{

    SeleniumBase lib=new SeleniumBase();
    AllPages allPages=new AllPages();

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

    @Given("Title {string} oldugunu dogrular")
    public void titleOldugunuDogrular(String text) {
        lib.control(lib.getTitle().equals(text),"Title dogrulandi","Title hatali Actual text -> "+ lib.getTitle());
    }

    @Given("House of test logosunun goruldugunu dogrula")
    public void houseOfTestLogosununGoruldugunuDogrula() {
        lib.control(lib.isDisplayed(allPages.houseOfTestHomePage().houseOfTestLogo),"Logo basari ile gorundu","Logo goruntulenemedi" );
    }


    @Given("Ustteki navigation alanının {string} {string} {string} {string} {string} kontrolu yapilir")
    public void usttekiNavigationAlanınınKontroluYapilir(String services, String courses , String blogs, String joinUs, String aboutUs) {
        lib.control(lib.isDisplayed(allPages.houseOfTestHomePage().ourServicesBtn)&&lib.getTextOfElement(allPages.houseOfTestHomePage().ourServicesBtn).equals(services),"Services text eşleşti","Text hatali ");
        lib.control(lib.isDisplayed(allPages.houseOfTestHomePage().coursesBtn)&&lib.getTextOfElement(allPages.houseOfTestHomePage().coursesBtn).equals(courses),"Courses text eşleşti","Text hatali ");
        lib.control(lib.isDisplayed(allPages.houseOfTestHomePage().blogsBtn)&&lib.getTextOfElement(allPages.houseOfTestHomePage().blogsBtn).equals(blogs),"Blogs text eşleşti","Text hatali ");
        lib.control(lib.isDisplayed(allPages.houseOfTestHomePage().joinUsBtn)&&lib.getTextOfElement(allPages.houseOfTestHomePage().joinUsBtn).equals(joinUs),"Join us text eşleşti","Text hatali ");
        lib.control(lib.isDisplayed(allPages.houseOfTestHomePage().aboutUsBtn)&&lib.getTextOfElement(allPages.houseOfTestHomePage().aboutUsBtn).equals(aboutUs),"About us text eşleşti","Text hatali ");

    }

    @Given("Ust navbardaki Services butonuna tıkla")
    public void ustNavbardakiServicesButonunaTıkla() {
        lib.clickElement(allPages.houseOfTestHomePage().ourServicesBtn);
    }
}
