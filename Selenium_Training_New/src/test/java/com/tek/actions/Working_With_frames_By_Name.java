package com.tek.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Working_With_frames_By_Name {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("file:///D:/Html%20Selenium/iframe.html");
		Thread.sleep(2000);
		//Switch to frame by name
		driver.switchTo().frame("frame1");
		driver.findElement(By.linkText("Register")).click();
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		driver.findElement(By.linkText("Google")).click();
	}
}
