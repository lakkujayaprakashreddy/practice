package testng_features;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Working_With_Configuration_Annotation {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Executing before suit");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("Executing after suit");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("Executing Before Test");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("Executing After Test");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("Executing before Class");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("Executing after class");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Executing before Method");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("Executing after Method");
	}
	@Test
	public void TC1(){
		System.out.println("Executing TC1");
	}
	@Test
	public void TC2(){
		System.out.println("Executing TC2");
	}
}
