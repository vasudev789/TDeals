package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions
(
		
  features="C:\\Users\\vasudev\\eclipse-workspace\\TDeals\\src\\test\\resources\\FeatureCollectionsAPI\\PutReqRes.feature",
  glue = "ApiBDD",
  dryRun = false
				
)
public class runTestApi
{

}
