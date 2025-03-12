package stepdefinitions;

import io.cucumber.java.*;
import io.qameta.allure.Allure;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utility.DataFinder;
import utility.Driver;
import utility.Terminal;

import java.io.ByteArrayInputStream;
import java.util.Objects;

public class Hooks implements TestLifecycleListener {

    @Override
    public void beforeTestStop(TestResult result){

        if (result.getStatus() == io.qameta.allure.model.Status.FAILED || result.getStatus() == Status.BROKEN) {
            if (Driver.getDriver() != null)
                Allure.addAttachment(result.getName(), new ByteArrayInputStream(((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES)));
        }
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
