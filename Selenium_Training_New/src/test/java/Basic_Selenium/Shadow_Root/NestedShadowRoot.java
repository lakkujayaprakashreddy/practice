package Basic_Selenium.Shadow_Root;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class NestedShadowRoot {
	public static void main(String[] args) throws InterruptedException {
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("https://demoapps.qspiders.com/ui/shadow/nested?sublist=2");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		SearchContext host = driver.findElement(By.xpath("//div[@class=\"shadowOuter\"]")).getShadowRoot();
		WebElement email = host.findElement(By.cssSelector("label[for=\"email\"]"));
		Actions action=new Actions(driver);
		action.sendKeys(email, Keys.TAB, "xyz",Keys.TAB, "xyz").perform();
		driver.findElement(By.xpath("//button[contains(.,\"Login\")]")).click();
		driver.quit();
	}
}
