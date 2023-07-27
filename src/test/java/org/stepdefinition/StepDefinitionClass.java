package org.stepdefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Condition;

import org.baseclass.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pojo.BlockProcessing;
import org.pojo.LoginPojo;
import org.pojo.MicroscopyPojo;
import org.pojo.OrderEntryPage;
import org.pojo.OrderVerificationPojo;
import org.pojo.PatientRegistrationPage;
import org.pojo.ProcedurePojo;
import org.pojo.SpecimenDissection;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionClass extends BaseClass {

	PatientRegistrationPage pr = new PatientRegistrationPage();
	LoginPojo l = new LoginPojo();
	OrderVerificationPojo ov = new OrderVerificationPojo();
	MicroscopyPojo mi = new MicroscopyPojo();
	BlockProcessing bp;
	OrderEntryPage oe;
	ProcedurePojo pp;
	Alert alert;
	Robot r;
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	public static String orderLrn = "";
	public static String lrnSpecimen = "";
	public String bLrn = "";
	public String currentUrl = "";
	public String pasNumber = "";
	public int psSize;
	public int proSize;
	public static String block1 = "";
	public static String proLrn = "";
	Actions act1 = new Actions(driver);

	@Given("User in Login page")
	public void user_in_Login_page() throws InterruptedException {

		driver.get("https://130.78.62.243:444/#/Login");

		String title = driver.getTitle();

		System.out.println("title is : " + title);

		Thread.sleep(5000);
		js1.executeScript("arguments[0].click()", l.getAdvanceOptions());

		Thread.sleep(2000);
		js1.executeScript("arguments[0].click()", l.getProceedLink());

		Thread.sleep(2000);

	}

	@When("user enter valid {string}and{string}")
	public void user_enter_valid_and(String string, String string2) {
		toPassInput(l.getTxtUser(), string);
		toPassInput(l.getTxtPass(), string2);
	}

	@When("user click the login button")
	public void user_click_the_login_button() {
		clickBtn(l.getBtnLogin());
	}

	@Given("Browser launch and User in Login page")
	public void browser_launch_and_user_in_login_page() throws InterruptedException {

		browserLaunch();
		maxWindow();
		urlLaunch();

	}

	@When("User enters invalid username and invalid password")
	public String user_enters_invalid_username_and_invalid_password() throws IOException, InterruptedException {
		toPassInput(l.getTxtUser(), excelRead(1, 0));
		toPassInput(l.getTxtPass(), excelRead(1, 1));
		clickBtn(l.getBtnLogin());
		expWait(l.getTxtUser());
		currentUrl = driver.getCurrentUrl();
		assertTrue("url check", currentUrl.contains("Login"));
		return currentUrl;

	}

	@When("User enters valid username and invalid password")
	public void user_enters_valid_username_and_invalid_password() throws IOException, InterruptedException {
		toPassInput(l.getTxtUser(), excelRead(2, 0));
		toPassInput(l.getTxtPass(), excelRead(2, 1));
		clickBtn(l.getBtnLogin());
		expWait(l.getTxtUser());
		assertFalse("url check", currentUrl.contains("Mainpage"));

	}

	@When("User enters invalid username and valid password")
	public void user_enters_invalid_username_and_valid_password() throws IOException, InterruptedException {
		toPassInput(l.getTxtUser(), excelRead(3, 0));
		toPassInput(l.getTxtPass(), excelRead(3, 1));
		clickBtn(l.getBtnLogin());
		expWait(l.getTxtUser());
		assertFalse("url check", currentUrl.contains("Mainpage"));

	}

	@Then("Verifying toast message Invalid username and Invalid password")
	public void verifying_toast_message_invalid_username_and_invalid_password() {
		expWait(l.getToastMsg());
		String toastmsg1 = l.getToastMsg().getText();
		System.out.println(toastmsg1);
		assertTrue("Verify toast message", toastmsg1.contains("Invalid Username or Password"));
	}

	@When("User enters empty username and valid password")
	public void user_enters_empty_username_and_valid_password() throws IOException, InterruptedException {
		toPassInput(l.getTxtUser(), "");
		toPassInput(l.getTxtPass(), excelRead(4, 1));
		clickBtn(l.getBtnLogin());
		expWait(l.getTxtUser());
		assertFalse("url check", currentUrl.contains("Mainpage"));

	}

	@Then("Verifying toast message Enter the username")
	public void verifying_toast_message_enter_the_username() {
		expWait(l.getToastMsg());
		String toast2 = l.getToastMsg().getText();
		assertTrue("toast2", toast2.contains("Enter the username"));
	}

	@When("User enters empty username and invalid password")
	public void user_enters_empty_username_and_invalid_password() throws IOException, InterruptedException {
		toPassInput(l.getTxtUser(), "");
		toPassInput(l.getTxtPass(), excelRead(5, 1));
		clickBtn(l.getBtnLogin());
		expWait(l.getTxtUser());
		assertFalse("url check", currentUrl.contains("Mainpage"));

	}

	@When("User enters valid username and empty password")
	public void user_enters_valid_username_and_empty_password() throws IOException, InterruptedException {
		toPassInput(l.getTxtUser(), excelRead(6, 0));
		toPassInput(l.getTxtPass(), "");
		clickBtn(l.getBtnLogin());
		expWait(l.getTxtUser());
		assertFalse("url check", currentUrl.contains("Mainpage"));

	}

	@Then("Verifying toast message Enter the password")
	public void verifying_toast_message_enter_the_password() {
		expWait(l.getToastMsg());
		String toast3 = l.getToastMsg().getText();
		System.out.println("toast : " + toast3);
		assertTrue("toast3", toast3.contains("Enter the password"));
	}

	@When("User enters invalid username and empty password")
	public void user_enters_invalid_username_and_empty_password() throws IOException, InterruptedException {
		toPassInput(l.getTxtUser(), excelRead(7, 0));
		toPassInput(l.getTxtPass(), "");
		clickBtn(l.getBtnLogin());
		expWait(l.getTxtUser());
		assertFalse("url check", currentUrl.contains("Mainpage"));

	}

	@When("User enters empty username and empty password")
	public void user_enters_empty_username_and_empty_password() throws IOException, InterruptedException {
		toPassInput(l.getTxtUser(), "");
		toPassInput(l.getTxtPass(), "");
		clickBtn(l.getBtnLogin());
		expWait(l.getTxtUser());
		assertFalse("url check", currentUrl.contains("Mainpage"));

	}

	@When("User enters valid username and valid password")
	public void user_enters_valid_username_and_valid_password() throws IOException, InterruptedException, AWTException {
		toPassInput(l.getTxtUser(), excelRead(9, 0));
		toPassInput(l.getTxtPass(), excelRead(9, 1));
		clickBtn(l.getBtnLogin());
		Thread.sleep(10000);

	}

	@When("User confirming that he is home page")
	public void user_confirming_that_he_is_home_page() throws IOException, InterruptedException {
		assertFalse("Url check", currentUrl.contains("Login"));

	}

	@When("User tring to close the browser and validating the popup")
	public void user_tring_to_close_the_browser_and_validating_the_popup()
			throws InterruptedException, IOException, AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_W);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_W);
	}

	@When("User clicks cancel button")
	public void user_clicks_cancel_button() throws InterruptedException {
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		System.out.println("User clicked cancel button");
	}

	@When("User clicks Leave button")
	public void user_clicks_Leave_button() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_W);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_W);
		Thread.sleep(2000);
		Alert alert2 = driver.switchTo().alert();
		alert2.accept();
		System.out.println("User clicked Leave button");
		assertFalse("url check", currentUrl.contains("Mainpage"));
		assertFalse("url check", currentUrl.contains("Login"));

	}

	@When("User should logout from app")
	public void user_should_logout_from_app() throws InterruptedException {

		Thread.sleep(5000);
		expWait(l.getLogoutBtn());
		js1.executeScript("arguments[0].click()", l.getLogoutBtn());
		assertFalse("checkurl", currentUrl.contains("Mainpage"));
	}

	@When("User enters another valid username and password")
	public void user_enters_another_valid_username_and_password() throws InterruptedException {
		LoginPojo l = new LoginPojo();
		expWait(l.getTxtUser());
		toPassInput(l.getTxtUser(), "SLN");
		expWait(l.getTxtPass());
		toPassInput(l.getTxtPass(), "Password@12");
		clickBtn(l.getBtnLogin());

	}

	@When("User opens another tab")
	public void user_opens_another_tab() throws AWTException, InterruptedException {
		// driver.switchTo().newWindow(WindowType.TAB);
	}

	@When("User clicks some options and Verify user is logged out")
	public void user_clicks_some_options_and_verify_user_is_logged_out() throws InterruptedException {
		WebElement refBtn = driver.findElement(By.xpath(
				"//span[@class=\"mat-tooltip-trigger context-icon-icon mdi mdi-refresh active ng-star-inserted\"]"));
		expWait(refBtn);
		refBtn.click();
		assertFalse("checkurl", currentUrl.contains("Mainpage"));
	}

	@When("User clicks some options and Validate user is not logged out")
	public void user_clicks_some_options_and_validate_user_is_not_logged_out() throws InterruptedException {
		WebElement refBtn = driver.findElement(By.xpath(
				"//span[@class=\"mat-tooltip-trigger context-icon-icon mdi mdi-refresh active ng-star-inserted\"]"));
		expWait(refBtn);
		refBtn.click();
		assertFalse("checkurl", currentUrl.contains("Login"));
	}

	@When("User again enters valid username and valid password")
	public void user_again_enters_valid_username_and_valid_password() throws IOException, InterruptedException {
		impWait();
		WebElement userTxt = driver.findElement(By.id("txtUsername"));
		userTxt.sendKeys("ajay");
		WebElement txtPass = driver.findElement(By.id("txtPassword"));
		txtPass.sendKeys("Yatra@1002");
		clickBtn(l.getBtnLogin());

	}

	@When("User again goes to first tab")
	public void user_again_goes_to_first_tab() throws InterruptedException {
		Set<String> handles = driver.getWindowHandles();
		List<String> ls = new ArrayList<String>(handles);
		String parentId = ls.get(0);
		String childId = ls.get(1);
		driver.switchTo().window(parentId);
	}

	@When("User opens another WINDOW")
	public void user_opens_another_WINDOW() {
		// driver.switchTo().newWindow(WindowType.WINDOW);
	}

	@When("User again goes to first WINDOW")
	public void user_again_goes_to_first_WINDOW() {
		Set<String> handles1 = driver.getWindowHandles();
		List<String> ls1 = new ArrayList<String>(handles1);
		String parentId1 = ls1.get(0);
		String childId1 = ls1.get(1);
		driver.switchTo().window(parentId1);
	}

	@When("Click on Order Management menu, Click on CP order entry menu")
	public void click_on_order_management_menu_click_on_cp_order_entry_menu() throws InterruptedException, IOException {
		
		LoginPojo l = new LoginPojo();
		expWait(l.getMenuBtn());
		js1.executeScript("arguments[0].click()", l.getMenuBtn());
		expWait(l.getChooseRole());
		js1.executeScript("arguments[0].click()", l.getChooseRole());
		expWait(l.getRoleDropdown());
		Select s = new Select(l.getRoleDropdown());
		s.selectByVisibleText("AJCPROLE");
		Thread.sleep(20000);
		js1.executeScript("arguments[0].click()", l.getWorkArea());
		expWait(l.getSpeReception());
		js1.executeScript("arguments[0].click()", l.getSpeReception());
		expWait(l.getOrdMgnt());
		js1.executeScript("arguments[0].click()", l.getOrdMgnt());
		expWait(l.getCpOrder());
		js1.executeScript("arguments[0].click()", l.getCpOrder());
		Thread.sleep(20000);
		OrderEntryPage oe = new OrderEntryPage();
		expWait(oe.getCpTab());
		String textCpOrder = driver.getCurrentUrl();
		assertTrue("checking CP order entry is displayed", textCpOrder.contains("CPOrderEntry"));
		assertTrue("checking patient details tab is highlighted", oe.getPatDetailsTab().isEnabled());
		assertTrue("checking quick registration tab is highlighted", oe.getqRegTab().isEnabled());
	}

	@When("Search for the patient using the given name as Arun and Family name as R and click on Search")
	public void search_for_the_patient_using_the_given_name_as_arun_and_family_name_as_r_and_click_on_search()
			throws InterruptedException {
		try {
			toPassInput(l.getgName(), excelRead(12, 1));
			toPassInput(l.getfName(), excelRead(12, 2));
			js1.executeScript("arguments[0].click()", l.getOpenCalender());
			expWait(l.getCalYears());
			js1.executeScript("arguments[0].click()", l.getCalYears());
			expWait(l.getPreviousMonth());
			js1.executeScript("arguments[0].click()", l.getPreviousMonth());
			expWait(l.getChooseYear());
			js1.executeScript("arguments[0].click()", l.getChooseYear());
			expWait(l.getChooseMonth());
			js1.executeScript("arguments[0].click()", l.getChooseMonth());
			expWait(l.getChooseDay());
			js1.executeScript("arguments[0].click()", l.getChooseDay());
			expWait(l.getSeX());
			js1.executeScript("arguments[0].click()", l.getSeX());
			expWait(l.getChooseSex());
			js1.executeScript("arguments[0].click()", l.getChooseSex());
			expWait(l.getSearchBtn());
			js1.executeScript("arguments[0].click()", l.getSearchBtn());
			WebElement table = driver.findElement(By.xpath("(//table)[2]"));
			Thread.sleep(10000);
			WebDriverWait waitForTable = new WebDriverWait(driver, Duration.ofSeconds(50));
			waitForTable.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table)[2]")));
			List<WebElement> allRows = table.findElements(By.tagName("tr"));
			for (int i = 0; i < allRows.size(); i++) {

				WebElement eachRow = allRows.get(0);
				List<WebElement> allData = eachRow.findElements(By.tagName("td"));
				WebElement eachData1 = allData.get(5);
				String pasNumber = eachData1.getText();
				String fName = allData.get(6).getText();
				System.out.println("FAmily name is : "+ fName);
				String gName = allData.get(7).getText();
				System.out.println("Given name is : "+ gName);
				assertTrue("verify family name", fName.contains(excelRead(12, 2)));
				assertTrue("verify given name", gName.contains(excelRead(12, 1)));
				Thread.sleep(3000);
				js1.executeScript("arguments[0].click()", eachData1);
			}

		} catch (Exception e) {
			WebElement iD = driver
					.findElement(By.xpath("//i[@class=\"icon-color fa fa-cog cogg cursor ng-star-inserted\"]"));
			iD.click();
			Thread.sleep(3000);
			expWait(l.getNewOrder());
			js1.executeScript("arguments[0].click()", l.getNewOrder());
		}

	}

	@When("Select the patient from the Grid")
	public void select_the_patient_from_the_grid() throws IOException {
		
		//screenshot
		
		screenShot("two");
		
		expWait(l.getNewOrder());
		assertTrue("check new order button is displayed", l.getNewOrder().isDisplayed());

	}

	@When("Click on New Order button")
	public void click_on_new_order_button() throws InterruptedException {
		js1.executeScript("arguments[0].click()", l.getNewOrder());
		ArrayList specimenPane = new ArrayList();
		List<WebElement> spList = driver.findElements(By.xpath("//div[@id=\"SpecimenList\"]"));
		WebDriverWait waitForTable = new WebDriverWait(driver, Duration.ofSeconds(20));
		waitForTable.until(ExpectedConditions.visibilityOfAllElements(spList));
		for (int i = 0; i < spList.size(); i++) {
			String spListDatas = spList.get(i).getText();
			specimenPane.add(spListDatas);
			assertTrue("checnking specimen/block/procedure pane is displayed", specimenPane.contains(spListDatas));
		}
		ArrayList orderListPane = new ArrayList();
		List<WebElement> orderDetailsList = driver.findElements(By.xpath("//div[@id=\"CpOrderEntry\"]"));
		for (int i = 0; i < orderDetailsList.size(); i++) {
			String orderListDatas = orderDetailsList.get(i).getText();
			orderListPane.add(orderListDatas);
			assertTrue("checking order Pane", orderListPane.contains(orderListDatas));
		}
	}

	@When("Check for the Patient banner")
	public void check_for_the_patient_banner() {
		ArrayList patBannerPane = new ArrayList();
		List<WebElement> patBanner = driver.findElements(By.xpath("//span[@class=\"banner-header\"]"));
		for (int i = 0; i < patBanner.size(); i++) {
			String patBannerDetails = patBanner.get(i).getText();
			patBannerPane.add(patBannerDetails);
			assertTrue("Verifying patient banner", patBannerPane.contains(patBannerDetails));
			System.out.println("the patient banner details are : " + patBannerDetails);
		}
		System.out.println("Patient banner details : " + patBannerPane);
	}

	@When("Click on the down-arrow key")
	public void click_on_the_down_arrow_key() throws InterruptedException {
		WebElement downArrow = driver.findElement(By.xpath("//mat-icon[text()='keyboard_arrow_down']"));
		assertTrue("verify patient banner down-arrow key", downArrow.isDisplayed());
		js1.executeScript("arguments[0].click()", downArrow);
		Thread.sleep(2000);
		WebElement patFlgContent = driver.findElement(By.xpath("//div[@class=\"patient-flags-content\"]"));
		assertTrue("verify patient flag content is available", patFlgContent.isDisplayed());
		WebElement spReqContent = driver.findElement(By.xpath("//div[@class=\"special-requirements-content\"]"));
		assertTrue("verify special requirement content is available", spReqContent.isDisplayed());
		js1.executeScript("arguments[0].click()", downArrow);
	}

	@When("Select a value from the Location field drop-down or type few characters and select the value EX: BREH")
	public void select_a_value_from_the_location_field_drop_down_or_type_few_characters_and_select_the_value_ex_breh()
			throws InterruptedException {
		try {
			Thread.sleep(8000);
			clickBtn(l.getOeLocation());
		} catch (Exception e) {
			expWait(l.getOeLocation());
			clickBtn(l.getOeLocation());
		}

		WebElement locName = driver.findElement(By.xpath("(//span[text()='Border Region Env Health'])[1]"));
		expWait(locName);
		String breh = locName.getText();
		locName.click();
		WebElement locField = driver.findElement(By.xpath("(//div[text()=' Border Region Env Health '])[1]"));
		String locName1 = locField.getText();
		assertTrue(breh.contains(locName1));
	}

	@When("Select a value from the Clinician field drop-down or type few characters \\(Ste) and select the value EX: SUB")
	public void select_a_value_from_the_clinician_field_drop_down_or_type_few_characters_ste_and_select_the_value_ex_sub()
			throws InterruptedException, AWTException {
		WebElement reqclinician = driver.findElement(By.xpath("(//input[@type=\"text\"])[2]"));
		expWait(reqclinician);
		reqclinician.click();
		reqclinician.sendKeys("sub");
		Thread.sleep(2000);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
		WebElement cliNAme = driver.findElement(By.xpath("//div[text()=\" Subbarayalu Lakshminath \"]"));
		String lakSub = cliNAme.getText();
		assertTrue("verifying clinician name", lakSub.contains("Subbarayalu Lakshminath"));
	}

	@When("Select a value from Patient category drop-down as NHS")
	public void select_a_value_from_patient_category_drop_down_as_nhs() {
		expWait(l.getPatCategory());
		clickBtn(l.getPatCategory());
		expWait(l.getSelectCategory());
		clickBtn(l.getSelectCategory());
		WebElement patCAt = driver.findElement(By.xpath("(//div[text()=' NHS Patient  '])[1]"));
		String nhsPatient = patCAt.getText();
		assertTrue("verifying NHS patient", nhsPatient.contains("NHS Patient"));
	}

	@When("Enter collection date and time")
	public void enter_collection_date_and_time() throws InterruptedException {
		try {
			js1.executeScript("arguments[0].click()", pr.getCpCalender());
			Thread.sleep(1000);
			js1.executeScript("arguments[0].click()", l.getSelectDate());
			Thread.sleep(2000);
			WebElement selClk = driver.findElement(By.xpath("(//input[@type=\"text\"])[4]"));
			selClk.sendKeys("00:10");
		} catch (Exception e) {
			System.out.println("exception handled");
		}

	}

	@When("Enter the details in the following fields -	Clinical Comments,Clinical Diagnosis,Clinical question,Medical Intervention")
	public void enter_the_details_in_the_following_fields_clinical_comments_clinical_diagnosis_clinical_question_medical_intervention() {
		OrderEntryPage oe = new OrderEntryPage();
		String text1 = "New clinical comments added";
		toPassInput(oe.getCliCmnts(), text1);
		String field1 = oe.getCliCmnts().getText();
		assertTrue(text1.contains(field1));
		String text2 = "New clinical diagnosis added";
		toPassInput(oe.getCliDiagnosis(), text2);
		String field2 = oe.getCliDiagnosis().getText();
		assertTrue(text2.contains(field2));
		String text3 = "New clinical question added";
		toPassInput(oe.getCliQuestion(), "New clinical question added");
		String field3 = oe.getCliQuestion().getText();
		assertTrue(text3.contains(field3));
		String text4 = "New medical intervention added";
		toPassInput(oe.getMedIntervention(), "New Medical intervention added");
		String field4 = oe.getMedIntervention().getText();
		assertTrue(text4.contains(field4));
	}

	@When("In the SPECIMEN\\/BLOCK\\/PRCODURE pane click on Specimen")
	public void in_the_specimen_block_prcodure_pane_click_on_specimen() throws InterruptedException {

		// Verify that all the sub-disciplines that the user has access too are
		// displayed

		expWait(l.getSpecimenSelect());
		clickBtn(l.getSpecimenSelect());
		ArrayList disciplineList = new ArrayList();
		List<WebElement> sdList = driver.findElements(By.xpath("(//div[@role=\"region\"])[15]"));
		WebDriverWait waitForList = new WebDriverWait(driver, Duration.ofSeconds(20));
		waitForList.until(ExpectedConditions.visibilityOfAllElements(sdList));
		for (int i = 0; i < sdList.size(); i++) {
			String disciplines = sdList.get(i).getText();
			disciplineList.add(disciplines);
		}
		ArrayList a = new ArrayList();
		a.addAll(disciplineList);
		assertTrue("verifying all the disciplines", disciplineList.equals(a));
	}

	@When("Click on Histology sub-discipline")
	public void click_on_histology_sub_discipline() throws InterruptedException {

		// Verify that all the active specimens are getting displayed

		expWait(l.getSelectHistolgy());
		clickBtn(l.getSelectHistolgy());
		ArrayList specimenList = new ArrayList();
		List<WebElement> activeSpecimens = driver.findElements(By.xpath("(//div[@role=\"region\"])[17]"));
		WebDriverWait waitForList = new WebDriverWait(driver, Duration.ofSeconds(20));
		;
		waitForList.until(ExpectedConditions.visibilityOfAllElements(activeSpecimens));
		for (int i = 0; i < activeSpecimens.size(); i++) {
			String specimenAll = activeSpecimens.get(i).getText();
			specimenList.add(specimenAll);
		}
		ArrayList a = new ArrayList();
		a.addAll(specimenList);
		assertTrue("verifying all the active specimens", specimenList.equals(a));
		System.out.println(a);
	}

	@When("Double click\\/Drag and drop on one of the specimen EX: Breast tissue")
	public String double_click_drag_and_drop_on_one_of_the_specimen_ex_breast_tissue() throws InterruptedException {

		Thread.sleep(5000);
		WebElement dest = driver.findElement(By.xpath("//span[text()=\"Arm\"]"));
		WebElement spdest = driver.findElement(By.xpath("//span[text()=\" ( BRET )\"]"));
		js1.executeScript("arguments[0].scrollIntoView(true)", dest);
		Actions act = new Actions(driver);
		act.doubleClick(spdest).perform();
		Thread.sleep(5000);
		WebElement siteChoose = driver.findElement(By.xpath("//span[text()=\"Left\"]"));
		clickBtn(siteChoose);
		Thread.sleep(5000);
		WebElement lrnDetail = driver.findElement(By.xpath("//div[@class=\"lrn\"]"));
		Thread.sleep(5000);
		orderLrn = lrnDetail.getText();
		List<WebElement> specimenTile = driver.findElements(By.xpath("//div[@class=\"row lrn-wrapper\"]"));
		List li = new ArrayList();
		for (int i = 0; i < specimenTile.size(); i++) {
			String spDetails = specimenTile.get(i).getText();
			li.add(spDetails);
		}
		assertTrue("checking no of blocks", li.size() == 4);
		// procedures
		List pro = new ArrayList();
		List<WebElement> listOfProcedure = driver
				.findElements(By.xpath("//div[@class=\"procedure ng-star-inserted\"]"));
		for (int i = 0; i < listOfProcedure.size(); i++) {
			String procedureDetails = listOfProcedure.get(i).getText();
			pro.add(procedureDetails);
		}
		assertTrue("checking no of procedures", pro.size() == 4);

		// checking primary from specimen card

		WebElement primaryText = driver.findElement(By.xpath("//div[@class=\"primary\"]"));
		String yesorno = primaryText.getText();
		assertTrue("Verify that specimen card displays the specimen as 'Primary'", yesorno.equals("Primary"));
		String specimenLrn = orderLrn + ".A";
		// Verify that the LRN of the specimen is displayed in the specimen tile and
		// specimen

		String spLrnInCArd = driver
				.findElement(By.xpath("//span[@class=\"mat-tooltip-trigger specimen-lrn col-sm-7 col-lg-7\"]"))
				.getText();
		assertTrue(specimenLrn.equals(spLrnInCArd));

		String spLrnInTile = driver.findElement(By.xpath("//div[@class=\"specimen-lrn\"]")).getText();
		assertTrue(specimenLrn.equals(spLrnInTile));

		// selecting specimen site as Right

		js1.executeScript("arguments[0].click()", l.getSpecSite());
		expWait(l.getSiteSide());
		js1.executeScript("arguments[0].click()", l.getSiteSide());

		return orderLrn;

	}

	@When("Drag and drop one more specimen from Histology sub-discipline Ex: Bone")
	public String drag_and_drop_one_more_specimen_from_histology_sub_discipline_ex_bone() throws InterruptedException {

		Thread.sleep(3000);

		lrnSpecimen = orderLrn + ".A";
		WebElement requestTxtField = driver.findElement(By.xpath("//input[@name=\"request\"]"));
		toPassInput(requestTxtField, "frozen");
		Thread.sleep(2000);
		WebElement spLiver = driver.findElement(By.xpath("(//span[text()=' ( FR )'])[1]"));
		Actions act5 = new Actions(driver);
		act5.doubleClick(spLiver).perform();

		// Verifying newly added specimen in specimen tile

		Thread.sleep(5000);
		String newSpecimen = driver.findElement(By.xpath("//div[@class=\"specimen-name col-sm-7 col-md-7 col-lg-8\"]"))
				.getText();
		assertTrue("verify new specimen is added or not", newSpecimen.contains("Frozen"));

		// Verifying the new specimen tile does not contain primary text

		WebElement primaryText = driver.findElement(By.xpath("//div[@class=\"primary\"]"));
		assertTrue(!primaryText.isDisplayed());

		// Verify that the LRN of the specimen is displayed in the specimen tile and
		// specimen card

		String specimenLrnB = orderLrn + ".B";
		String spLrnInCArd = driver
				.findElement(By.xpath("(//span[@class=\"mat-tooltip-trigger specimen-lrn col-sm-7 col-lg-7\"])[2]"))
				.getText();
		assertTrue(specimenLrnB.equals(spLrnInCArd));

		String spLrnInTile = driver.findElement(By.xpath("//div[@class=\"specimen-lrn\"]")).getText();
		assertTrue(specimenLrnB.equals(spLrnInTile));

		return lrnSpecimen;
	}

	@When("In the SPECIMEN\\/BLOCK\\/PRCODURE pane click on Procedure group and select a procedure from histology sub-discipline")
	public int in_the_specimen_block_prcodure_pane_click_on_procedure_group_and_select_a_procedure_from_histology_sub_discipline()
			throws InterruptedException, AWTException {

		// checking no of procedures in block 1 before adding the procedure group

		Thread.sleep(5000);
		WebElement scrollDown = driver.findElement(By.xpath("(//span[text()=\"Arrived\"])[2]"));
		js1.executeScript("arguments[0].scrollIntoView(true)", scrollDown);
		WebElement downArrow = driver.findElement(By.xpath("//div[text()=' White Routine H&E Spare per level ']"));
		Thread.sleep(2000);
		Actions act8 = new Actions(driver);
		act8.moveToElement(downArrow).perform();
		downArrow.click();
		Robot pe = new Robot();
		pe.keyPress(KeyEvent.VK_ENTER);
		pe.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		List psBefore = new ArrayList();
		List<WebElement> bOnePsBefore = driver.findElements(
				By.xpath("//div[@class=\"mat-tooltip-trigger procedure-number col-sm-4 col-md-4 col-lg-4\"]"));
		for (int i = 0; i < bOnePsBefore.size(); i++) {
			String procedureNo = bOnePsBefore.get(i).getText();
			psBefore.add(procedureNo);
		}
		int psSize = psBefore.size();

		OrderEntryPage oe = new OrderEntryPage();
		expWait(oe.getProcedureGrp());
		js1.executeScript("arguments[0].click()", oe.getProcedureGrp());
		expWait(oe.getpGrpHistology());
		js1.executeScript("arguments[0].click()", oe.getpGrpHistology());
		Thread.sleep(2000);
		Actions act6 = new Actions(driver);
		act6.doubleClick(oe.getChoosePGrp()).perform();
		Thread.sleep(2000);
		String msg = oe.getPopupAfterPgrp().getText();
		assertTrue(msg.contains("ADD TO SPECIMEN/BLOCK"));
		return psSize;
	}

	@When("Double click on the second block LRN from popup")
	public int double_click_on_the_second_block_lrn_from_popup() throws InterruptedException, AWTException {

		// checking no of procedures in block 1 after adding the procedure group

		WebElement block1 = driver.findElement(By.xpath("(//div[@class=\"block-lrn\"])[1]"));
		Actions act7 = new Actions(driver);
		act7.doubleClick(block1).perform();
		Thread.sleep(2000);
		List psAfter = new ArrayList();
		List<WebElement> bOnePsAfter = driver.findElements(
				By.xpath("//div[@class=\"mat-tooltip-trigger procedure-number col-sm-4 col-md-4 col-lg-4\"]"));
		for (int i = 0; i < bOnePsAfter.size(); i++) {
			String procedureNo = bOnePsAfter.get(i).getText();
			psAfter.add(procedureNo);
		}
		assertTrue("Verifying selected procedure groups are added only in concern block", psAfter.size() > psSize);
		int proSize = psAfter.size();
		return proSize;
	}

	@When("Delete one of the procedure added to the block by click on X in the procedure card")
	public void delete_one_of_the_procedure_added_to_the_block_by_click_on_x_in_the_procedure_card() {

		// deleting the 1st procedure from block1

		WebElement delOneProc = driver
				.findElement(By.xpath("(//span[@class=\"mat-tooltip-trigger mdi mdi-close ng-star-inserted\"])[2]"));
		expWait(delOneProc);
		delOneProc.click();
		List psAfterDel = new ArrayList();
		List<WebElement> bOnePsAfterDel = driver.findElements(
				By.xpath("//div[@class=\"mat-tooltip-trigger procedure-number col-sm-4 col-md-4 col-lg-4\"]"));
		for (int i = 0; i < bOnePsAfterDel.size(); i++) {
			String procedureNo = bOnePsAfterDel.get(i).getText();
			psAfterDel.add(procedureNo);
		}
		assertTrue("verifying no of procedure in block 1 after deleting one", psAfterDel.size() != proSize);

	}

	@When("Click on Save button")
	public void click_on_save_button() throws InterruptedException {

		// Verify that the order is saved and user is alerted with two success toast
		// message

		OrderEntryPage oe = new OrderEntryPage();
		clickBtn(oe.getOrderSave());

		// 1st message: Order <LRN> saved for patient <Patient number> is displayed

		expWait(l.getToastBottom());
		String firstMsg = l.getToastBottom().getText();
		System.out.println("First msg is : " + firstMsg);
		// assertTrue(firstMsg.contains("saved"));

		// 2nd message: Labels are printed

		expWait(l.getToastMsg());
		try {
			String secondMsg = l.getToastMsg().getText();
			System.out.println("second msg : " + secondMsg);
			assertTrue(secondMsg.contains("Labels are printed."));
		} catch (Exception e) {
			System.out.println("exception handled");
		}

		// focus is set on the registration screen

		WebElement qReg = driver.findElement(By.xpath("//div[text()='Quick registration']"));
		assertTrue(qReg.isDisplayed());
	}

	@Given("Click on Laboratory processing menu and Click on Specimen dissection menu")
	public void click_on_laboratory_processing_menu_and_click_on_specimen_dissection_menu()
			throws InterruptedException {

		// User changes the workarea to specimen dissection first

		expWait(l.getWorkArea());
		js1.executeScript("arguments[0].click()", l.getWorkArea());
		expWait(l.getWorkareaSD());
		js1.executeScript("arguments[0].click()", l.getWorkareaSD());

		// Verify specimen dissection screen should be launched

		expWait(l.getMenuBtn());
		js1.executeScript("arguments[0].click()", l.getMenuBtn());
		expWait(l.getLpMenu());
		js1.executeScript("arguments[0].click()", l.getLpMenu());
		expWait(l.getSelectSpeDis());
		js1.executeScript("arguments[0].click()", l.getSelectSpeDis());
		expWait(l.getScanField());
		String spDiss = driver.getCurrentUrl();
		assertTrue("checking user in specimen dissection page", spDiss.contains("specimendissection"));
	}

	@When("User enters Specimen LRN in the scan field and does search")
	public void user_enters_Specimen_LRN_in_the_scan_field_and_does_search() throws InterruptedException, AWTException {

		// Specimen Lrn is entered in scan field and clicked barcode

		Thread.sleep(25000);
		System.out.println(lrnSpecimen);
		expWait(l.getScanField());
		toPassInput(l.getScanField(), lrnSpecimen);
		js1.executeScript("arguments[0].click()", l.getBarcodeClick());
		expWait(l.getConfirmYes());
		js1.executeScript("arguments[0].click()", l.getConfirmYes());

	}

	@When("Check the details displaying in the Specimen dissection")
	public String check_the_details_displaying_in_the_specimen_dissection() throws IOException, InterruptedException {

		// Verify patient banner should be updated with respective records.

		Thread.sleep(10000);
		expWait(l.getBannerGname());
		String gName = l.getBannerGname().getText();
		// assertTrue("checking patient given name", gName.equals(excelRead(12, 1)));
		String fName = l.getBannerFname().getText();
		// assertTrue("checking patient family name", fName.equals(excelRead(12, 2)));
		String bannerDob = l.getBannerDob().getText();
		// assertTrue("checking patient DOB", bannerDob.equals(excelRead(12, 3)));

		// It displays Specimen LRN, Specimen name and Specimen status, and
		// below that it displays Priority, Block name and Block LRN (brown background)

		List li = new ArrayList();
		List<WebElement> scardDatas = driver.findElements(By.id("mat-expansion-panel-header-51"));
		for (int i = 0; i < scardDatas.size(); i++) {
			String text = scardDatas.get(i).getText();
			li.add(text);
		}

		System.out.println("Complete Details about specimen : " + li);

		// verifying specimen LRN

		boolean cond1 = li.contains(lrnSpecimen);
		assertTrue(cond1 = true);

		// verifying specimen name

		boolean cond2 = li.contains("Mohs");
		assertTrue(cond2 = true);

		// verifying specimen status

		boolean cond3 = li.contains("Arrived");
		assertTrue(cond3 = true);

		// verifying priority

		boolean cond4 = li.contains("Routine");
		assertTrue(cond4 = true);

		// Retreiving block lrn

		block1 = lrnSpecimen + ".1";

		// verifying block Lrn is present or not

		boolean cond5 = li.contains(block1);
		assertTrue(cond5 = true);

		// By default Specimen size and Level will be displayed (if we give level on
		// order entry)

		WebElement size = driver.findElement(By.xpath("//span[text()=\"P1\"]"));
		assertTrue(size.isDisplayed());

		// Previous and Next buttons are Enabled
		OrderEntryPage oe = new OrderEntryPage();
		assertTrue(oe.getPrevBtn().isEnabled());
		assertTrue(oe.getNextBtn().isEnabled());

		return block1;
	}

	@When("On the First Block,Without entering other details, click on Save Blocks.")
	public void on_the_first_block_without_entering_other_details_click_on_save_blocks() {

		// Verifying the warning message

		expWait(l.getSaveBlocks());
		js1.executeScript("arguments[0].click()", l.getSaveBlocks());
		WebElement warningMsg = driver.findElement(By.xpath("//div[@class=\"mat-dialog-content\"]"));
		expWait(warningMsg);
		String actual = warningMsg.getText();
		System.out.println(actual);
		String expected = "Macro is not complete (Number of pieces not entered) Continue?";
		assertTrue(expected.equals(actual));
	}

	@When("Click on No")
	public void click_on_no() {
		expWait(l.getConfirmNo());
		js1.executeScript("arguments[0].click()", l.getConfirmNo());
		WebElement size = driver.findElement(By.xpath("//span[text()=\"P1\"]"));
		assertTrue(size.isDisplayed());

	}

	@When("Again Click on Save Block without entering Pieces, Displays warning , Click on Yes.")
	public void again_click_on_save_block_without_entering_pieces_displays_warning_click_on_yes()
			throws InterruptedException {

		LoginPojo l = new LoginPojo();
		expWait(l.getSaveBlocks());
		js1.executeScript("arguments[0].click()", l.getSaveBlocks());
		Thread.sleep(2000);
		js1.executeScript("arguments[0].click()", l.getConfirmYes());
		expWait(l.getToastBottom());
		String actual = l.getToastBottom().getText();
		System.out.println("toast : " + actual);
		String expected = "Blocks saved";
		assertTrue(actual.contains(expected));
	}

	@When("Again scan the Same Specimen LRN")
	public void again_scan_the_same_specimen_lrn() throws InterruptedException {

		// Scanning the specimen A again and verifying it displays block1 as we didn't
		// enter pieces

		Thread.sleep(5000);
		toPassInput(l.getScanField(), lrnSpecimen);
		expWait(l.getBarcodeClick());
		js1.executeScript("arguments[0].click()", l.getBarcodeClick());
		expWait(l.getConfirmYes());
		js1.executeScript("arguments[0].click()", l.getConfirmYes());
		Thread.sleep(15000);
		WebElement condition = driver.findElement(By.xpath("//div[@class=\"col-lg-12 col-md-12 leftr\"]"));
		String expected = condition.getText();
		System.out.println("no of blocks before selecting disregard check box : " + expected);
		assertTrue(expected.contains(block1));
	}

	@When("For Block1,Enter all the details and	Verify that on selecting the block Corresponding procedure for that block will be displayed")
	public void for_block1_enter_all_the_details_and_verify_that_on_selecting_the_block_corresponding_procedure_for_that_block_will_be_displayed()
			throws AWTException, InterruptedException {

		OrderEntryPage oe = new OrderEntryPage();
		expWait(l.getNoPieces());
		toPassInput(l.getNoPieces(), "1");
		Thread.sleep(3000);
		WebElement scrollDown = driver.findElement(By.xpath("//mat-label[text()=\"Keep settings\"]"));
		js1.executeScript("arguments[0].scrollIntoView(true)", scrollDown);
		js1.executeScript("arguments[0].click()", oe.getDropDownWorkAreaInSd());
		expWait(oe.getChooseSdFromDdown());
		js1.executeScript("arguments[0].click()", oe.getChooseSdFromDdown());
		Thread.sleep(3000);
		expWait(l.getDissUser());
		js1.executeScript("arguments[0].click()", l.getDissUser());
		expWait(l.getRtSearchField1());
		toPassInput(l.getRtSearchField1(), "lakshminath");
		WebElement d = driver.findElement(By.xpath("//span[text()=\"Lakshminath\"]"));
		expWait(d);
		js1.executeScript("arguments[0].click()", d);
		clickBtn(l.getSpeDissHeader());
		js1.executeScript("arguments[0].click()", l.getAssUser());
		expWait(l.getRtSearchField2());
		toPassInput(l.getRtSearchField2(), "AjayBabu");
		WebElement a = driver.findElement(By.xpath("//span[text()=\"AjayBabu\"]"));
		expWait(a);
		js1.executeScript("arguments[0].click()", a);
		clickBtn(l.getSpeDissHeader());
		js1.executeScript("arguments[0].click()", l.getRepPath());
		expWait(l.getRtSearchField3());
		toPassInput(l.getRtSearchField3(), "ajay");
		WebElement r = driver.findElement(By.xpath("//span[text()=\"AjayBabu\"]"));
		expWait(r);
		js1.executeScript("arguments[0].click()", r);
		clickBtn(l.getSpeDissHeader());
		js1.executeScript("arguments[0].click()", l.getSupPath());
		expWait(l.getRtSearchField4());
		toPassInput(l.getRtSearchField4(), "mabel");
		WebElement s = driver.findElement(By.xpath("//span[text()=\"Mabel\"]"));
		expWait(s);
		js1.executeScript("arguments[0].click()", s);
		clickBtn(l.getSpeDissHeader());
		Thread.sleep(3000);
		
	}

	@When("Select Keep Setting check box and Click on click on Next")
	public void select_keep_setting_check_box_and_click_on_click_on_next() {

		// checking keep settings is default, and if not user clicks keep settings and
		// next button

		SpecimenDissection sd = new SpecimenDissection();
		js1.executeScript("arguments[0].scrollIntoView(true)", sd.getKpSetCheckBox());
		boolean condition = sd.getKpSetCheckBox().isSelected();
		System.out.println("keep settings is : " + condition);
		if (condition == true) {
			expWait(sd.getNextBtn());
			js1.executeScript("arguments[0].click()", sd.getNextBtn());
		} else {
			clickBtn(sd.getKpSetCheckBox());
			expWait(sd.getNextBtn());
			clickBtn(sd.getNextBtn());
		}

		// It moves to Block2

		System.out.println("lrn specimen is : " + lrnSpecimen);
		String block2 = lrnSpecimen + ".2";
		System.out.println(block2);
		WebElement lrnBlock2 = driver.findElement(By.xpath("//div[@class=\"col-lg-12 col-md-12 leftr\"]"));
		expWait(lrnBlock2);
		String expected = lrnBlock2.getText();
		System.out.println("block 2 LRN is : "+expected);
		assertTrue(expected.contains(block2));

		// verify all the users of block 1 is retained for block 2 also

		
		System.out.println(l.getDissUser().getText());
		// assertTrue(dissUser.equals("Lakshminath"));

		System.out.println(l.getAssUser().getText());
		// assertTrue(assUser.equals("AjayBabu"));

		System.out.println(l.getRepPath().getText());
		// assertTrue(repPath.equals("AjayBabu"));

		System.out.println(l.getSupPath().getText());
		// assertTrue(supPath.equals("Mabel"));
		
	
	}

	@When("Now enter no.of Pieces on Block2 as One")
	public void now_enter_no_of_pieces_on_block2_as_one() throws InterruptedException {

		// No of pieces entered is 1

		WebElement scrollDown = driver.findElement(By.xpath("//mat-label[text()=\"Keep settings\"]"));
		js1.executeScript("arguments[0].scrollIntoView(true)", scrollDown);
		expWait(l.getNoPieces());
		toPassInput(l.getNoPieces(), "1");
		Thread.sleep(3000);

	}

	@When("Click on Save Block and scan the Same Specimen LRN")
	public void click_on_save_block_and_scan_the_same_specimen_lrn() throws InterruptedException {

		// Block is saved with success message ''Blocks saved for specimen"

		OrderEntryPage oe = new OrderEntryPage();
		expWait(oe.getDropDownWorkAreaInSd());
		js1.executeScript("arguments[0].click()", oe.getDropDownWorkAreaInSd());
		expWait(oe.getChooseSdFromDdown());
		js1.executeScript("arguments[0].click()", oe.getChooseSdFromDdown());
		expWait(l.getSaveBlocks());
		js1.executeScript("arguments[0].click()", l.getSaveBlocks());
		expWait(l.getConfirmYes());
		js1.executeScript("arguments[0].click()", l.getConfirmYes());
		expWait(l.getToastBottom());
		String actual = l.getToastBottom().getText();
		System.out.println("toast : " + actual);
		String expected = "Blocks saved";
		// assertTrue(actual.contains(expected));

		// Scanning the specimen A again and verifying it displays block3 as we didn't
		// enter pieces

		Thread.sleep(5000);
		toPassInput(l.getScanField(), lrnSpecimen);
		expWait(l.getBarcodeClick());
		js1.executeScript("arguments[0].click()", l.getBarcodeClick());
		expWait(l.getConfirmYes());
		js1.executeScript("arguments[0].click()", l.getConfirmYes());
		Thread.sleep(15000);
		WebElement condition = driver.findElement(By.xpath("//div[@class=\"col-lg-12 col-md-12 leftr\"]"));
		expWait(condition);
		String s = condition.getText();
		System.out.println("no of blocks before selecting disregard check box : " + s);
		assertTrue(s.contains("(3/4)"));
	}

	@When("Select Disregard Unused Blocks check box and scan the Same Specimen LRN")
	public void select_disregard_unused_blocks_check_box_and_scan_the_same_specimen_lrn() throws InterruptedException {
		SpecimenDissection sd = new SpecimenDissection();
		js1.executeScript("arguments[0].scrollIntoView(true)", sd.getKpSetCheckBox());
		js1.executeScript("arguments[0].click()", sd.getDisUnused());
		Thread.sleep(3000);
		boolean condition = sd.getDisUnused().isEnabled();
		System.out.println("unused is selected : " + condition);
		expWait(l.getSaveBlocks());
		js1.executeScript("arguments[0].click()", l.getSaveBlocks());
		expWait(l.getConfirmYes());
		js1.executeScript("arguments[0].click()", l.getConfirmYes());

		// scanning the LRN

		Thread.sleep(7000);
		expWait(l.getScanField());
		toPassInput(l.getScanField(), lrnSpecimen);
		expWait(l.getBarcodeClick());
		js1.executeScript("arguments[0].click()", l.getBarcodeClick());
		expWait(l.getConfirmYes());
		js1.executeScript("arguments[0].click()", l.getConfirmYes());
		Thread.sleep(20000);
		WebElement condition1 = driver.findElement(By.xpath("//div[@class=\"col-lg-12 col-md-12 leftr\"]"));
		expWait(condition1);
		String s = condition1.getText();
		System.out.println("no of blocks after selecting disregard check box : " + s);
		assertTrue(s.contains("(1/2)"));

	}

	@When("Select All Tissue used check box and click on save blocks")
	public void select_all_tissue_used_check_box_and_click_on_save_blocks() throws InterruptedException {

		SpecimenDissection sd = new SpecimenDissection();

		// Select the all tissue used check box

		js1.executeScript("arguments[0].click()", sd.getKpSetCheckBox());
		js1.executeScript("arguments[0].click()", sd.getAllTissueUsed());
		Thread.sleep(3000);
		boolean condition = sd.getAllTissueUsed().isEnabled();
		System.out.println("all tissue is selected : " + condition);
		expWait(l.getSaveBlocks());
		js1.executeScript("arguments[0].click()", l.getSaveBlocks());

	}

	@Then("Scan the specimen Lrn again")
	public void scan_the_specimen_lrn_again() throws InterruptedException {

		Thread.sleep(7000);
		expWait(l.getScanField());
		toPassInput(l.getScanField(), lrnSpecimen);
		expWait(l.getBarcodeClick());
		js1.executeScript("arguments[0].click()", l.getBarcodeClick());
		expWait(l.getConfirmYes());
		js1.executeScript("arguments[0].click()", l.getConfirmYes());

		// verify toast message "this specimen cannot be processed"

		expWait(l.getToastBottom());
		String tMsg = l.getToastBottom().getText();
		System.out.println(tMsg);
		assertTrue(tMsg.contains("This specimen cannot be processed"));
	}

	@Given("User changes the workarea to Embed")
	public void user_changes_the_workarea_to_Embed() throws InterruptedException {

		// User changing the workarea as embed to proceed with block processing screen

		expWait(l.getWorkArea());
		js1.executeScript("arguments[0].click()", l.getWorkArea());
		Thread.sleep(5000);
		clickBtn(l.getWorkareaEmbed());

	}

	@When("User selects the block processing worklist from Menu")
	public void user_selects_the_block_processing_worklist_from_Menu() throws InterruptedException {

		// user selects block processing from menu

		impWait();
		js1.executeScript("arguments[0].click()", l.getMenuBtn());
		js1.executeScript("arguments[0].click()", l.getLpMenu());
		js1.executeScript("arguments[0].click()", l.getBpWorklist());
		Thread.sleep(10000);
		String bpScreen = driver.getCurrentUrl();
		System.out.println(bpScreen);
		assertTrue("verify user is in block processing screen", bpScreen.contains("blockprocessing"));
		System.out.println("Block 1 Lrn is : " + block1);

	}

	@When("User Scans the order LRN and validate the corresponding blocks for the order")
	public void user_Scans_the_order_LRN_and_validate_the_corresponding_blocks_for_the_order()
			throws InterruptedException {

		// user scans the block 1 Lrn in scan field

		expWait(l.getScanField());
		toPassInput(l.getScanField(), block1);
		expWait(l.getBarcodeClick());
		js1.executeScript("arguments[0].click()", l.getBarcodeClick());
		expWait(l.getConfirmYes());
		js1.executeScript("arguments[0].click()", l.getConfirmYes());

		// validate edit value section is there

		BlockProcessing bp = new BlockProcessing();
		Thread.sleep(2000);
		js1.executeScript("arguments[0].scrollIntoView(true)", bp.getEditVal());
		assertTrue("edit values is enabled or not", bp.getEditVal().isEnabled());
		boolean b = bp.getEditVal().isEnabled();
		System.out.println("Edit value is : " + b);

		// validate default status is outstanding

		String defStatus = bp.getStatusDrop().getText();
		// assertTrue(defStatus.contains("Outstanding"));

		// verifying expected workarea is specimen dissection by default

		String expWork = bp.getExpWorkarea().getText();
		System.out.println(expWork);
		// assertTrue(expWork.contains("SPECIMEN DISSECTION"));

		// verifying block name is white routine

		String bName = bp.getBlockName().getText();
		System.out.println(bName);
		// assertTrue(bName.contains("White Routine"));
	}

	@When("Verify Print Save Cancel and CAncel EDits button")
	public void verify_print_save_cancel_and_c_ancel_e_dits_button() {

		BlockProcessing bp = new BlockProcessing();

		// Save and cancel edits buttons should be disabled

		WebElement saveBtn = driver.findElement(By.xpath("//span[text()=' SAVE ']"));
		boolean condition1 = saveBtn.isSelected();
		assertTrue("verifying save button", condition1 == false);

		boolean condition2 = bp.getCancelEditsBtn().isSelected();
		assertTrue("verifying cancel edits button", condition2 == false);

		// Print and Cancel buttons are enabled

		assertTrue("verifying print button", bp.getPrintBtn().isEnabled());
		assertTrue("verifying cancel button", bp.getCancelBtn().isEnabled());

	}

	@When("Edit the values and verify the save and cancel Edits button")
	public void edit_the_values_and_verify_the_save_and_cancel_edits_button() throws InterruptedException {

		BlockProcessing bp = new BlockProcessing();
		// selecting the status as Embedding in progress

		js1.executeScript("arguments[0].click()", bp.getStatusDrop());
		Thread.sleep(2000);
		clickBtn(bp.getStatusSelect());

		// entering the instructions

		expWait(bp.getInstructionField());
		toPassInput(bp.getInstructionField(), "Test");

		// now verifying save and cancel buttons are enabled

		assertTrue("verifying save button", bp.getSaveBtn().isEnabled());
		assertTrue("verifying cancel button", bp.getCancelBtn().isEnabled());

	}

	@When("Click on Print button")
	public void click_on_print_button() throws InterruptedException, AWTException {

		BlockProcessing bp = new BlockProcessing();
		clickBtn(bp.getPrintBtn());
		Thread.sleep(5000);
		int size = driver.getWindowHandles().size();
		System.out.println("size of the window is : " + size);
		assertTrue("verifying another window opens and displays the result", size == 2);
		ctrlW();
	}

	@When("Click on Save button in Block Processing screen")
	public String click_on_save_button_in_block_processing_screen() throws InterruptedException {

		Thread.sleep(3000);
		BlockProcessing bp = new BlockProcessing();
		expWait(bp.getSaveBtn());
		js1.executeScript("arguments[0].click()", bp.getSaveBtn());
		expWait(l.getToastBottom());
		String text = l.getToastBottom().getText();
		assertTrue("verifying toast message", text.contains("saved"));

		// finally click cancel button to close the block processing screen

		expWait(bp.getCancelBtn());
		js1.executeScript("arguments[0].click()", bp.getCancelBtn());

		// generating procedure lrn

		proLrn = lrnSpecimen + ".1" + ".1";
		System.out.println("Procedure Lrn is : " + proLrn);
		return proLrn;

	}

	@Given("Click on Laboratory processing menu and Click on Procedure processing worklist menu.")
	public void click_on_laboratory_processing_menu_and_click_on_procedure_processing_worklist_menu()
			throws InterruptedException {

		// Changing the workarea to Microtome 1

		expWait(l.getWorkArea());
		js1.executeScript("arguments[0].click()", l.getWorkArea());
		expWait(l.getMicroWorkArea());
		js1.executeScript("arguments[0].click()", l.getMicroWorkArea());

		// selecting procedure processing from menu

		expWait(l.getMenuBtn());
		js1.executeScript("arguments[0].click()", l.getMenuBtn());
		expWait(l.getLpMenu());
		js1.executeScript("arguments[0].click()", l.getLpMenu());
		expWait(l.getPpWorkArea());
		js1.executeScript("arguments[0].click()", l.getPpWorkArea());

	}

	@When("Scan with Procedure LRN and press ENTER key and Verify the columns in the grid.")
	public void scan_with_procedure_lrn_and_press_enter_key_and_verify_the_columns_in_the_grid()
			throws InterruptedException, AWTException {
		Thread.sleep(5000);
		toPassInput(l.getScanField(), proLrn);
		pressEnter();
		expWait(l.getConfirmYes());
		js1.executeScript("arguments[0].click()", l.getConfirmYes());
		Thread.sleep(5000);

		// verify the procedure LRn is correct in grid

		WebElement table = driver.findElement(By.xpath("(//table)[3]"));
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		for (int i = 0; i < allRows.size(); i++) {

			WebElement eachRow = allRows.get(i);
			List<WebElement> allData = eachRow.findElements(By.tagName("td"));
			WebElement eachData1 = allData.get(2);
			String proNumber = eachData1.getText();
			System.out.println("procedure lrn in grid is : " + proNumber);
			assertTrue(proNumber.equals(proLrn));
		}

	}

	@When("Check the patient details displaying in procedure processing screen")
	public void check_the_patient_details_displaying_in_procedure_processing_screen() throws IOException {

		expWait(l.getBannerGname());
		String gName = l.getBannerGname().getText();
		// assertTrue("checking patient given name", gName.equals(excelRead(12, 1)));
		String fName = l.getBannerFname().getText();
		assertTrue("checking patient family name", fName.equals(excelRead(12, 2)));
		String bannerDob = l.getBannerDob().getText();
		assertTrue("checking patient DOB", bannerDob.equals(excelRead(12, 3)));

	}

	@When("Edit the values and verify the save and cancel Edits button in Pp screen")
	public void edit_the_values_and_verify_the_save_and_cancel_edits_button_in_pp_screen() throws InterruptedException {

		ProcedurePojo pp = new ProcedurePojo();

		js1.executeScript("arguments[0].scrollIntoView(true)", pp.getEditVal());

		// selecting the status as staining completed

		js1.executeScript("arguments[0].click()", pp.getPpStatusDrop());
		Thread.sleep(4000);
		js1.executeScript("arguments[0].click()", pp.getPpStatusSelect());

		// entering the instructions

		expWait(pp.getPpInstructionField());
		toPassInput(pp.getPpInstructionField(), "Test");

		// now verifying save and cancel buttons are enabled

		assertTrue("verifying save button", pp.getPpsaveBtn().isEnabled());
		assertTrue("verifying cancel button", pp.getPpcancelBtn().isEnabled());

	}

	@When("Click on Print button in pp screen")
	public void click_on_print_button_in_pp_screen() throws InterruptedException, AWTException {

		ProcedurePojo pp = new ProcedurePojo();
		clickBtn(pp.getPpprintBtn());
		Thread.sleep(5000);
		int size = driver.getWindowHandles().size();
		System.out.println("size of the window is : " + size);
		assertTrue("verifying another window opens and displays the result", size == 2);
		ctrlW();

	}

	@When("Click on Save button in pp screen")
	public void click_on_save_button_in_pp_screen() throws InterruptedException {

		Thread.sleep(3000);
		ProcedurePojo pp = new ProcedurePojo();
		expWait(pp.getPpsaveBtn());
		js1.executeScript("arguments[0].click()", pp.getPpsaveBtn());
		expWait(l.getToastBottom());
		String text = l.getToastBottom().getText();
		assertTrue("verifying toast message", text.contains("saved"));
		Thread.sleep(10000);

	}

	@When("Click on Assign button.")
	public void click_on_assign_button() throws InterruptedException {

		// Clicking assign button

		ProcedurePojo pp = new ProcedurePojo();
		js1.executeScript("arguments[0].click()", pp.getAssignBtn());
		Thread.sleep(6000);

		// verifying assigned column is highlighted in Grid

		WebElement checkbox = driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[3]"));
		// assertTrue("verifying chech box is selected", checkbox.isSelected());

	}

	@Then("Click on cancel button.")
	public void click_on_cancel_button() {

		// Finally clicking on cancel button
		ProcedurePojo pp = new ProcedurePojo();
		js1.executeScript("arguments[0].click()", pp.getPpcancelBtn());

	}

	@Given("Click on Laboratory processing menu and Click on Order verification menu.")
	public void click_on_laboratory_processing_menu_and_click_on_order_verification_menu() {

		OrderVerificationPojo ov = new OrderVerificationPojo();
		expWait(l.getMenuBtn());
		js1.executeScript("arguments[0].click()", l.getMenuBtn());
		js1.executeScript("arguments[0].click()", l.getLpMenu());
		js1.executeScript("arguments[0].click()", ov.getOrderVerify());

	}

	@When("Scan the Order LRN and hit enter key")
	public void scan_the_order_lrn_and_hit_enter_key() throws InterruptedException, AWTException, IOException {

		OrderVerificationPojo ov = new OrderVerificationPojo();
		Thread.sleep(5000);
		toPassInput(l.getScanField(), orderLrn);
		pressEnter();
		Thread.sleep(10000);
		// Verify respective procedure records against the order LRN
		// has been defaulted in the grid under Verification tab.

		WebElement firstRowPlrn = driver.findElement(By.xpath("((//table)[2]//child::tbody//child::tr//child::td)[4]"));
		String text = firstRowPlrn.getText();
		System.out.println("procedure lrn in ord verification is : " + text);
		assertTrue(text.equals(proLrn));

		// Verify New,Refresh and Cancel should be enabled.

		assertTrue("NewButton", ov.getNewBtn().isEnabled());
		assertTrue("refreshbutton", ov.getRefreshBtn().isEnabled());
		assertTrue("cancelbutton", ov.getCancelBtn().isEnabled());

		// Validate Verify and Release button should be disabled.

		boolean condition = ov.getVerifyBtn().isSelected();
		System.out.println("Verify button is : " + condition);
		assertTrue(condition == false);

		boolean condition1 = ov.getReleaseBtn().isSelected();
		System.out.println("release button is : " + condition1);
		assertTrue(condition1 == false);

		// verify the patient details in patient banner

		expWait(l.getBannerGname());
		String gName = l.getBannerGname().getText();
		assertTrue("checking patient given name", gName.equals(excelRead(12, 1)));
		String fName = l.getBannerFname().getText();
		assertTrue("checking patient family name", fName.equals(excelRead(12, 2)));
		String bannerDob = l.getBannerDob().getText();
		assertTrue("checking patient DOB", bannerDob.equals(excelRead(12, 3)));

		// verify reporting pathologist is defaulted

		WebElement txtField = driver.findElement(By.xpath("//input[@data-placeholder=\"Reporting pathologist\"]"));
		boolean displayed = txtField.isDisplayed();
		System.out.println("Reporting pathologist is displayed or not : " + displayed);

	}

	@When("Check for the verification and history tab")
	public void check_for_the_verification_and_history_tab() {

		OrderVerificationPojo ov = new OrderVerificationPojo();

		// Verification and History tabs should be present.

		assertTrue(ov.getTabVerification().isDisplayed());
		assertTrue(ov.getTabHistory().isDisplayed());

		// By default verification tab is opened and highlighted

		assertTrue(ov.getTabVerification().isEnabled());
	}

	@When("Double click under scanned column in grid")
	public void double_click_under_scanned_column_in_grid() throws InterruptedException {

		// click one of the procedure in grid and Green tick should appear

		WebElement scannedColoumn = driver
				.findElement(By.xpath("((//table)[2]//child::tbody//child::tr//child::td)[10]"));

		impWait();
		clickBtn(scannedColoumn);
		Thread.sleep(3000);

		assertTrue("green tick", scannedColoumn.isEnabled());

	}

	@When("Check for Verify and Release button")
	public void check_for_verify_and_release_button() {

		// verify button should be enabled

		assertTrue(ov.getVerifyBtn().isEnabled());

		// release button should be enabled

		assertTrue(ov.getReleaseBtn().isEnabled());
	}

	@When("Click on Release button")
	public void click_on_release_button() throws InterruptedException {

		js1.executeScript("arguments[0].click()", ov.getReleaseBtn());

		// verify toast message "order released successfully"

		expWait(l.getToastinOV());
		String message = l.getToastinOV().getText();
		System.out.println(message);
		String expected = "Order verified successfully";
		assertTrue(message.equals(expected));

		// verify it navigates to order verification window

		Thread.sleep(5000);
		String url = driver.getCurrentUrl();
		assertTrue(url.contains("orderverification"));

	}

	@When("Check for the corresponding row under verified column")
	public void check_for_the_corresponding_row_under_verified_column() throws InterruptedException {

		// A green color tick icon in the Verified column should appear.

		WebElement verifiedColoumn = driver
				.findElement(By.xpath("((//table)[2]//child::tbody//child::tr//child::td)[11]"));

		assertTrue("green tick", verifiedColoumn.isEnabled());

	}

	@When("Validate Verify date has been updated against the respective procedure")
	public void validate_verify_date_has_been_updated_against_the_respective_procedure() {

		WebElement verifyDate = driver.findElement(By.xpath("((//table)[2]//child::tbody//child::tr//child::td)[11]"));

		String date = verifyDate.getText();
		System.out.println("date is : " + date);

		assertTrue(verifyDate.isDisplayed());
	}

	@Then("Click on the History tab")
	public void click_on_the_history_tab() throws InterruptedException {

		clickBtn(ov.getTabHistory());
		Thread.sleep(2000);
		boolean dateFilter = ov.getDateFilter().isDisplayed();
		System.out.println(" date Filter icon is : " + dateFilter);
		assertTrue(ov.getDateFilter().isDisplayed());
		boolean locationFilter = ov.getLocationFilter().isDisplayed();
		System.out.println(" location Filter icon is : " + locationFilter);
		assertTrue(ov.getLocationFilter().isDisplayed());

		// verify table contains row which contains data

		WebElement table = driver.findElement(By.xpath("(//table)[2]"));
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		WebElement eachRow = allRows.get(0);
		assertTrue(eachRow.isDisplayed());

	}

	@Given("Click on Result Management menu, Click on Microscopy menu.")
	public void click_on_result_management_menu_click_on_microscopy_menu() throws InterruptedException, IOException {

		MicroscopyPojo mi = new MicroscopyPojo();

		// Go to result management
		js1.executeScript("arguments[0].click()", l.getMenuBtn());
		Thread.sleep(2000);
		js1.executeScript("arguments[0].scrollIntoView(true)", mi.getResultManage());
		expWait(mi.getResultManage());
		js1.executeScript("arguments[0].click()", mi.getResultManage());
		expWait(mi.getMicroscopyOption());

		// Go to Microscopy and click it

		js1.executeScript("arguments[0].click()", mi.getMicroscopyOption());

		// verifying show worklist and cosd icon is available

		assertTrue(mi.getShowWorklistIcon().isDisplayed());
		assertTrue(mi.getCosdIcon().isDisplayed());

		// verify header microscopy is available

		assertTrue(mi.getHeaderMicroscopy().isDisplayed());
	}

	@When("Enter OR Scan LRN in Scan field and Press ENTER key")
	public void enter_or_scan_lrn_in_scan_field_and_press_enter_key() throws InterruptedException {

		// pass the order Lrn in scan field and click scan icon
		// String lrn = "H22,0004040B";
		Thread.sleep(5000);
		toPassInput(l.getScanField(), orderLrn);
		js1.executeScript("arguments[0].click()", l.getBarcodeClick());
		try {
			WebElement yesBtn = driver.findElement(By.xpath("//span[text()=\"YES\"]"));
			Thread.sleep(3000);
			js1.executeScript("arguments[0].click()", yesBtn);
			expWait(mi.getCancelInPatientReport());
			js1.executeScript("arguments[0].click()", mi.getCancelInPatientReport());

		} catch (Exception e) {
			expWait(mi.getCancelInPatientReport());
			js1.executeScript("arguments[0].click()", mi.getCancelInPatientReport());

		}

		assertTrue(mi.getShowWorklistIcon().isEnabled());

		// verify search icon is disabled

		assertFalse(mi.getSearchIcon().isSelected());

	}

	@When("Check the patient details displaying in Microscopy screen")
	public void check_the_patient_details_displaying_in_microscopy_screen() throws IOException, InterruptedException {

		Thread.sleep(10000);
		expWait(l.getBannerGname());
		String gName = l.getBannerGname().getText();
		// assertTrue("checking patient given name", gName.equals(excelRead(12, 1)));
		String fName = l.getBannerFname().getText();
		assertTrue("checking patient family name", fName.equals(excelRead(12, 2)));
		String bannerDob = l.getBannerDob().getText();
		assertTrue("checking patient DOB", bannerDob.equals(excelRead(12, 3)));

	}

	@When("User Verifies the context icon displaying on left side of the screen")
	public void user_Verifies_the_context_icon_displaying_on_left_side_of_the_screen() {
		assertTrue("Synoptic Wizard", mi.getSynopticIcon().isDisplayed());
		assertTrue("Dignosis coding", mi.getDcodingIcon().isDisplayed());
		assertTrue("Text Block", mi.getTblockIcon().isDisplayed());
		assertTrue("Tally Icon", mi.getTallyIcon().isDisplayed());
		assertTrue("Review Tally Icon", mi.getReviewTallyIcon().isDisplayed());
	}

	@When("User Selects any reporting pathologist from the reporting pathologist field and enter some details on report editor and Click on SAVE AS option")
	public void user_Selects_any_reporting_pathologist_from_the_reporting_pathologist_field_and_enter_some_details_on_report_editor_and_Click_on_SAVE_AS_option()
			throws InterruptedException {
		js1.executeScript("arguments[0].click()", mi.getTwSave());
		impWait();
		js1.executeScript("arguments[0].click()", mi.getTwReportCreated());
		WebElement toast = driver.findElement(By.xpath("//div[@role=\"alert\"]"));
		expWait(toast);
		String msg = toast.getText();
		System.out.println(msg);
		assertTrue("toast msg", msg.contains("saved"));

	}

	@When("User enters order LRN and retreiving the patient")
	public void user_enters_order_LRN_and_retreiving_the_patient() throws InterruptedException {
		Thread.sleep(10000);
		toPassInput(l.getScanField(), orderLrn);
		Thread.sleep(2000);
		js1.executeScript("arguments[0].click()", l.getBarcodeClick());
		Thread.sleep(5000);
		WebElement cancel = driver.findElement(By.xpath("//mat-icon[text()=\" cancel \"]"));
		js1.executeScript("arguments[0].click()", cancel);

	}

	@When("User clicks on insert text blocks option")
	public void user_clicks_on_insert_text_blocks_option() throws InterruptedException {
		
		Thread.sleep(10000);
		expWait(mi.getTblockIcon());
		js1.executeScript("arguments[0].click()", mi.getTblockIcon());
		Thread.sleep(5000);
		assertTrue("verify search field is present", mi.getTblockSearchField().isDisplayed());
		assertTrue("verify expansion", mi.getTblockExpansion().isDisplayed());
		toPassInput(mi.getTblockSearchField(), "action");
		Thread.sleep(5000);
		System.out.println("Hi");
		WebElement tblockTable = driver.findElement(By.xpath("(//table)[8]"));
		List<WebElement> allRowsTblock = tblockTable.findElements(By.tagName("tr"));
		System.out.println("Size of rows : "+allRowsTblock.size());
		for (int i = 0; i < allRowsTblock.size(); i++) {
			WebElement eachrowTblock = allRowsTblock.get(i);
			List<WebElement> allDataTblock = eachrowTblock.findElements(By.tagName("td"));
			System.out.println("All data is : "+allDataTblock.size());
			WebElement tBlock1 = allDataTblock.get(0);
			//clickBtn(tBlock1);
			Thread.sleep(2000);
			clickBtn(tBlock1);
			Thread.sleep(2000);
			js1.executeScript("arguments[0].click()", l.getOrderSave());
		}
		Thread.sleep(3000);
		js1.executeScript("arguments[0].scrollIntoView(true)", mi.getReviewTallyIcon());
		WebElement txtBlock = l.getEditor()
				.findElement(By.xpath("(//div//preceding-sibling::div//child::div//child::p/span)[18]"));
		String content = txtBlock.getText();
		System.out.println("content is : " + content);
		assertTrue("text block is present or not", content.contains("ACTION REQUIRED"));

	}

	

	@When("User click on Synoptic wizard option")
	public void user_click_on_Synoptic_wizard_option() throws InterruptedException {
		js1.executeScript("arguments[0].click()", mi.getSynopticIcon());
		/*
		 * expWait(l.getToastBottom()); String msg = l.getToastMsg().getText();
		 * System.out.println(msg); assertEquals("alert", msg, msg);
		 */
		Thread.sleep(5000);
		js1.executeScript("arguments[0].click()", mi.getTblockIcon());
		Thread.sleep(5000);
		WebElement textblock2 = driver.findElement(By.xpath("(//input[@name=\"textblock\"])[1]"));
		toPassInput(textblock2, "a1");
		Thread.sleep(5000);
		WebElement newTblock = driver.findElement(By.xpath("//span[text()=\" MACRO \"]"));
		js1.executeScript("arguments[0].scrollIntoView(true)", newTblock);
		WebElement tblockTable = driver.findElement(By.xpath("(//table)[8]"));
		List<WebElement> allRowsTblock = tblockTable.findElements(By.tagName("tr"));
		for (int i = 0; i < allRowsTblock.size(); i++) {
			WebElement eachrowTblock = allRowsTblock.get(i);
			List<WebElement> allDataTblock = eachrowTblock.findElements(By.tagName("td"));
			WebElement eachdataTblock1 = allDataTblock.get(0);
			Thread.sleep(2000);
			eachdataTblock1.click();
		}
		js1.executeScript("arguments[0].click()", l.getOrderSave());
		Thread.sleep(5000);
		js1.executeScript("arguments[0].click(0)", mi.getSynopticIcon());
		Thread.sleep(4000);
		WebElement q1 = driver.findElement(By.xpath("//span[text()=\"Yes,patient is having allergy\"]"));
		q1.click();
		WebElement q2 = driver.findElement(By.id("Is the patient taking any treatment?"));
		q2.click();
		Thread.sleep(2000);
		WebElement q3 = driver.findElement(By.xpath("//span[text()=\"Yes,patient is taking treatment\"]"));
		q3.click();
		WebElement q4 = driver.findElement(By.id("How many days does he/she take the treatment?"));
		q4.click();
		toPassInput(q4, "200");
		js1.executeScript("arguments[0].click()", l.getOrderSave());

	}

	@When("User click on Diagnosis coding option")
	public void user_click_on_Diagnosis_coding_option() throws AWTException, InterruptedException {
		Thread.sleep(5000);
		js1.executeScript("arguments[0].click()", mi.getDcodingIcon());
		downEnter();
		Robot r3 = new Robot();
		r3.keyPress(KeyEvent.VK_TAB);
		r3.keyRelease(KeyEvent.VK_TAB);
		WebElement textField1 = driver.findElement(By.xpath("(//input[@type=\"text\"])[3]"));
		toPassInput(textField1, "t24000");
		downEnter();
		r3.keyPress(KeyEvent.VK_TAB);
		r3.keyRelease(KeyEvent.VK_TAB);
		WebElement textField2 = driver.findElement(By.xpath("(//input[@type=\"text\"])[4]"));
		toPassInput(textField2, "m80103");
		downEnter();
		/*
		 * WebElement txtfield =
		 * driver.findElement(By.xpath("(//input[@type=\"text\"])[3]"));
		 * txtfield.click(); Thread.sleep(2000); WebElement dropdown1 =
		 * driver.findElement(By.xpath("//div[@class=\"scrollable-content\"]"));
		 * List<WebElement> options =
		 * dropdown1.findElements(By.xpath("//div[@role=\"option\"]")); for (int i = 0;
		 * i < options.size(); i++) { WebElement eachRow = options.get(i); WebElement
		 * findElement = eachRow.findElement(By.tagName("span")); String
		 * masterSnomedCode= findElement.getText(); if
		 * (masterSnomedCode.contains("T24000 - LARYNX")) { eachRow.click(); break; }
		 * else { continue; } }
		 * 
		 * r3.keyPress(KeyEvent.VK_TAB); r3.keyRelease(KeyEvent.VK_TAB); WebElement
		 * textField1 = driver.findElement(By.xpath("(//input[@type=\"text\"])[3]"));
		 * down(); WebElement dropdown2 =
		 * driver.findElement(By.xpath("//div[@class=\"scrollable-content\"]"));
		 * List<WebElement> options1 =
		 * dropdown2.findElements(By.xpath("//div[@role=\"option\"]")); for (int i = 0;
		 * i < options1.size(); i++) { WebElement eachRow1 = options1.get(i); WebElement
		 * findElement1 = eachRow1.findElement(By.tagName("span")); String
		 * assSnomedCode= findElement1.getText(); if
		 * (assSnomedCode.contains("M80103 - Carcinoma, NOS")) { eachRow1.click();
		 * break; } else { continue; } }
		 */

		Thread.sleep(2000);
		WebElement plusIcon = driver
				.findElement(By.xpath("//span[@class=\"mat-tooltip-trigger mdi mdi-plus cursor\"]"));
		js1.executeScript("arguments[0].click()", plusIcon);
		Thread.sleep(2000);
		WebElement editIcon = driver.findElement(By.xpath("(//i[text()='edit'])[3]"));
		editIcon.click();
		Thread.sleep(2000);
		WebElement mCode = driver.findElement(By.xpath("(//span[text()=\"M80103 - Carcinoma, NOS\"])[1]"));
		assertTrue("check for Mcode", mCode.isDisplayed());
		js1.executeScript("arguments[0].click()", l.getOrderSave());
	}

	@When("User click on Release AS option and selects Final report")
	public void user_click_on_Release_AS_option_and_selects_Final_report() throws InterruptedException {
		js1.executeScript("arguments[0].click()", l.getReleaseAs());
		impWait();
		js1.executeScript("arguments[0].click()", l.getFinalReport());
		Thread.sleep(13000);
		//WebElement findElement = driver.findElement(By.xpath("//span[text()=\"YES\"]"));
		//clickBtn(findElement);
		//Thread.sleep(13000);
		expWait(l.getScanField());
		toPassInput(l.getScanField(), orderLrn);
		js1.executeScript("arguments[0].click()", l.getBarcodeClick());
		Thread.sleep(10000);
		expWait(mi.getPatientReportTab());
		expWait(mi.getCancelInPatientReport());
		js1.executeScript("arguments[0].click()", mi.getCancelInPatientReport());
		Thread.sleep(4000);
		WebElement contIcon = driver.findElement(By.xpath(
				"//span[@class=\"mat-tooltip-trigger context-icon-icon mdi mdi-book-clock has-data ng-star-inserted\"]"));
		js1.executeScript("arguments[0].click()", contIcon);
		Thread.sleep(5000);
		WebElement rpTable = driver.findElement(By.xpath("(//table)[2]"));
		List<WebElement> rpTableRows = rpTable.findElements(By.tagName("tr"));
		for (int i = 0; i < rpTableRows.size(); i++) {
			if (i == 0) {
				WebElement rpEachrow = rpTableRows.get(i);
				List<WebElement> rpAlldatas = rpEachrow.findElements(By.tagName("td"));
				String rpStatus = rpAlldatas.get(8).getText();
				System.out.println(rpStatus);
				assertTrue("Checking Report status is Final", rpStatus.contains("Final"));
			} else {
				break;
			}
		}
		clickBtn(l.getMicroscopyTab());
		Thread.sleep(2000);
		clickBtn(l.getActionIcon());
		Thread.sleep(2000);
		clickBtn(l.getCloseDocument());
	}

	@When("User selects Specimen Worklist from Menu")
	public void user_selects_Specimen_Worklist_from_Menu() throws InterruptedException {
		impWait();
		js1.executeScript("arguments[0].click()", l.getMenuBtn());
		js1.executeScript("arguments[0].click()", l.getLpMenu());
		js1.executeScript("arguments[0].click()", l.getSpWorklist());
	}

	@When("User keeps some criteria in status dropdown and applies filter")
	public void user_keeps_some_criteria_in_status_dropdown_and_applies_filter()
			throws InterruptedException, AWTException {
		Thread.sleep(8000);
		js1.executeScript("arguments[0].click()", l.getSwStatus());
		impWait();
		WebElement arrived = driver.findElement(By.xpath("//div[text()='Select all']"));
		js1.executeScript("arguments[0].click()", arrived);
		Robot rw = new Robot();
		rw.keyPress(KeyEvent.VK_ESCAPE);
		rw.keyRelease(KeyEvent.VK_ESCAPE);
		js1.executeScript("arguments[0].click()", l.getcWCheckBox());
		clickBtn(l.getApplyFilter());
		Thread.sleep(10000);
	}

	@When("User selects CP role from his ROLES")
	public void user_selects_CP_role_from_his_ROLES() throws InterruptedException {
		loginAlert30s();
		Thread.sleep(2000);
		js1.executeScript("arguments[0].click()", l.getMenuBtn());
		Thread.sleep(2000);
		js1.executeScript("arguments[0].click()", l.getChooseRole());
		Thread.sleep(2000);
		Select s = new Select(l.getRoleDropdown());
		s.selectByVisibleText("AJCPROLE");

	}

	@When("User selects one template from the Report Template Dropdown")
	public void user_selects_one_template_from_the_Report_Template_Dropdown() throws InterruptedException {
		Thread.sleep(15000);
		try {
			js1.executeScript("arguments[0].click()", l.getRepYes());
		} catch (Exception e) {
			System.out.println("exception handled");
		}
		js1.executeScript("arguments[0].click()", l.getRtDropdown());
		Thread.sleep(2000);
		toPassInput(l.getRtSearchField(), "CPCT1");
		Thread.sleep(2000);
		clickBtn(l.getChooseRt());
		Thread.sleep(1000);
		js1.executeScript("arguments[0].click()", l.getTwYes());

	}

	@When("User clicks Menu")
	public void user_clicks_Menu() throws InterruptedException {
		Thread.sleep(2000);
		js1.executeScript("arguments[0].click()", l.getMenuBtn());
	}

	@When("User clicks Microscopy under result management")
	public void user_clicks_Microscopy_under_result_management() throws InterruptedException {
		Thread.sleep(2000);
		js1.executeScript("arguments[0].click()", l.getMicroScpy());
	}

	@When("User enters all the fields and saves the patient")
	public void user_enters_all_the_fields_and_saves_the_patient() throws InterruptedException, AWTException {

		Thread.sleep(5000);
		PatientRegistrationPage pr = new PatientRegistrationPage();
		WebElement iD = driver.findElement(By.xpath("//i[@class=\"fa fa-cog cogg cursor ng-star-inserted\"]"));
		iD.click();
		clickBtn(pr.getTitleDropdown());
		Thread.sleep(2000);
		clickBtn(pr.getWordMrs());
		Thread.sleep(3000);
		toPassInput(pr.getGivenName(), "Anitha");
		expWait(pr.getMiddleName());
		toPassInput(pr.getMiddleName(), "k");
		expWait(pr.getFamilyName());
		toPassInput(pr.getFamilyName(), "pandey");
		clickBtn(pr.getGenderDropdown());
		expWait(pr.getGenderFemale());
		clickBtn(pr.getGenderFemale());
		clickBtn(pr.getSexDropdown());
		expWait(pr.getSexFemale());
		clickBtn(pr.getSexFemale());
		clickBtn(pr.getPatientCatDropdown());
		expWait(pr.getWordNhspatient());
		clickBtn(pr.getWordNhspatient());
		expWait(pr.getEthnicityField());
		clickBtn(pr.getEthnicityField());
		expWait(pr.getWordIndian());
		clickBtn(pr.getWordIndian());
		js1.executeScript("arguments[0].click()", pr.getDobButton());
		expWait(l.getCalYears());
		js1.executeScript("arguments[0].click()", pr.getCalYears());
		expWait(l.getChooseYear());
		js1.executeScript("arguments[0].click()", pr.getChooseYear());
		expWait(l.getChooseMonth());
		js1.executeScript("arguments[0].click()", pr.getChooseMonth());
		expWait(l.getChooseDay());
		js1.executeScript("arguments[0].click()", pr.getChooseDay());
		js1.executeScript("arguments[0].click()", pr.getDodButton());
		expWait(pr.getCurrentDate());
		clickBtn(pr.getCurrentDate());
		expWait(pr.getSpecialFlagDropdown());
		clickBtn(pr.getSpecialFlagDropdown());
		expWait(pr.getWordSIP());
		clickBtn(pr.getWordSIP());
		Actions ac = new Actions(driver);
		ac.moveToElement(pr.getMiddleName()).click().perform();
		/*
		 * Robot e = new Robot(); e.keyPress(KeyEvent.VK_TAB);
		 * e.keyRelease(KeyEvent.VK_TAB);
		 */
		expWait(pr.getPregnantCheckBox());
		js1.executeScript("arguments[0].click()", pr.getPregnantCheckBox());
		expWait(pr.getGestationField());
		toPassInput(pr.getGestationField(), "25");
		expWait(pr.getHazardField());
		clickBtn(pr.getHazardField());
		expWait(pr.getWordHepatitis());
		clickBtn(pr.getWordHepatitis());
		toPassInput(pr.getAddress1(), "east west pharma");
		toPassInput(pr.getAddress2(), "2nd street");
		toPassInput(pr.getTownField(), "vadapalani");
		toPassInput(pr.getCityField(), "chennai");
		js1.executeScript("arguments[0].click()", pr.getCountryField());
		expWait(pr.getWordIndia());
		clickBtn(pr.getWordIndia());
		toPassInput(pr.getPostcodeField(), "636102");
		toPassInput(pr.getEmailField(), "skyblue@gmail.com");
		Thread.sleep(2000);
		toPassInput(pr.getMobileField(), "90000900009");
		Thread.sleep(2000);
		js1.executeScript("arguments[0].scrollIntoView(true)", pr.getSaveBtn());
		js1.executeScript("arguments[0].click()", pr.getGpDropdown());
		expWait(pr.getGpName());
		clickBtn(pr.getGpName());
		js1.executeScript("arguments[0].click()", pr.getAddDetailsTab());
		expWait(pr.getKnownasField());
		toPassInput(pr.getKnownasField(), "manishpandey");
		toPassInput(pr.getContactHome(), "6677889910");
		toPassInput(pr.getContactWork(), "043567856");
		js1.executeScript("arguments[0].click()", pr.getPatientNotepadTab());
		Thread.sleep(3000);
		WebElement pfTable = driver.findElement(By.xpath("(//table)[2]"));
		List<WebElement> allRows = pfTable.findElements(By.tagName("tr"));
		WebElement firstRow = allRows.get(0);
		List<WebElement> allDatas = firstRow.findElements(By.tagName("td"));
		allDatas.get(1).click();
		toPassInput(pr.getFreeTextNoteField(), "Patient in high risk");
		clickBtn(pr.getAddupdateBtn());
		js1.executeScript("arguments[0].click()", pr.getSaveBtn());

	}

	@When("User searches the patient with clinician name")
	public void user_searches_the_patient_with_clinician_name() throws InterruptedException, AWTException {

		String expectedLrn = "H21,0000473T";
		Thread.sleep(5000);
		js1.executeScript("arguments[0].click()", pr.getOrderDetails());
		Thread.sleep(2000);
		expWait(pr.getClinicianField());
		clickBtn(pr.getClinicianField());
		Thread.sleep(3000);
		clickBtn(pr.getDrAbbot());
		Thread.sleep(2000);
		clickBtn(pr.getDrAnoka());
		Thread.sleep(2000);
		js1.executeScript("arguments[0].click()", pr.getOrderDetails());
		js1.executeScript("arguments[0].click()", pr.getSearchBtn());
		Thread.sleep(10000);
		List<WebElement> totalPages = driver.findElements(By.xpath("//li[@class=\"ng-star-inserted\"]"));
		int size = totalPages.size();
		System.out.println("size is : " + size);

		if (size > 1) {
			js1.executeScript("arguments[0].click()", pr.getLastPage());
			Thread.sleep(4000);
			WebElement endPoint = driver.findElement(By.xpath("//span[@class=\"k-link k-selected k-pager-nav\"]"));
			String endingPage = endPoint.getText();
			final int parseInt = Integer.parseInt(endingPage);
			System.out.println("parse int is : " + parseInt);
			System.out.println("ending page is : " + endingPage);
			js1.executeScript("arguments[0].click()", pr.getFirstPage());
			System.out.println("parse int is : " + parseInt);
			for (int i = 0; i < parseInt; i++) {
				WebElement tableOne = driver.findElement(By.xpath("(//table)[2]"));
				List<WebElement> allRows = tableOne.findElements(By.tagName("tr"));
				System.out.println("all rows size is : " + allRows.size());
				for (int j = 0; j < allRows.size(); j++) {
					WebElement eachRow = allRows.get(j);
					List<WebElement> allDatas = eachRow.findElements(By.tagName("td"));
					WebElement indexOne = allDatas.get(1);
					String eachLrn = indexOne.getText();
					if (eachLrn.equals(expectedLrn)) {
						Actions dc = new Actions(driver);
						dc.doubleClick(indexOne).perform();
						boolean cond = eachLrn.equals(expectedLrn);
						System.out.println(cond);
						break;
					} else {
						Thread.sleep(2000);
						js1.executeScript("arguments[0].click()", pr.getNextPage());
						WebElement tableOnes = driver.findElement(By.xpath("(//table)[2]"));
						List<WebElement> allRowss = tableOnes.findElements(By.tagName("tr"));
						System.out.println("all rows size is : " + allRowss.size());
						for (int k = 0; k < allRowss.size(); k++) {
							WebElement eachRows = allRowss.get(k);
							List<WebElement> allDatass = eachRows.findElements(By.tagName("td"));
							WebElement indexOnes = allDatass.get(1);
							String eachLrns = indexOnes.getText();
							if (eachLrns.equals(expectedLrn)) {
								Actions dcs = new Actions(driver);
								dcs.doubleClick(indexOnes).perform();
								boolean conds = eachLrns.equals(expectedLrn);
								System.out.println(conds);
								break;
							}

						}

					}

				}
			}
		}
	}

	@When("Click order details tab and verify the calender")
	public void click_order_details_tab_and_verify_the_calender() throws InterruptedException {

		String s = "13-MAR-1965";
		String[] stringSplit = s.split("-");
		ArrayList<String> dateList = new ArrayList<String>(Arrays.asList(stringSplit));
		String year = dateList.get(2);
		int expectedYear = Integer.parseInt(year); // int = 1998;
		System.out.println("expected year is : " + expectedYear);
		Thread.sleep(5000);
		js1.executeScript("arguments[0].click()", pr.getOrderDetails());
		Thread.sleep(2000);
		js1.executeScript("arguments[0].click()", pr.getFromDate());
		Thread.sleep(2000);
		String presentCalPage = pr.getPresentYearButton().getText();
		String[] afterSplit = presentCalPage.split(" ");
		ArrayList<String> strList = new ArrayList<String>(Arrays.asList(afterSplit));
		String string = strList.get(1);
		int m = Integer.parseInt(string);
		System.out.println(string);
		if (expectedYear == m) {
			clickBtn(pr.getDay());
		} else if (expectedYear > m) {
			System.out.println("Sorry the year you have entered is not in the calender");
		} else {
			js1.executeScript("arguments[0].click()", pr.getPresentYearButton());
			Thread.sleep(5000);
			for (int i = 0; i < 10; i++) {
				ArrayList allYearsPageOne = new ArrayList();
				WebElement backwardOne = driver.findElement(By.xpath("(//table)[1]"));
				List<WebElement> allRows = backwardOne.findElements(By.xpath("//tr[@role=\"row\"]"));
				System.out.println("total rows : " + allRows.size());
				for (int k = 0; k < allRows.size(); k++) {
					WebElement eachRow = allRows.get(k);
					List<WebElement> allData = eachRow.findElements(By.tagName("td"));
					for (int j = 0; j < allData.size(); j++) {
						String text = allData.get(j).getText();
						allYearsPageOne.add(text);
					}

				}
				System.out.println(allYearsPageOne);
				if (allYearsPageOne.contains(year)) {
					clickBtn(pr.getYears());
					Thread.sleep(3000);
					clickBtn(pr.getMonth());
					Thread.sleep(3000);
					clickBtn(pr.getDay());
					break;
				} else {
					Thread.sleep(4000);
					clickBtn(pr.getPreviousBtn());

				}
				allYearsPageOne.clear();

			}

		}

	}

}
