package org.sample;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
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

public class BrowserLaunch {

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {

		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\xajaybabur\\eclipse-workspace\\Library\\drivers\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();

		driver.get("http://130.78.62.52:107/#/Login?IPADDRESS=192.168.1.2&MACHINE=DHHCLJTL2MQ3");

		driver.manage().window().maximize();

		WebElement txtUser = driver.findElement(By.id("txtUsername"));

		txtUser.sendKeys("$$");

		WebElement txtPass = driver.findElement(By.id("txtPassword"));

		txtPass.sendKeys("22328020");

		WebElement logBtn = driver.findElement(By.id("btnLogin"));

		logBtn.click();

		WebDriverWait we = new WebDriverWait(driver, Duration.ofSeconds(30));

		we.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[text()='OK']")));

		WebElement okBtn = driver.findElement(By.xpath("//span[text()='OK']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click()", okBtn);

		WebElement subDrop = driver.findElement(By.id("mat-select-value-3"));

		js.executeScript("arguments[0].click()", subDrop);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement subDis = driver.findElement(By.xpath("(//div[text()=\"Histology\"])[2]"));

		js.executeScript("arguments[0].click()", subDis);

		we.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("mat-select-value-5")));

		WebElement workArea = driver.findElement(By.id("mat-select-value-5"));

		js.executeScript("arguments[0].click()", workArea);

		WebElement workSelect = driver.findElement(By.xpath("(//div[text()=\"SPECIMEN RECEPTION\"])[2]"));

		js.executeScript("arguments[0].click()", workSelect);

		Thread.sleep(10000);

		WebElement menuOption = driver.findElement(By.xpath("//i[text()='menu']"));

		menuOption.click();

		we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Order management ']")));

		WebElement orderManage = driver.findElement(By.xpath("//div[text()=' Order management ']"));

		orderManage.click();

