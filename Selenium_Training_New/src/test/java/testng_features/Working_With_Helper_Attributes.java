package testng_features;

import org.testng.annotations.Test;

public class Working_With_Helper_Attributes {
	@Test(dependsOnMethods = "RegisterTest")
	public void LoginTest() {
		System.out.println("Executing logging test");
	}
	
	@Test
	public void SearchTest() {
		System.out.println("Executing search test");
	}
	
	@Test
	public void RegisterTest() {
		System.out.println("Executing Register test");
	}
	
	@Test(dependsOnMethods = "SearchTest")
	
	public void SubscribeTest() {
		System.out.println("Executing subscribe test");
	}
	
	
}
