package com.tek.loan_management_system;

import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.fileutility.Los_File_Utility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.tek.loan_management_system.baseclass.BaseClass;
import com.tek.los.objectRepositoryUtility.BorrowersPage;
import com.tek.los.objectRepositoryUtility.HomePage;

public class Sys_Borrower_Edit extends BaseClass {
	@Test
	public void addedBorrowerEditOrNotTest() throws InterruptedException, IOException {
		BorrowersPage borrowersPage = new BorrowersPage(driver);
		HomePage homePage = new HomePage(driver);
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader2")));
		WebElement borrower_Search = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type=\"search\"]")));
		borrower_Search.clear();
		borrower_Search.click();
		borrower_Search.sendKeys(email);
		wLib.mouseMoveOnElement(driver,
				driver.findElement(By.xpath(
						"//th[text()=\"Borrower\"]/parent::tr/parent::thead/following-sibling::tbody//tr[contains(.,\""
								+ email + "\")]")));
		driver.findElement(By.xpath(
				"//th[@class=\"text-center sorting_asc\"]/parent::tr/parent::thead/following-sibling::tbody//button[@class=\"btn btn-outline-primary btn-sm edit_borrower\"]"))
				.click();
		Thread.sleep(5000);
		String rename=eLib.getDataFromExcel("Borrowers", 1, 1)+jLib.getRandomNumber();
		borrowersPage.getLastNameEdit().clear();
		borrowersPage.getLastNameEdit().sendKeys(rename);
		borrowersPage.getSave().click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader2")));

		WebElement borrower_Search1 = wait.until(
		    ExpectedConditions.elementToBeClickable(
		        By.xpath("//input[@type='search']")));

		borrower_Search1.clear();
		borrower_Search1.sendKeys(rename);
		
		Assert.assertTrue(driver.findElement(By.xpath("//th[@class=\"text-center sorting_asc\"]/parent::tr/parent::thead/following-sibling::tbody/child::tr/child::td/following-sibling::td/child::p/child::b")).getText().trim().contains(rename));

	}
}
