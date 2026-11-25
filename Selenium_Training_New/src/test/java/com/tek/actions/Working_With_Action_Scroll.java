package com.tek.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Working_With_Action_Scroll {
	public static void main(String[] args) {
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		
		Actions action=new Actions(driver);
		//action.scrollByAmount(0, 600).build().perform();
		WebElement myAccount=driver.findElement(By.linkText("My account"));
		action.scrollToElement(myAccount).perform();
	}
}
