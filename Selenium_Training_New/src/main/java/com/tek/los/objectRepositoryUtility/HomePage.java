package com.tek.los.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	@FindBy(xpath = "//div[contains(.,\"Borrowers\") and @class=\"text-white-75 small\"]/parent::div//div[@class=\"text-lg font-weight-bold\"]")
	private WebElement count_borrowerCard;
	
	public WebElement get_count_borrowerCard() {
		return count_borrowerCard;
	}



	@FindAll({
		@FindBy(xpath = "//a[contains(.,\"Loans\")]"),
		@FindBy(className = "nav-item.nav-loans"),
		@FindBy(css = "a[href=\"index.php?page=loans\"]")
	})
	private WebElement loans;
	
	
	
	@FindAll({
		@FindBy(xpath = "//a[contains(.,\"Home\")]"),
		@FindBy(className = "nav-item.nav-home"),
		@FindBy(css = "a[href=\"index.php?page=home\"]")
	})
	private WebElement home;
	
	
	@FindAll({
		@FindBy(xpath = "//a[contains(.,\"Payments\")]"),
		@FindBy(className = "nav-item.nav-payments"),
		@FindBy(css = "a[href=\"index.php?page=payments\"]")
	})
	private WebElement payments;
	
	
	@FindAll({
		@FindBy(xpath = "//a[contains(.,\"Borrowers\")]"),
		@FindBy(className = "nav-item.nav-borrowers"),
		@FindBy(xpath = "a[href=\"index.php?page=borrowers\"]")
	})
	private WebElement borrowers;
	
	
	@FindAll({
		@FindBy(xpath = "//a[contains(.,\"Loan Plans\")]"),
		@FindBy(className = "nav-item.nav-plan"),
		@FindBy(xpath = "a[href=\"index.php?page=plan\"]")
	})
	private WebElement loanPlans;
	
	
	@FindBy(css = "a[href*='page=loan_type']")
	private WebElement loanTypes;
	//private WebElement loanTypes;
	
	
	
	@FindAll({
		@FindBy(xpath = "//a[contains(.,\"Users\")]"),
		@FindBy(className = "nav-item.nav-users"),
		@FindBy(xpath = "a[href=\"index.php?page=users\"]")
	})
	private WebElement users;
	
	
	@FindBy(xpath = "//a[contains(.,\"Administrator\")]") 
	private WebElement logOut;
	
	
	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getLoans() {
		return loans;
	}


	public WebElement getHome() {
		return home;
	}


	public WebElement getPayments() {
		return payments;
	}


	public WebElement getBorrowers() {
		return borrowers;
	}


	public WebElement getLoanPlans() {
		return loanPlans;
	}


	public WebElement getLoanTypes() {
		return loanTypes;
	}


	public WebElement getUsers() {
		return users;
	}


	public WebElement getLogOut() {
		return logOut;
	}
	
	

}
