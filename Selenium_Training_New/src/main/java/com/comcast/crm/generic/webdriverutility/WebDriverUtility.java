package com.comcast.crm.generic.webdriverutility;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;

public class WebDriverUtility {
	public void pageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void waitForElementPresent(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void switchToTabOnUrl(WebDriver driver, String partialUrl) {
		Set<String> windows_Available = driver.getWindowHandles();
		Iterator itr=windows_Available.iterator();
		while(itr.hasNext()) {
			driver.switchTo().window((String) itr.next());
			String actUrl=driver.getCurrentUrl();
			if(actUrl.contains(partialUrl)) {
				break;
			}
		}
	}
	public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
		Set<String> windows_Available = driver.getWindowHandles();
		Iterator itr=windows_Available.iterator();
		while(itr.hasNext()) {
			driver.switchTo().window((String) itr.next());
			String actUrl=driver.getTitle();
			if(actUrl.contains(partialTitle)) {
				break;
			}
		}
	}
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver, String  nameId) {
		driver.switchTo().frame(nameId);
	}
	public void switchToFrame(WebDriver driver, WebElement  element) {
		driver.switchTo().frame(element);
	}
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void select(WebElement element, String text) {
		Select select=new Select(element);
		select.selectByContainsVisibleText(text);
	}
	public void select(WebElement element, int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	public void mouseMoveOnElement(WebDriver driver, WebElement  element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).click().perform();
	}
	public void doubleClickOnElement(WebDriver driver, WebElement  element) {
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
	}
	public WebDriver getDriver() throws IOException {
		FileUtility fLib=new FileUtility();
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USER_NAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		WebDriver driver = null;
		if ("edge".equalsIgnoreCase(BROWSER)) {
		    driver = new EdgeDriver();
		} else if ("chrome".equalsIgnoreCase(BROWSER)) {
		    driver = new ChromeDriver();
		} else if ("safari".equalsIgnoreCase(BROWSER)) {
		    driver = new SafariDriver();
		} else {
		    throw new IllegalArgumentException(
		        "Unsupported browser: " + BROWSER
		    );
		}
		return driver;
	}
	
}
