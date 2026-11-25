package Contact;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

public class Create_Contact_With_Org_Test {
	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\jpred\\OneDrive\\Desktop\\TestScriptFiles\\vtigerConfigurationFile.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String BROWSER = pObj.getProperty("browser").trim();
		String URL = pObj.getProperty("url").trim();
		String USER_NAME = pObj.getProperty("username").trim();
		String PASSWORD = pObj.getProperty("password").trim();
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
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[@href=\"index.php?module=Accounts&action=index\"]")).click();
		
		
		 Random random=new Random(); 
		 int random_Num=random.nextInt(100000);
		 
		 FileInputStream orgFile = new FileInputStream(
					"C:\\Users\\jpred\\OneDrive\\Desktop\\TestScriptFiles\\testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(orgFile);
		Sheet sheet = wb.getSheet("Sheet2");
		driver.findElement(By.xpath("//a[@href=\"index.php?module=Accounts&action=EditView&return_action=DetailView&parenttab=Marketing\"]")).click();
		String name=sheet.getRow(7).getCell(2).toString()+random_Num;
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(name/* random_Num */);
		driver.findElement(By.xpath("//td[@class=\"detailedViewHeader\"]/parent::tr/preceding-sibling::tr/descendant::div/child::input[@title=\"Save [Alt+S]\"]")).click();
		String nameWithRandom=driver.findElement(By.xpath("//span[@id=\"dtlview_Organization Name\"]")).getText().trim();
		System.out.println("Organisation created with the Name: "+nameWithRandom);
		
		
		
		//contact
		driver.findElement(By.xpath("//a[@href=\"index.php?module=Contacts&action=index\"]")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys(sheet.getRow(7).getCell(5).toString()+random_Num);
		driver.findElement(By.xpath("//td[text()=\"Organization Name 			\"]/parent::tr//img[@src=\"themes/softed/images/select.gif\"]")).click();
		String parent_Window = driver.getWindowHandle();
		Set<String> windows_Available = driver.getWindowHandles();
		Iterator itr=windows_Available.iterator();
		while(itr.hasNext()) {
			driver.switchTo().window((String) itr.next());
			String actUrl=driver.getCurrentUrl();
			if(actUrl.contains("module=Accounts&action")) {
				break;
			}
		}
		driver.findElement(By.id("search_txt")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name=\"search\"]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'" + name + "')]")).click();
//		driver.findElement(By.xpath("//a[@href=\"javascript:;\"]/parent::td/parent::tr/following-sibling::tr//a[@href=\"javascript:window.close();\"]")).click();
		/*
		 * if(driver.findElement(By.xpath("//input[@name=\"lastname\"]")).getText()==
		 * nameWithRandom) { System.out.
		 * println("Look Up of Organization Name in Creating new contact is correctly passed"
		 * ); }else { System.err.
		 * println("Bad Look up passed for organization name in contact creation"); }
		 */
		
		driver.switchTo().window(parent_Window);
		driver.findElement(By.xpath("//b[text()='Contact Information']/parent::td/parent::tr/preceding-sibling::tr//input[@title=\"Save [Alt+S]\"]")).click();
		
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"))).moveToElement(driver.findElement(By.xpath("//a[@href=\"index.php?module=Users&action=Logout\"]")))
		.click().perform();
		
	}

}
