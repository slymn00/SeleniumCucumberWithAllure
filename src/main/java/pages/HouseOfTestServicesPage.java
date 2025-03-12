package pages;

import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class HouseOfTestServicesPage {
    public HouseOfTestServicesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

}
