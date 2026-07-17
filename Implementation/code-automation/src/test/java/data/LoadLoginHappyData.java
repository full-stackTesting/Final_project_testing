package data;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LoadLoginHappyData {
	
	public static Object[][] getLoginHappyData() throws IOException{
		
		String filePath = System.getProperty("user.dir")+("\\src\\test\\java\\excelFile\\data.xlsx");
		
		FileInputStream stream = new FileInputStream(filePath);
		
		XSSFWorkbook workBook = new XSSFWorkbook(stream);
		XSSFSheet LoginHappySheet = workBook.getSheet("Login Happy");
		
		int nRows =LoginHappySheet.getLastRowNum() +1;
		int nCols = 2;
		
		Object[][] loginHappyData = new Object[nRows][nCols];
		
		for(int i = 0; i < nRows ; i++) {
			
			XSSFRow row = LoginHappySheet.getRow(i);
			for(int j = 0; j < nCols; j++) {
				
				loginHappyData[i][j] = row.getCell(j).toString();
			}
		}

		
		workBook.close();
		
		return loginHappyData;
	}
}