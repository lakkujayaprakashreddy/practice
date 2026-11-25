package Basic_Selenium.Shadow_Root;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenShadowRoot {
	public static void main(String[] args) {
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("https://demoapps.qspiders.com/ui/shadow?sublist=0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		SearchContext aa = driver.findElement(By.xpath("//div[@class=\"my-3\"][1]")).getShadowRoot();
		aa.findElement(By.cssSelector("input[placeholder=\"Enter your username\"]")).click();
		aa.findElement(By.cssSelector("input[placeholder=\"Enter your username\"]")).clear();
		aa.findElement(By.cssSelector("input[placeholder=\"Enter your username\"]")).sendKeys("abc");
		
		SearchContext bb = driver.findElement(By.xpath("//div[@class=\"my-3\"][2]")).getShadowRoot();
		bb.findElement(By.cssSelector("input[placeholder=\"Enter your password\"]")).click();
		bb.findElement(By.cssSelector("input[placeholder=\"Enter your password\"]")).clear();
		bb.findElement(By.cssSelector("input[placeholder=\"Enter your password\"]")).sendKeys("def");
		
		
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		driver.quit();
		
	}
}
