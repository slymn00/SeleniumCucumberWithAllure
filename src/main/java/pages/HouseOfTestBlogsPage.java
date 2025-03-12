package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class HouseOfTestBlogsPage {
    public HouseOfTestBlogsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "(//*[@class='container']//*[@role='listitem'])[last()]")
    public WebElement lastBlogItem;

    @FindBy(xpath = "//div[@class='dropdown w-dropdown']//*[@class='text-block-20']")
    public WebElement aboutUsBtn;
}
