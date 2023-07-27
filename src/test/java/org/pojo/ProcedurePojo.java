package org.pojo;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProcedurePojo extends BaseClass{
	
	public ProcedurePojo() {

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()=' EDIT VALUES ']")
	private WebElement editVal;

	public WebElement getEditVal() {
		return editVal;
	}

	@CacheLookup
	@FindAll({ @FindBy(xpath = "//input[@id=\"mat-input-198\"]"),
			@FindBy(xpath = "//input[@data-placeholder=\"Status\"]") })
	
	private WebElement ppStatusDrop;
	

	@CacheLookup
	@FindAll({
	@FindBy(xpath="//span[text()='Staining completed']"),
	@FindBy(xpath="(//div[@class=\"row\"])[19]")
	})
	
	private WebElement ppStatusSelect;
	
	@FindBy(xpath = "//textarea[@data-placeholder=\"Instructions\"]")
	private WebElement ppInstructionField;

	public WebElement getPpStatusDrop() {
		return ppStatusDrop;
	}

	public WebElement getPpStatusSelect() {
		return ppStatusSelect;
	}

	public WebElement getPpInstructionField() {
		return ppInstructionField;
	}

	@FindBy(xpath = "//span[text()=' SAVE ']")
	private WebElement ppsaveBtn;

	@FindBy(xpath = "//span[text()=' CANCEL EDITS ']")
	private WebElement ppcancelEditsBtn;

	@FindBy(xpath = "//span[text()=' PRINT ']")
	private WebElement ppprintBtn;

	@FindBy(xpath = "//span[text()=' CANCEL ']")
	private WebElement ppcancelBtn;

	
	@FindBy(xpath="//span[text()=' ASSIGN ']")
	private WebElement assignBtn;

	public WebElement getPpsaveBtn() {
		return ppsaveBtn;
	}

	public WebElement getPpcancelEditsBtn() {
		return ppcancelEditsBtn;
	}

	public WebElement getPpprintBtn() {
		return ppprintBtn;
	}

	public WebElement getPpcancelBtn() {
		return ppcancelBtn;
	}

	public WebElement getAssignBtn() {
		return assignBtn;
	}
	
	





















}
