package com.crm.qa.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.Testbase;

public class TestUtil extends Testbase{
	public static long PAGE_LOAD_TIME_OUT=20;
	public static long IMPLICIT_WAIT=20;
	public static String Test_Data_SheetPath = "/Users/muralisubramani/eclipse-workspace/FreeCRMTest/src/main/java/com/crm/qa/testdata/EventCalender.xlsx";
	static Workbook book;

	static Sheet sheet;
	//public static FileInputStream file;

	@SuppressWarnings("resource")
	/*public static XSSFCell getTestData(String SheetName)throws IOException
	{
		//FileInputStream file;

			//File file=new File(Test_Data_SheetPath);
			FileInputStream fInputStream=new FileInputStream(Test_Data_SheetPath);
			XSSFWorkbook CRMWorkbook=new XSSFWorkbook(fInputStream);
			XSSFSheet CRMSheet = CRMWorkbook.getSheet(SheetName);

		   XSSFCell data;//=new String[CRMSheet.getLastRowNum()];//[CRMSheet.getRow(0).getLastCellNum()];
		//for(int i=0;i<CRMSheet.getLastRowNum();i++)
		//{
			//for(int k=0;k<CRMSheet.getRow(0).getLastCellNum();k++)
			//{
				data=CRMSheet.getRow(1).getCell(0);

			//}
		//}

		return data;

	}*/
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(Test_Data_SheetPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

}
