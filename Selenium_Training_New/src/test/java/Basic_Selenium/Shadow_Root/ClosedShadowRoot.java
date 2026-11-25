package Basic_Selenium.Shadow_Root;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ClosedShadowRoot {
	public static void main(String[] args) {
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("https://demoapps.qspiders.com/ui/shadow/closed?sublist=1");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		Actions action=new Actions(driver);
		action.sendKeys(driver.findElement(By.xpath("//h1[contains(.,\"Login\")]")), Keys.TAB, "xyz", Keys.TAB, "xyz" ).perform();
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		driver.quit();
	}
}
