package com.tek.test_automation_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Working_With_Test_Automation_Practice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		//create an object of Actions class
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		System.out.println("Application Launched Successfully");
		Actions action=new Actions(driver);
		driver.findElement(By.id("name")).sendKeys("Jayaprakash");
		driver.findElement(By.id("email")).sendKeys("lakkujayaprakash@gmail.com");
		driver.findElement(By.id("phone")).sendKeys("7893137299");
		driver.findElement(By.id("textarea")).sendKeys("Banglore");
		driver.findElement(By.id("male")).click();
		driver.findElement(By.id("saturday")).click();
		WebElement countryDropDown=driver.findElement(By.id("country"));
		countryDropDown.click();
		Select country=new Select(countryDropDown);
		country.selectByVisibleText("India");
		
		WebElement colourList=driver.findElement(By.id("colors"));
		Select colour=new Select(colourList);
		colour.selectByVisibleText("White");
		
		WebElement animalList = driver.findElement(By.id("animals"));
		Select animal = new Select(animalList);
		animal.selectByVisibleText("Zebra");
		
		//Double Click
		WebElement boubleClick=driver.findElement(By.xpath("//button[text()='Copy Text']"));
		action.doubleClick(boubleClick).perform();
		
//		//hover to Point me 
		WebElement pointMe=driver.findElement(By.xpath("//button[text()='Point Me']"));
		action.moveToElement(pointMe).moveToElement(driver.findElement(By.xpath("//a[text()='Mobiles']"))).click().perform();

		
		//Drag and Drop
		WebElement first=driver.findElement(By.id("draggable"));
		WebElement second=driver.findElement(By.id("droppable"));
		action.dragAndDrop(first, second).perform();
		System.out.println("Drag and drop successfully executed");
		
		//slider
		WebElement firstSlider=driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle')][1]"));
		WebElement secondSlider=driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle')][2]"));
		action.clickAndHold(firstSlider).moveByOffset(24, 0).release().perform();
		action.clickAndHold(secondSlider).moveByOffset(63, 0).release().perform();
		System.out.println("Sliding operation successfully Executed");
		
		//scrollingTByAmount
		driver.findElement(By.id("comboBox")).click();
		WebElement item47 = driver.findElement(
			    By.xpath("//div[@class='option' and text()='Item 47']")
			);
		action.scrollToElement(item47);
		
		
		//Dell navigation
		String parent_Window=driver.getWindowHandle();
		WebElement dell=driver.findElement(By.id("dell"));
		action.click(dell).perform();
		System.out.println("Dell navigation Successfully executed");
		
		//navigate back from dell to home page
		driver.navigate().back();
		
		//Broken Links
		driver.findElement(By.linkText("Errorcode 408")).click();
		//navigate back from error page to home page
		driver.navigate().back();
		
		//
		driver.findElement(By.id("input3")).sendKeys("abcd");
		
		//Shadoe root
		SearchContext shadoow_Host = driver.findElement(By.id("shadow_host")).getShadowRoot();
		shadoow_Host.findElement(By.cssSelector("input[type='text']")).sendKeys("abcd");
		System.out.println("Shadow root successfully Successfully");
		
		//Footer Links
		driver.findElement(By.linkText("Download Files")).click();
		//navigate back from error page to home page
		driver.navigate().back();
		
		driver.quit();
		
	}

}
