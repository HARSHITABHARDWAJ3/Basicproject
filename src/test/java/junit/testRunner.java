package junit;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "/Users/harshitabhardwaj/eclipse-workspace/Basicproject/features/Locators.feature",  // Specify the directory where your feature files are located
    glue = "stepdefinations",             // Specify the package where your step definitions are located
    dryRun = false,
    monochrome = true,
    plugin = {"pretty", "html:target/cucumber-reports"}  // Optional: Specify plugins and output directory
)
public class testRunner {
}
