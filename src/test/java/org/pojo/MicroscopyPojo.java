package org.pojo;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MicroscopyPojo extends BaseClass {

	public MicroscopyPojo() {

		PageFactory.initElements(driver, this);

}
	
	@FindBy(xpath = "//div[text()=' Result management ']")
	private WebElement resultManage;


	public WebElement getResultManage() {
		return resultManage;
	}
	
	@FindBy(xpath="//div[text()=' Microscopy ']")
	private WebElement microscopyOption;


	public WebElement getMicroscopyOption() {
		return microscopyOption;
	}
	
	@FindBy(xpath="//span[@class=\"mat-tooltip-trigger mdi mdi-text-box-multiple cursor\"]")
	private WebElement showWorklistIcon;
	
	@FindBy(xpath="//span[@class=\"mat-tooltip-trigger mdi mdi-ribbon cursor ng-star-inserted\"]")
	private WebElement cosdIcon;
	
	@FindBy(xpath="//span[text()=\" MICROSCOPY \"]")
	private WebElement headerMicroscopy;


	public WebElement getShowWorklistIcon() {
		return showWorklistIcon;
	}

	public WebElement getCosdIcon() {
		return cosdIcon;
	}

	public WebElement getHeaderMicroscopy() {
		return headerMicroscopy;
	}
	
	@FindBy(xpath="//span[@class=\"mat-tooltip-trigger mdi mdi-magnify cursor ReadOnly\"]")
	private WebElement searchIcon;


	public WebElement getSearchIcon() {
		return searchIcon;
	}
	
	@FindBy(xpath = "//i[@class=\"mdi mdi-caps-lock\"]")
	private WebElement synopticIcon;

	@FindBy(xpath = "//i[@class=\"mdi mdi-file-code\"]")
	private WebElement dcodingIcon;

	@FindBy(xpath = "//i[@class=\"mdi mdi-text-recognition\"]")
	private WebElement tblockIcon;

	@FindBy(xpath = "//i[@class=\"mdi mdi-book-open-page-variant\"]")
	private WebElement tallyIcon;

	@FindBy(xpath = "//i[@class=\"mdi mdi-book-open-variant\"]")
	private WebElement reviewTallyIcon;

	public WebElement getSynopticIcon() {
		return synopticIcon;
	}

	public WebElement getDcodingIcon() {
		return dcodingIcon;
	}

	public WebElement getTblockIcon() {
		return tblockIcon;
	}

	public WebElement getTallyIcon() {
		return tallyIcon;
	}

	public WebElement getReviewTallyIcon() {
		return reviewTallyIcon;
	}
	@FindBy(xpath = "(//span[text()='Reporting pathologist'])[1]")
	private WebElement twRepPath;

	@FindBy(xpath = "(//span[text()=\"AjayBabu\"])[4]")
	private WebElement twPathName;

	public WebElement getTwRepPath() {
		return twRepPath;
	}

	public WebElement getTwPathName() {
		return twPathName;
	}

	@FindBy(xpath = "//span[text()=' Save as']")
	private WebElement twSave;

	@FindBy(xpath = "//span[text()='Report created']")
	private WebElement twReportCreated;

	public WebElement getTwSave() {
		return twSave;
	}

	public WebElement getTwReportCreated() {
		return twReportCreated;
	}
	@FindBy(xpath = "(//input[@name=\"textblock\"])[1]")
	private WebElement tblockSearchField;

	@FindBy(xpath = "//span[text()=' MACRO ']")
	private WebElement tblockExpansion;

	public WebElement getTblockSearchField() {
		return tblockSearchField;
	}

	public WebElement getTblockExpansion() {
		return tblockExpansion;
	}

	@FindBy(xpath="//span[text()=\" CANCEL \"]")
	private WebElement cancelInPatientReport;


	public WebElement getCancelInPatientReport() {
		return cancelInPatientReport;
	}
	
	@FindBy(xpath="//span[text()=\"PATIENT REPORTS\"]")
	private WebElement patientReportTab;


	public WebElement getPatientReportTab() {
		return patientReportTab;
	}
	
	


}
