package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

/**
 * Created by Karthik on 21/09/2019.
 */
@Listeners(NGTestListener.class)
@CucumberOptions(features = {"src/test/java/features"} , plugin = {"json:target/cucumber.json","html:target/site/cucumber-pretty"},
        glue = "steps",tags= {"~@smoke"})
public class TestRunner extends AbstractTestNGCucumberTests {


   /* @Override
    @DataProvider
    //@DataProvider (parallel = true) -- For parallel execution support (which is not going to work for our code)
    public Object[][] scenarios() {
        return super.scenarios();
    }*/

}
