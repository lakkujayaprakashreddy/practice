package com.tek.los.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Payments_Page {
	WebDriver driver;
	public Payments_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindAll({
		@FindBy(id = "new_payments"),
		@FindBy(xpath = "//button[@class=\"btn btn-primary btn-sm btn-block col-md-2 float-right\"]"),
		@FindBy(xpath = "//button[text()=\" New Payment\"]")
	})
	private WebElement new_Payment;
	
	@FindAll({
		@FindBy(id = "select2--container"),
		@FindBy(className = "select2-selection__rendered"),
		@FindBy(css = "span[role=\"textbox\"]"),
		@FindBy(xpath = "//span[@id=\"select2--container\"]"),
		@FindBy(xpath = "//span[@class=\"select2-selection__rendered\"]")
	})
	private WebElement loan_Reference_Number;
	
	@FindAll({
		@FindBy(css = "input[role=\"textbox\"]"),
		@FindBy(css = "input[class=\"select2-search__field\"]"),
		@FindBy(xpath = "//input[@class=\"select2-search__field\"]"),
		@FindBy(xpath = "//input[@role=\"textbox\"]")
	})
	private WebElement loan_Reference_Number_Search_Field;
	
	@FindAll({
		@FindBy(id = "submit"),
		@FindBy(xpath = "//button[@onclick=\"$('#uni_modal form').submit()\"]"),
		@FindBy(xpath = "//button[text()=\"Save\"]"),
	})
	private WebElement save;
	
	
	@FindBy(xpath = "//button[text()=\"Cancel\"]")
	private WebElement cancel;
	
	
}
