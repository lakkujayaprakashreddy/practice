package com.tek.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Working_With_Shadow_Root_Elements {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui/shadow?sublist=0");
		driver.findElement(By.xpath("//section[contains(text(),'Shadow Root Elements')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//section[contains(text(),'Shadow Root')])[2]")).click();
		
		SearchContext shadow_host=driver.findElement(By.xpath("//form/div[1]")).getShadowRoot();
		shadow_host.findElement(By.cssSelector("input[type='text']")).sendKeys("prakash");
		
		SearchContext shadow_host_password=driver.findElement(By.xpath("//form/div[2]")).getShadowRoot();
		shadow_host_password.findElement(By.cssSelector("input[type='text']")).sendKeys("prakash");
	}
}
