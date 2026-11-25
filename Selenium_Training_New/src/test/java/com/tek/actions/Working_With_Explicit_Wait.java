package com.tek.actions;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Working_With_Explicit_Wait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		
		WebElement search=driver.findElement(By.id("small-searchterms"));
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(search));
		
		search.sendKeys("prakash");
		
		WebElement button=driver.findElement(By.xpath("//input[@type='submit']"));
		wait.until(ExpectedConditions.visibilityOf(button));
		
		button.click();
	}

}
