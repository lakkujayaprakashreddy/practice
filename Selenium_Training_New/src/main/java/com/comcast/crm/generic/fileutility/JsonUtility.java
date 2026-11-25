package com.comcast.crm.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mysql.cj.xdevapi.JsonParser;

public class JsonUtility {
	public String getDataFromJsonFile(String key)
            throws FileNotFoundException, IOException, ParseException {

        FileReader reader = new FileReader(
                "./configAppData/appCommonData.json");

        JSONParser parser = new JSONParser();

        Object obj = parser.parse(reader);

        JSONObject map = (JSONObject) obj;

        String data = (String) map.get(key);

        reader.close();

        return data;
    }
}
//Selenium_Training_New/configAppData/appCommonData.json