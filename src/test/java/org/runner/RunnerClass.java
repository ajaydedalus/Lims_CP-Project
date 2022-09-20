package org.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.stepdefinition.JvmReport;

import io.cucumber.java.After;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\ar287\\eclipse-workspace\\LIMS\\src\\test\\resources\\FeatureFiles",
				 glue = "org.stepdefinition",
				 dryRun =false,
				 monochrome = false,
				 tags="@smoke",
				 plugin = {"html:C:\\Users\\ar287\\eclipse-workspace\\LIMS\\Reports\\HtmlReports",
						 "json:C:\\Users\\ar287\\eclipse-workspace\\LIMS\\Reports\\JsonReports\\login.json",
						 "junit:C:\\Users\\ar287\\eclipse-workspace\\LIMS\\Reports\\JunitReports\\log.xml"}
				 )	


public class RunnerClass {

	@AfterClass
	public static void report() {
		
		JvmReport.generateJvmReport("C:\\Users\\ar287\\eclipse-workspace\\LIMS\\Reports\\JsonReports\\login.json");
		

	}
	
}
