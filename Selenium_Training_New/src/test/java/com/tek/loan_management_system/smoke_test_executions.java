package com.tek.loan_management_system;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class smoke_test_executions {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://49.249.29.4:8081/TestServer/Build/Loan_Management_System/login.php");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(15));
		
		
		//1::::::To verify the Loan Management System application launches and the page loads without errors
		
		//select the username field and enter the username as admin
		driver.findElement(By.id("username")).sendKeys("admin");
		//select the password field and enter the password as admin
		driver.findElement(By.id("password")).sendKeys("admin123");
		//click on Login button on the Login page
		driver.findElement(By.xpath("//button[@class='btn-sm btn-block btn-wave col-md-4 btn-primary']")).click();
		System.out.println("Logged in successfully");
		
		
		
		//2::::::To verify the Dashboard (Home) page displays the welcome message after launch
		
		
		String welcomeMessage =driver.findElement(By.xpath("//div[contains(@class,'card-body')]")).getText();
		if(welcomeMessage.equals("Welcome back Administrator!")) {
			System.out.println("displays the welcome message after launch successfully");
		}else {
			System.err.println(" Not ...displays the welcome message after launch successfully");
		}
		
		
		
		//3::::::To verify the four Dashboard summary cards are displayed

	    // 3: Verify the four Dashboard summary cards

	    String[] expectedLabels = {
	        "Payments Today",
	        "Borrowers",
	        "Active Loans",
	        "Total Receivable"
	    };

	    for (int i = 1; i <= expectedLabels.length; i++) {

	        By cardLocator = By.xpath(
	            "(//div[contains(@class,'text-white-75 small')])[" + i + "]"
	        );

	        String actualLabel = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(cardLocator)
	        ).getText().trim();

	        Assert.assertEquals(
	            actualLabel,
	            expectedLabels[i - 1],
	            "Dashboard summary card label mismatch at position " + i
	        );

	        System.out.println("PASS: " + actualLabel);
	    }
	    
	    driver.quit();

	}
}
