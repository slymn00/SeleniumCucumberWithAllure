package stepdefinitions;

import io.cucumber.java.*;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utility.DataFinder;
import utility.Driver;
import utility.Terminal;

import java.io.ByteArrayInputStream;
import java.util.Objects;

public class Hooks {

    @After
    public void tearDown(Scenario scenario){

        if (scenario.isFailed()){
            byte[] screenshot=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(screenshot));
        }

        Driver.closeDriver();
    }

    @BeforeAll
    public static void removeReportHistory() {

        if (Objects.equals(DataFinder.getValue("config", "deleteHistory"), "true")) {
            Terminal.runCommand("cmd /c allure generate --clean --output allure-results");
        }
    }

    @AfterAll
    public static void openAllureReport() {
        Terminal.runCommand("cmd /c allure serve -h localhost");
    }
}
