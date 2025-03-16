package Runner;

import io.cucumber.testng.*;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"StepDefinations"},
        tags = "@test1",
        plugin = {"pretty", "html:target"},
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {
}
