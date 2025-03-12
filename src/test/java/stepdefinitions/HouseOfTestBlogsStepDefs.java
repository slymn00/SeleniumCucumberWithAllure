package stepdefinitions;

import io.cucumber.java.en.Given;
import pages.AllPages;
import utility.SeleniumBase;

public class HouseOfTestBlogsStepDefs extends AllPages {

    SeleniumBase lib=new SeleniumBase();
    AllPages allPages=new AllPages();

    @Given("Blog sayfasindaki en son blog yazisi gorunur oldugunu kontrol et")
    public void blogSayfasindakiEnSonBlogYazisiGorunurOldugunuKontrolEt() {
        lib.moveElement(allPages.housOfTestBlogsPage().lastBlogItem);
        lib.Wait(500);
        lib.control(lib.isDisplayed(allPages.housOfTestBlogsPage().lastBlogItem),"Son blog yazısı göründü","Son blog yazısı bulunmuyor !!");
    }

    @Given("Ust navbardaki dropdownda contact us butonuna tıkla")
    public void ustNavbardakiDropdowndaContactUsButonunaTıkla() {
        lib.clickElement(allPages.housOfTestBlogsPage().aboutUsBtn);
        lib.Wait(500);
        lib.clickElement(allPages.houseOfTestHomePage().contactUsBtn);
    }
}
