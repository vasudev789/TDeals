package Runner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions
(
  tags = {"@rediffmail"},
  features="C:\\Users\\vasudev\\eclipse-workspace\\TDeals\\src\\test\\resources\\FeatureCollections",
  glue = "TDSteps",
  dryRun = false
				
)
public class runTestSelenium 
{
  
}
