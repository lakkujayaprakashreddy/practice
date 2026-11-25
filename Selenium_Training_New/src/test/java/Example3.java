
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Example3 {

    WebDriver driver = null;

    @Test
    public void abs() {

        String browser = System.getProperty("browser");
        String url = System.getProperty("url");

        if (browser == null || url == null) {
            throw new IllegalArgumentException(
                "Please provide browser and url properties"
            );
        }

        try {

            if ("edge".equalsIgnoreCase(browser)) {

                EdgeOptions options = new EdgeOptions();

                options.addArguments("--headless=new");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--disable-extensions");

                driver = new EdgeDriver(options);

            } else if ("chrome".equalsIgnoreCase(browser)) {

                driver = new ChromeDriver();

            } else if ("firefox".equalsIgnoreCase(browser)) {

                driver = new FirefoxDriver();

            } else {

                throw new IllegalArgumentException(
                    "Unsupported browser: " + browser
                );
            }

            driver.manage().window().maximize();
            driver.get(url);

            System.out.println("Browser: " + browser);
            System.out.println("Title: " + driver.getTitle());
            System.out.println("URL: " + driver.getCurrentUrl());

        } finally {

            if (driver != null) {
                driver.quit();
            }
        }
    }
}
