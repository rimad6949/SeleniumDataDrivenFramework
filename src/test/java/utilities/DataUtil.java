package utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import base.Basetest;

public class DataUtil extends Basetest{
	
	@DataProvider(name="dp")
	public static Object[][] getData(Method m){
		
		String sheetName = m.getName();
		
		int rowCount = excel.getRowCount(sheetName);
		int colCount = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rowCount-1][colCount];
		System.out.println(data);
		
		for(int rows=2; rows<=rowCount; rows++) {
			
			for(int cols=0; cols<colCount; cols++) {
				
				data[rows-2][cols] = excel.getCellData(sheetName, cols, rows);
			}
		}
		
		return data;
		
	}

}
