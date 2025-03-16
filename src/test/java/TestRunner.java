import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/Features",
        glue = {"StepDefinitions", "Hooks"},
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        tags = "@Smoke or @Regression or @DrillDown or @ReportLinks or @Login or @Widgets",
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {
}
