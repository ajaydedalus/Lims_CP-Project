package org.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pojo.LoginPojo;

import io.cucumber.core.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static JavascriptExecutor js;

	public static Actions act;

	public static void browserLaunch() {

		WebDriverManager.edgedriver().setup();

		driver = new EdgeDriver();

	}

	public static void urlLaunch() {

		driver.get("http://130.78.62.52:107/#/Login?IPADDRESS=172.22.80.1&MACHINE=DUC-xedvHCLAsTW");

	}

	public static void maxWindow() {

		driver.manage().window().maximize();

	}

	public static void toPassInput(WebElement txtUser, String value) {

		txtUser.sendKeys(value);

	}

	public static void clickBtn(WebElement txtPass) {

		txtPass.click();

	}

	public static void impWait() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public static void scrollUp(WebElement refName) {

		js.executeScript("arguments[0].scrollIntoView(true)", refName);

	}

	public static void scrollDown(WebElement refName) {

		js.executeScript("arguments[0].scrollIntoView(false)", refName);

	}

	public static void mouseOver(WebElement refName) {

		Actions act = new Actions(driver);

		act.moveToElement(refName).perform();
	}

	public static void dragDrop(WebElement src, WebElement dest) {

		act.dragAndDrop(src, dest).perform();

	}

	public static void selectValue(WebElement refName, String text) {

		Select s = new Select(refName);

		s.selectByVisibleText(text);

	}

	public static void expWait(String s) {

		WebDriverWait we = new WebDriverWait(driver, Duration.ofSeconds(30));

		we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(s)));

	}

	public static void closebrowser() {

		driver.close();

	}

	public static String excelRead(int rownum, int cellnum) throws IOException {

		File f = new File("C:\\Users\\ar287\\eclipse-workspace\\LIMS\\TestDatas\\Login - Copy.xlsx");

		FileInputStream fi = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fi);

		Sheet sheet = w.getSheet("credintials");

		Row row = sheet.getRow(rownum);

		Cell cell = row.getCell(cellnum);

		int cellType = cell.getCellType();

		String string = "";

		if (cellType == 1) {

			string = cell.getStringCellValue();

		} else if (DateUtil.isCellDateFormatted(cell)) {

			Date date = cell.getDateCellValue();

			SimpleDateFormat sim = new SimpleDateFormat("dd-mmm-yyyy");

			string = sim.format(date);

		} else {

			double numericCellValue = cell.getNumericCellValue();

			long l = (long) numericCellValue;

			string = String.valueOf(l);
		}

		return string;

	}

	public static void screenShot(String filename) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		File dest = new File(
				"C:\\Users\\xajaybabur\\eclipse-workspace\\MavenProject\\screenshots\\LoginPage\\" + filename);

		FileUtils.copyFile(src, dest);

	}

	public static void getUrl(String s) {

		String title = driver.getTitle();
		if (title.contains(s)) {
			System.out.println("User in respective page");
		} else {
			System.out.println("User in irrespective page");
		}

	}

	public static void loginAlert30s() {

		WebDriverWait we = new WebDriverWait(driver, Duration.ofSeconds(30));

		we.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[text()='OK']")));

		WebElement okBtn = driver.findElement(By.xpath("//span[text()='OK']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click()", okBtn);

	}
	public static void loginAlert10s() {

		WebDriverWait we = new WebDriverWait(driver, Duration.ofSeconds(10));

		we.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[text()='OK']")));

		WebElement okBtn = driver.findElement(By.xpath("//span[text()='OK']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click()", okBtn);

	}

	public static void selectGrid(int value) throws InterruptedException {

		WebElement table = driver.findElement(By.xpath("(//table)[2]"));

		List<WebElement> allRows = table.findElements(By.tagName("tr"));

		for (int i = 0; i < allRows.size(); i++) {

			WebElement eachRow = allRows.get(i);
			List<WebElement> allData = eachRow.findElements(By.tagName("td"));
			WebElement eachData1 = allData.get(value);
			impWait();
			eachData1.click();
			Thread.sleep(3000);
		}

	}

	public static void doubleClick(WebElement element) {

		act.doubleClick(element).perform();

	}

	public static void downEnter() throws AWTException, InterruptedException {
		Thread.sleep(2000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void selectGridForBpworklist(int value) throws InterruptedException {

		WebElement table = driver.findElement(By.xpath("(//table)[3]"));

		List<WebElement> allRows = table.findElements(By.tagName("tr"));

		for (int i = 0; i < allRows.size(); i++) {

			WebElement eachRow = allRows.get(i);
			List<WebElement> allData = eachRow.findElements(By.tagName("td"));
			WebElement eachData1 = allData.get(value);
			clickBtn(eachData1);
			Thread.sleep(3000);
		}

	}

	public static void ctrlW() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_W);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_W);

	}

	public static void selectGridForPpworklist(int value) throws InterruptedException {

		WebElement table = driver.findElement(By.xpath("(//table)[3]"));

		List<WebElement> allRows = table.findElements(By.tagName("tr"));

		for (int i = 0; i < allRows.size(); i++) {

			WebElement eachRow = allRows.get(i);
			List<WebElement> allData = eachRow.findElements(By.tagName("td"));
			WebElement eachData1 = allData.get(value);
			impWait();
			clickBtn(eachData1);
			Thread.sleep(3000);
		}
	}

	public static void selectGridOrderVerification() throws InterruptedException {

		WebElement table = driver.findElement(By.xpath("(//table)[2]"));

		List<WebElement> allRows = table.findElements(By.tagName("tr"));

		for (int i = 0; i < allRows.size(); i++) {

			WebElement eachRow = allRows.get(i);
			List<WebElement> allData = eachRow.findElements(By.tagName("td"));
			WebElement eachData1 = allData.get(7);
			impWait();
			clickBtn(eachData1);
			Thread.sleep(3000);
		}
	}


	
}