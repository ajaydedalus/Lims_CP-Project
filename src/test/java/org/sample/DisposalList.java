package org.sample;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DisposalList {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\xajaybabur\\eclipse-workspace\\Library\\drivers\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();

		driver.get("http://130.78.62.52:107/#/Login?IPADDRESS=192.168.1.2&MACHINE=DHHCLJTL2MQ3");

		driver.manage().window().maximize();

		WebElement txtUser = driver.findElement(By.id("txtUsername"));

		txtUser.sendKeys("$$");

		WebElement txtPass = driver.findElement(By.id("txtPassword"));

		txtPass.sendKeys("22618020");

		WebElement logBtn = driver.findElement(By.id("btnLogin"));

		logBtn.click();

		WebDriverWait we = new WebDriverWait(driver, Duration.ofSeconds(50));

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

		js.executeScript("arguments[0].click()", menuOption);
		
		we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Order management ']")));

		WebElement orderManage = driver.findElement(By.xpath("//div[text()=' Order management ']"));

		js.executeScript("arguments[0].click()", orderManage);

		we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Disposal list ']")));

		WebElement disList = driver.findElement(By.xpath("//div[text()=' Disposal list ']"));
		
		js.executeScript("arguments[0].click()", disList);
		
		Thread.sleep(10000);
		
		WebElement stsDrop = driver.findElement(By.xpath("(//span[text()='Status'])[1]"));
		
		js.executeScript("arguments[0].click()", stsDrop);
		
		Thread.sleep(3000);
		
		WebElement selStatus = driver.findElement(By.xpath("(//div[text()='Arrived'])[2]"));
		
		js.executeScript("arguments[0].click()", selStatus);
		
		Thread.sleep(2000);
		
		Robot r = new Robot();
		
		r.keyPress(KeyEvent.VK_ESCAPE);
		
		r.keyRelease(KeyEvent.VK_ESCAPE);
		
		WebElement sensCheck = driver.findElement(By.xpath("//mat-label[text()='Sensitive']"));
		
		js.executeScript("arguments[0].click()",sensCheck);
		
		WebElement filBtn = driver.findElement(By.xpath("//span[text()=' APPLY FILTER ']"));
		
		js.executeScript("arguments[0].click()", filBtn);
		
		Thread.sleep(40000);
		
		/*WebElement allGrid = driver.findElement(By.xpath("(//table)[3]"));
		
		List<WebElement> gridRows = allGrid.findElements(By.tagName("tr"));
		
		WebElement rowOne = gridRows.get(0);
		
		List<WebElement> gridDatas = rowOne.findElements(By.tagName("td"));
		
		WebElement element = gridDatas.get(1);
		
		js.executeScript("arguments[0].click()", element);
		
		String viewLrn= gridDatas.get(2).getText();
		
		System.out.println(viewLrn);*/
		
		WebElement chkBox = driver.findElement(By.id("mat-checkbox-17-input"));
		
		Actions act = new Actions(driver);
		
		act.doubleClick(chkBox).perform();
		
		Thread.sleep(3000);
		
		WebElement tissCont = driver.findElement(By.xpath("//mat-select[@id=\"TissueAnswer\"]"));
		
		tissCont.click();
		
		Thread.sleep(2000);
		
		WebElement tissValue = driver.findElement(By.xpath("//span[text()='Kept as part of medical record ']"));
		
		tissValue.click();
		
		WebElement savTiss = driver.findElement(By.xpath("//span[text()='Save']"));
		
		savTiss.click();
		
		WebElement scrollEdit = driver.findElement(By.xpath("//strong[text()='EDIT VALUES']"));
		
		js.executeScript("arguments[0].scrollIntoView(true)", scrollEdit);
		
		WebElement dispMethod = driver.findElement(By.xpath("(//span[text()='Disposal method'])[1]"));
		
		js.executeScript("arguments[0].click()", dispMethod);
		
		Thread.sleep(2000);
		
		WebElement dispValue = driver.findElement(By.xpath("(//div[text()='ABC1'])[2]"));
		
		js.executeScript("arguments[0].click()", dispValue);
		
		WebElement appBtn = driver.findElement(By.xpath("//span[text()=' APPLY DISPOSE METHOD ']"));
		
		js.executeScript("arguments[0].click()", appBtn);
		
		WebElement saveList = driver.findElement(By.xpath("//span[text()=' SAVE ']"));
		
		js.executeScript("arguments[0].click()",saveList);
		
		WebElement preDis = driver.findElement(By.xpath("//span[text()='Previously disposed']"));
		
		js.executeScript("arguments[0].click()", preDis);
		
		WebElement disMethod = driver.findElement(By.xpath("(//span[text()='Disposal method'])[1]"));
		
		js.executeScript("arguments[0].click()",disMethod );
		
		Thread.sleep(3000);
		
		WebElement disSelect = driver.findElement(By.xpath("(//div[text()='ABC1'])[2]"));
		
		js.executeScript("arguments[0].click()", disSelect);
		
		r.keyPress(KeyEvent.VK_ESCAPE);
		
		r.keyRelease(KeyEvent.VK_ESCAPE);
		
		WebElement filClick = driver.findElement(By.xpath("//span[text()=' APPLY FILTER ']"));
		
		js.executeScript("arguments[0].click()", filClick);
		
		Thread.sleep(20000);
		
		WebElement eachTable = driver.findElement(By.xpath("(//table)[3]"));
		
		List<WebElement> allRows = eachTable.findElements(By.tagName("tr"));
		
		WebElement eachRow = allRows.get(0);
		
		List<WebElement> allDatas = eachRow.findElements(By.tagName("td"));
		
		WebElement eachData = allDatas.get(1);
		
		act.doubleClick(eachData).perform();
		
		WebElement eachData1 = allDatas.get(2);
		
		act.doubleClick(eachData1).perform();
		
		String viewLrn2 = eachData1.getText();
		
		System.out.println(viewLrn2);
		
		we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' SAVE ']")));
		
		WebElement saveButton = driver.findElement(By.xpath("//span[text()=' SAVE ']"));
		
		js.executeScript("arguments[0].click()", saveButton);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
