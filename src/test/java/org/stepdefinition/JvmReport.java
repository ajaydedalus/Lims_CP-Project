package org.stepdefinition;

import java.awt.List;
import java.io.File;
import java.util.ArrayList;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JvmReport {

	public static void generateJvmReport(String jsonPath) {
		
		File f = new File(System.getProperty("user.dir")+"\\Reports\\JvmReports");
		
		Configuration c = new Configuration(f, "LIMS application");
		
		c.addClassifications("sprint", "n");
		
		ArrayList<String> l = new ArrayList<String>();
		
		l.add(jsonPath);

		ReportBuilder r = new ReportBuilder(l, c);
		
		r.generateReports();
	}
}
