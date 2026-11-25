package testng_features;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class InvocationCountExample {
	@Test(invocationCount = 3,threadPoolSize = 3)
	public void TC1(){
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Reporter.log("Application launch successfully");
		driver.findElement(By.id("small-searchterms")).sendKeys("computers");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
}
