package com.tek.los.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BorrowersPage {
	WebDriver driver;
	public BorrowersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindAll({
		@FindBy(id = "new_borrower"),
		@FindBy(tagName="button"),@FindBy(xpath = "//button[contains(.,\"New Borrower\")]"),
		@FindBy(css="button[type=\"button\"]")})
	private WebElement new_Borrower;
	
	
	
		
	
	
	@FindAll({
		@FindBy(name = "lastname"),
		@FindBy(xpath = "//input[@name=\"lastname\"]")
	})
	private WebElement lastNameEdit;
	
	
	
	@FindAll({
		@FindBy(name = "firstname"),
		@FindBy(xpath = "//input[@name=\"firstname\"]")
	})
	private WebElement firstNameEdit;
	
	
	@FindAll({
		@FindBy(name = "middlename"),
		@FindBy(xpath = "//input[@name=\"middlename\"]")
	})
	private WebElement middleNameEdit;
	
	
	@FindAll({
		@FindBy(name = "address"),
		@FindBy(xpath = "//textarea[@name=\"address\"]")
	})
	private WebElement addressEdit;
	
	
	@FindAll({
		@FindBy(name = "contact_no"),
		@FindBy(css = "input[type=\"text\"]"),
		@FindBy(xpath = "//input[@name=\"contact_no\"]")
	})
	private WebElement contactEdit;
	
	
	
	@FindAll({
		@FindBy(name = "email"),
		@FindBy(css = "input[type=\"email\"]"),
		@FindBy(xpath = "//input[@name=\"email\"]")
	})
	private WebElement emailEdit;
	
	
	@FindAll({
		@FindBy(name = "tax_id"),
		@FindBy(xpath = "//input[@name=\"tax_id\"]")
	})
	private WebElement tax_id_Edit;
	
	
	@FindAll({
		@FindBy(id = "submit"),
		@FindBy(name = "tax_id"),
		@FindBy(className = "btn.btn-primary"),
		@FindBy(css = "input[type=\"button\"]"),
		@FindBy(xpath = "//button[text()=\"Save\"]")
	})
	private WebElement save;
	
	@FindBy(xpath = "//a[contains(.,\"Home\")]")
	private WebElement home;
	
	
	public WebElement getHome() {
		return home;
	}


	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getNew_Borrower() {
		return new_Borrower;
	}


	public WebElement getLastNameEdit() {
		return lastNameEdit;
	}


	public WebElement getFirstNameEdit() {
		return firstNameEdit;
	}


	public WebElement getMiddleNameEdit() {
		return middleNameEdit;
	}


	public WebElement getAddressEdit() {
		return addressEdit;
	}


	public WebElement getContactEdit() {
		return contactEdit;
	}


	public WebElement getEmailEdit() {
		return emailEdit;
	}


	public WebElement getTax_id_Edit() {
		return tax_id_Edit;
	}


	public WebElement getSave() {
		return save;
	}
	
	
}
