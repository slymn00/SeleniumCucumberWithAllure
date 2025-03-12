package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

import java.util.List;

public class HouseOfTestHomePage {

    public HouseOfTestHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@class='navbar-hot home w-nav']//*[contains(@alt,'House of test logo')]")
    public WebElement houseOfTestLogo;

    @FindBy(xpath = "//*[@class='navbar-hot home w-nav']//a[@href='/our-services']")
    public WebElement ourServicesBtn;
    @FindBy(xpath = "//*[@class='navbar-hot home w-nav']//a[@href='/courses-and-workshops']")
    public WebElement coursesBtn;
    @FindBy(xpath = "//*[@class='navbar-hot home w-nav']//a[@href='/insights']")
    public WebElement blogsBtn;
    @FindBy(xpath = "//*[@class='navbar-hot home w-nav']//div[@class='dropdown w-dropdown']//*[@class='text-block-20']")
    public WebElement aboutUsBtn;
    @FindBy(xpath = "//*[@class='navbar-hot home w-nav']//a[@href='/join-us']")
    public WebElement joinUsBtn;
    @FindBy(xpath = "//*[@id='w-dropdown-list-1']//a[@href='/contact']")
    public WebElement contactUsBtn;
}
