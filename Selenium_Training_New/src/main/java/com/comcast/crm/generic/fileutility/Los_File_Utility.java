package com.comcast.crm.generic.fileutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class Los_File_Utility {
	JavaUtility fLib=new JavaUtility();
	public String getDataFromPropertiesFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./configAppData/los_configuration.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		String data = pObj.getProperty(key).trim();
		return data;
	}
	public void getScreenShot(WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./ScreenShots/"+fLib.getRandomNumber()+".png");
		org.openqa.selenium.io.FileHandler.copy(src, dest);
		
	}
}
