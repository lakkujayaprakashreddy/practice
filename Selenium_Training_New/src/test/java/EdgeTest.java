import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeTest {

    public static void main(String[] args) {

        EdgeOptions options = new EdgeOptions();

        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        WebDriver driver = new EdgeDriver(options);

        try {
            driver.get("https://www.google.com");

            System.out.println("Title: " + driver.getTitle());

        } finally {
            driver.quit();
        }
    }
}