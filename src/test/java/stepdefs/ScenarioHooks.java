package stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import pages.basepagesconfiguration.BasePageClass;

public class ScenarioHooks extends BasePageClass {

    @Before
    public void beforeScenario(){
        setUp();
    }

    @After
    public void afterScenario(){
        driver.quit();
    }

}
