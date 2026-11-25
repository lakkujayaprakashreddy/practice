package com.tek.los.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoansPage {
	WebDriver driver;
	public LoansPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindAll({
		@FindBy(id = "new_application"),
		@FindBy(className = "btn.btn-primary.btn-sm.btn-block.col-md-2.float-right"),
		@FindBy(tagName="button"),
		@FindBy(xpath = "//button[@class=\"btn btn-primary btn-sm btn-block col-md-2 float-right\"]"),
		@FindBy(xpath = "//button[@id=\"new_application\"]")})
	private WebElement create_New_Application;
	
	
	@FindAll({
		@FindBy(css = "input[type=\"search\"]"),
		@FindBy(css = "aria-controls=\"loan-list\""),
		@FindBy(xpath = "//input[@type=\"search\"]"),
		@FindBy(xpath = "//input[@aria-controls=\"loan-list\"]")})
	private WebElement Loan_Page_Search;
	
	@FindAll({
		@FindBy(id = "select2-borrower_id-container"),
		@FindBy(css = "span[id=\"select2-borrower_id-container\"]"),
		@FindBy(xpath = "//span[@id=\"select2-borrower_id-container\"]")})
	private WebElement borrower_edit;
	
	
	@FindAll({
		@FindBy(id = "select2-loan_type_id-container"),
		@FindBy(css = "span[id=\"select2-borrower_id-container\"]"),
		@FindBy(xpath = "//span[@id=\"select2-borrower_id-container\"]")})
	private WebElement loan_Type_Edit;
	
	
	@FindAll({
		@FindBy(id = "select2-plan_id-container"),
		@FindBy(css = "span[id=\"select2-plan_id-container\"]"),
		@FindBy(xpath = "//span[@id=\"select2-plan_id-container\"]")})
	private WebElement loan_Plan_Edit;
	
	
	@FindAll({
		@FindBy(name = "amount"),
		@FindBy(className = "class=\"form-control text-right\""),
		@FindBy(css = "input[type=\"number\"]"),
		@FindBy(css = "input[name=\"amount\"]"),
		@FindBy(xpath = "//input[@name=\"amount\"]")
		})
	private WebElement loan_Amount;
	
	
	@FindAll({
		@FindBy(name = "purpose"),
		@FindBy(xpath = "//textarea[@class=\"form-control\"]"),
		@FindBy(css = "textarea[name=\"purpose\"]"),
		@FindBy(css = "textarea[class=\"form-control\"]"),
		@FindBy(xpath = "//textarea[@name=\"purpose\"]")
		})
	private WebElement purpose;
	
	
	@FindAll({
		@FindBy(xpath = "//button[@class=\"btn btn-primary btn-sm \"]")
		})
	private WebElement save;
	
	
	@FindAll({
		@FindBy(xpath = "//button[@class=\"btn btn-secondary btn-sm\"]"),
		@FindBy(xpath = "//button[text()=\"Cancel\"]")
		})
	private WebElement cancel;
	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getCreate_New_Application() {
		return create_New_Application;
	}


	public WebElement getLoan_Page_Search() {
		return Loan_Page_Search;
	}


	public WebElement getBorrower_edit() {
		return borrower_edit;
	}


	public WebElement getLoan_Type_Edit() {
		return loan_Type_Edit;
	}


	public WebElement getLoan_Plan_Edit() {
		return loan_Plan_Edit;
	}


	public WebElement getLoan_Amount() {
		return loan_Amount;
	}


	public WebElement getPurpose() {
		return purpose;
	}


	public WebElement getSave() {
		return save;
	}


	public WebElement getCancel() {
		return cancel;
	}
	
	
}
