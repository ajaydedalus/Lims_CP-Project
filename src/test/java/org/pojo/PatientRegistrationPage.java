package org.pojo;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientRegistrationPage extends BaseClass {

	public PatientRegistrationPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[text()='add']")
	private WebElement plusIcon;

	@FindBy(xpath = "(//span[text()='Select identifier type'])[1]")
	private WebElement idType;

	@FindBy(xpath = "//span[text()=' Patient Number']")
	private WebElement patientNumber;

	@FindBy(xpath = "//input[@name=\"txtIdentifier\"]")
	private WebElement fieldIdentifier;

	@FindBy(xpath = "(//span[@class=\"mat-checkbox-inner-container\"])[4]")
	private WebElement mainIdCheckBox;

	@FindBy(xpath = "(//i[text()='add'])[2]")
	private WebElement addIdentifier;

	@FindBy(xpath = "(//span[text()='Close'])[2]")
	private WebElement closeIdentifier;

	@FindBy(xpath = "(//span[text()='Title'])[1]")
	private WebElement titleDropdown;

	@FindBy(xpath = "//span[text()=' Mrr ']")
	private WebElement wordMrr;

	@FindBy(xpath = "//input[@name=\"txtGivenName\"]")
	private WebElement givenName;

	@FindBy(xpath = "//input[@name=\"txtMiddleName\"]")
	private WebElement middleName;

	@FindBy(xpath = "//input[@name=\"txtFamilyName\"]")
	private WebElement familyName;

	@FindBy(xpath = "(//span[text()='Gender'])[1]")
	private WebElement genderDropdown;

	@FindBy(xpath = "(//span[text()='Male '])[1]")
	private WebElement genderMale;

	@FindBy(xpath = "(//span[text()='Sex'])[3]")
	private WebElement sexDropdown;

	@FindBy(xpath = "(//span[text()='Male'])[2]")
	private WebElement sexMale;

	@FindBy(xpath = "(//span[text()='Patient category'])[1]")
	private WebElement patientCatDropdown;

	@FindBy(xpath = "//span[text()=' NHS Patient ']")
	private WebElement wordNhspatient;

	@FindBy(xpath = "(//input[@name=\"autocompleteModel\"])[1]")
	private WebElement ethnicityField;

	@FindBy(xpath = "//span[text()='Indian']")
	private WebElement wordIndian;

	@FindBy(xpath = "(//button[@aria-label=\"Open calendar\"])[2]")
	private WebElement dobButton;

	@FindBy(xpath = "//button[@aria-label=\"Choose month and year\"]")
	private WebElement calYears;

	@FindBy(xpath = "//div[text()=' 1999 ']")
	private WebElement chooseYear;

	@FindBy(xpath = "//div[text()=' AUG ']")
	private WebElement chooseMonth;

	@FindBy(xpath = "//div[text()=' 31 ']")
	private WebElement chooseDay;

	@FindBy(xpath = "(//button[@aria-label=\"Open calendar\"])[3]")
	private WebElement dodButton;

	@FindBy(xpath = "//button[@aria-current=\"date\"]")
	private WebElement currentDate;

	@FindBy(xpath = "(//span[text()='Special interest flag'])[1]")
	private WebElement specialFlagDropdown;

	@FindBy(xpath = "//span[text()='SIP']")
	private WebElement wordSIP;

	@FindBy(xpath = "(//input[@name=\"autocompleteModel\"])[2]")
	private WebElement hazardField;

	@FindBy(xpath = "//input[@name=\"txtaddrline1\"]")
	private WebElement address1;

	@FindBy(xpath = "//input[@name=\"txtaddrline2\"]")
	private WebElement address2;

	@FindBy(xpath = "//input[@name=\"txtaddrline3\"]")
	private WebElement townField;

	@FindBy(xpath = "//input[@name=\"txtcity\"]")
	private WebElement cityField;

	@FindBy(xpath = "(//input[@name=\"autocompleteModel\"])[3]")
	private WebElement countryField;

	@FindBy(xpath = "//span[text()='INDIA']")
	private WebElement wordIndia;

	@FindBy(xpath = "//input[@name=\"txtpostcode\"]")
	private WebElement postcodeField;

	@FindBy(xpath = "//input[@name=\"patEmailAddress\"]")
	private WebElement emailField;

	@FindBy(id="patMobile")
	private WebElement mobileField;

	@FindBy(xpath = "(//span[text()='Registered GP'])[1]")
	private WebElement gpDropdown;

	@FindBy(xpath = "//span[text()='DR Abbot Johnson']")
	private WebElement gpName;

	@FindBy(xpath = "(//button[@id=\"SAVE\"])[1]")
	private WebElement saveBtn;

	@FindBy(xpath = "(//span[text()='Hepatitis A'])[1]")
	private WebElement wordHepatitis;

	public WebElement getWordHepatitis() {
		return wordHepatitis;
	}

	public WebElement getPlusIcon() {
		return plusIcon;
	}

	public WebElement getIdType() {
		return idType;
	}

	public WebElement getPatientNumber() {
		return patientNumber;
	}

	public WebElement getFieldIdentifier() {
		return fieldIdentifier;
	}

	public WebElement getMainIdCheckBox() {
		return mainIdCheckBox;
	}

	public WebElement getAddIdentifier() {
		return addIdentifier;
	}

	public WebElement getCloseIdentifier() {
		return closeIdentifier;
	}

	public WebElement getTitleDropdown() {
		return titleDropdown;
	}

	public WebElement getWordMrr() {
		return wordMrr;
	}

	public WebElement getGivenName() {
		return givenName;
	}

	public WebElement getMiddleName() {
		return middleName;
	}

	public WebElement getFamilyName() {
		return familyName;
	}

	public WebElement getGenderDropdown() {
		return genderDropdown;
	}

	public WebElement getGenderMale() {
		return genderMale;
	}

	public WebElement getSexDropdown() {
		return sexDropdown;
	}

	public WebElement getSexMale() {
		return sexMale;
	}

	public WebElement getPatientCatDropdown() {
		return patientCatDropdown;
	}

	public WebElement getWordNhspatient() {
		return wordNhspatient;
	}

	public WebElement getEthnicityField() {
		return ethnicityField;
	}

	public WebElement getWordIndian() {
		return wordIndian;
	}

	public WebElement getDobButton() {
		return dobButton;
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

	public WebElement getDodButton() {
		return dodButton;
	}

	public WebElement getCurrentDate() {
		return currentDate;
	}

	public WebElement getSpecialFlagDropdown() {
		return specialFlagDropdown;
	}

	public WebElement getWordSIP() {
		return wordSIP;
	}

	public WebElement getHazardField() {
		return hazardField;
	}

	public WebElement getAddress1() {
		return address1;
	}

	public WebElement getAddress2() {
		return address2;
	}

	public WebElement getTownField() {
		return townField;
	}

	public WebElement getCityField() {
		return cityField;
	}

	public WebElement getCountryField() {
		return countryField;
	}

	public WebElement getWordIndia() {
		return wordIndia;
	}

	public WebElement getPostcodeField() {
		return postcodeField;
	}

	public WebElement getEmailField() {
		return emailField;
	}

	public WebElement getMobileField() {
		return mobileField;
	}

	public WebElement getGpDropdown() {
		return gpDropdown;
	}

	public WebElement getGpName() {
		return gpName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	@FindBy(xpath = "//input[@id=\"Nhsnumber\"]")
	private WebElement searchIden;

	public WebElement getSearchIden() {
		return searchIden;
	}

	@FindBy(xpath = "//div[text()='Additional details']")
	private WebElement addDetailsTab;

	@FindBy(xpath = "//input[@name=\"txtKnownAs\"]")
	private WebElement knownasField;

	@FindBy(xpath = "//input[@name=\"patHome\"]")
	private WebElement contactHome;

	@FindBy(xpath = "//input[@name=\"patworknumber\"]")
	private WebElement contactWork;

	@FindBy(xpath = "//div[text()='Patient notepad']")
	private WebElement patientNotepadTab;

	public WebElement getAddDetailsTab() {
		return addDetailsTab;
	}

	public WebElement getKnownasField() {
		return knownasField;
	}

	public WebElement getContactHome() {
		return contactHome;
	}

	public WebElement getContactWork() {
		return contactWork;
	}

	public WebElement getPatientNotepadTab() {
		return patientNotepadTab;
	}

	@FindBy(xpath = "//textarea[@name=\"txtComments\"]")
	private WebElement freeTextNoteField;

	public WebElement getFreeTextNoteField() {
		return freeTextNoteField;
	}

	@FindBy(xpath = "//span[text()=' Add/Update ']")
	private WebElement addupdateBtn;

	public WebElement getAddupdateBtn() {
		return addupdateBtn;
	}

	@FindBy(xpath = "//span[text()='Order details']")
	private WebElement orderDetails;

	public WebElement getClinicianField() {
		return clinicianField;
	}

	public WebElement getDrAbbot() {
		return drAbbot;
	}

	public WebElement getPagetwoBtn() {
		return pagetwoBtn;
	}

	public WebElement getOrderDetails() {
		return orderDetails;
	}

	@FindBy(xpath = "(//span[text()='Clinician'])[1]")
	private WebElement clinicianField;

	@FindBy(xpath = "//span[text()='DR Johnson Abbot ']")
	private WebElement drAbbot;

	@FindBy(xpath = "(//span[text()=' SEARCH '])[2]")
	private WebElement searchBtn;

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	@FindBy(xpath = "//span[text()=' 2 ']")
	private WebElement pagetwoBtn;

	@FindBy(xpath = "(//span[@class=\"mat-button-wrapper\"])[1]")
	private WebElement cpCalender;

	public WebElement getCpCalender() {
		return cpCalender;
	}

	@FindBy(xpath = "(//span[@class=\"mat-button-wrapper\"])[1]")
	private WebElement dobButtonPdetails;

	public WebElement getDobButtonPdetails() {
		return dobButtonPdetails;
	}

	@FindBy(xpath = "//button[@aria-label=\"Choose month and year\"]")
	private WebElement presentYearButton;

	public WebElement getPresentYearButton() {
		return presentYearButton;
	}

	@FindBy(xpath = "(//span[@class=\"mat-button-wrapper\"])[1]")
	private WebElement fromDate;

	public WebElement getFromDate() {
		return fromDate;
	}

	@FindBy(xpath = "//div[text()=' 10 ']")
	private WebElement dateTen;

	public WebElement getDateTen() {
		return dateTen;
	}

	@FindBy(xpath = "//div[text()=' 1965 ']")
	private WebElement Years;

	public WebElement getYears() {
		return Years;
	}

	@FindBy(xpath = "//button[@aria-label=\"Choose date\"]")
	private WebElement beforeYears;

	public WebElement getBeforeYears() {
		return beforeYears;
	}

	@FindBy(xpath = "//button[@aria-label=\"Previous 24 years\"]")
	private WebElement previousBtn;

	public WebElement getPreviousBtn() {
		return previousBtn;
	}

	@FindBy(xpath = "//div[text()=' MAR ']")
	private WebElement Month;

	@FindBy(xpath = "//div[text()=' 13 ']")
	private WebElement Day;

	public WebElement getMonth() {
		return Month;
	}

	public WebElement getDay() {
		return Day;
	}

	@FindBy(xpath = "(//mat-option[@role=\"option\"])[3]")
	private WebElement wordMrs;

	@FindBy(xpath = "//span[text()='Female ']")
	private WebElement genderFemale;

	@FindBy(xpath = "(//span[text()='Female'])[2]")
	private WebElement sexFemale;

	public WebElement getWordMrs() {
		return wordMrs;
	}

	public WebElement getGenderFemale() {
		return genderFemale;
	}

	public WebElement getSexFemale() {
		return sexFemale;
	}

	@FindBy(xpath = "(//span[@class=\"mat-checkbox-inner-container\"])[3]")
	private WebElement pregnantCheckBox;

	@FindBy(xpath = "//input[@name=\"WeeksGestation\"]")
	private WebElement gestationField;

	public WebElement getPregnantCheckBox() {
		return pregnantCheckBox;
	}

	public WebElement getGestationField() {
		return gestationField;
	}

	@FindBy(xpath="//span[text()='Mr ANOCLINN ANOKA ']")
	private WebElement drAnoka;

	public WebElement getDrAnoka() {
		return drAnoka;
	}
	
	@FindBy(xpath="//span[@aria-label=\"Go to the last page\"]")
	private WebElement lastPage;
	
	@FindBy(xpath="//span[@aria-label=\"Go to the first page\"]")
	private WebElement firstPage;

	public WebElement getLastPage() {
		return lastPage;
	}

	public WebElement getFirstPage() {
		return firstPage;
	}
	
	@FindBy(xpath="//span[@aria-label=\"Go to the next page\"]")
	private WebElement nextPage;

	public WebElement getNextPage() {
		return nextPage;
	}
	
	
	
}
