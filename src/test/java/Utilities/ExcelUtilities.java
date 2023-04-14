package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities
{
	
   public static HashMap<String, String> getMapData() throws IOException
   {
	   HashMap<String, String> hm =new HashMap<>();
	   try 
	   {
		  FileInputStream file =new FileInputStream("C:\\Users\\vasudev\\eclipse-workspace\\TDeals\\src\\test\\resources\\TestData\\TestDataUsers.xlsx");
		  Workbook workbook = new XSSFWorkbook(file);
		  Sheet sheet =workbook.getSheet("Sheet1");
		  int lastRowNumber =sheet.getLastRowNum();
		  for(int i=0;i<lastRowNumber;i++)
		  {
			  Row row = sheet.getRow(i);
			  Cell keycell =row.getCell(0);
			  String key =keycell.getStringCellValue().trim();
			  Cell keyvalue =row.getCell(1);
			  String value =keyvalue.getStringCellValue().trim();
			  hm.put(key, value);
			  
		  }
	   } 
	   catch (FileNotFoundException e) 
	   {
		 e.printStackTrace();
	   }
	   return hm;
   }
}
