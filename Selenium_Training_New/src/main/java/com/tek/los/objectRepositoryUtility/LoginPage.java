package com.tek.los.objectRepositoryUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {
	WebDriver driver;
	public LoginPage(WebDriver driver)  {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id = "username")
	private WebElement userNameEdit;

	@FindBy(id = "password")
	private WebElement passwordEdit;

	@FindBy(css = "button.btn-sm.btn-block.btn-wave.col-md-4.btn-primary")
	private WebElement loginButton;
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getUserNameEdit() {
		return userNameEdit;
	}
	public WebElement getPasswordEdit() {
		return passwordEdit;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	public void loginToApplication(String url,String username, String password) {
		driver.get(url);
	    driver.manage().window().maximize();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    wait.until(ExpectedConditions.visibilityOf(userNameEdit))
	        .sendKeys(username);
	    passwordEdit.sendKeys(password);
	    loginButton.click();
	}
}
