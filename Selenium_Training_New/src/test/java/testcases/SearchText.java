package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SearchText {
	@Test
	public void SearchTestCase() {
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Reporter.log("Application launch successfully");
		driver.findElement(By.id("small-searchterms")).sendKeys("computers");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Reporter.log("Search test case completed");
		driver.close();
	}
}
