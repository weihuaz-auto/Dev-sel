package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {
	
//	static String filename = "tc001Data";

	private XSSFWorkbook workbook ;
	public String[][]  getData(String filename){
//		0. Location
//		1. Workbook
//		2. Sheet
//		3. Row & column - Cell
		
		try {
			workbook = new XSSFWorkbook("./testdata/"+filename+".xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheetAt(0);
		// rows
		int lastRowNum = sheet.getLastRowNum();
		System.out.println("Rows: "+lastRowNum);
		// columns
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		System.out.println("Cell: "+lastCellNum);
		
		String[][] data = new String[lastRowNum][lastCellNum];
		// read the data based on rows & column
		for (int i = 1; i <= lastRowNum; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < lastCellNum; j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter dft = new DataFormatter();
				String value = dft.formatCellValue(cell);
//				String value = cell.getStringCellValue();
				System.out.println(value);
				data[i-1][j] = value;
			} 
		}
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}
