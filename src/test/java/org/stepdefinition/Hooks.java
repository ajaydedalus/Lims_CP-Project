package org.stepdefinition;

import org.baseclass.BaseClass;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks extends BaseClass {
	
	
	@Before("@login")
	public void befLogin() throws InterruptedException {
		browserLaunch();
		maxWindow();
		impWait();
		

	}
	
	@Before("@cpLogin")
	public void befCP() throws InterruptedException {
		browserLaunch();
		maxWindow();
		impWait();


	}


	@Before("@td")
	public void beftd() throws InterruptedException {
		browserLaunch();
		maxWindow();
		impWait();

	}
	
	

	@Before("@pd")
	public void befPd() throws InterruptedException {
		browserLaunch();
		maxWindow();
		impWait();

	}

	@After("@td or @pd")
	public void close() throws InterruptedException {
		Thread.sleep(5000);
		closebrowser();
	}

	@AfterStep
	public void snapMethod(Scenario s) {
		if (s.isFailed()) {

			byte[] screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			s.attach(screenshotAs, "image/png", "error msg");

		}

	}
}
