package utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import base.Basetest;

public class DataUtil extends Basetest{
	
	@DataProvider(name="dp")
	
	public static Object[][] getData(Method m){
		//Here the Method m is getting the information of the excel sheet name
		String sheetName = m.getName();
		
		//gets the row count, i.e 5 here
		int rowCount = excel.getRowCount(sheetName);
		
		//gets the column count, i.e 3 here
		int colCount = excel.getColumnCount(sheetName);
		
		//rowCount-1 because the 1st row are the labels of columns
		//Object[][] data = new Object[4][3];
		 Object[][] data = new Object[rowCount-1][colCount];
		
		//rows=2 because the count needs to start from row 2 as 1st row is labels
		for(int rows=2; rows<=rowCount; rows++) {
			
			for(int cols=0; cols<colCount; cols++) {
				
				//1st round - data[0][0] - Rima ----- data[0][1] - Das ------ data[0][2] - 98980
				//2nd round - data[1][0] - Animesh ----- data[1][1] - Das ------ data[1][2] - 7879
				//3rd round - data[2][0] - Animesh ----- data[2][1] - Das ------ data[2][2] - 7879
				//4th round - data[3][0] - Animesh ----- data[3][1] - Das ------ data[3][2] - 7879				
				data[rows-2][cols] = excel.getCellData(sheetName, cols, rows);
			}
		}
		
		return data;
		
	}

}
