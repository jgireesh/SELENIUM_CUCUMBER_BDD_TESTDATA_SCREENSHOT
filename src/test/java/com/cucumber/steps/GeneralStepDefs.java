package com.cucumber.steps;

import com.cucumber.utils.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.Before;

import java.util.logging.Logger;

import static com.cucumber.utils.BasePage.teardown;

public class GeneralStepDefs {

    private final static Logger log = Logger.getLogger(GeneralStepDefs.class.getName());
    public static Scenario currentScenario;

    @Before
    public void getScenarioName(Scenario scenario){
        currentScenario = scenario;
        log.info("Executing scenario : "+scenario.getName());
    }

    @Before ("@UI")
    public void initialiseBrowser(){
        BasePage basePage = new BasePage();
        basePage.setup();
    }

    @After ("@UI")
    public void closeBrowser(){
        teardown();
        log.info("Completed scenario : "+currentScenario.getName());
    }

    public static Scenario getCurrentScenario(){
        return currentScenario;
    }

}
