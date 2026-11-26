
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Example3 {

    @Test
    public void abs() {

        String browser = System.getProperty("browser", "edge");
        String url = System.getProperty("url", "https://www.google.com");

        WebDriver driver = null;

        try {
            if ("edge".equalsIgnoreCase(browser)) {

                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless=new");
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-extensions");
                options.addArguments("--no-first-run");
                options.addArguments("--no-default-browser-check");

                driver = new EdgeDriver(options);

            } else {
                throw new IllegalArgumentException(
                    "Currently supported browser: edge"
                );
            }

            driver.get(url);

            System.out.println("Page title: " + driver.getTitle());
            System.out.println("Current URL: " + driver.getCurrentUrl());

        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
