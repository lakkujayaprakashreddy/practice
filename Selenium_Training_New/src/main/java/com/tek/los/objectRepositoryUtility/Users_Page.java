package com.tek.los.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Users_Page {

	WebDriver driver;
	public Users_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindAll({
		@FindBy(id = "new_user"),
		@FindBy(className = "btn btn-primary.float-right.btn-sm"),
		@FindBy(xpath = "//button[@class=\"btn btn-primary float-right btn-sm\"]"),
		@FindBy(xpath = "//button[text()=\" New user\"]")
	})
	private WebElement new_User;
	
	
	@FindAll({
		@FindBy(id = "name"),
		@FindBy(name = "name"),
		@FindBy(xpath = "//input[@name=\"name\"]"),
		@FindBy(xpath = "//input[@id=\"name\"]")
	})
	private WebElement name;
	
	
	@FindAll({
		@FindBy(id = "username"),
		@FindBy(name = "username"),
		@FindBy(xpath = "//input[@name=\"username\"]"),
		@FindBy(xpath = "//input[@id=\"username\"]"),
		@FindBy(css = "input[id=\"username\"]"),
		@FindBy(css = "input[name=\"username\"]")
	})
	private WebElement new_User_Username;
	
	
	@FindAll({
		@FindBy(id = "password"),
		@FindBy(name = "password"),
		@FindBy(xpath = "//input[@type=\"password\"]"),
		@FindBy(xpath = "//input[@name=\"password\"]"),
		@FindBy(xpath = "//input[@id=\"password\"]"),
		@FindBy(css = "input[name=\"password\"]"),
		@FindBy(css = "input[id=\"password\"]"),
		@FindBy(css = "input[type=\"password\"]")
	})
	private WebElement new_User_Password;
	
	
	@FindAll({
		@FindBy(id = "type"),
		@FindBy(name = "type"),
		@FindBy(xpath = "//select[@id=\"type\"]"),
		@FindBy(xpath = "//select[@name=\"type\"]"),
		@FindBy(css = "select[name=\"type\"]"),
		@FindBy(css = "select[id=\"type\"]")
	})
	private WebElement new_User_Type;
	
	
	@FindAll({
		@FindBy(id = "submit"),
		@FindBy(xpath = "//button[@id=\"submit\"]"),
		@FindBy(xpath = "//button[text()=\"Save\"]"),
		@FindBy(css = "button[onclick=\"$('#uni_modal form').submit()\"]")
	})
	private WebElement new_User_Save;
	
	
	@FindAll({
		@FindBy(xpath = "//button[contains(.,\"Cancel\")]"),
		@FindBy(xpath = "//button[text()=\"Cancel\"]")
	})
	
	private WebElement new_User_Cancel;
}
