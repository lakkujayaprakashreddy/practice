package tek.com.ddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Data_Driven_Intehration_With_Selenium_Code {
	public static void main(String[] args) throws IOException, InterruptedException {
		String first_Name;
		String second_Name;
		FileInputStream fis = new FileInputStream(
			    "C:\\Users\\jpred\\OneDrive\\Desktop\\lms.properties"
			);
		Properties pObj=new Properties();
		pObj.load(fis);
		String BROWSER=pObj.getProperty("browser");
		String URL=pObj.getProperty("url");
		String USERNAME=pObj.getProperty("username");
		String PASSWORD=pObj.getProperty("password");
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		
		WebDriver driver=null;
		if(BROWSER=="chrome") {
			driver=new ChromeDriver();
		}else if(BROWSER=="edge") {
			driver=new EdgeDriver();
		}else if(BROWSER=="safari") {
			driver=new SafariDriver();
		}else {
			driver=new EdgeDriver();
		}
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()=\"Login\"]")).click();
		driver.findElement(By.xpath("//a[@class=\"nav-item nav-borrowers\"]")).click();
		//WebElement borrower= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class=\"nav-item nav-borrowers\"]")));
		//borrower.click();
				WebElement new_Borrower =null;
				
//		new_Borrower.click();

FileInputStream test_Script_Data = new FileInputStream(
    "C:/Users/jpred/OneDrive/Desktop/testScriptData.xlsx"
);

		Workbook work_Book = WorkbookFactory.create(test_Script_Data);
		Sheet sheet = work_Book.getSheet("Sheet3");
		int max_Rows=sheet.getLastRowNum();
		for(int i=1;i<=max_Rows;i++) {
			//wait.until(
				  //  ExpectedConditions.elementToBeClickable(
				        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block col-md-2 float-right']")).click();
				    //)
				//).click();	
			first_Name=sheet.getRow(i).getCell(0).toString();
			second_Name=sheet.getRow(i).getCell(1).toString();
			//WebElement firstName=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name=\"firstname\"]")));
			//firstName.sendKeys(first_Name);
			//WebElement secondName=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name=\"lastname\"]")));
			//secondName.sendKeys(second_Name);
          driver.findElement(By.xpath("//input[@name=\"firstname\"]")).sendKeys(first_Name);
			driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys(second_Name);
			driver.findElement(By.xpath("//button[text()=\"Save\"]")).click();
			driver.navigate().refresh();
			//Thread.sleep(5000);
		}
	}
}
