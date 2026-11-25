package com.tek.actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Workin_With_JavaScript_Executor {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementById('small-searchterms').value='mobiles'");
		WebElement button=driver.findElement(By.xpath("//input[@type='submit']"));
		js.executeScript("arguments[0].click();",button);
	}
}
