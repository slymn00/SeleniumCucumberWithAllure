package pages;

public class AllPages {

    public AllPages(){

    }

    //javada her class return type olabilir
    //Her page class return type ile private instance olusturduk
    private AmazonPage amazonPage;


    //her page class icin public method olusturup obje olusturacagiz

    public AmazonPage amazonPage(){
        if (amazonPage==null){ //eger benim burda olusturdugum instance apiDemosPage yani null ise
            amazonPage=new AmazonPage(); //o zaman bunu bana bir obje olarak olustur daha sonra bu objeyi bana ver
        }
        return amazonPage; //ben bu methodu cagirdigim zaman onu kullanayim
    }

}
