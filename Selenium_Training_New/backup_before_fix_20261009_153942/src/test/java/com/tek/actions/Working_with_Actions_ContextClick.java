package com.tek.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Working_with_Actions_ContextClick {
	public static void main(String[] args) {
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		
		Actions action=new Actions(driver);
		WebElement rightClick=driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
		action.contextClick(rightClick).build().perform();
		WebElement paste=driver.findElement(By.xpath("//span[contains(text(),'Paste')]"));
		action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Paste')]"))).click().perform();
		
	}
}
