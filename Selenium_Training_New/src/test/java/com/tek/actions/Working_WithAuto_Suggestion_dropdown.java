package com.tek.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Working_WithAuto_Suggestion_dropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		//driver.get("https://demowebshop.tricentis.com/");
		driver.get("https://www.flipkart.com/");
		
		Actions action=new Actions(driver);
		
//		driver.findElement(By.id("small-searchterms")).sendKeys("compu");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[contains(text(),'Build your own computer')]"));
		driver.findElement(By.name("q")).sendKeys("puma");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[contains(text(),'puma')])[2]")).click();
		
	}

}
