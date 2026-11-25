import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class Example3 {
	@Test
	public void abs() {
		String browser=System.getProperty("browser");
		String url=System.getProperty("url");
		
		WebDriver driver = null;
		if ("edge".equalsIgnoreCase(browser)) {
		    driver = new EdgeDriver();
		} else if ("chrome".equalsIgnoreCase(browser)) {
		    driver = new ChromeDriver();
		} else if ("safari".equalsIgnoreCase(browser)) {
		    driver = new SafariDriver();
		} else {
		    throw new IllegalArgumentException(
		        "Unsupported browser: " + browser
		    );
		}
		driver.get(url);
		
	}
}
