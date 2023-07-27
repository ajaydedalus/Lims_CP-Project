package org.pojo;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlockProcessing extends BaseClass {

	public BlockProcessing() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' EDIT VALUES ']")
	private WebElement editVal;

	public WebElement getEditVal() {
		return editVal;
	}

	@CacheLookup
	@FindAll({ @FindBy(xpath = "//input[@id=\"mat-input-193\"]"),
			@FindBy(xpath = "//input[@data-placeholder=\"Status\"]") })

	private WebElement statusDrop;

	public WebElement getStatusDrop() {
		return statusDrop;
	}

	@CacheLookup
	@FindAll({
	@FindBy(xpath="//span[text()='Embedding completed']"),
	@FindBy(xpath="(//div[@class=\"row\"])[8]")
	})
	private WebElement statusSelect;

	public WebElement getStatusSelect() {
		return statusSelect;
	}

	@FindBy(xpath = "(//div[text()='SPECIMEN DISSECTION'])[1]")
	private WebElement expWorkarea;

	public WebElement getExpWorkarea() {
		return expWorkarea;
	}

	@FindBy(xpath = "//input[@id=\"mat-input-195\"]")
	private WebElement blockSize;

	public WebElement getBlockSize() {
		return blockSize;
	}

	@FindBy(xpath = "(//div[text()='White Routine H&E Spare per level'])[1]")
	private WebElement blockName;

	public WebElement getBlockName() {
		return blockName;
	}

	@FindBy(xpath = "//textarea[@data-placeholder=\"Instructions\"]")
	private WebElement instructionField;

	public WebElement getInstructionField() {
		return instructionField;
	}

	@FindBy(xpath = "//span[text()=' SAVE ']")
	private WebElement saveBtn;

	@FindBy(xpath = "//span[text()=' CANCEL EDITS ']")
	private WebElement cancelEditsBtn;

	@FindBy(xpath = "//span[text()=' PRINT ']")
	private WebElement printBtn;

	@FindBy(xpath = "//span[text()=' CANCEL ']")
	private WebElement cancelBtn;

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getCancelEditsBtn() {
		return cancelEditsBtn;
	}

	public WebElement getPrintBtn() {
		return printBtn;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}

}
