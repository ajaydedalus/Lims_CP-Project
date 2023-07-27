package org.stepdefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "C:\\Users\\ar287\\eclipse-workspace\\LIMS\\src\\test\\resources\\FeatureFiles", glue = "org.stepdefinition",

		dryRun = false, monochrome = true, tags = ("@cp"), plugin = {

				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"json:C:\\Users\\ar287\\eclipse-workspace\\LIMS\\Reports\\JsonReports\\report.json",
				"rerun:C:\\Users\\ar287\\eclipse-workspace\\LIMS\\ReRun\\failedCases.txt" })

public class TestRunner {

}
