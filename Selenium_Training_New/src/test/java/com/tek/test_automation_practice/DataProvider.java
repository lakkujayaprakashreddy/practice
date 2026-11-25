package com.tek.test_automation_practice;

import org.testng.annotations.Test; // ✅
public class DataProvider {
	@org.testng.annotations.DataProvider
	public Object[][] getData(){
		Object[][] object=new Object[2][2];
		object[0][0]="xgjg";
		object[0][1]="kjgn";
		object[1][0]="fgfn";
		object[1][1]="vnmb";
		return object;
	}
	@Test(dataProvider="getData")
	public void create(String name,String name1) {
		System.out.println(name+"----"+name1);
	}
	
}
