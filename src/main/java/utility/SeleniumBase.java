package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SeleniumBase {

    public final JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


   // private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    //public final Actions actions;

    /*public SeleniumBase() {
        actions = new Actions(Driver.getDriver());
    }*/

    /*public SeleniumBase(WebDriver driver) {
        actions = new Actions(driver);
    }*/





    public void clickElement(WebElement element){
        try {
            element.click();
        }catch (Exception e){
            System.out.println("elemente tıklanılamadı! "+e);
        }
    }

    public String getTextOfElement(WebElement element){

        String text = null;

        try {
            text=element.getText();
        }catch (Exception e){
            Log.fail("Elementin yazisi alinamadi.");
        }
        return text;
    }

    public void navigateTo(Enum<?> url){
        try {
            Driver.getDriver().get(DataFinder.getValue(url));
        }catch (Exception e){
            System.out.println("Istenilen URL gidilemedi."+ e);
        }
    }

    public void selectBrowserVariety(String variety){
        Driver.setUp(variety);
    }

    public String getCurrentUrl(){
        return Driver.getDriver().getCurrentUrl();
    }

    public String getTitle(){
        return Driver.getDriver().getTitle();
    }

    public Boolean isDisplayed(WebElement element){
        boolean displayed = false;
        try {
            displayed=element.isDisplayed();
        }catch (Exception e){
            System.out.println("Element goruntulenemedi!!"+e);
        }

        return displayed;
    }

    public void control(boolean statement, String onTrue, String onFalse) {

        if (statement) {
            Log.pass(onTrue);
        } else {
            Log.fail(onFalse);
        }

    }

    public void Wait(int millisecond) {
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
