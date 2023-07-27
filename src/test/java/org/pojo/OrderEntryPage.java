package org.pojo;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderEntryPage extends BaseClass {

	public OrderEntryPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=\" CP ORDER ENTRY \"]")
	private WebElement cpTab;

	public WebElement getCpTab() {
		return cpTab;
	}

	@FindBy(xpath = "//span[text()='Patient details']")
	private WebElement patDetailsTab;

	public WebElement getPatDetailsTab() {
		return patDetailsTab;
	}

	@FindBy(xpath = "//div[text()='Quick registration']")
	private WebElement qRegTab;

	public WebElement getqRegTab() {
		return qRegTab;
	}

	@FindBy(xpath = "//span[text()='Routine']")
	private WebElement defaultPriority;

	public WebElement getDefaultPriority() {
		return defaultPriority;
	}

	@FindBy(xpath = "//span[@class=\"mat-content ng-tns-c92-157\"]")
	private WebElement wordSpecimen;

	@FindBy(xpath = "//span[@class=\"mat-content ng-tns-c92-159\"]")
	private WebElement wordBlock;

	@FindBy(xpath = "//span[@class=\"mat-content ng-tns-c92-161\"]")
	private WebElement wordProcedureGroup;

	@FindBy(xpath = "//span[@class=\"mat-content ng-tns-c92-163\"]")
	private WebElement wordProcedure;

	public WebElement getWordSpecimen() {
		return wordSpecimen;
	}

	public WebElement getWordBlock() {
		return wordBlock;
	}

	public WebElement getWordProcedureGroup() {
		return wordProcedureGroup;
	}

	public WebElement getWordProcedure() {
		return wordProcedure;
	}

	@FindBy(xpath = "//mat-icon[text()='keyboard_arrow_down']")
	private WebElement patBannerDownKey;

	public WebElement getPatBannerDownKey() {
		return patBannerDownKey;
	}

	@FindBy(xpath = "//textarea[@id=\"clinicaldetComments\"]")
	private WebElement cliCmnts;

	@FindBy(id = "clinicaldiagnosis")
	private WebElement cliDiagnosis;

	@FindBy(id = "clinicalquestions")
	private WebElement cliQuestion;

	@FindBy(id = "Medicalintervention")
	private WebElement medIntervention;

	public WebElement getCliCmnts() {
		return cliCmnts;
	}

	public WebElement getCliDiagnosis() {
		return cliDiagnosis;
	}

	public WebElement getCliQuestion() {
		return cliQuestion;
	}

	public WebElement getMedIntervention() {
		return medIntervention;
	}

	@FindBy(xpath = "//div[@class=\"mat-expansion-panel-body ng-tns-c90-164\"]")
	private WebElement subDisciplineList;

	public WebElement getSubDisciplineList() {
		return subDisciplineList;
	}

	@FindBy(xpath = "//mat-panel-title[text()='Procedure Group']")
	private WebElement procedureGrp;

	@FindBy(xpath = "(//mat-panel-title[text()='Histology'])[3]")
	private WebElement pGrpHistology;

	@FindBy(xpath = "//span[text()=' ( P1 )']")
	private WebElement choosePGrp;

	@FindBy(xpath = "//h4[text()='ADD TO SPECIMEN/BLOCK']")
	private WebElement popupAfterPgrp;

	@FindBy(xpath = "//span[text()='Cancel']")
	private WebElement popupcancelPgrp;

	public WebElement getProcedureGrp() {
		return procedureGrp;
	}

	public WebElement getpGrpHistology() {
		return pGrpHistology;
	}

	public WebElement getChoosePGrp() {
		return choosePGrp;
	}

	public WebElement getPopupAfterPgrp() {
		return popupAfterPgrp;
	}

	public WebElement getPopupcancelPgrp() {
		return popupcancelPgrp;
	}

	@FindBy(xpath = "//span[text()=' SAVE ']")
	private WebElement orderSave;

	public WebElement getOrderSave() {
		return orderSave;
	}

	@FindBy(xpath = "//div[text()=' 1 ']")
	private WebElement selectDate;

	public WebElement getSelectDate() {
		return selectDate;
	}

	@FindBy(xpath = "//div[@class=\"row block-name col-lg-12 col-md-12\"]")
	private WebElement specimenCard;

	public WebElement getSpecimenCard() {
		return specimenCard;
	}

	@FindBy(xpath = "//span[text()=' PREVIOUS ']")
	private WebElement prevBtn;

	@FindBy(xpath = "//span[text()=' NEXT ']")
	private WebElement nextBtn;

	public WebElement getPrevBtn() {
		return prevBtn;
	}

	public WebElement getNextBtn() {
		return nextBtn;
	}

	@FindBy(xpath = "(//mat-select[@id=\"limsdropdownid\"])[6]")
	private WebElement dropDownWorkAreaInSd;

	public WebElement getDropDownWorkAreaInSd() {
		return dropDownWorkAreaInSd;
	}

	@FindBy(xpath = "(//span[text()='SPECIMEN DISSECTION'])[3]")
	private WebElement chooseSdFromDdown;

	public WebElement getChooseSdFromDdown() {
		return chooseSdFromDdown;
	}

	@CacheLookup
	@FindAll({
	
	@FindBy(xpath="//div[text()=' Labels are printed. ']"),
	@FindBy(xpath="//div[@role=\"alertdialog\"]")
	
	})
	private WebElement alertDialog;

	public WebElement getAlertDialog() {
		return alertDialog;
	}

}
