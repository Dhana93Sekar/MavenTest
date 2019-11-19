package com.vTiger.genericLib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import org.apache.poi.ss.usermodel.*;


	 /**
	 *
	 *it is used to read the data form Excel Workbook,DataBase & Properties file from dataFiles folder
	 *
	 *@author Dhanashekhar
	 *
	 */

public class FileLibrary {
		 /**
		 *
		 *it is used to read data from commonData.properties file based on Key
		 *@param key
		 *@return
		 *@throws Throwable
		 */
		 public String getPropertyKeyValue(String key) throws Throwable
		 { 
			 FileInputStream fis = new FileInputStream("D:\\Maven\\MavenPractise\\MavenProject\\src\\test\\resources\\commonData.properties");
			 Properties pObj = new Properties();
			 pObj.load(fis);
			 String value = pObj.getProperty(key);
			 return value;
		 } 
		 /**
		 *
		 *It is used to read data from TS_Create_Organizations.xlsx based on arguments
		 *@param sheetName
		 *@param rowNum
		 *@param cellNum
		 *@return String data
		 *@throws Throwable
		 *
		 */
		 public String getExcelData(String sheetName, int rowNum, int cellNum) throws Throwable
		 {
				FileInputStream fis = new FileInputStream("./resources/TS_Create_Organizations.xlsx");
				Workbook wb = WorkbookFactory.create(fis);
				Sheet sh = wb.getSheet(sheetName);
				Row row = sh.getRow(rowNum);
				String data = row.getCell(cellNum).getStringCellValue();
				wb.close();
				return data;
		 }
		 /**
		 *its used to write data back to TS_Create_Organizations.xlsx file based on user arguments
		 *@param sheetName, rowNum, celNum
		 *@param data
		 * @throws Throwable
		 */
		 public void setExcelData(String sheetName, int rowNum, int celNum, String data) throws Throwable
		 {
			FileInputStream fis = new FileInputStream("D:\\Maven\\MavenPractise\\MavenProject\\src\\test\\resources\\TS_Create_Organizations.xlsx");	
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(rowNum); 
			Cell cel = row.createCell(celNum);
			cel.setCellValue(data);
			
			FileOutputStream fos = new FileOutputStream("D:\\Maven\\MavenPractise\\MavenProject\\src\\test\\resources\\TS_Create_Organizations.xlsx");
			wb.write(fos);
			wb.close();
		 }
}
