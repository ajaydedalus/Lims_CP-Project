package org.pojo;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class SpecimenDissection extends BaseClass{

	public SpecimenDissection() {
		
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindAll({
		
		@FindBy(xpath="(//input[@type=\"checkbox\"])[3]"),
		@FindBy(id="mat-checkbox-30-input")
	})
	private WebElement kpSetCheckBox;

	public WebElement getKpSetCheckBox() {
		return kpSetCheckBox;
	}
	@FindBy(xpath="//span[text()=' NEXT ']")
	private WebElement nextBtn;
	
	public WebElement getNextBtn() {
		return nextBtn;
	}
	
	@CacheLookup
	@FindAll({
		
		@FindBy(xpath="(//span[@class=\"mat-checkbox-inner-container\"])[2]"),
		@FindBy(id="mat-checkbox-38-input")
	})
	private WebElement allTissueUsed;

	public WebElement getAllTissueUsed() {
		return allTissueUsed;
	}
	
	public WebElement getDisUnused() {
		return disUnused;
	}

	@CacheLookup
	@FindAll({
		
		@FindBy(xpath="(//span[@class=\"mat-checkbox-inner-container\"])[1]"),
		@FindBy(id="mat-checkbox-37-input")
	})
	private WebElement disUnused;
}
