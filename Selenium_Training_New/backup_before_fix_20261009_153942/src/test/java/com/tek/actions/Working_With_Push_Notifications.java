package com.tek.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Working_With_Push_Notifications {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		EdgeOptions option=new EdgeOptions();
		option.addArguments("--disable-notifications");
		
		WebDriver driver=new EdgeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.easemytrip.com/");
		Thread.sleep(5000);
		driver.quit();
	}

}
