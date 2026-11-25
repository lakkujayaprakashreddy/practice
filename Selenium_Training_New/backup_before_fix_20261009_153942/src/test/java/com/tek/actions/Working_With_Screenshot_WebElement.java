package com.tek.actions;

import java.io.File;
import java.time.Duration;
import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Working_With_Screenshot_WebElement {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		WebElement searchtxt=driver.findElement(By.id("small-searchterms"));
		searchtxt.sendKeys("mobiles");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=searchtxt.getScreenshotAs(OutputType.FILE);
		File dest=new File("./ScreenShots/searchField.png");
		org.openqa.selenium.io.FileHandler.copy(source, dest);
		System.out.println("ScreenShot on the web element searchtxt was successful");
		WebElement button=driver.findElement(By.xpath("//input[@type='submit']"));
		
		File src=button.getScreenshotAs(OutputType.FILE);
		File destination=new File("./ScreenShots/searchButton.png");
		org.openqa.selenium.io.FileHandler.copy(src, destination);
		
		System.out.println("ScreenShot on the web element button was successful");
		driver.close();
	}
}
