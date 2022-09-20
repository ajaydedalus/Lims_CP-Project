package org.stepdefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.baseclass.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.pojo.LoginPojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionClass extends BaseClass {

	LoginPojo l = new LoginPojo();
	Alert alert;
	Robot r;
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	public String orderLrn = "";
	public String specimenLrn = "";
	public String bLrn = "";
	public String currentUrl = "";
	Actions act1 = new Actions(driver);

	@Given("User in Login page")
	public void user_in_Login_page() throws InterruptedException {
		urlLaunch();
		Thread.sleep(5000);
	}

	@When("User enters invalid username and invalid password")
	public String user_enters_invalid_username_and_invalid_password() throws IOException, InterruptedException {
		toPassInput(l.getTxtUser(), excelRead(1, 0));
		toPassInput(l.getTxtPass(), excelRead(1, 1));
		clickBtn(l.getBtnLogin());
		Thread.sleep(6000);
		currentUrl = driver.getCurrentUrl();
		assertTrue("url check", currentUrl.contains("Login"));
		return currentUrl;

	}

	@When("User enters valid username and invalid password")
	public void user_enters_valid_username_and_invalid_password() throws IOException, InterruptedException {
		toPassInput(l.getTxtUser(), excelRead(2, 0));
		toPassInput(l.getTxtPass(), excelRead(2, 1));
		clickBtn(l.getBtnLogin());
		Thread.sleep(8000);
		assertFalse("url check", currentUrl.contains("Mainpage"));

	}

	@When("User enters invalid username and valid password")
	public void user_enters_invalid_username_and_valid_password() throws IOException, InterruptedException {
		toPassInput(l.getTxtUser(), excelRead(3, 0));
		toPassInput(l.getTxtPass(), excelRead(3, 1));
		clickBtn(l.getBtnLogin());
		Thread.sleep(6000);
		assertFalse("url check", currentUrl.contains("Mainpage"));

	}

	@When("User enters empty username and valid password")
	public void user_enters_empty_username_and_valid_password() throws IOException, InterruptedException {
		toPassInput(l.getTxtUser(), "");
		toPassInput(l.getTxtPass(), excelRead(4, 1));
		clickBtn(l.getBtnLogin());
		Thread.sleep(6000);
		assertFalse("url check", currentUrl.contains("Mainpage"));

	}

	@When("User enters empty username and invalid password")
	public void user_enters_empty_username_and_invalid_password() throws IOException, InterruptedException {
		toPassInput(l.getTxtUser(), "");
		toPassInput(l.getTxtPass(), excelRead(5, 1));
		clickBtn(l.getBtnLogin());
		Thread.sleep(6000);
		assertFalse("url check", currentUrl.contains("Mainpage"));

	}

	@When("User enters valid username and empty password")
	public void user_enters_valid_username_and_empty_password() throws IOException, InterruptedException {
		toPassInput(l.getTxtUser(), excelRead(6, 0));
		toPassInput(l.getTxtPass(), "");
		clickBtn(l.getBtnLogin());
		Thread.sleep(6000);
		assertFalse("url check", currentUrl.contains("Mainpage"));

	}

	@When("User enters invalid username and empty password")
	public void user_enters_invalid_username_and_empty_password() throws IOException, InterruptedException {
		toPassInput(l.getTxtUser(), excelRead(7, 0));
		toPassInput(l.getTxtPass(), "");
		clickBtn(l.getBtnLogin());
		Thread.sleep(6000);
		assertFalse("url check", currentUrl.contains("Mainpage"));

	}

	@When("User enters empty username and empty password")
	public void user_enters_empty_username_and_empty_password() throws IOException, InterruptedException {
		toPassInput(l.getTxtUser(), "");
		toPassInput(l.getTxtPass(), "");
		clickBtn(l.getBtnLogin());
		Thread.sleep(6000);
		assertFalse("url check", currentUrl.contains("Mainpage"));

	}

	@When("User enters valid username and valid password")
	public void user_enters_valid_username_and_valid_password() throws IOException, InterruptedException, AWTException {
		toPassInput(l.getTxtUser(), excelRead(9, 0));
		toPassInput(l.getTxtPass(), excelRead(9, 1));
		clickBtn(l.getBtnLogin());
		Thread.sleep(6000);
		assertFalse("url check", currentUrl.contains("Login"));
	}

	@When("User confirming that he is home page")
	public void user_confirming_that_he_is_home_page() throws IOException, InterruptedException {
		Thread.sleep(6000);
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
		Thread.sleep(2000);
	}

	@When("User clicks Leave button")
	public void user_clicks_Leave_button() throws InterruptedException, AWTException {
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_W);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_W);
		Thread.sleep(2000);
		Alert alert2 = driver.switchTo().alert();
		alert2.dismiss();
		System.out.println("User clicked Leave button");
		Thread.sleep(5000);
	}

	@When("User should logout from app")
	public void user_should_logout_from_app() throws InterruptedException {

		loginAlert30s();
		expWait("(//div[@class=\"mainpageheadericon\"])[1]");
		WebElement logout = driver.findElement(
				By.xpath("//div[@class=\"mat-tooltip-trigger mdi mdi-logout inactiveText1 font150 cursor\"]"));
		Thread.sleep(5000);
		logout.click();
		Thread.sleep(5000);
	}

	@When("User enters another valid username and password")
	public void user_enters_another_valid_username_and_password() throws InterruptedException {
		WebElement userTxt1 = driver.findElement(By.id("txtUsername"));
		userTxt1.sendKeys("$$");
		WebElement txtPass1 = driver.findElement(By.id("txtPassword"));
		txtPass1.sendKeys("22219020");
		clickBtn(l.getBtnLogin());

	}

	@When("User opens another tab")
	public void user_opens_another_tab() throws AWTException {
		driver.switchTo().newWindow(WindowType.TAB);
	}

	@When("User clicks some options")
	public void user_clicks_some_options() {
		loginAlert30s();
		WebElement refBtn = driver.findElement(By.xpath(
				"//span[@class=\"mat-tooltip-trigger context-icon-icon mdi mdi-refresh active ng-star-inserted\"]"));
		refBtn.click();
	}

	@When("User again enters valid username and valid password")
	public void user_again_enters_valid_username_and_valid_password() throws IOException, InterruptedException {
		WebElement userTxt = driver.findElement(By.id("txtUsername"));
		userTxt.sendKeys("ajay");
		WebElement txtPass = driver.findElement(By.id("txtPassword"));
		txtPass.sendKeys("ajai133");
		clickBtn(l.getBtnLogin());
		Thread.sleep(10000);
	}

	@When("User again goes to first tab")
	public void user_again_goes_to_first_tab() {
		Set<String> handles = driver.getWindowHandles();
		List<String> ls = new ArrayList<String>(handles);
		String parentId = ls.get(0);
		String childId = ls.get(1);
		driver.switchTo().window(parentId);
	}

	@Then("Validate user is not logged out")
	public void validate_user_is_not_logged_out() throws IOException, InterruptedException {
		Thread.sleep(6000);
		assertFalse("Url check", currentUrl.contains("Login"));

	}

	@When("User opens another WINDOW")
	public void user_opens_another_WINDOW() {
		driver.switchTo().newWindow(WindowType.WINDOW);
	}

	@When("User again goes to first WINDOW")
	public void user_again_goes_to_first_WINDOW() {
		Set<String> handles1 = driver.getWindowHandles();
		List<String> ls1 = new ArrayList<String>(handles1);
		String parentId1 = ls1.get(0);
		String childId1 = ls1.get(1);
		driver.switchTo().window(parentId1);
	}

	@When("User selects CP order entry")
	public void user_selects_CP_order_entry() throws InterruptedException {
		loginAlert30s();
		Thread.sleep(2000);
		js1.executeScript("arguments[0].click()", l.getMenuBtn());
		Thread.sleep(2000);
		js1.executeScript("arguments[0].click()", l.getChooseRole());
		Thread.sleep(2000);
		Select s = new Select(l.getRoleDropdown());
		s.selectByVisibleText("AJCPROLE");
		Thread.sleep(2000);
		try {
			loginAlert10s();
		} catch (Exception e) {
			System.out.println("exception handled");
		}
		js1.executeScript("arguments[0].click()", l.getWorkArea());
		Thread.sleep(3000);
		js1.executeScript("arguments[0].click()", l.getSpeReception());
		Thread.sleep(2000);
		js1.executeScript("arguments[0].click()", l.getOrdMgnt());
		Thread.sleep(2000);
		js1.executeScript("arguments[0].click()", l.getCpOrder());

	}

	@When("User doing patient search with some criteria")
	public void user_doing_patient_search_with_some_criteria() throws IOException, InterruptedException {
		Thread.sleep(7000);
		toPassInput(l.getgName(), excelRead(12, 1));
		toPassInput(l.getfName(), excelRead(12, 2));
		js1.executeScript("arguments[0].click()", l.getOpenCalender());
		Thread.sleep(1000);
		js1.executeScript("arguments[0].click()", l.getCalYears());
		Thread.sleep(1000);
		js1.executeScript("arguments[0].click()", l.getChooseYear());
		Thread.sleep(1000);
		js1.executeScript("arguments[0].click()", l.getChooseMonth());
		Thread.sleep(1000);
		js1.executeScript("arguments[0].click()", l.getChooseDay());
		js1.executeScript("arguments[0].click()", l.getSeX());
		Thread.sleep(1000);
		js1.executeScript("arguments[0].click()", l.getChooseSex());
		js1.executeScript("arguments[0].click()", l.getSearchBtn());
		Thread.sleep(10000);
		selectGrid(5);
		impWait();
		js1.executeScript("arguments[0].click()", l.getNewOrder());
	}

	@When("User Creating a order for that patient")
	public String user_Creating_a_order_for_that_patient() throws InterruptedException, AWTException {
		Thread.sleep(15000);
		clickBtn(l.getOeLocation());
		Thread.sleep(3000);
		clickBtn(l.getOeLocationName());
		WebElement reqclinician = driver.findElement(By.xpath("(//input[@type=\"text\"])[2]"));
		reqclinician.click();
		reqclinician.sendKeys("sub");
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
		clickBtn(l.getPatCategory());
		Thread.sleep(1000);
		clickBtn(l.getSelectCategory());
		clickBtn(l.getCpCalender());
		Thread.sleep(1000);
		clickBtn(l.getSelectDate());
		WebElement selClk = driver.findElement(By.xpath("//input[@id=\"mat-input-70\"]"));
		selClk.sendKeys("00:10");
		clickBtn(l.getSpecimenSelect());
		Thread.sleep(1000);
		clickBtn(l.getSelectHistolgy());
		Thread.sleep(2000);
		WebElement src = driver.findElement(By.xpath("//span[text()='Mohs excision from chin']"));
		js1.executeScript("arguments[0].scrollIntoView(true)", src);
		Actions act = new Actions(driver);
		act.doubleClick(src).perform();
		Thread.sleep(5000);
		WebElement lrnDetail = driver.findElement(By.xpath("//div[@class=\"lrn\"]"));
		orderLrn = lrnDetail.getText();
		js1.executeScript("arguments[0].click()", l.getSpecSite());
		Thread.sleep(1000);
		js1.executeScript("arguments[0].click()", l.getSiteSide());
		js1.executeScript("arguments[0].click()", l.getOrderSave());
		Thread.sleep(12000);
		System.out.println("order Lrn is : " + orderLrn);
		return orderLrn;

	}

	@When("User searching the patient with OrderLrn and validating it")
	public String user_searching_the_patient_with_OrderLrn_and_validating_it()
			throws InterruptedException, AWTException {
		js1.executeScript("arguments[0].click()", l.getOrderDetails());
		Thread.sleep(2000);
		WebElement passLrn = driver.findElement(By.xpath("//input[@id=\"mat-input-83\"]"));
		passLrn.sendKeys(orderLrn);
		toPassInput(l.getOtherId(), "PAS2598");
		js1.executeScript("arguments[0].click()", l.getEnterClinician());
		Thread.sleep(2000);
		WebElement txtSearch = driver.findElement(By.xpath("//input[@placeholder=\"Search\"]"));
		toPassInput(txtSearch, "sub");
		clickBtn(l.getSelectClinician());
		Robot r2 = new Robot();
		r2.keyPress(KeyEvent.VK_TAB);
		r2.keyRelease(KeyEvent.VK_TAB);
		WebElement txtSearch1 = driver.findElement(By.xpath("//input[@placeholder=\"Search\"]"));
		toPassInput(txtSearch1, "breh");
		clickBtn(l.getSelectLocation());
		r2.keyPress(KeyEvent.VK_TAB);
		r2.keyRelease(KeyEvent.VK_TAB);
		clickBtn(l.getOpenCalender());
		Thread.sleep(1000);
		WebElement datPick = driver.findElement(By.xpath("//div[text()=' 1 ']"));
		datPick.click();
		WebElement toDate = driver.findElement(By.xpath("(//button[@aria-label=\"Open calendar\"])[2]"));
		toDate.click();
		Thread.sleep(1000);
		WebElement dateSelect = driver.findElement(By.xpath("//div[text()=' 8 ']"));
		dateSelect.click();
		clickBtn(l.getSearchBtn());
		Thread.sleep(3000);
		WebElement table1 = driver.findElement(By.xpath("(//table)[2]"));
		List<WebElement> allRows1 = table1.findElements(By.tagName("tr"));
		for (int i = 0; i < allRows1.size(); i++) {
			WebElement eachRow1 = allRows1.get(i);
			List<WebElement> allData1 = eachRow1.findElements(By.tagName("td"));
			WebElement eachData1 = allData1.get(1);
			impWait();
			act1.doubleClick(eachData1).perform();
		}
		Thread.sleep(10000);
		WebElement specLrn = driver
				.findElement(By.xpath("//span[@class=\"mat-tooltip-trigger specimen-lrn col-sm-7 col-lg-7\"]"));
		specimenLrn = specLrn.getText();
		System.out.println("specimen Lrn is : " + specimenLrn);
		js1.executeScript("arguments[0].click()", l.getCancelBtn());
		return specimenLrn;

	}

	@When("User changes workarea to specimen dissection")
	public void user_changes_workarea_to_specimen_dissection() throws InterruptedException {
		Thread.sleep(5000);
		js1.executeScript("arguments[0].click()", l.getWorkArea());
		impWait();
		js1.executeScript("arguments[0].click()", l.getWorkareaSD());
	}

	@When("User selects Specimen dissection from Lab Processing dropdown")
	public void user_selects_Specimen_dissection_from_Lab_Processing_dropdown() throws InterruptedException {
		impWait();
		js1.executeScript("arguments[0].click()", l.getMenuBtn());
		impWait();
		js1.executeScript("arguments[0].click()", l.getLpMenu());
		impWait();
		js1.executeScript("arguments[0].click()", l.getSelectSpeDis());

	}

	@When("User enters Specimen LRN in the scan field and does search")
	public void user_enters_Specimen_LRN_in_the_scan_field_and_does_search() throws InterruptedException, AWTException {
		Thread.sleep(17000);
		toPassInput(l.getScanField(), specimenLrn);
		js1.executeScript("arguments[0].click()", l.getBarcodeClick());
		Thread.sleep(2000);
		js1.executeScript("arguments[0].click()", l.getConfirmYes());
		Thread.sleep(23000);
		toPassInput(l.getNoPieces(), "1");
		WebElement scrollDown = driver.findElement(By.xpath("//mat-label[text()=\"Keep settings\"]"));
		js1.executeScript("arguments[0].scrollIntoView(true)", scrollDown);
		toPassInput(l.getDissUser(), "abc");
		downEnter();
		toPassInput(l.getAssUser(), "ajay");
		downEnter();
		toPassInput(l.getRepPath(), "vel");
		downEnter();
		toPassInput(l.getSupPath(), "bala");
		downEnter();
		js1.executeScript("arguments[0].click()", l.getNextBtn());
		Thread.sleep(2000);
		toPassInput(l.getNoPieces(), "1");
		js1.executeScript("arguments[0].click()", l.getSaveBlocks());

	}

	@When("User Scanning the same specimen agian and adding one more block in specimen dissection page")
	public void user_Scanning_the_same_specimen_agian_and_adding_one_more_block_in_specimen_dissection_page()
			throws InterruptedException, AWTException {
		Thread.sleep(5000);
		toPassInput(l.getScanField(), specimenLrn);
		js1.executeScript("arguments[0].click()", l.getBarcodeClick());
		Thread.sleep(2000);
		clickBtn(l.getConfirmYes());
		Thread.sleep(20000);
		js1.executeScript("arguments[0].click()", l.getAddBlocksDropDown());
		downEnter();
		impWait();
		clickBtn(l.getAddBlocksByClick());
		clickBtn(l.getAddBlocksByClick());
		clickBtn(l.getAddBlocks());
		Thread.sleep(25000);
		toPassInput(l.getNoPieces(), "1");
		js1.executeScript("arguments[0].click()", l.getNextBtn());
		Thread.sleep(5000);
		toPassInput(l.getNoPieces(), "1");
		js1.executeScript("arguments[0].click()", l.getSaveBlocks());

	}

	@When("User changes the workarea to Embed")
	public void user_changes_the_workarea_to_Embed() throws InterruptedException {
		Thread.sleep(7000);
		js1.executeScript("arguments[0].click()", l.getWorkArea());
		Thread.sleep(2000);
		js1.executeScript("arguments[0].click()", l.getWorkareaEmbed());

	}

	@When("User selects the block processing worklist from Menu")
	public void user_selects_the_block_processing_worklist_from_Menu() throws InterruptedException {
		impWait();
		js1.executeScript("arguments[0].click()", l.getMenuBtn());
		js1.executeScript("arguments[0].click()", l.getLpMenu());
		js1.executeScript("arguments[0].click()", l.getBpWorklist());

	}

	@When("User Scans the order LRN and validate the corresponding blocks for the order")
	public void user_Scans_the_order_LRN_and_validate_the_corresponding_blocks_for_the_order()
			throws InterruptedException {
		Thread.sleep(10000);
		toPassInput(l.getScanField(), orderLrn);
		js1.executeScript("arguments[0].click()", l.getBarcodeClick());

	}

	@When("User clicks some blocks,modifies edit values section and clicks save button")
	public String user_clicks_some_blocks_modifies_edit_values_section_and_clicks_save_button()
			throws InterruptedException {
		Thread.sleep(20000);
		WebElement table = driver.findElement(By.xpath("(//table)[3]"));

		List<WebElement> allRows = table.findElements(By.tagName("tr"));

		for (int i = 0; i < allRows.size(); i++) {

			WebElement eachRow = allRows.get(i);
			List<WebElement> allData = eachRow.findElements(By.tagName("td"));
			WebElement eachData1 = allData.get(1);
			if (i <= allRows.size()) {
				WebElement blockLrn = allData.get(2);
				bLrn = blockLrn.getText();
			}
			clickBtn(eachData1);
			Thread.sleep(3000);

		}
		System.out.println("block LRN is : " + bLrn);
		js1.executeScript("arguments[0].scrollIntoView(true)", l.getEditVal());
		clickBtn(l.getTxtStatus());
		impWait();
		WebElement embComp = driver.findElement(By.xpath("//span[text()='Embedding completed']"));
		embComp.click();
		toPassInput(l.getTxtInstruction(), "Workarea is EMBED 1");
		clickBtn(l.getOrderSave());
		return bLrn;

	}

	@When("User Scans the specimen LRN and validate the corresponding blocks for the specimen")
	public void user_Scans_the_specimen_LRN_and_validate_the_corresponding_blocks_for_the_specimen()
			throws InterruptedException, AWTException {
		Thread.sleep(10000);
		toPassInput(l.getScanField(), specimenLrn);
		js1.executeScript("arguments[0].click()", l.getBarcodeClick());
		impWait();
		js1.executeScript("arguments[0].click()", l.getConfirmYes());
		Thread.sleep(10000);
		WebElement printBtnBp = driver.findElement(By.xpath("//span[text()=' PRINT ']"));
		js1.executeScript("arguments[0].click()", printBtnBp);
		Thread.sleep(2000);
		ctrlW();
		Thread.sleep(2000);
		js1.executeScript("arguments[0].click()", l.getCancelBtn());

	}

	@When("User changes the workarea to Microtome {int}")
	public void user_changes_the_workarea_to_Microtome(Integer int1) throws InterruptedException {
		Thread.sleep(3000);
		js1.executeScript("arguments[0].click()", l.getWorkArea());
		Thread.sleep(2000);
		js1.executeScript("arguments[0].click()", l.getMicroWorkArea());

	}

	@When("User enters procedure processing worklist from menu")
	public void user_enters_procedure_processing_worklist_from_menu() {
		impWait();
		js1.executeScript("arguments[0].click()", l.getMenuBtn());
		js1.executeScript("arguments[0].click()", l.getLpMenu());
		js1.executeScript("arguments[0].click()", l.getPpWorkArea());
	}

	@When("User scans the order LRN")
	public void user_scans_the_order_LRN() throws InterruptedException {
		Thread.sleep(5000);
		toPassInput(l.getScanField(), orderLrn);
		js1.executeScript("arguments[0].click()", l.getBarcodeClick());
	}

	@When("USer selects some procedures, changing the status and Saved it")
	public void user_selects_some_procedures_changing_the_status_and_Saved_it() throws InterruptedException {
		Thread.sleep(10000);
		selectGridForPpworklist(1);
		js1.executeScript("arguments[0].scrollIntoView(true)", l.getEditVal());
		clickBtn(l.getTxtStatus());
		impWait();
		clickBtn(l.getSeComplete());
		impWait();
		clickBtn(l.getOrderSave());

	}

	@When("User Scans specimen Lrn")
	public void user_Scans_specimen_Lrn() throws InterruptedException {
		Thread.sleep(5000);
		toPassInput(l.getScanField(), specimenLrn);
		impWait();
		js1.executeScript("arguments[0].click()", l.getBarcodeClick());
		Thread.sleep(2000);
		clickBtn(l.getConfirmYes());
		Thread.sleep(5000);
	}

	@When("User scans the block Lrn")
	public void user_scans_the_block_Lrn() throws InterruptedException {
		Thread.sleep(5000);
		toPassInput(l.getScanField(), bLrn);
		impWait();
		js1.executeScript("arguments[0].click()", l.getBarcodeClick());
		Thread.sleep(2000);
		clickBtn(l.getConfirmYes());
	}

	@When("User clicks cancel")
	public void user_clicks_cancel() throws InterruptedException {
		Thread.sleep(2000);
		js1.executeScript("arguments[0].click()", l.getCancelBtn());
	}

	@When("User Selects order verication from Menu")
	public void user_Selects_order_verication_from_Menu() {
		impWait();
		js1.executeScript("arguments[0].click()", l.getMenuBtn());
		js1.executeScript("arguments[0].click()", l.getLpMenu());
		js1.executeScript("arguments[0].click()", l.getOrderVerify());
	}

	@When("User enters order Lrn and Scans it")
	public void user_enters_order_Lrn_and_Scans_it() throws InterruptedException {
		Thread.sleep(5000);
		toPassInput(l.getScanField(), orderLrn);
		js1.executeScript("arguments[0].click()", l.getBarcodeClick());

	}

	@When("User selects some of the procedure from the grid and clicks Release button")
	public void user_selects_some_of_the_procedure_from_the_grid_and_clicks_Release_button()
			throws InterruptedException {
		Thread.sleep(7000);
		selectGridOrderVerification();
		clickBtn(l.getReleaseBtn());
	}

	@When("User verifies the procedure is released for the patient")
	public void user_verifies_the_procedure_is_released_for_the_patient() throws InterruptedException {
		Thread.sleep(5000);
		WebElement table = driver.findElement(By.xpath("(//table)[2]"));

		List<WebElement> tableAllRows = table.findElements(By.tagName("tr"));

		for (int i = 0; i < tableAllRows.size(); i++) {

			WebElement tableEachRow = tableAllRows.get(i);
			List<WebElement> tableAllData = tableEachRow.findElements(By.tagName("td"));
			WebElement tableEachData = tableAllData.get(5);
			String status = tableEachData.getText();
			assertTrue("status check", status.contains("Slide Released"));
			Thread.sleep(3000);

		}

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

	@When("User clicks Result Management from menu")
	public void user_clicks_Result_Management_from_menu() throws InterruptedException {
		Thread.sleep(2000);
		js1.executeScript("arguments[0].click()", l.getResultManage());
	}

	@When("User clicks Typing worklist under result management")
	public void user_clicks_Typing_worklist_under_result_management() throws InterruptedException {
		Thread.sleep(2000);
		js1.executeScript("arguments[0].click()", l.getTypingWork());
	}

	@When("User enters order LRN and retreiving the patient")
	public void user_enters_order_LRN_and_retreiving_the_patient() throws InterruptedException {
		Thread.sleep(10000);
		toPassInput(l.getScanField(), orderLrn);
		Thread.sleep(2000);
		js1.executeScript("arguments[0].click()", l.getBarcodeClick());
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

	@When("User verfifies patient banner details")
	public void user_verfifies_patient_banner_details() throws IOException {
		String gName = l.getBannerGname().getText();
		assertTrue("checking patient given name", gName.equals(excelRead(12, 1)));
		String fName = l.getBannerFname().getText();
		assertTrue("checking patient family name", fName.equals(excelRead(12, 2)));
		String bannerDob = l.getBannerDob().getText();
		System.out.println(bannerDob);
		assertTrue("checking patient DOB", bannerDob.equals(excelRead(12, 3)));

	}

	@When("User Verifies the context icon displaying on left side of the screen")
	public void user_Verifies_the_context_icon_displaying_on_left_side_of_the_screen() {
		assertTrue("Synoptic Wizard", l.getSynopticIcon().isDisplayed());
		assertTrue("Dignosis coding", l.getDcodingIcon().isDisplayed());
		assertTrue("Text Block", l.getTblockIcon().isDisplayed());
		assertTrue("Tally Icon", l.getTallyIcon().isDisplayed());
		assertTrue("Review Tally Icon", l.getReviewTallyIcon().isDisplayed());
	}

	@When("User Selects any reporting pathologist from the reporting pathologist field and enter some details on report editor and Click on SAVE AS option")
	public void user_Selects_any_reporting_pathologist_from_the_reporting_pathologist_field_and_enter_some_details_on_report_editor_and_Click_on_SAVE_AS_option()
			throws InterruptedException {
		js1.executeScript("arguments[0].click()", l.getTwRepPath());
		Thread.sleep(2000);
		js1.executeScript("arguments[0].click()", l.getTwPathName());
		js1.executeScript("arguments[0].click()", l.getTwSave());
		impWait();
		js1.executeScript("arguments[0].click()", l.getTwReportCreated());
		expWait("//div[@class=\"toast-bottom-right toast-container\"]");
		String msg = l.getToastMsg().getText();
		System.out.println(msg);
		assertTrue("toast msg", msg.contains("saved"));

	}

	@When("User clicks on insert text blocks option")
	public void user_clicks_on_insert_text_blocks_option() throws InterruptedException {
		Thread.sleep(10000);
		js1.executeScript("arguments[0].click()", l.getTblockIcon());
		Thread.sleep(5000);
		assertTrue("verify search field is present", l.getTblockSearchField().isDisplayed());
		assertTrue("verify expansion", l.getTblockExpansion().isDisplayed());
		toPassInput(l.getTblockSearchField(), "AsirT");
		Thread.sleep(5000);
		WebElement tblockTable = driver.findElement(By.xpath("(//table)[2]"));
		List<WebElement> allRowsTblock = tblockTable.findElements(By.tagName("tr"));
		for (int i = 0; i < allRowsTblock.size(); i++) {
			WebElement eachrowTblock = allRowsTblock.get(i);
			List<WebElement> allDataTblock = eachrowTblock.findElements(By.tagName("td"));
			WebElement tBlock1 = allDataTblock.get(0);
			tBlock1.click();
			js1.executeScript("arguments[0].click()", l.getOrderSave());
		}
		Thread.sleep(3000);
		js1.executeScript("arguments[0].scrollIntoView(true)", l.getReviewTallyIcon());
		WebElement txtBlock = l.getEditor().findElement(By.xpath("//p[text()='This is my conent']"));
		String content = txtBlock.getText();
		System.out.println("content is : " + content);
		assertTrue("text block is present or not", content.equals("This is my conent"));

	}

	@When("User click on Synoptic wizard option")
	public void user_click_on_Synoptic_wizard_option() throws InterruptedException {
		js1.executeScript("arguments[0].click()", l.getSynopticIcon());
		expWait("//div[@class=\"toast-bottom-right toast-container\"]");
		String msg = l.getToastMsg().getText();
		System.out.println(msg);
		assertEquals("alert", msg, msg);
		Thread.sleep(5000);
		js1.executeScript("arguments[0].click()", l.getTblockIcon());
		Thread.sleep(5000);
		toPassInput(l.getTblockSearchField(), "Smokeq");
		Thread.sleep(5000);
		WebElement newTblock = driver.findElement(By.xpath("//span[text()=' TEXT BLOCK TWO ']"));
		js1.executeScript("arguments[0].scrollIntoView(true)", newTblock);
		WebElement tblockTable = driver.findElement(By.xpath("(//table)[9]"));
		List<WebElement> allRowsTblock = tblockTable.findElements(By.tagName("tr"));
		for (int i = 0; i < allRowsTblock.size(); i++) {
			WebElement eachrowTblock = allRowsTblock.get(i);
			List<WebElement> allDataTblock = eachrowTblock.findElements(By.tagName("td"));
			WebElement eachdataTblock1 = allDataTblock.get(0);
			eachdataTblock1.click();
		}
		js1.executeScript("arguments[0].click()", l.getOrderSave());
		Thread.sleep(5000);
		js1.executeScript("arguments[0].click(0)", l.getSynopticIcon());
		Thread.sleep(4000);
		WebElement q1 = driver.findElement(By.xpath("(//div[text()='Patient does not smoke'])[2]"));
		q1.click();
		WebElement q2 = driver.findElement(By.xpath("//mat-select[@id=\"Specimen type\"]"));
		q2.click();
		Thread.sleep(2000);
		WebElement q3 = driver.findElement(By.xpath("(//div[text()='Total colectomy'])[2]"));
		q3.click();
		js1.executeScript("arguments[0].click()", l.getOrderSave());

	}

	@When("User click on Diagnosis coding option")
	public void user_click_on_Diagnosis_coding_option() throws AWTException, InterruptedException {
		js1.executeScript("arguments[0].click()", l.getDcodingIcon());
		downEnter();
		Robot r3 = new Robot();
		r3.keyPress(KeyEvent.VK_TAB);
		r3.keyRelease(KeyEvent.VK_TAB);
		WebElement txtfield = driver.findElement(By.xpath("(//input[@type=\"text\"])[3]"));
		txtfield.click();
		Thread.sleep(2000);
		WebElement code1 = driver.findElement(By.xpath("//span[text()='T0 - T0']"));
		String masterSnow = code1.getText();
		System.out.println(masterSnow);
		Thread.sleep(2000);
		code1.click();
		r3.keyPress(KeyEvent.VK_TAB);
		r3.keyRelease(KeyEvent.VK_TAB);
		downEnter();
		WebElement plusIcon = driver
				.findElement(By.xpath("//span[@class=\"mat-tooltip-trigger mdi mdi-plus cursor\"]"));
		js1.executeScript("arguments[0].click()", plusIcon);
		Thread.sleep(2000);
		WebElement editIcon = driver.findElement(By.xpath("(//i[text()='edit'])[3]"));
		editIcon.click();
		Thread.sleep(2000);
		WebElement mCode = driver.findElement(By.xpath("(//span[text()='M0 - M0'])[1]"));
		assertTrue("check for Mcode", mCode.isDisplayed());
		js1.executeScript("arguments[0].click()", l.getOrderSave());
	}

	@When("User clicks Microscopy under result management")
	public void user_clicks_Microscopy_under_result_management() throws InterruptedException {
		Thread.sleep(2000);
		js1.executeScript("arguments[0].click()", l.getMicroScpy());
	}

	@When("User click on Release AS option and selects Final report")
	public void user_click_on_Release_AS_option_and_selects_Final_report() throws InterruptedException {
		js1.executeScript("arguments[0].click()", l.getReleaseAs());
		impWait();
		js1.executeScript("arguments[0].click()", l.getFinalReport());
		Thread.sleep(6000);
		toPassInput(l.getScanField(), orderLrn);
		js1.executeScript("arguments[0].click()", l.getBarcodeClick());
		Thread.sleep(10000);
		WebElement contIcon = driver.findElement(By.xpath(
				"//span[@class=\"mat-tooltip-trigger context-icon-icon mdi mdi-book-clock ng-star-inserted has-data\"]"));
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
	}

}
