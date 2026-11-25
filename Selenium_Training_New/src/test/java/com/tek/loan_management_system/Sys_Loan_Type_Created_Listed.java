package com.tek.loan_management_system;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.fileutility.Los_File_Utility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.tek.loan_management_system.baseclass.BaseClass;
import com.tek.los.objectRepositoryUtility.HomePage;
import com.tek.los.objectRepositoryUtility.Loan_Types_page;
import com.tek.los.objectRepositoryUtility.LoginPage;
@Listeners(ListenerUtility.ListenerImplimentation.class)
public class Sys_Loan_Type_Created_Listed extends BaseClass {
	@Test
	public void Sys_Loan_Type_Created_Listed() throws InterruptedException, IOException {
		//ExtentTest test=report.createTest("Sys_Loan_Type_Created_Listed");
		UtilityClassObject.getTest().log(Status.INFO, "Logged into Application");
		HomePage hp = new HomePage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "Entered  into default Home Pade");
		WebDriverUtility wLib = new WebDriverUtility();
		Loan_Types_page lt = new Loan_Types_page(driver);
		hp.getLoanTypes().click();
		UtilityClassObject.getTest().log(Status.INFO, "Entered into Loan Types Page");
		String name = eLib.getDataFromExcel("Loan Type", 1, 1) + jLib.getRandomNumber();
		
		lt.getTypeName().sendKeys(name);
		UtilityClassObject.getTest().log(Status.INFO, "Passed keys to name Field");
		lt.getDescription().sendKeys(eLib.getDataFromExcel("Loan Type", 1, 2) + jLib.getRandomNumber());
		UtilityClassObject.getTest().log(Status.INFO, "Passed keys to Description Field");
		lt.getSave().click();
		UtilityClassObject.getTest().log(Status.INFO, "Entered Saved Button");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		// Find and click Edit once
		By searchLoanType = By
				.xpath("//tbody//tr[contains(.,'" + name + "')]" + "//button[contains(@class,'edit_ltype')]");

		WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(searchLoanType));
		editButton.click();

		UtilityClassObject.getTest().log(Status.INFO, "Clicking Edit button");

		// Update the name after the edit form is available
		WebElement typeNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("type_name")));

		typeNameField.clear();
		UtilityClassObject.getTest().log(Status.INFO, "Cleared the name field");

		String reName = eLib.getDataFromExcel("Loan Type", 1, 1) + jLib.getRandomNumber();

		typeNameField.sendKeys(reName);
		UtilityClassObject.getTest().log(Status.INFO, "Renamed the name Field");
		lt.getSave().click();
		UtilityClassObject.getTest().log(Status.INFO, "Entered Saved button");

		// Verify the renamed record
		By renamedRowLocator = By.xpath("//tbody//tr[contains(.,'" + reName + "')]");

		WebElement renamedRow = wait.until(ExpectedConditions.visibilityOfElementLocated(renamedRowLocator));

		Assert.assertTrue(renamedRow.getText().contains(reName));
		UtilityClassObject.getTest().log(Status.PASS, "Edited the created LoanType name successfully");
		
	}
}
