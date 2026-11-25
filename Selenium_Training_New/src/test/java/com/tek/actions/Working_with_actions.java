package com.tek.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Working_with_actions {
	public static void main(String[] args) {
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		//create an object of Actions class
		Actions action=new Actions(driver);
		
		WebElement computers=driver.findElement(By.xpath("(//a[contains(text(),'Computers')])[1]"));
		
		//move to elements
		action.moveToElement(computers).build().perform();
		
		WebElement desktops=driver.findElement(By.xpath("(//a[contains(text(),'Desktops')])[1]"));
		
		action.moveToElement(desktops).click().build().perform();
				
	}
}
