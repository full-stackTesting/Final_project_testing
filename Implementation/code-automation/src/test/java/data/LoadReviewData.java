package data;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LoadReviewData {
	
	public static Object[][] getReviewData() throws IOException{
		
		String filePath = System.getProperty("user.dir")+("\\src\\test\\java\\excelFile\\data.xlsx");
		
		FileInputStream stream = new FileInputStream(filePath);
		
		XSSFWorkbook workBook = new XSSFWorkbook(stream);
		XSSFSheet ReviewSheet = workBook.getSheet("Review");
		
		int nRows =ReviewSheet.getLastRowNum() +1;
		int nCols = 3;
		
		Object[][] ReviewData = new Object[nRows][nCols];
		
		for(int i = 0; i < nRows ; i++) {
			
			XSSFRow row = ReviewSheet.getRow(i);
			for(int j = 0; j < nCols; j++) {
				
				ReviewData[i][j] = row.getCell(j).toString();
			}
		}

		
		workBook.close();
		
		return ReviewData;
	}
}