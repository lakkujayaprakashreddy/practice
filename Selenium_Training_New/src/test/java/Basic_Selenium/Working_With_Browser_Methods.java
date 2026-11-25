package Basic_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Working_With_Browser_Methods {

    public static void main(String[] args) throws InterruptedException {

        // Launch Edge Browser
        WebDriver driver = new EdgeDriver();

        // Navigate to Google
        driver.get("https://www.google.co.in");

        // Get and print title
        String title = driver.getTitle();
        System.out.println("Title: " + title);

        // Get and print current URL
        String currentURL = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentURL);

        // Get page source
        String pageSource = driver.getPageSource();
        System.out.println("Page Source Length: " + pageSource.length());

        // Navigate to Google.com
        driver.get("https://www.google.com");

        System.out.println("Title: " + driver.getTitle());

        // Navigate to Myntra
        driver.navigate().to("https://www.myntra.com/");

        Thread.sleep(2000);

        // Go back
        driver.navigate().back();
        Thread.sleep(2000);

        // Go forward
        driver.navigate().forward();
        Thread.sleep(2000);

        // Refresh page
        driver.navigate().refresh();
        Thread.sleep(2000);

        // Maximize browser window
        driver.manage().window().maximize();

        Thread.sleep(2000);

        // Close the entire browser session
        driver.quit();
    }
}