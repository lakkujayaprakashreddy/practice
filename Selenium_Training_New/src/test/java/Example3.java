import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class Example3 {
	@Test
	public void abs() {
		String BROWSER=System.getProperty("browser");
		String url=System.getProperty("www.myntra.com");
		
		WebDriver driver = null;
		if ("edge".equalsIgnoreCase(BROWSER)) {
		    driver = new EdgeDriver();
		} else if ("chrome".equalsIgnoreCase(BROWSER)) {
		    driver = new ChromeDriver();
		} else if ("safari".equalsIgnoreCase(BROWSER)) {
		    driver = new SafariDriver();
		} else {
		    throw new IllegalArgumentException(
		        "Unsupported browser: " + BROWSER
		    );
		}
		driver.get(url);
		
	}
}
