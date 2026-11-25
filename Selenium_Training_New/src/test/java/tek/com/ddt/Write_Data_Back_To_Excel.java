package tek.com.ddt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Write_Data_Back_To_Excel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\jpred\\OneDrive\\Desktop\\TestScriptFiles\\testScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet2");
		Row row=sh.getRow(1);
		Cell cell= row.createCell(4);
		cell.setCellType(CellType.STRING);
		cell.setCellValue("PASS");
		FileOutputStream fos=new FileOutputStream("C:\\Users\\jpred\\OneDrive\\Desktop\\TestScriptFiles\\testScriptData.xlsx");
		wb.write(fos);
		wb.close();
		System.out.println("--- Executed ---");
	}
}
