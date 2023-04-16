package com.bank.qa.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataSupplier {

	@DataProvider
	public static Object[][] getData() throws Exception {
		String TESTDATA_SHEET_PATH = "./resources/TestData.xlsx";
		 File excelFile = new File(TESTDATA_SHEET_PATH);
		 System.out.println(excelFile.exists());
		 FileInputStream fis = new FileInputStream(excelFile);
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 XSSFSheet sheet = workbook.getSheet("contacts");
		 int noOfRows = sheet.getPhysicalNumberOfRows();
		 int noOfColumns = sheet.getRow(0).getLastCellNum();
		 Object[][] data = new Object [noOfRows-1][noOfColumns];
		 DataFormatter df = new DataFormatter();
		 for(int i=0; i<noOfRows-1; i++){
			 
			 for(int j=0; j<noOfColumns;j++){
				 
				data[i][j]= df.formatCellValue(sheet.getRow(i+1).getCell(j));
			 }
		 }		 
		fis.close();
		for (Object[] dataArr : data) {
			System.out.println(Arrays.toString(dataArr));
		}
		return data;
	}
}
