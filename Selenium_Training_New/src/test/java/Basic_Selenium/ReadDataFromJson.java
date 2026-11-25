package Basic_Selenium;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.comcast.crm.generic.fileutility.JsonUtility;

public class ReadDataFromJson {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		JsonUtility jLib=new JsonUtility();
		System.out.println(jLib.getDataFromJsonFile("url"));
	}
}
