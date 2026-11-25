package com.tek.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Working_With_Actions_KeyBoard_Actions {
	public static void main(String[] args) {
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		
		Actions action=new Actions(driver);
		
		WebElement searchTexElement=driver.findElement(By.id("small-searchterms"));
		
		//action.moveToElement(searchTexElement).click().sendKeys("mobiles").perform();
		
		//key up and down
		action.moveToElement(searchTexElement).click().keyDown(Keys.SHIFT).sendKeys("mobiles").keyUp(Keys.SHIFT).build().perform();
	}
}
