package com.tek.los.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoanPlansPage {
	WebDriver driver;
	public LoanPlansPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindAll({
		@FindBy(xpath = "//input[@name=\"months\"]"),
		@FindBy(css = "input[name=\"months\"]")})
	private WebElement plan_months;
	
	@FindAll({
		@FindBy(xpath = "//input[@name=\"interest_percentage\"]"),
		@FindBy(css = "input[name=\"interest_percentage\"]"),
		@FindBy(css="input[aria-label=\"Interest\"]")})
	private WebElement interest;
	
	
	@FindAll({
		@FindBy(css = "input[aria-label=\"Penalty percentage\"]"),
		@FindBy(css = "input[name=\"penalty_rate\"]"),
		@FindBy(xpath = "//input[@name=\"penalty_rate\"]"),
		@FindBy(xpath = "//input[@aria-label=\"Penalty percentage\"]")
		})
	
	private WebElement monthly_Overdue_Penalty;
	
	@FindAll({
		@FindBy(xpath = "//button[@class=\"btn btn-sm btn-primary col-sm-3 offset-md-3\"]"),
		@FindBy(xpath = "//button[text()=\"Save\"]")
		})
	
	private WebElement save;
	
	
	@FindAll({
		@FindBy(xpath = "//button[@class=\"btn btn-sm btn-default col-sm-3\"]"),
		@FindBy(xpath = "//button[text()=\"Cancel\"]"),
		@FindBy(css = "button[onclick=\"_reset()\"]")
		})
	
	private WebElement cancel;
}
