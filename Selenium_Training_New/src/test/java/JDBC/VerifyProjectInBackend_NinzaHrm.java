package JDBC;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.mysql.cj.jdbc.Driver;

public class VerifyProjectInBackend_NinzaHrm {
	public static void main(String[] args) throws SQLException, InterruptedException {
		JavaUtility jLib=new JavaUtility();
		String projectId="NH_PROJ_"+jLib.getRandomNumber();
		String projectName = "sefsf";
        String createdBy = jLib.getrandomString(4);
        String status = "Created";
        int teamSize = 5;
		Driver jdbcDriver=new Driver();
		DriverManager.registerDriver(jdbcDriver);
		Connection con;
		java.sql.Statement stmt;
		PreparedStatement pstmt;
		String query = "INSERT INTO project VALUES (?, ?, ?, ?, ?, ?)";
		try {
			con = DriverManager.getConnection("jdbc:mysql://49.249.29.4:3307/ninza_hrm","root@%","root");
			stmt = con.createStatement();
			pstmt = con.prepareStatement(query);

	            System.out.println("Database connected successfully!");

	            pstmt.setString(1, projectId);
	            pstmt.setString(2, projectName);
	            pstmt.setString(3, "2026-11-17");
	            pstmt.setString(4, createdBy);
	            pstmt.setString(5, status);
	            pstmt.setInt(6, teamSize);

	            // Execute INSERT query
	            int result = pstmt.executeUpdate();
	            if (result > 0) {
	                System.out.println("Project inserted successfully!");
	                System.out.println("Project ID: " + projectId);
	                System.out.println("Created By: " + createdBy);
	            } else {
	                System.out.println("Project insertion failed!");
	            }

		}catch (Exception e) {
			// TODO: handle exception
			 System.out.println("Database operation failed!");
	            e.printStackTrace();
		}
		
		
		
		
		
		Thread.sleep(10000);
		
		
		
		
		WebDriver driver=new FirefoxDriver();
		driver.get("http://49.249.29.4:8091/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("rmgyantra");
		driver.findElement(By.xpath("//input[@id=\"inputPassword\"]")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[contains(.,\"Sign in\")]")).click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[contains(.,\"Projects\")]"))));
		driver.findElement(By.xpath("//a[contains(.,\"Projects\")]")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"Search by Project Id\"]")).sendKeys(projectId);
	}
}
