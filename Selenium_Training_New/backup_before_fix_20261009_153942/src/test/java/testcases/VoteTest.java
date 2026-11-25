package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class VoteTest {
	@Test
	public void voteTest() {
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Reporter.log("Application launch successfully:");
		driver.findElement(By.id("pollanswers-1")).click();
		driver.findElement(By.id("vote-poll-1")).click();
		Reporter.log("Vote test case completed");
		driver.quit();
	}
}
