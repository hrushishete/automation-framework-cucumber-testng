package TestNgTestRunners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="@target/failed_test.txt",glue="Stepdefinitions",monochrome=true,tags="@test1 or @test2",
plugin = {"html:target/cucumber.html","json:target/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class FailedTestNGRunners extends AbstractTestNGCucumberTests{

	@Override
	@DataProvider(parallel=true)
	public Object[] [] scenarios()
	{
		return super.scenarios();
	}
}
