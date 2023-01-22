package pages;

import utility.SeleniumBase;

public class AllPages{

    public AllPages(){

    }

    //javada her class return type olabilir
    //Her page class return type ile private instance olusturduk

    public SeleniumBase lib=new SeleniumBase();
    private TrendyolHomePage trendyolHomePage;
    private TrendyolSearchPage trendyolSearchPage;

    //her page class icin public method olusturup obje olusturacagiz

    public TrendyolHomePage trendyolPage(){
        if (trendyolHomePage ==null){
            trendyolHomePage =new TrendyolHomePage();
        }
        return trendyolHomePage;
    }

    public TrendyolSearchPage trendyolSearchPage(){
        if (trendyolSearchPage==null){
            trendyolSearchPage=new TrendyolSearchPage();
        }

        return trendyolSearchPage;
    }

}
