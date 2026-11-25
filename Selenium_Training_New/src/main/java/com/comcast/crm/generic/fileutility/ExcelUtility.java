
package com.comcast.crm.generic.fileutility;

import java.io.FileReader;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ExcelUtility {
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testData/testScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String data=wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testData/testScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int rowCount=wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
	}
	public void setDataIntoExcel(String sheetName,int rowNum,int cellNum, String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testData/testScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum);
		
		FileOutputStream fos=new FileOutputStream("./testData/testScriptData.xlsx");
		wb.write(fos);
		wb.close();
	}
	/*
	 * public int getLastRow(String sheetName) throws IOException { FileInputStream
	 * fis=new FileInputStream("./testData/testScriptData.xlsx"); int
	 * rows=WorkbookFactory.create(fis).getSheet(sheetName).getLastRowNum();
	 * fis.close(); return rows; }
	 */
	

public void writeFlightData(String sheetName, List<String[]> flightData)
        throws EncryptedDocumentException, IOException {

    String path = "./testData/testScriptData.xlsx";

    FileInputStream fis = new FileInputStream(path);
    Workbook wb = WorkbookFactory.create(fis);
    fis.close();

    try {

        Sheet sheet = wb.getSheet(sheetName);

        if (sheet == null) {
            sheet = wb.createSheet(sheetName);
        }

        // Create header
        Row header = sheet.getRow(0);

        if (header == null) {
            header = sheet.createRow(0);
        }

        header.createCell(0).setCellValue("Flight Name");
        header.createCell(1).setCellValue("Airline Number");
        header.createCell(2).setCellValue("Price");

        // Insert all flight details
        int rowNum = 1;

        for (String[] details : flightData) {

            Row row = sheet.getRow(rowNum);

            if (row == null) {
                row = sheet.createRow(rowNum);
            }

            row.createCell(0).setCellValue(details[0]);
            row.createCell(1).setCellValue(details[1]);
            row.createCell(2).setCellValue(details[2]);

            rowNum++;
        }

        // Save Excel only once
        FileOutputStream fos = new FileOutputStream(path);

        try {
            wb.write(fos);
        } finally {
            fos.close();
        }

    } finally {
        wb.close();
    }
}
}
