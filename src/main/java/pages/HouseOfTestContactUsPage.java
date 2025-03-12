package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class HouseOfTestContactUsPage {
    public HouseOfTestContactUsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[contains(@id,'firstname')]")
    public WebElement firstNameInp;

    @FindBy(xpath = "//input[contains(@id,'lastname')]")
    public WebElement lastNameInp;

    @FindBy(xpath = "//input[contains(@id,'email')]")
    public WebElement emailInp;

    @FindBy(xpath = "//input[contains(@id,'mobilephone')]")
    public WebElement mobilephoneInp;

    @FindBy(xpath = "//input[contains(@id,'company')]")
    public WebElement companyInp;

    @FindBy(xpath = "//textarea[contains(@id,'message')]")
    public WebElement messageInp;

    @FindBy(xpath = "(//input[contains(@id,'LEGAL_CONSENT')])[1]")
    public WebElement smsPermissionCheckBox;

    @FindBy(xpath = "(//input[contains(@id,'LEGAL_CONSENT')])[2]")
    public WebElement PDPACheckBox;

    @FindBy(xpath = "(//input[contains(@id,'LEGAL_CONSENT')])[3]")
    public WebElement readOurPrivacyCheckBox;

    @FindBy(xpath = "//*[contains(@class,'hs-button')]")
    public WebElement submitBtn;

    @FindBy(xpath = "(//*[contains(@id,'label-firstname')]//span)[1]")
    public WebElement labelFirstnameText;

    @FindBy(xpath = "(//*[contains(@id,'label-lastname')]//span)[1]")
    public WebElement labelLastnameText;

    @FindBy(xpath = "(//*[contains(@id,'label-email')]//span)[1]")
    public WebElement labelEmailText;

    @FindBy(xpath = "(//*[contains(@id,'label-mobilephone')]//span)[1]")
    public WebElement labelMobilePhoneText;

    @FindBy(xpath = "(//*[contains(@id,'label-company')]//span)[1]")
    public WebElement labelCompanyText;

    @FindBy(xpath = "(//*[contains(@id,'label-message')]//span)[1]")
    public WebElement labelMessageText;

    @FindBy(xpath = "//section[@class='section contact']")
    public WebElement contactSection;

    @FindBy(xpath = "//*[@id='hs-form-iframe-0']")
    public WebElement contactIframe;

    @FindBy(xpath = "//*[contains(@class,'hs-error-msgs')]//label")
    public WebElement captchaText;

}
