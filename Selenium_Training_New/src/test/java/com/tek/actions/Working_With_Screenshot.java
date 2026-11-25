package com.tek.actions;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;

public class Working_With_Screenshot {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Type cast to get the capabilities of take screenshot interface to the driver instance
		
		//Typecasting
		TakesScreenshot ts=(TakesScreenshot)driver;
		//Temporary Storage
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File("./ScreenShots/HomePage.png");
		
		FileHandler.copy(srcFile, destFile);
		
		System.out.println("Home page launched Sucessfully");
		driver.findElement(By.id("small-searchterms")).sendKeys("mobiles");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		//Screenshot after clicking on search
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./ScreenShots/SearchPage.png");
		FileHandler.copy(src, dest);
		driver.close();
	}

}
