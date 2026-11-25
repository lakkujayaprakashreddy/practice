package com.tek.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Working_With_Frame_By_WebElement {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("file:///D:/Html%20Selenium/iframe.html");
		Thread.sleep(2000);
		//Switch to frame by Web Element
		driver.switchTo().frame(driver.findElement(By.id("FR1")));
		driver.findElement(By.id("newsletter-email")).sendKeys("lakkujp@gmail.com");
		driver.findElement(By.id("newsletter-subscribe-button")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Google")).click();
	}
}