		we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()=' CP Order entry '])[1]")));

		WebElement orderEntry = driver.findElement(By.xpath("(//div[text()=' CP Order entry '])[1]"));

		orderEntry.click();

		we.until(ExpectedConditions.visibilityOfElementLocated(By.id("Forename")));

		WebElement givName = driver.findElement(By.id("Forename"));

		givName.sendKeys("aa");

		WebElement famName = driver.findElement(By.id("Surname"));

		famName.sendKeys("aa");

		WebElement searchBtn = driver.findElement(By.xpath("(//span[text()=' SEARCH '])[2]"));

		js.executeScript("arguments[0].click()", searchBtn);

		Thread.sleep(5000);

		WebElement patSelect = driver.findElement(By.xpath("//span[text()='AA']"));

		js.executeScript("arguments[0].click()", patSelect);

		WebElement newOrder = driver.findElement(By.xpath("(//span[text()=' NEW ORDER '])[2]"));

		js.executeScript("arguments[0].click()", newOrder);

		Thread.sleep(10000);

		WebElement locaTion = driver.findElement(By.xpath("(//input[@type=\"text\"])[2]"));

		locaTion.click();
		
		Thread.sleep(2000);

		WebElement locName = driver.findElement(By.xpath("(//div[text()='BREH'])[1]"));

		locName.click();
		
		Thread.sleep(2000);

		WebElement reqClini = driver.findElement(By.xpath("(//input[@type=\"text\"])[3]"));

		reqClini.click();
		
		Thread.sleep(2000);

		reqClini.sendKeys("sub");

		Robot s = new Robot();

		s.keyPress(KeyEvent.VK_ENTER);

		s.keyRelease(KeyEvent.VK_ENTER);

		WebElement patCat = driver.findElement(By.xpath("(//input[@type=\"text\"])[4]"));

		patCat.click();
		
		Thread.sleep(2000);

		WebElement catName = driver.findElement(By.xpath("//div[text()=\"NHS Patient \"]"));

		catName.click();

		WebElement calBtn = driver.findElement(By.xpath("(//span[@class=\"mat-button-wrapper\"])[1]"));

		calBtn.click();

		Thread.sleep(2000);

		WebElement calArrow = driver.findElement(By.xpath("//div[@class=\"mat-calendar-arrow\"]"));

		calArrow.click();

		Thread.sleep(2000);

		WebElement yearSelect = driver.findElement(By.xpath("//div[text()=' 1999 ']"));

		yearSelect.click();

		WebElement monSelect = driver.findElement(By.xpath("//div[text()=' MAR ']"));

		monSelect.click();

		WebElement dateSelect = driver.findElement(By.xpath("//div[text()=' 13 ']"));

		dateSelect.click();

		WebElement selClk = driver
				.findElement(By.xpath("(//span[@class=\"mdi mdi-clock-outline transformXIpad clock-icon\"])[1]"));

		js.executeScript("arguments[0].click()", selClk);

		Robot m = new Robot();

		m.keyPress(KeyEvent.VK_ENTER);

		m.keyRelease(KeyEvent.VK_ENTER);

		WebElement speDrop = driver.findElement(By.xpath("//mat-panel-title[text()='Specimen']"));

		speDrop.click();

		Thread.sleep(3000);

		WebElement specHist = driver.findElement(By.xpath("(//mat-panel-title[text()='Histology'])[1]"));

		specHist.click();

		Thread.sleep(3000);
		
		WebElement src = driver.findElement(By.xpath("//span[text()='Mohs excision from chin']"));
		
		js.executeScript("arguments[0].scrollIntoView(true)", src);

		Actions act = new Actions(driver);

		act.doubleClick(src).perform();

		Thread.sleep(5000);
		
		WebElement spSite = driver.findElement(By.xpath("(//span[text()='Specimen site'])[2]"));
		
		js.executeScript("arguments[0].click()", spSite);
		
		Thread.sleep(2000);
		
		WebElement spRight = driver.findElement(By.xpath("//span[text()='Right']"));
		
		spRight.click();

		// Order LRN

		WebElement lrnDetail = driver.findElement(By.xpath("//div[@class=\"lrn\"]"));

		String text = lrnDetail.getText();

		System.out.println("Order LRN is : " + text);

		// specimen LRN

		List<WebElement> specLrn = driver.findElements(By.xpath("//span[@class=\"specimen-lrn col-sm-7 col-lg-7\"]"));

		WebElement webElement = specLrn.get(0);

		String text2 = webElement.getText();

		System.out.println("the specimen LRN is : " + text2);

		Thread.sleep(3000);

		WebElement saveBtn = driver.findElement(By.xpath("//span[text()=' SAVE ']"));

		js.executeScript("arguments[0].click()", saveBtn);

		Thread.sleep(15000);

		WebElement workArea1 = driver.findElement(By.id("mat-select-value-5"));

		js.executeScript("arguments[0].click()", workArea1);

		WebElement workSelect1 = driver.findElement(By.id("mat-option-61"));

		js.executeScript("arguments[0].click()", workSelect1);

		Thread.sleep(10000);

		WebElement menuOption1 = driver.findElement(By.xpath("//i[text()='menu']"));

		js.executeScript("arguments[0].click()", menuOption1);

		Thread.sleep(5000);

		WebElement labProcess = driver.findElement(By.id("mat-expansion-panel-header-5"));

		js.executeScript("arguments[0].click()", labProcess);

		Thread.sleep(5000);

		WebElement specDiss = driver.findElement(By.xpath("//div[text()=' Specimen dissection ']"));

		js.executeScript("arguments[0].click()", specDiss);

		Thread.sleep(3000);

		WebElement scanLrn = driver.findElement(By.xpath("//input[@name=\"lrn\"]"));

		scanLrn.sendKeys(text2);

		WebElement barScan = driver.findElement(By.xpath("//span[@class=\"mdi mdi-barcode-scan\"]"));

		JavascriptExecutor js1 = (JavascriptExecutor) driver;

		js1.executeScript("arguments[0].click()", barScan);
		
		Thread.sleep(3000);
		
		WebElement confirm = driver.findElement(By.xpath("//span[text()='YES']"));
		
		js.executeScript("arguments[0].click()", confirm);

		Thread.sleep(15000);

		//we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-placeholder=\\\"No of pieces\\\"]")));

		WebElement nopieces = driver.findElement(By.xpath("//input[@data-placeholder=\"No of pieces\"]"));

		nopieces.sendKeys("1");

		Thread.sleep(3000);

		WebElement scrollDown = driver.findElement(By.xpath("//mat-label[text()=\"Keep settings\"]"));

		js.executeScript("arguments[0].scrollIntoView(true)", scrollDown);

		Thread.sleep(3000);

		WebElement disUser = driver.findElement(By.xpath("(//input[@type=\"text\"])[2]"));

		disUser.sendKeys("abc");

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_DOWN);

		r.keyPress(KeyEvent.VK_ENTER);

		r.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(3000);

		WebElement asUser = driver.findElement(By.xpath("//input[@data-placeholder=\"Assisting user\"]"));

		asUser.sendKeys("vel");

		r.keyPress(KeyEvent.VK_DOWN);

		r.keyRelease(KeyEvent.VK_DOWN);

		r.keyPress(KeyEvent.VK_ENTER);

		r.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(3000);

		WebElement repPath = driver.findElement(By.xpath("//input[@data-placeholder=\"Reporting pathologist\"]"));

		repPath.sendKeys("vel");

		r.keyPress(KeyEvent.VK_DOWN);

		r.keyRelease(KeyEvent.VK_DOWN);

		r.keyPress(KeyEvent.VK_ENTER);

		r.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(3000);

		WebElement supPath = driver.findElement(By.xpath("//input[@data-placeholder=\"Supervising pathologist\"]"));

		supPath.sendKeys("bala");

		r.keyPress(KeyEvent.VK_DOWN);

		r.keyRelease(KeyEvent.VK_DOWN);

		r.keyPress(KeyEvent.VK_ENTER);

		r.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(2000);
		
		WebElement nextBtn = driver.findElement(By.xpath("//span[text()=' NEXT ']"));

		js.executeScript("arguments[0].click()", nextBtn);

		Thread.sleep(2000);
		
		WebElement nopieces1 = driver.findElement(By.id("pieces"));

		nopieces1.sendKeys("1");

		Thread.sleep(5000);

		WebElement saveButton = driver.findElement(By.xpath("//span[text()=' SAVE BLOCKS ']"));

		js.executeScript("arguments[0].click()", saveButton);

		Thread.sleep(5000);

		//scanning with order LRN to validate order not valid
		
		WebElement scanLrn3 = driver.findElement(By.xpath("//input[@name=\"lrn\"]"));

		scanLrn3.sendKeys(text);

		WebElement barScan2 = driver.findElement(By.xpath("//span[@class=\"mdi mdi-barcode-scan\"]"));

		js.executeScript("arguments[0].click()", barScan2);

		Thread.sleep(2000);

		TakesScreenshot ts1 = (TakesScreenshot) driver;

		File src1 = ts1.getScreenshotAs(OutputType.FILE);

		File dest1 = new File("C:\\Users\\xajaybabur\\eclipse-workspace\\MavenProject\\screenshots\\shot2.png");

		FileUtils.copyFile(src1, dest1);

		WebElement workArea2 = driver.findElement(By.id("mat-select-value-5"));

		workArea2.click();

		Thread.sleep(5000);

		WebElement workSelect2 = driver.findElement(By.xpath("(//div[text()='EMBED 1'])[2]"));

		workSelect2.click();

		Thread.sleep(3000);

		WebElement menuOption2 = driver.findElement(By.xpath("//i[text()='menu']"));

		js.executeScript("arguments[0].click()", menuOption2);

		Thread.sleep(5000);

		WebElement labProcess2 = driver.findElement(By.id("mat-expansion-panel-header-5"));

		js.executeScript("arguments[0].click()", labProcess2);

		Thread.sleep(5000);

		WebElement blkMenu = driver.findElement(By.xpath("//div[text()=\" Block processing worklist \"]"));

		js.executeScript("arguments[0].click()", blkMenu);

		Thread.sleep(5000);

		WebElement scanLrn4 = driver.findElement(By.xpath("//input[@name=\"lrn\"]"));

		scanLrn4.sendKeys(text);

		Thread.sleep(4000);

		WebElement barScan3 = driver.findElement(By.xpath("//span[@class=\"mdi mdi-barcode-scan\"]"));

		js.executeScript("arguments[0].click()", barScan3);

		Thread.sleep(15000);

		WebElement table = driver.findElement(By.xpath("(//table)[3]"));

		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		
		for (int i = 0; i < allRows.size(); i++) {
			
			WebElement eachRow = allRows.get(i);
			List<WebElement> allData = eachRow.findElements(By.tagName("td"));
			WebElement eachData1 = allData.get(1);
			eachData1.click();
			Thread.sleep(3000);
		}

		Thread.sleep(5000);

		WebElement editValues = driver.findElement(By.xpath("//span[text()=' EDIT VALUES ']"));

		js.executeScript("arguments[0].scrollIntoView(true)", editValues);

		Thread.sleep(3000);

		WebElement status = driver.findElement(By.xpath("//input[@data-placeholder=\"Status\"]"));

		js.executeScript("arguments[0].click()", status);

		Thread.sleep(2000);
		
		WebElement embComp = driver.findElement(By.xpath("//span[text()='Embedding completed']"));

		embComp.click();

		WebElement insTruct = driver.findElement(By.id("instruction"));

		insTruct.sendKeys("workarea is EMBED1");

		Thread.sleep(3000);

		WebElement blockSave = driver.findElement(By.xpath("//span[text()=' SAVE ']"));

		blockSave.click();

		Thread.sleep(10000);

		TakesScreenshot ts2 = (TakesScreenshot) driver;

		File src3 = ts2.getScreenshotAs(OutputType.FILE);

		File dest3 = new File("C:\\Users\\xajaybabur\\eclipse-workspace\\MavenProject\\screenshots\\shot3.png");

		FileUtils.copyFile(src3, dest3);

		WebElement workArea3 = driver.findElement(By.id("mat-select-value-5"));

		workArea3.click();

		Thread.sleep(5000);

		WebElement workSelect3 = driver.findElement(By.xpath("(//div[text()='MICROTOME 1'])[2]"));

		workSelect3.click();

		Thread.sleep(3000);

		WebElement menuOption3 = driver.findElement(By.xpath("//i[text()='menu']"));

		js.executeScript("arguments[0].click()", menuOption3);

		Thread.sleep(5000);

		WebElement labProcess3 = driver.findElement(By.id("mat-expansion-panel-header-5"));

		js.executeScript("arguments[0].click()", labProcess3);

		Thread.sleep(5000);

		WebElement ppWork = driver.findElement(By.xpath("//div[text()=\" Procedure processing worklist \"]"));

		ppWork.click();

		Thread.sleep(5000);

		WebElement scanLrn5 = driver.findElement(By.xpath("//input[@name=\"lrn\"]"));

		scanLrn5.sendKeys(text);

		Thread.sleep(4000);

		WebElement barScan4 = driver.findElement(By.xpath("//span[@class=\"mdi mdi-barcode-scan\"]"));

		js.executeScript("arguments[0].click()", barScan4);

		Thread.sleep(10000);

		List<WebElement> allTable1 = driver.findElements(By.tagName("table"));

		WebElement table1 = driver.findElement(By.xpath("(//table)[3]"));

		List<WebElement> allRows1 = table1.findElements(By.tagName("tr"));
		
		for (int i = 0; i < allRows1.size(); i++) {
			
			WebElement eachRow1 = allRows1.get(i);
			
			List<WebElement> allDatas1 = eachRow1.findElements(By.tagName("td"));
			
			WebElement element = allDatas1.get(1);
			
			element.click();
			
			Thread.sleep(3000);
			
		}
		
		Thread.sleep(5000);

		WebElement scrollPrint = driver.findElement(By.xpath("//span[text()=' PRINT ']"));

		js.executeScript("arguments[0].scrollIntoView(true)", scrollPrint);

		Thread.sleep(3000);

		WebElement editVal = driver.findElement(By.xpath("//input[@data-placeholder=\"Status\"]"));

		editVal.click();

		Thread.sleep(3000);

		WebElement stainComp = driver.findElement(By.xpath("//span[text()='Staining completed']"));

		stainComp.click();

		WebElement savePp = driver.findElement(By.xpath("//span[text()=' SAVE ']"));

		savePp.click();

		TakesScreenshot ts3 = (TakesScreenshot) driver;

		File srcpp = ts3.getScreenshotAs(OutputType.FILE);

		File destPp = new File("C:\\Users\\xajaybabur\\eclipse-workspace\\MavenProject\\screenshots\\shot4.png");

		FileUtils.copyFile(srcpp, destPp);

		WebElement printBtn1 = driver.findElement(By.xpath("//span[text()=' PRINT ']"));

		js.executeScript("arguments[0].click()", printBtn1);
		
		WebElement toastIcon = driver.findElement(By.xpath("(//i[@id=\"quicklink\"])[2]"));
		
		js.executeScript("arguments[0].click()", toastIcon);
		
		Thread.sleep(3000);
		
		File toastSrc = ts1.getScreenshotAs(OutputType.FILE);
		
		File toastDest = new File("C:\\Users\\xajaybabur\\eclipse-workspace\\MavenProject\\screenshots\\toastmsg.png");
		
		FileUtils.copyFile(toastSrc, toastDest);
		
		WebElement cancelBut = driver.findElement(By.xpath("//button[@name=\"cancel\"]"));
		
		js.executeScript("arguments[0].click()", cancelBut);
		
		Thread.sleep(3000);

		WebElement menuOption4 = driver.findElement(By.xpath("//i[text()='menu']"));

		js.executeScript("arguments[0].click()", menuOption4);

		
		
		Thread.sleep(3000);

		WebElement labProcess4 = driver.findElement(By.id("mat-expansion-panel-header-5"));

		js.executeScript("arguments[0].click()", labProcess4);

		Thread.sleep(3000);
		
		WebElement ordVerify = driver.findElement(By.xpath("//div[text()=' Order verification ']"));
		
		Thread.sleep(3000);
		
		js.executeScript("arguments[0].click()", ordVerify);
		
		WebElement scanLrn6 = driver.findElement(By.xpath("//input[@id=\"lrn\"]"));

		scanLrn6.sendKeys(text);

		Thread.sleep(4000);

		WebElement barScan5 = driver.findElement(By.xpath("//span[@class=\"mdi mdi-barcode-scan\"]"));

		js.executeScript("arguments[0].click()", barScan5);

		Thread.sleep(10000);
		
		WebElement orderTable = driver.findElement(By.xpath("(//table)[2]"));
		
		List<WebElement> orderRows = orderTable.findElements(By.tagName("tr"));
		
		for (int i = 0; i < orderRows.size(); i++) {
			
			WebElement rowSelect = orderRows.get(i);
			
			List<WebElement> orderDatas = rowSelect.findElements(By.tagName("td"));
			
			WebElement dataSelect = orderDatas.get(7);
			
			act.doubleClick(dataSelect).perform();
			
			Thread.sleep(3000);
		}
		
		WebElement releaseBtn = driver.findElement(By.xpath("//span[text()=' RELEASE ']"));
		
		js.executeScript("arguments[0].click()", releaseBtn);
		

		

		
		

}

}
