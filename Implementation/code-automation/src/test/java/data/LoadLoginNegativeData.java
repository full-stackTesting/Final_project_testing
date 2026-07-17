package data;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LoadLoginNegativeData {
	
	public static Object[][] getLoginNegativeData() throws IOException{
		
		String filePath = System.getProperty("user.dir")+("\\src\\test\\java\\excelFile\\data.xlsx");
		
		FileInputStream stream = new FileInputStream(filePath);
		
		XSSFWorkbook workBook = new XSSFWorkbook(stream);
		XSSFSheet LoginNegativeSheet = workBook.getSheet("Login Negative");
		
		int nRows =LoginNegativeSheet.getLastRowNum() +1;
		int nCols = 2;
		
		Object[][] loginNegativeData = new Object[nRows][nCols];
		
		for(int i = 0; i < nRows ; ++i) {
			
			XSSFRow row = LoginNegativeSheet.getRow(i);
			
			for(int j = 0; j < nCols; ++j) {
				loginNegativeData[i][j] = row.getCell(j).toString();
			}
		}
System.out.println(nRows);
		
		workBook.close();
		
		return loginNegativeData;
	}
}