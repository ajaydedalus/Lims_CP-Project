package org.pojo;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderVerificationPojo extends BaseClass {
	
	public OrderVerificationPojo() {

		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//div[text()=' Order verification ']")
	private WebElement orderVerify;


	public WebElement getOrderVerify() {
		return orderVerify;
	}

	@FindBy(xpath="//span[text()=' NEW ']")
	private WebElement newBtn;
	
	@FindBy(xpath="//span[text()=' REFRESH ']")
	private WebElement refreshBtn;
	
	@FindBy(xpath="//span[text()=' CANCEL ']")
	private WebElement cancelBtn;


	public WebElement getNewBtn() {
		return newBtn;
	}

	public WebElement getRefreshBtn() {
		return refreshBtn;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}
	
	@FindBy(xpath="//span[text()=' VERIFY ']")
	private WebElement verifyBtn;
	
	@FindBy(xpath="//span[text()=' RELEASE TO PATHOLOGIST ']")
	private WebElement releaseBtn;


	public WebElement getVerifyBtn() {
		return verifyBtn;
	}

	public WebElement getReleaseBtn() {
		return releaseBtn;
	}
	
	@FindBy(xpath="(//div[@role=\"tab\"])[2]")
	private WebElement tabVerification;
	
	@FindBy(xpath="(//div[@role=\"tab\"])[3]")
	private WebElement tabHistory;


	public WebElement getTabVerification() {
		return tabVerification;
	}

	public WebElement getTabHistory() {
		return tabHistory;
	}
	

	@FindBy(xpath="//a[@title=\"Date Filter Menu\"]")
	private WebElement dateFilter;
	
	@FindBy(xpath="//a[@title=\"Location Filter Menu\"]")
	private WebElement locationFilter;


	public WebElement getDateFilter() {
		return dateFilter;
	}

	public WebElement getLocationFilter() {
		return locationFilter;
	}
	
	
	
	
	
	
	
	
}
