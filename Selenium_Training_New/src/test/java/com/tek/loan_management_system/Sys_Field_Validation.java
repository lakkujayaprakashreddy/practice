package com.tek.loan_management_system;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tek.loan_management_system.baseclass.BaseClass;
import com.tek.los.objectRepositoryUtility.BorrowersPage;
import com.tek.los.objectRepositoryUtility.HomePage;

public class Sys_Field_Validation extends BaseClass {
	@Test
	public void RecordCreationWithAllFields() throws EncryptedDocumentException, IOException {
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
		Assert.assertTrue(driver.findElements(By.xpath(
			    "//th[@class=\"text-center sorting_asc\"]/parent::tr/parent::thead/following-sibling::tbody/child::tr/child::td/following-sibling::td//p[contains(.,'" + email + "')]"
			)).size() > 0);
	}

	@Test
	public void RecordCreationWithOutLastName() throws EncryptedDocumentException, IOException {
		BorrowersPage borrowersPage = new BorrowersPage(driver);
		HomePage homePage = new HomePage(driver);
		homePage.getBorrowers().click();
		borrowersPage.getNew_Borrower().click();

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
		Assert.assertFalse(driver.findElements(By.xpath(
			    "//th[@class=\"text-center sorting_asc\"]/parent::tr/parent::thead/following-sibling::tbody/child::tr/child::td/following-sibling::td//p[contains(.,'" + email + "')]"
			)).size() > 0);
	}
	
	
	@Test
	public void RecordCreationWithOutFirstName() throws EncryptedDocumentException, IOException {
		BorrowersPage borrowersPage = new BorrowersPage(driver);
		HomePage homePage = new HomePage(driver);
		homePage.getBorrowers().click();
		borrowersPage.getNew_Borrower().click();

		borrowersPage.getLastNameEdit().sendKeys(eLib.getDataFromExcel("Borrowers", 1, 1) + jLib.getRandomNumber());

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
		Assert.assertFalse(driver.findElements(By.xpath(
			    "//th[@class=\"text-center sorting_asc\"]/parent::tr/parent::thead/following-sibling::tbody/child::tr/child::td/following-sibling::td//p[contains(.,'" + email + "')]"
			)).size() > 0);
	}
	
	@Test
	public void RecordCreationWithOutMiddleName() throws EncryptedDocumentException, IOException {
		BorrowersPage borrowersPage = new BorrowersPage(driver);
		HomePage homePage = new HomePage(driver);
		homePage.getBorrowers().click();
		borrowersPage.getNew_Borrower().click();

		borrowersPage.getLastNameEdit().sendKeys(eLib.getDataFromExcel("Borrowers", 1, 1) + jLib.getRandomNumber());

		borrowersPage.getFirstNameEdit().sendKeys(eLib.getDataFromExcel("Borrowers", 1, 0) + jLib.getRandomNumber());
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
		Assert.assertFalse(driver.findElements(By.xpath(
			    "//th[@class=\"text-center sorting_asc\"]/parent::tr/parent::thead/following-sibling::tbody/child::tr/child::td/following-sibling::td//p[contains(.,'" + email + "')]"
			)).size() > 0);
	}
	
	@Test
	public void RecordCreationWithOutAddress() throws EncryptedDocumentException, IOException {
		BorrowersPage borrowersPage = new BorrowersPage(driver);
		HomePage homePage = new HomePage(driver);
		homePage.getBorrowers().click();
		borrowersPage.getNew_Borrower().click();

		borrowersPage.getLastNameEdit().sendKeys(eLib.getDataFromExcel("Borrowers", 1, 1) + jLib.getRandomNumber());

		borrowersPage.getFirstNameEdit().sendKeys(eLib.getDataFromExcel("Borrowers", 1, 0) + jLib.getRandomNumber());
		borrowersPage.getMiddleNameEdit().sendKeys(eLib.getDataFromExcel("Borrowers", 1, 2) + jLib.getRandomNumber());
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
		Assert.assertFalse(driver.findElements(By.xpath(
			    "//th[@class=\"text-center sorting_asc\"]/parent::tr/parent::thead/following-sibling::tbody/child::tr/child::td/following-sibling::td//p[contains(.,'" + email + "')]"
			)).size() > 0);
	}
	@Test
	public void RecordCreationWithOutContact() throws EncryptedDocumentException, IOException {
		BorrowersPage borrowersPage = new BorrowersPage(driver);
		HomePage homePage = new HomePage(driver);
		homePage.getBorrowers().click();
		borrowersPage.getNew_Borrower().click();

		borrowersPage.getLastNameEdit().sendKeys(eLib.getDataFromExcel("Borrowers", 1, 1) + jLib.getRandomNumber());

		borrowersPage.getFirstNameEdit().sendKeys(eLib.getDataFromExcel("Borrowers", 1, 0) + jLib.getRandomNumber());
		borrowersPage.getMiddleNameEdit().sendKeys(eLib.getDataFromExcel("Borrowers", 1, 2) + jLib.getRandomNumber());
		borrowersPage.getAddressEdit().sendKeys(eLib.getDataFromExcel("Borrowers", 1, 3));
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
		Assert.assertFalse(driver.findElements(By.xpath(
			    "//th[@class=\"text-center sorting_asc\"]/parent::tr/parent::thead/following-sibling::tbody/child::tr/child::td/following-sibling::td//p[contains(.,'" + email + "')]"
			)).size() > 0);
	}
	
	@Test
	public void RecordCreationWithOutEmail() throws EncryptedDocumentException, IOException {
		BorrowersPage borrowersPage = new BorrowersPage(driver);
		HomePage homePage = new HomePage(driver);
		homePage.getBorrowers().click();
		borrowersPage.getNew_Borrower().click();

		borrowersPage.getLastNameEdit().sendKeys(eLib.getDataFromExcel("Borrowers", 1, 1) + jLib.getRandomNumber());

		borrowersPage.getFirstNameEdit().sendKeys(eLib.getDataFromExcel("Borrowers", 1, 0) + jLib.getRandomNumber());
		borrowersPage.getMiddleNameEdit().sendKeys(eLib.getDataFromExcel("Borrowers", 1, 2) + jLib.getRandomNumber());
		borrowersPage.getAddressEdit().sendKeys(eLib.getDataFromExcel("Borrowers", 1, 3));
		borrowersPage.getContactEdit().sendKeys(jLib.getrandomContactNumber());
		String taxId="536‑80‑" + jLib.getRandomNumber();
		borrowersPage.getTax_id_Edit().sendKeys(taxId);
		borrowersPage.getSave().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader2")));
		WebElement borrower_Search = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type=\"search\"]")));
		borrower_Search.clear();
		borrower_Search.click();
		borrower_Search.sendKeys(taxId);
		Assert.assertFalse(driver.findElements(By.xpath(
			    "//th[@class=\"text-center sorting_asc\"]/parent::tr/parent::thead/following-sibling::tbody/child::tr/child::td/following-sibling::td//p[contains(.,'" + taxId + "')]"
			)).size() > 0);
	}
	@Test
	public void RecordCreationWithOutTaxId() throws EncryptedDocumentException, IOException {
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
		borrowersPage.getSave().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader2")));
		WebElement borrower_Search = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type=\"search\"]")));
		borrower_Search.clear();
		borrower_Search.click();
		borrower_Search.sendKeys(email);
		Assert.assertFalse(driver.findElements(By.xpath(
			    "//th[@class=\"text-center sorting_asc\"]/parent::tr/parent::thead/following-sibling::tbody/child::tr/child::td/following-sibling::td//p[contains(.,'" + email + "')]"
			)).size() > 0);
	}

	
}
