package com.tek.actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Working_With_Fluent_Wait {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		
		WebElement search=driver.findElement(By.id("small-searchterms"));
		
		FluentWait wait=new FluentWait(driver);
		wait.withTimeout(Duration.ofSeconds(15));
		wait.pollingEvery(Duration.ofSeconds(1));
		
		wait.until(ExpectedConditions.elementToBeClickable(search));
		
		search.sendKeys("prakash");
		
		WebElement button=driver.findElement(By.xpath("//input[@type='submit']"));
		wait.until(ExpectedConditions.visibilityOf(button));
		
		button.click();
	}
}
