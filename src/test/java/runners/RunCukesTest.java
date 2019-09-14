package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
  features = "src/test/features",
  glue = "stepdefs",
  plugin = {"pretty", "html:reports/cucumber-html-report"},
  tags = {""}
)
public class RunCukesTest {
}
