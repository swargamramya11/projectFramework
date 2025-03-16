package Runner;

import Utilities.Retry;
import io.cucumber.testng.*;
import org.testng.annotations.*;

import java.io.IOException;

import static Utilities.ReusableMethods.*;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"Utilities", "StepDefinations"},
        tags = "@test1",
        plugin = {"pretty", "html:target/cucumber-reports",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failedRerun.txt"},
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

    @Test(
            groups = {"cucumber"},
            description = "Runs Cucumber Scenarios",
            dataProvider = "scenarios",
            retryAnalyzer = Retry.class
    )

    @Override
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        super.runScenario(pickleWrapper, featureWrapper);
    }

    @BeforeSuite
    public static void beforeSuite() throws IOException {
        System.out.println("Before Suite");
        deleteRequiredFolder("target\\allure");
    }

    @AfterSuite
    public static void afterSuite() throws IOException {
        System.out.println("After Suite");

        String newDir = System.getProperty("user.dir") + "target\\allure";
        Runtime.getRuntime().exec("cmd.exe /c cd \"" + newDir + "\" & start cmd.exe /k \"allure generate --single-file allure-results --clean\"");
        threadSleep(8000);
        Runtime.getRuntime().exec("TASKKILL /F /IM cmd.exe");
    }
}