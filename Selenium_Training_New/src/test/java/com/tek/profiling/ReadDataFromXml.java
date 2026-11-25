package com.tek.profiling;

import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;


public class ReadDataFromXml {
	@org.testng.annotations.Parameters({"un","pwd"})
	@Test
	public void m1(@Optional("admin")String un,@Optional("admin")String pwd) {
		System.out.println("un:"+un);
		System.out.println("pwd:"+pwd);
	}
	@Test
	public void m2(XmlTest test) {
		System.out.println("unn:"+test.getParameter("un"));
		System.out.println("unn:"+test.getParameter("pwd"));
	}
}
