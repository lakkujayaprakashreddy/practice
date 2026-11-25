package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class Create_Contact_With_Org_Test {
	public static void main(String[] args) throws IOException, InterruptedException {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USER_NAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		WebDriver driver =wLib.getDriver();
		System.out.println("BROWSER: " + BROWSER);
		System.out.println("URL: " + URL);

		if (URL == null || URL.isBlank()) {
		    throw new IllegalStateException(
		        "URL is missing. Check the properties file path and key."
		    );
		}

		driver.get(URL);
		driver.manage().window().maximize();
		wLib.pageToLoad(driver);
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(USER_NAME);
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[@href=\"index.php?module=Accounts&action=index\"]")).click();
		driver.findElement(By.xpath("//a[@href=\"index.php?module=Accounts&action=EditView&return_action=DetailView&parenttab=Marketing\"]")).click();
		String name=eLib.getDataFromExcel("Sheet2", 7, 2);
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(name+jLib.getRandomNumber()/* random_Num */);
		driver.findElement(By.xpath("//td[@class=\"detailedViewHeader\"]/parent::tr/preceding-sibling::tr/descendant::div/child::input[@title=\"Save [Alt+S]\"]")).click();
		String nameWithRandom=driver.findElement(By.xpath("//span[@id=\"dtlview_Organization Name\"]")).getText().trim();
		System.out.println("Organisation created with the Name: "+nameWithRandom);
		//contact
		driver.findElement(By.xpath("//a[@href=\"index.php?module=Contacts&action=index\"]")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys(eLib.getDataFromExcel("Sheet2", 7, 5)/* sheet.getRow(7).getCell(5).toString() */+jLib.getRandomNumber());
		driver.findElement(By.xpath("//td[text()=\"Organization Name 			\"]/parent::tr//img[@src=\"themes/softed/images/select.gif\"]")).click();
		String parent_Window = driver.getWindowHandle();
		wLib.switchToTabOnUrl(driver, "module=Accounts&action");
		driver.findElement(By.id("search_txt")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name=\"search\"]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'" + name + "')]")).click();
		driver.switchTo().window(parent_Window);
		driver.findElement(By.xpath("//b[text()='Contact Information']/parent::td/parent::tr/preceding-sibling::tr//input[@title=\"Save [Alt+S]\"]")).click();
		Thread.sleep(5000);
		wLib.mouseMoveOnElement(driver, driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")));
		wLib.mouseMoveOnElement(driver, driver.findElement(By.xpath("//a[@href=\"index.php?module=Users&action=Logout\"]")));
		driver.quit();
	}

}
