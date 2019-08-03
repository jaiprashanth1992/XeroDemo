package Tests;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/Tests/FeatureFile"}
        ,tags = {"@account"}
)

public class testrunner {
}
