package pages;

import utility.SeleniumBase;

public class AllPages{

    public AllPages(){

    }

    //javada her class return type olabilir
    //Her page class return type ile private instance olusturduk

    public SeleniumBase lib=new SeleniumBase();
    private HouseOfTestHomePage houseOfTestHomePage;
    private HouseOfTestServicesPage houseOfTestServicesPage;

    //her page class icin public method olusturup obje olusturacagiz

    public HouseOfTestHomePage houseOfTestHomePage(){
        if (houseOfTestHomePage ==null){
            houseOfTestHomePage =new HouseOfTestHomePage();
        }
        return houseOfTestHomePage;
    }

    public HouseOfTestServicesPage houseOfTestServices(){
        if (houseOfTestServicesPage ==null){
            houseOfTestServicesPage =new HouseOfTestServicesPage();
        }

        return houseOfTestServicesPage;
    }

}
