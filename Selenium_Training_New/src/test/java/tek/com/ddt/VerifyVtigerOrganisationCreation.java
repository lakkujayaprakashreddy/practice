package tek.com.ddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

public class VerifyVtigerOrganisationCreation {
	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\jpred\\OneDrive\\Desktop\\TestScriptFiles\\vtigerConfigurationFile.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USER_NAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		WebDriver driver = null;
		if (BROWSER == "edge") {
			driver = new EdgeDriver();
		} else if (BROWSER == "chrome") {
			driver = new ChromeDriver();
		} else if (BROWSER == "safari") {
			driver = new SafariDriver();
		} else {
			driver = new EdgeDriver();
		}
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(USER_NAME);
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(USER_NAME);
		Thread.sleep(5000);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[@href=\"index.php?module=Accounts&action=index\"]")).click();
		
		/*
		 * Random random=new Random(); int random_Num=random.nextInt(1000);
		 */
		FileInputStream orgFile = new FileInputStream(
				"C:\\Users\\jpred\\OneDrive\\Desktop\\TestScriptFiles\\testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(orgFile);
		Sheet sheet = wb.getSheet("Sheet4");
		int total_Rows = sheet.getLastRowNum();
		for (int i = 1; i <= total_Rows; i++) {
			driver.findElement(By.xpath(
					"//a[@href=\"index.php?module=Accounts&action=EditView&return_action=DetailView&parenttab=Marketing\"]"))
					.click();
			String name=sheet.getRow(i).getCell(0).toString();
			driver.findElement(By.xpath("//input[@name=\"accountname\"]"))
					.sendKeys(name/* random_Num */);
			driver.findElement(By.xpath(
					"//td[@class=\"detailedViewHeader\"]/parent::tr/preceding-sibling::tr/descendant::div/child::input[@title=\"Save [Alt+S]\"]"))
					.click();
			if(driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText().toLowerCase().contains(name.toLowerCase())) {
					  System.out.println(name+" Organization created successfully");
					  }else {
					  System.out.println(name+" Organization not created");
				}
			driver.navigate().refresh();
		}

		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"))).moveToElement(driver.findElement(By.xpath("//a[@href=\"index.php?module=Users&action=Logout\"]")))
		.click().perform();
		  


		Thread.sleep(5000);
		driver.quit();
	}
}
