package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC1 {
	public WebDriver driver;
	@BeforeTest
	public void launchApplication() {
		//Launch application code
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		System.out.println("Execution of before test is completed");
	}
	@AfterTest
	public void closeApplication() {
		//close the application
		driver.quit();
		System.out.println("Execution of after test is completed");
	}
	@Test
	public void searchTestCase() {
		driver.findElement(By.id("small-searchterms")).sendKeys("mobiles");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println("Execution of search test case is completed");
	}
	@Test
	public void subscribeTestCase() {
		System.out.println("Executing subscribe test case");
		driver.findElement(By.id("small-searchterms")).sendKeys("mobiles");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println("Execution of search test case is completed");
	}
}
