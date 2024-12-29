package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features={"C:\\Users\\admin\\eclipse-workspace\\API_Framework\\src\\test\\java\\Features\\AddPet.feature"},
        glue={"stepDefinations"},
//        tags="@GetPet"
//        dryRun=true,
      tags="@CreateUser"
//      plugin= {"pretty","html:test-output/html-reports/cucumber-json-reports.html"}
		)
public class TestRunner {

}
