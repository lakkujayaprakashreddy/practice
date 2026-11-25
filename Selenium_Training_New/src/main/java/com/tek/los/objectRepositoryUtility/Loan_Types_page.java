package com.tek.los.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loan_Types_page {
	WebDriver driver;
	public Loan_Types_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindAll({
		@FindBy(name = "type_name"),
		@FindBy(xpath = "//textarea[@name=\"type_name\"]"),
		@FindBy(css = "textarea[name=\"type_name\"]")
		})
	private WebElement typeName;
	
	@FindAll({
		@FindBy(name = "description"),
		@FindBy(xpath = "//textarea[@name=\"description\"]"),
		@FindBy(css = "textarea[name=\"description\"]")
		})
	private WebElement description;
	
	@FindAll({
		@FindBy(xpath = "//button[@class=\"btn btn-sm btn-primary col-sm-3 offset-md-3\"]"),
		@FindBy(css = "button[class=\"btn btn-sm btn-primary col-sm-3 offset-md-3\"]"),
		@FindBy(xpath = "//button[text()=\"Save\"]")
		})
	private WebElement save;
	
	
	@FindAll({
		@FindBy(xpath = "//button[text()=\"Cancel\"]")
		})
	private WebElement cancel;
	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getTypeName() {
		return typeName;
	}


	public WebElement getDescription() {
		return description;
	}


	public WebElement getSave() {
		return save;
	}


	public WebElement getCancel() {
		return cancel;
	}
	
	
}
