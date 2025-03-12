package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class HouseOfTestServicesPage {
    public HouseOfTestServicesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//H1")
    public WebElement mainInfoTitleText;
    @FindBy(xpath = "//*[@class='navbar-hot w-nav']//a[@href='/insights']")
    public WebElement blogsBtn;
}
