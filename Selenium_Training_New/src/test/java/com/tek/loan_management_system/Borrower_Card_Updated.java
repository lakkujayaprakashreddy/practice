package com.tek.loan_management_system;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.Los_File_Utility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.tek.loan_management_system.baseclass.BaseClass;
import com.tek.los.objectRepositoryUtility.BorrowersPage;
import com.tek.los.objectRepositoryUtility.HomePage;

public class Borrower_Card_Updated extends BaseClass {
	@Test
	public void is_Borrower_Card_Updated_While_Borrower_Added() throws InterruptedException, IOException {
		BorrowersPage borrowersPage = new BorrowersPage(driver);
		HomePage homePage = new HomePage(driver);
		int count_Before_Borrower_added = Integer.parseInt(homePage.get_count_borrowerCard().getText());
		homePage.getBorrowers().click();
		borrowersPage.getNew_Borrower().click();

		borrowersPage.getLastNameEdit().sendKeys(eLib.getDataFromExcel("Borrowers", 1, 1) + jLib.getRandomNumber());

		borrowersPage.getFirstNameEdit().sendKeys(eLib.getDataFromExcel("Borrowers", 1, 0) + jLib.getRandomNumber());
		borrowersPage.getMiddleNameEdit().sendKeys(eLib.getDataFromExcel("Borrowers", 1, 2) + jLib.getRandomNumber());
		borrowersPage.getAddressEdit().sendKeys(eLib.getDataFromExcel("Borrowers", 1, 3));
		borrowersPage.getContactEdit().sendKeys(jLib.getrandomContactNumber());
		String email = jLib.getRandomEmail();
		borrowersPage.getEmailEdit().sendKeys(email);
		borrowersPage.getTax_id_Edit().sendKeys("536‑80‑" + jLib.getRandomNumber());
		borrowersPage.getSave().click();
		Thread.sleep(5000);
		wLib.waitForElementPresent(driver, homePage.getHome());
		homePage.getHome().click();
		int count_After_Borrower_added = Integer.parseInt(homePage.get_count_borrowerCard().getText());
		Assert.assertEquals(count_After_Borrower_added,count_Before_Borrower_added+1);
	}

}
