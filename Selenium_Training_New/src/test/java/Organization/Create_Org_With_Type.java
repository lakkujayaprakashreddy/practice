package Organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.math3.geometry.spherical.twod.Edge;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

public class Create_Org_With_Type {
	static WebDriver d;
	public static void main(String[] args) throws IOException {
		FileInputStream fobj=new FileInputStream("C:\\Users\\jpred\\OneDrive\\Desktop\\TestScriptFiles\\vtigerConfigurationFile.properties");
		Properties pobj=new Properties();
		pobj.load(fobj);		
		String browse=pobj.getProperty("Browser");
		String url=pobj.getProperty("url");
		String un=pobj.getProperty("username");
		String pwd=pobj.getProperty("password");
		String x="chrome";
		System.out.println(browse);
		
		
		FileInputStream xobj=new FileInputStream("C:\\Users\\jpred\\OneDrive\\Desktop\\TestScriptFiles\\testScriptData.xlsx");
		Workbook wb= WorkbookFactory.create(xobj);
		Sheet sht=wb.getSheet("Sheet5");
		String org_name = sht.getRow(1).getCell(1).toString();
		String ind_name=sht.getRow(1).getCell(2).toString();
		String typ_name=sht.getRow(1).getCell(3).toString();
		String phn_no=sht.getRow(1).getCell(4).toString();


		Random ran = new Random();
	    int ran_num = ran.nextInt(100);
		
		 
	    if (browse == "edge") {
			d = new EdgeDriver();
		} else if (browse == "chrome") {
			d = new ChromeDriver();
		} else if (browse == "safari") {
			d = new SafariDriver();
		} else {
			d = new EdgeDriver();
		}
		
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Actions  act=new Actions(d);
		
		if(d!=null)
		{
			d.get(url);
		}
		
		d.findElement(By.name("user_name")).sendKeys(un);
		d.findElement(By.name("user_password")).sendKeys(pwd);
		d.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
		d.findElement(By.xpath("//a[@href=\"index.php?module=Accounts&action=index\"]")).click();
		d.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		d.findElement(By.xpath("//td[@class=\"dvtCellLabel\"]/ancestor::table[@class=\"small\"]/descendant::input[@name=\"accountname\"]")).sendKeys(org_name+ran_num);
//		d.findElement(By.xpath("//td[@class=\"detailedViewHeader\"]/parent::tr/preceding-sibling::tr//input[@title=\"Save [Alt+S]\"]")).click();
		WebElement el1=d.findElement(By.name("industry"));
		
		Select sel1 = new Select(el1);
		sel1.selectByVisibleText(ind_name);
		
		WebElement el2=d.findElement(By.name("accounttype"));
		Select sel2 = new Select(el2);
		sel2.selectByVisibleText(typ_name);
		
		d.findElement(By.xpath("//td[@class=\"detailedViewHeader\"]/parent::tr/preceding-sibling::tr//input[@title=\"Save [Alt+S]\"]")).click();
		
		String aft_ind=d.findElement(By.id("dtlview_Industry")).getText();
		String aft_typ=d.findElement(By.id("dtlview_Type")).getText();
		
		if(ind_name.equals(aft_ind))
		{
			System.out.println(ind_name+" industry is matching");
		}
		if(typ_name.equals(aft_typ))
		{
		System.out.println(typ_name+" typre is matching");
		}
	
	}
}
