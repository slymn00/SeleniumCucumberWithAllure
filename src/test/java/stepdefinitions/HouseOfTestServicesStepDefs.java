package stepdefinitions;

import io.cucumber.java.en.Given;
import pages.AllPages;
import utility.SeleniumBase;

public class HouseOfTestServicesStepDefs extends AllPages {

    SeleniumBase lib=new SeleniumBase();
    AllPages allPages=new AllPages();

    @Given("{string} yazisinin gorundugunu dogrula")
    public void yazisininGorundugunuDogrula(String text) {
        lib.Wait(500);
        lib.control(lib.isDisplayed(allPages.houseOfTestServices().mainInfoTitleText),"Kontroller basirili","Hata bulundu.");
    }

    @Given("Ust navbardaki Blogs butonuna tıkla")
    public void ustNavbardakiBlogsButonunaTıkla() {
        lib.clickElement(allPages.houseOfTestServices().blogsBtn);
    }
}
