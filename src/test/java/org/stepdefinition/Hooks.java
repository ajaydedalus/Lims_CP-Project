package org.stepdefinition;

import org.baseclass.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.pojo.LoginPojo;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass {

	@Before
	public void befLogin() {
		browserLaunch();
		maxWindow();
		impWait();

	}
	/*@After(order=0)
	public void aftLogin() {
		driver.quit();

	}*/
	
	@After(order=1)
	public void snapMethod(Scenario s) {
		if (s.isFailed()) {
			
			byte[] screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			s.embed(screenshotAs, "image/png");
			System.out.println("Snapshot taken successfully");
		}

	}
	
}
