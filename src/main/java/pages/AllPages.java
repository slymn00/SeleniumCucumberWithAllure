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
    private HouseOfTestBlogsPage houseOfTestBlogsPage;
    private HouseOfTestContactUsPage houseOfTestContactUsPage;

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

    public HouseOfTestBlogsPage housOfTestBlogsPage(){
        if (houseOfTestBlogsPage ==null){
            houseOfTestBlogsPage =new HouseOfTestBlogsPage();
        }

        return houseOfTestBlogsPage;
    }

    public HouseOfTestContactUsPage houseOfTestContactUsPage(){
        if (houseOfTestContactUsPage ==null){
            houseOfTestContactUsPage =new HouseOfTestContactUsPage();
        }

        return houseOfTestContactUsPage;
    }

}
