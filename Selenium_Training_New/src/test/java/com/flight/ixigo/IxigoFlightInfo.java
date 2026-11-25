package com.flight.ixigo;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

import ListenerUtility.RetryListenerImplimentation;

public class IxigoFlightInfo {
	@Test(dataProvider = "getData" ,
			 retryAnalyzer = RetryListenerImplimentation.class
			)
	public  void xyz(String source,String sourceOption, String destOption) throws IOException, InterruptedException {
    	ExcelUtility eLib=new ExcelUtility();
    	JavaUtility jLib=new JavaUtility();
        FileInputStream fis = new FileInputStream(
                "./configAppData/ixigo.properties");
        

        Properties pObj = new Properties();
        pObj.load(fis);
        fis.close();

        String BROWSER = pObj.getProperty("browser");
        String URL = pObj.getProperty("url");

        WebDriver driver = null;

        if (BROWSER.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (BROWSER.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (BROWSER.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else {
            throw new IllegalArgumentException("Invalid browser");
        }

        driver.get(URL);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        
        driver.findElement(By.xpath("//p[@data-testid='originId']")).click();
        driver.findElement(By.xpath("//label[text()='From']/following-sibling::input")).sendKeys(source);
        driver.findElement(By.xpath("//p[text()='"+sourceOption+"']")).click();
        
        Thread.sleep(3000);
        driver.findElement(By.xpath("//label[text()='To']/following-sibling::input")).click();
        driver.findElement(By.xpath("(//p[text()='"+destOption+"'])[2]")).click();
       
        LocalDate date = LocalDate.now().plusDays(5);

        String day = date.format(
            DateTimeFormatter.ofPattern("MMMM d, yyyy")
        );

        System.out.println("Expected date: " + day);

        By dateLocator = By.xpath(
            "//div[contains(@class,'react-calendar__viewContainer')]" +
            "//abbr[@aria-label='" + day + "']/parent::button"
        );

        WebElement dateElement = wait.until(
            ExpectedConditions.elementToBeClickable(dateLocator)
        );

        dateElement.click();
		driver.findElement(By.xpath("//button[text()='Search']")).click();
	
        
			Thread.sleep(5000);

			 // Store all flight details
			 List<String[]> flightData = new ArrayList<>();

	            // Locate all price elements
	            List<WebElement> prices = driver.findElements(
	                By.xpath("//h6[@data-testid='pricing']")
	            );

	            System.out.println("Total prices found: " + prices.size());

	            for (WebElement priceElement : prices) {

	                String priceText = priceElement.getText();

	                // Convert price into numeric value
	                String amount = priceText.replaceAll("[^0-9]", "");

	                if (amount.isEmpty()) {
	                    continue;
	                }

	                int price = Integer.parseInt(amount);

	                System.out.println("Checking price: " + price);

	                // Check price greater than 12000
	                if (price > 5000) {

	                    // Navigate to individual flight card
	                    WebElement flightCard = priceElement.findElement(
	                        By.xpath("./ancestor::div[contains(@class,'shadow-card')][1]")
	                    );

	                    // Get airline name and flight number
	                    String airlineDetails = flightCard.findElement(
	                        By.xpath(".//div[contains(@class,'airlineInfo')]")
	                    ).getText();

	                    String[] details = airlineDetails.split("\\R");

	                    String flightName = details[0].trim();

	                    String airlineNumber = details.length > 1
	                        ? details[1].trim()
	                        : "Not Available";

	                    System.out.println("--------------------------");
	                    System.out.println("Flight Name: " + flightName);
	                    System.out.println("Airline Number: " + airlineNumber);
	                    System.out.println("Flight Price: " + priceText);

	                    // Add flight details to ArrayList
	                    flightData.add(new String[] {
	                        flightName,
	                        airlineNumber,
	                        priceText
	                    });
	                }
	            }

	            System.out.println("--------------------------");
	            System.out.println("Qualifying flights: " + flightData.size());

	            // Write all records into Excel once
	            if (!flightData.isEmpty()) {

	                ExcelUtility eUtil = new ExcelUtility();

	                eUtil.writeFlightData("FlightDetails"+jLib.getRandomNumber(), flightData);

	                System.out.println("Flight details inserted into Excel successfully.");

	            } else {

	                System.out.println("No flights found above 12000.");
	                System.out.println("Excel was not updated because no matching flights were found.");
	            }
	        driver.quit();
        	
    }
	@DataProvider
	public Object[][] getData()
	{
	    Object[][] data = {
	        {"Ch", "Chennai International Airport", "Delhi Indira Gandhi International Airport"},
	        {"delhi", "Delhi Indira Gandhi International Airport", "Chennai International Airport"}
	        
	    };

	    return data;
	}

}

