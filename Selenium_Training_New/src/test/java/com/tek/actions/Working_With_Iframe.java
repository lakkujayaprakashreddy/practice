package com.tek.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Working_With_Iframe {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("file:///D:/Html%20Selenium/iframe.html");
		Thread.sleep(2000);
		//Switch to frame by index
		driver.switchTo().frame(0);
		driver.findElement(By.id("small-searchterms")).sendKeys("mobiles");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		//Switch back to main page
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Google")).click();
	}

}
