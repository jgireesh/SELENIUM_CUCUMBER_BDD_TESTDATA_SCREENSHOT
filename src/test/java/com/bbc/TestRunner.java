package com.bbc;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        glue={"com/bbc/steps"},
        plugin={
                "pretty:target/cucumber-pretty.text",
                "html:target/cucumber/cucumber",
                "json:target/cucumber/cucumber.json",
                "junit:target/cucumber/cucumber.xml"
        },
        features={"src/test/resources/features"},
        tags = "@bbcsports")

public class TestRunner {
}
