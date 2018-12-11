package testRunners;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features/",
        glue= "stepDefinitions/",
        tags= {"@CalcTests"},
        plugin={"pretty","html:target/test-report"}
)

public class calcTestRunner {
}
