package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

import java.util.List;

public class TrendyolSearchPage {

    public TrendyolSearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//*[@class='prdct-desc-cntnr-ttl-w two-line-text'] | //*[@class='product-description__name']//span")
    public List<WebElement> textsSellerStoreName;


}
