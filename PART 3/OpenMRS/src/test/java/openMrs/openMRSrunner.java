package openMrs;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/java/openMrs/openMRS.feature"},
        glue= {"openMrs"},
        tags= "@OpenMRS"
        
)
@RunWith(Cucumber.class)

public class openMRSrunner extends AbstractTestNGCucumberTests{

}
