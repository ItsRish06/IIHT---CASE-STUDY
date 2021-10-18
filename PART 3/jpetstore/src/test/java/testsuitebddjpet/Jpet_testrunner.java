package testsuitebddjpet;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;




@CucumberOptions(
        features = {"src/test/java/testsuitebddjpet/jpet.feature"},
        glue= {"testsuitebddjpet"},
        tags= "@Jpet_store_functionalities"
        
        
)
@RunWith(Cucumber.class)
public class Jpet_testrunner extends AbstractTestNGCucumberTests{

	
}
