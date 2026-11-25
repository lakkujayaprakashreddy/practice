package com.tek.actions;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Working_With_Multiple_Windows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new EdgeDriver();
		Actions action=new Actions(driver);
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(3000);
		String parentWindow=driver.getWindowHandle();
		driver.findElement(By.linkText("Facebook")).click();
		Thread.sleep(3000);
		Set<String> childWindows=driver.getWindowHandles();					//WebElement email=
		//System.out.println(childWindows);
		for(String window:childWindows) {
			driver.switchTo().window(window);
			System.out.println(driver.getTitle());
			if(driver.getTitle().toLowerCase().contains("facebook")) {
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("lakkujayaprakash");
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		Thread.sleep(2000);
		driver.findElement(By.id("small-searchterms")).sendKeys("mobiles");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		driver.quit();
	}

}
