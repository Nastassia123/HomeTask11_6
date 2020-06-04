package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="./src/test/resources/FindProduct.feature", glue= "./src/test/java/stepdefs/ShopStepDefs.java")
public class CucumberRunner {

   /* public class Runner {

    }

    @RunWith(Cucumber.class)
    @CucumberOptions(features="./src/test/resources/AddProductIntoTheComparasionListPage.feature", glue="./src/test/java/stepdefs/ShopStepDefs.java")
    public class TestRunner_SecondTest {

    }*/
}
