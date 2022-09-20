package org.pojo;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPojo extends BaseClass{
	
	public LoginPojo() {
		
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBys({
		
		@FindBy(id="txtUsername"),
		@FindBy(xpath="//input[@name=\"username\"]")
	})
	private WebElement txtUser;
	
	@FindBy(id="txtPassword")
	private WebElement txtPass;
	
	@FindBy(id="btnLogin")
	private WebElement btnLogin;

	public WebElement getTxtUser() {
		return txtUser;
	}

	public WebElement getTxtPass() {
		return txtPass;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}
	@FindBy(xpath = "//div[@class=\"mat-tooltip-trigger mdi mdi-logout inactiveText1 font150 cursor\"]")
	private WebElement logoutBtn;

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	@FindAll({
		@FindBy(id="mat-select-value-3"),
		@FindBy(xpath="//div[@class=\"mat-select-value ng-tns-c106-7\"]")
	})
	private WebElement subdisDrop;
	
	public WebElement getSubdisDrop() {
		return subdisDrop;
	}
	
	@FindBy(xpath="(//div[text()='Histology'])[2]")
	private WebElement subHistology;

	public WebElement getSubHistology() {
		return subHistology;
	}
	
	@FindBy(xpath="//div[@class=\"mat-select-arrow ng-tns-c106-9\"]")
	private WebElement workArea;
	
	@FindBy(xpath="(//div[text()='SPECIMEN RECEPTION'])[2]")
	private WebElement speReception;

	@FindBy(xpath="//i[text()='menu']")
	private WebElement menuBtn;
	
	@FindBy(xpath="//div[text()=' Order management ']")
	private WebElement ordMgnt;
	
	@FindBy(xpath="(//div[text()=' CP Order entry '])[1]")
	private WebElement cpOrder;

	public WebElement getWorkArea() {
		return workArea;
	}

	public WebElement getSpeReception() {
		return speReception;
	}

	public WebElement getMenuBtn() {
		return menuBtn;
	}

	public WebElement getOrdMgnt() {
		return ordMgnt;
	}

	public WebElement getCpOrder() {
		return cpOrder;
	}
	@FindBy(id="pasnumber")
	private WebElement otherId;
	
	@FindBy(id="Forename")
	private WebElement gName;
	
	@FindBy(id="Surname")
	private WebElement fName;
	
	@FindBy(id="mat-input-53")
	private WebElement dOb;
	
	public WebElement getOtherId() {
		return otherId;
	}

	public WebElement getgName() {
		return gName;
	}

	public WebElement getfName() {
		return fName;
	}

	public WebElement getdOb() {
		return dOb;
	}

	public WebElement getSeX() {
		return seX;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	@FindBy(xpath="(//span[text()='Sex'])[1]")
	private WebElement seX;
	
	@FindBy(xpath="//span[text()='Male']")
	private WebElement chooseSex;
	
	public WebElement getChooseSex() {
		return chooseSex;
	}

	@FindBy(xpath="(//span[text()=' SEARCH '])[2]")
	private WebElement searchBtn;
	
	@FindBy(xpath="(//button[@aria-label=\"Open calendar\"])[1]")
	private WebElement openCalender;
	
	@FindBy(xpath="//div[@class=\"mat-calendar-arrow\"]")
	private WebElement calYears;
	
	@FindBy(xpath="//div[text()=' 1999 ']")
	private WebElement chooseYear;
	
	@FindBy(xpath="//div[text()=' AUG ']")
	private WebElement chooseMonth;
	
	@FindBy(xpath="//div[text()=' 31 ']")
	private WebElement chooseDay;

	public WebElement getOpenCalender() {
		return openCalender;
	}

	public WebElement getCalYears() {
		return calYears;
	}

	public WebElement getChooseYear() {
		return chooseYear;
	}

	public WebElement getChooseMonth() {
		return chooseMonth;
	}

	public WebElement getChooseDay() {
		return chooseDay;
	}
	
	@FindBy(xpath="(//span[text()=' NEW ORDER '])[1]")
	private WebElement newOrder;

	public WebElement getNewOrder() {
		return newOrder;
	}
	
	public WebElement getQuickOtherd() {
		return quickOtherd;
	}

	@FindBy(xpath="//div[@class=\"mainLayerIdyTwo\"]")
	private WebElement quickOtherd;
	
	@CacheLookup
	@FindAll({
		@FindBy(xpath="(//input[@type=\"text\"])[1]"),
		@FindBy(xpath="//div[text()='Location']")
	})
	private WebElement oeLocation;
	

	@FindBy(xpath="(//div[text()='BREH'])[1]")
	
	private WebElement oeLocationName;
	
	@FindBy(xpath="(//input[@type=\"text\"])[2]")
	private WebElement regClinician;
	
	@FindBy(xpath="(//input[@type=\"text\"])[3]")
	private WebElement patCategory;
	
	@FindBy(xpath="//div[text()='NHS Patient ']")
	private WebElement selectCategory;
	
	@FindBy(xpath="(//span[@class=\"mat-button-wrapper\"])[1]")
	private WebElement cpCalender;
	
	@FindBy(xpath="//div[text()=' 1 ']")
	private WebElement selectDate;

	public WebElement getOeLocation() {
		return oeLocation;
	}

	public WebElement getOeLocationName() {
		return oeLocationName;
	}

	public WebElement getRegClinician() {
		return regClinician;
	}

	public WebElement getPatCategory() {
		return patCategory;
	}

	public WebElement getSelectCategory() {
		return selectCategory;
	}

	public WebElement getCpCalender() {
		return cpCalender;
	}

	public WebElement getSelectDate() {
		return selectDate;
	}
	@FindBy(xpath="//mat-panel-title[text()='Specimen']")
	private WebElement specimenSelect;
	
	@FindBy(xpath="(//mat-panel-title[text()='Histology'])[1]")
	private WebElement selectHistolgy;
	
	@FindBy(xpath="//*[@id=\"SpecimenSite\"]")
	private WebElement specSite;
	
	@FindBy(xpath="//span[text()='Right']")
	private WebElement siteSide;
	
	public WebElement getSpecimenSelect() {
		return specimenSelect;
	}

	public WebElement getSelectHistolgy() {
		return selectHistolgy;
	}

	public WebElement getSpecSite() {
		return specSite;
	}

	public WebElement getSiteSide() {
		return siteSide;
	}
	
	@FindBy(xpath="//span[text()=' SAVE ']")
	private WebElement orderSave;

	public WebElement getOrderSave() {
		return orderSave;
	}
	
	@FindBy(xpath="//span[text()='Order details']")
	private WebElement orderDetails;

	public WebElement getOrderDetails() {
		return orderDetails;
	}
	@FindBy(xpath="//input[@name=\"lrn\"]")
	private WebElement textLrn;



	public WebElement getTextLrn() {
		return textLrn;
	}
	
	@FindBy(xpath="//span[text()='Clinician']")
	private WebElement enterClinician;
	

	public WebElement getEnterClinician() {
		return enterClinician;
	}


	@FindBy(xpath="(//span[text()='Requesting location'])[1]")
	private WebElement enterLocation;
	
	public WebElement getEnterLocation() {
		return enterLocation;
	}
	
	@FindBy(xpath="(//div[text()='SLN'])[2]")
	private WebElement selectClinician;
	
	@FindBy(xpath="(//div[text()='BREH'])[2]")
	private WebElement selectLocation;

	public WebElement getSelectClinician() {
		return selectClinician;
	}

	public WebElement getSelectLocation() {
		return selectLocation;
	}
	

	@FindBy(xpath="//span[text()=' CANCEL ']")
	private WebElement cancelBtn;
	
	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	@FindBy(xpath="(//div[text()='SPECIMEN DISSECTION'])[2]")
	private WebElement workareaSD;

	public WebElement getWorkareaSD() {
		return workareaSD;
	}
	@FindBy(xpath="//div[text()=' Laboratory processing ']")
	private WebElement lpMenu;
	
	@FindBy(xpath="//div[text()=' Specimen dissection ']")
	private WebElement selectSpeDis;

	public WebElement getLpMenu() {
		return lpMenu;
	}

	public WebElement getSelectSpeDis() {
		return selectSpeDis;
	}
	
	@FindBy(id="lrn")
	private WebElement scanField;
	
	@FindBy(xpath="//span[@class=\"mdi mdi-barcode-scan\"]")
	private WebElement barcodeClick;

	public WebElement getScanField() {
		return scanField;
	}

	public WebElement getBarcodeClick() {
		return barcodeClick;
	}
	@FindBy(xpath="//span[text()='YES']")
	private WebElement confirmYes;
	
	@FindBy(xpath="//span[text()='NO']")
	private WebElement confirmNo;

	public WebElement getConfirmYes() {
		return confirmYes;
	}

	public WebElement getConfirmNo() {
		return confirmNo;
	}
	@FindBys({
		
		@FindBy(id="pieces"),
		@FindBy(xpath="//input[@name=\"pieces\"]")
	
	})
	private WebElement noPieces;
	
	@FindBy(xpath="//input[@data-placeholder=\"Dissecting user\"]")
	private WebElement dissUser;
	
	@FindBy(xpath="//input[@data-placeholder=\"Assisting user\"]")
	private WebElement assUser;
	
	@FindBy(xpath="//input[@data-placeholder=\"Reporting pathologist\"]")
	private WebElement repPath;
	
	@FindBy(xpath="//input[@data-placeholder=\"Supervising pathologist\"]")
	private WebElement supPath;

	public WebElement getNoPieces() {
		return noPieces;
	}

	public WebElement getDissUser() {
		return dissUser;
	}

	public WebElement getAssUser() {
		return assUser;
	}

	public WebElement getRepPath() {
		return repPath;
	}

	public WebElement getSupPath() {
		return supPath;
	}
	@FindBy(xpath="//span[text()=' NEXT ']")
	private WebElement nextBtn;
	
	@FindBy(xpath="//span[text()=' SAVE BLOCKS ']")
	private WebElement saveBlocks;

	public WebElement getNextBtn() {
		return nextBtn;
	}

	public WebElement getSaveBlocks() {
		return saveBlocks;
	}
	@FindBy(xpath="//span[@class=\"mat-tooltip-trigger mdi mdi-plus-box col-md-2 col-lg-1 font\"]")
	private WebElement addBlocks;
	
	public WebElement getAddBlocks() {
		return addBlocks;
	}

	public WebElement getAddBlocksByClick() {
		return addBlocksByClick;
	}

	public WebElement getAddBlocksDropDown() {
		return addBlocksDropDown;
	}

	@FindBy(xpath="//input[@type=\"number\"]")
	private WebElement addBlocksByClick;
	
	@FindBy(xpath="(//span[text()='Addtional block(s)'])[1]")
	private WebElement addBlocksDropDown;
	
	@CacheLookup
	@FindBys({
		
		@FindBy(id="mat-option-38"),
		@FindBy(xpath="(//div[text()='EMBED 1'])[2]")
	
	})
	private WebElement workareaEmbed;

	public WebElement getWorkareaEmbed() {
		return workareaEmbed;
	}
	
	public WebElement getEditVal() {
		return editVal;
	}

	public WebElement getTxtStatus() {
		return txtStatus;
	}

	public WebElement getTxtInstruction() {
		return txtInstruction;
	}

	@FindBy(xpath="//div[text()=' Block processing worklist ']")
	private WebElement bpWorklist;

	public WebElement getBpWorklist() {
		return bpWorklist;
	}
	
	@FindBy(xpath="//span[text()=' EDIT VALUES ']")
	private WebElement editVal;
	
	@FindBy(xpath="//input[@data-placeholder=\"Status\"]")
	private WebElement txtStatus;
	
	@FindBy(id="instruction")
	private WebElement txtInstruction;
	
	@FindBy(xpath="(//div[text()='MICROTOME 1'])[2]")
	private WebElement microWorkArea;

	public WebElement getMicroWorkArea() {
		return microWorkArea;
	}
	@FindBy(xpath="(//div[text()=' Procedure processing worklist '])[1]")
	private WebElement ppWorkArea;



	public WebElement getPpWorkArea() {
		return ppWorkArea;
	}
	@FindBy(xpath="//span[text()='Staining completed']")
	private WebElement seComplete;

	public WebElement getSeComplete() {
		return seComplete;
	}
	@FindBy(xpath="//div[text()=' Order verification ']")
	private WebElement orderVerify;
	
	public WebElement getOrderVerify() {
		return orderVerify;
	}
	@FindBy(xpath="//span[text()=' RELEASE ']")
	private WebElement releaseBtn;

	public WebElement getReleaseBtn() {
		return releaseBtn;
	}
	@FindBy(xpath="//div[text()=' Specimen worklist ']")
	private WebElement spWorklist;

	public WebElement getSpWorklist() {
		return spWorklist;
	}
	@CacheLookup
	@FindBys({
	
	@FindBy(id="mat-select-value-241"),
	@FindBy(xpath="(//span[text()='Status'])[1]")
	
	})
	private WebElement swStatus;

	public WebElement getSwStatus() {
		return swStatus;
	}
	@FindBy(xpath="(//span[text()='Priority'])[1]")
	private WebElement prioDropDown;
	
	@FindBy(id="mat-checkbox-127")
	private WebElement cWCheckBox;
	
	@FindBy(xpath="//span[text()=' APPLY FILTER ']")
	private WebElement applyFilter;

	public WebElement getPrioDropDown() {
		return prioDropDown;
	}

	public WebElement getcWCheckBox() {
		return cWCheckBox;
	}

	public WebElement getApplyFilter() {
		return applyFilter;
	}
	@FindBy(xpath="//a[text()='AJROLE']")
	private WebElement chooseRole;
	
	@FindBy(id="Role")
	private WebElement roleDropdown;

	public WebElement getChooseRole() {
		return chooseRole;
	}

	public WebElement getRoleDropdown() {
		return roleDropdown;
	}
	@FindBy(xpath="//div[text()=' Result management ']")
	private WebElement resultManage;
	
	@FindBy(xpath="//div[text()=' Typing worklist ']")
	private WebElement typingWork;

	public WebElement getResultManage() {
		return resultManage;
	}

	public WebElement getTypingWork() {
		return typingWork;
	}
	
	@FindBy(xpath="(//span[text()='Report template'])[1]")
	private WebElement rtDropdown;;
	
	@FindBy(xpath="//input[@placeholder=\"Search\"]")
	private WebElement rtSearchField;
	
	@FindBy(xpath="(//div[text()='CPCT1'])[2]")
	private WebElement chooseRt;

	public WebElement getRtDropdown() {
		return rtDropdown;
	}

	public WebElement getRtSearchField() {
		return rtSearchField;
	}

	public WebElement getChooseRt() {
		return chooseRt;
	}
	
	@FindBy(id="yes")
	private WebElement twYes;

	public WebElement getTwYes() {
		return twYes;
	}
	
	@FindBy(xpath="(//span[@class=\"mat-tooltip-trigger patient-data\"])[2]")
	private WebElement bannerGname;

	public WebElement getBannerGname() {
		return bannerGname;
	}
	
	@FindBy(xpath="(//span[@class=\"mat-tooltip-trigger patient-data\"])[1]")
	private WebElement bannerFname;
	
	@FindBy(xpath="(//span[@class=\"patient-data\"])[2]")
	private WebElement bannerDob;

	public WebElement getBannerFname() {
		return bannerFname;
	}

	public WebElement getBannerDob() {
		return bannerDob;
	}
	
	@FindBy(xpath="//i[@class=\"mdi mdi-caps-lock\"]")
	private WebElement synopticIcon;
	
	@FindBy(xpath="//i[@class=\"mdi mdi-file-code\"]")
	private WebElement dcodingIcon;
	
	@FindBy(xpath="//i[@class=\"mdi mdi-text-recognition\"]")
	private WebElement tblockIcon;
	
	@FindBy(xpath="//i[@class=\"mdi mdi-book-open-page-variant\"]")
	private WebElement tallyIcon;
	
	@FindBy(xpath="//i[@class=\"mdi mdi-book-open-variant\"]")
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
	
	@FindBy(xpath="(//span[text()='Reporting pathologist'])[1]")
	private WebElement twRepPath;
	
	@FindBy(xpath="(//div[text()='AjayBabu'])[3]")
	private WebElement twPathName;
	
	public WebElement getTwRepPath() {
		return twRepPath;
	}

	public WebElement getTwPathName() {
		return twPathName;
	}
	@FindBy(xpath="//span[text()=' Save as']")
	private WebElement twSave;
	
	@FindBy(xpath="//span[text()='Report created']")
	private WebElement twReportCreated;
	
	@FindBy(xpath="//div[@class=\"toast-bottom-right toast-container\"]")
	private WebElement toastMsg;

	public WebElement getTwSave() {
		return twSave;
	}

	public WebElement getTwReportCreated() {
		return twReportCreated;
	}

	public WebElement getToastMsg() {
		return toastMsg;
	}
	@FindBy(xpath="//input[@name=\"textblock\"]")
	private WebElement tblockSearchField;
	
	@FindBy(xpath="//span[text()=' MACRO ']")
	private WebElement tblockExpansion;

	public WebElement getTblockSearchField() {
		return tblockSearchField;
	}

	public WebElement getTblockExpansion() {
		return tblockExpansion;
	}
	@FindBy(xpath="(//div[@id=\"editor\"])[2]")
	private WebElement editor;

	public WebElement getEditor() {
		return editor;
	}
	
	@FindBy(xpath="//ng-dropdown-panel[@role=\"listbox\"]")
	private WebElement tCodes;
	
	
	@FindBy(xpath="//div[text()=' Microscopy ']")
	private WebElement microScpy;

	public WebElement gettCodes() {
		return tCodes;
	}

	public WebElement getMicroScpy() {
		return microScpy;
	}
	@FindBy(xpath="//span[text()='YES']")
	private WebElement repYes;

	public WebElement getRepYes() {
		return repYes;
	}
	
	@FindBy(xpath="//span[text()=' Release as']")
	private WebElement releaseAs;
	
	@FindBy(xpath="//span[text()='Final report']")
	private WebElement finalReport;

	public WebElement getReleaseAs() {
		return releaseAs;
	}

	public WebElement getFinalReport() {
		return finalReport;
	}
	

	@FindBy(xpath="//span[text()=' Action']")
	private WebElement actionIcon;
	
	@FindBy(xpath="//span[text()='Close']")
	private WebElement closeDocument;

	public WebElement getActionIcon() {
		return actionIcon;
	}

	public WebElement getCloseDocument() {
		return closeDocument;
	}
	
	@FindBy(xpath="//div[text()='Result publication history']")
	private WebElement rpHistory;

	public WebElement getRpHistory() {
		return rpHistory;
	}
	
	
	
	
	
	
	
	
	
}
