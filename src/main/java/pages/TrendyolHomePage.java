package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class TrendyolHomePage {

    public TrendyolHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//*[@data-id='1']//a")
    public WebElement sliderTop;

    @FindBy(id = "logo")
    public WebElement mainLogo;

    @FindBy(xpath = "//*[@class='modal-close']")
    public WebElement btnModalClose;
}
