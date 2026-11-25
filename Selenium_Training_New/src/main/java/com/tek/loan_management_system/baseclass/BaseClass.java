package com.tek.loan_management_system.baseclass;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.Los_File_Utility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.tek.los.objectRepositoryUtility.HomePage;
import com.tek.los.objectRepositoryUtility.LoginPage;


public class BaseClass {
	public static WebDriver driver;
	public   Los_File_Utility fLib=new Los_File_Utility();
	public   ExcelUtility eLib=new ExcelUtility();
	public   JavaUtility jLib=new JavaUtility();
	public   WebDriverUtility wLib=new WebDriverUtility();
	public   DataBaseUtility dLib=new DataBaseUtility();
	public static WebDriver sdriver=null;
	@BeforeSuite(alwaysRun = true)
	public void configBeforeSuite() {
		System.out.println("---connect to Database , Report Configuration---");
		
		//dLib.getConnection();
		
		//spark report config
		
		
		//add Environment information and create test
		
		
	}
	@BeforeClass(alwaysRun = true)
	public void configBeforeClass() throws IOException {
	    System.out.println("Launch the Browser");

	    driver = wLib.getDriver();
	    UtilityClassObject.setDriver(driver);

	    if (driver == null) {
	        throw new IllegalStateException(
	            "WebDriver initialization failed in configBeforeClass()");
	    }

	    System.out.println("Driver initialized: " + driver);
	}
	@BeforeMethod(alwaysRun = true)
	public void configBeforeMethod() throws IOException {
	    System.out.println("---Login---");
	    
	    
	    System.out.println("BaseClass driver: " + driver);
	     String URL=fLib.getDataFromPropertiesFile("url");
	     String USER_NAME = fLib.getDataFromPropertiesFile("username");
	     String PASSWORD = fLib.getDataFromPropertiesFile("password");

	    LoginPage loginPage = new LoginPage(driver);
	    System.out.println("LoginPage driver: " + loginPage.getDriver());

	    loginPage.loginToApplication(URL,USER_NAME, PASSWORD);
	}
	@AfterMethod(alwaysRun = true)
	public void configAfterMethod() {
		System.out.println("---logout---");
		HomePage hp=new HomePage(driver);
		hp.getLogOut().click();;
	}
	@AfterClass(alwaysRun = true)
	public void configAfterClass() {
		System.out.println("---Close the Browser---");
		driver.quit();
	}
	@AfterSuite(alwaysRun = true)
	public void configAfterSuite() throws SQLException {
		System.out.println("--- Close DB, Report Backup---");
		dLib.closeDataBaseConnection();
		
	}
	
	
}
