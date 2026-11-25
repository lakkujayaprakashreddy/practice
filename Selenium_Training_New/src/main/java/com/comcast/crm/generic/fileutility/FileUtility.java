package com.comcast.crm.generic.fileutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class FileUtility {
	public String getDataFromPropertiesFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./configAppData/vtigerConfigurationFile.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		String data = pObj.getProperty(key).trim();
		return data;
	}
	
}

