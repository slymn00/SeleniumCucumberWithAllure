package stepdefinitions;

import io.cucumber.java.en.Given;
import pages.AllPages;
import utility.SeleniumBase;

public class HouseOfTestContactUsStepDefs extends AllPages {

    SeleniumBase lib=new SeleniumBase();
    AllPages allPages=new AllPages();

    @Given("{string} {string} {string} {string} {string} {string} alanlarının gorundugunu dogrula")
    public void alanlarınınGorundugunuDogrula(String fName, String lName, String email, String phone, String compName, String message) {
        lib.Wait(2000);
        lib.moveElement(allPages.houseOfTestContactUsPage().contactSection);
        lib.Wait(2000);
        lib.switchToIframe(allPages.houseOfTestContactUsPage().contactIframe);

        lib.control(lib.isDisplayed(allPages.houseOfTestContactUsPage().firstNameInp)&&lib.getTextOfElement(allPages.houseOfTestContactUsPage().labelFirstnameText).equals(fName),"Firstname text eşleşti","Text hatali ");
        lib.control(lib.isDisplayed(allPages.houseOfTestContactUsPage().lastNameInp)&&lib.getTextOfElement(allPages.houseOfTestContactUsPage().labelLastnameText).equals(lName),"Lastname text eşleşti","Text hatali ");
        lib.control(lib.isDisplayed(allPages.houseOfTestContactUsPage().emailInp)&&lib.getTextOfElement(allPages.houseOfTestContactUsPage().labelEmailText).equals(email),"Email text eşleşti","Text hatali ");
        lib.control(lib.isDisplayed(allPages.houseOfTestContactUsPage().mobilephoneInp)&&lib.getTextOfElement(allPages.houseOfTestContactUsPage().labelMobilePhoneText).equals(phone),"Mobile Phone text eşleşti","Text hatali ");
        lib.control(lib.isDisplayed(allPages.houseOfTestContactUsPage().companyInp)&&lib.getTextOfElement(allPages.houseOfTestContactUsPage().labelCompanyText).equals(compName),"Company text eşleşti","Text hatali ");
        lib.control(lib.isDisplayed(allPages.houseOfTestContactUsPage().messageInp)&&lib.getTextOfElement(allPages.houseOfTestContactUsPage().labelMessageText).equals(message),"Message text eşleşti","Text hatali ");

    }

    @Given("Firstname textboxa {string} texti gonder")
    public void firstnameTextboxaTextiGonder(String firstname) {
        lib.sendKeys(allPages.houseOfTestContactUsPage().firstNameInp, firstname);
    }

    @Given("Lastname textboxa {string} texti gonder")
    public void lastnameTextboxaTextiGonder(String lastname) {
        lib.sendKeys(allPages.houseOfTestContactUsPage().lastNameInp, lastname);
    }

    @Given("Email textboxa {string} texti gonder")
    public void emailTextboxaTextiGonder(String email) {
        lib.sendKeys(allPages.houseOfTestContactUsPage().emailInp, email);
    }

    @Given("Mobile Phone textboxa {string} texti gonder")
    public void mobilePhoneTextboxaTextiGonder(String phone) {
        lib.sendKeys(allPages.houseOfTestContactUsPage().mobilephoneInp, phone);
    }

    @Given("Company Name textboxa {string} texti gonder")
    public void companyNameTextboxaTextiGonder(String comp) {
        lib.sendKeys(allPages.houseOfTestContactUsPage().companyInp, comp);
    }

    @Given("Message textboxa {string} texti gonder")
    public void messageTextboxaTextiGonder(String message) {
        lib.sendKeys(allPages.houseOfTestContactUsPage().messageInp, message);
    }

    @Given("Tüm checkboxlara tıkla")
    public void tümCheckboxlaraTıkla() {
        lib.moveElementAndClick(allPages.houseOfTestContactUsPage().PDPACheckBox);
        lib.moveElementAndClick(allPages.houseOfTestContactUsPage().readOurPrivacyCheckBox);
        lib.moveElementAndClick(allPages.houseOfTestContactUsPage().smsPermissionCheckBox);
    }

    @Given("Submit butonuna tıkla")
    public void submitButonunaTıkla() {
        lib.moveElementAndClick(allPages.houseOfTestContactUsPage().submitBtn);
    }

    @Given("Captcha koruması hatasıyla {string} karsilastigini dogrula")
    public void captchaKorumasıHatasıylaKarsilastiginiDogrula(String text) {
        lib.control(lib.getTextOfElement(houseOfTestContactUsPage().captchaText).equals(text),"Captcha icin textler esit","Captcha icin textler eslesmedi!!!");
    }
}
