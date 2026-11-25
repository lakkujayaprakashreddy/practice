package com.tek.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Working_With_Closed_Shadow_root_Elements {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui/shadow?sublist=1");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//h1[text()='Login']")).click();
		
		Actions action=new Actions(driver);
		action.sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);
		action.sendKeys("prakash").perform();
		action.sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);
		action.sendKeys("prakash").perform();
	}
}
