package testng_features;


import org.testng.Reporter;
import org.testng.annotations.Test;

public class SampleTest {
	@Test
	public void demo() {  // Test case 1 
		System.out.println("Welcome to TestNG");
		// Test Steps
		
	}
	
	@Test
	public void RegisterTest() {  // Test case 2
		System.out.println("Executing register test case");
	}
	
	@Test
	public void LoginTest() {  // Test case 3
		System.out.println("Executing Login test case");
	}
	
	@Test
	public void SearchTest() {  // Test case 4
		System.out.println("Executing Search test case");
	}
}
