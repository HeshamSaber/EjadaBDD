package org.ejadaTest.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/java/resources/features",
        glue = {"org.ejadaTest.stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class RunnerClass extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }}
