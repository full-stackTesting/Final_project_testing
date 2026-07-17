package data;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LoadSearchData {
	
	public static Object[][] getSearchData() throws IOException{
		
		String filePath = System.getProperty("user.dir")+("\\src\\test\\java\\excelFile\\data.xlsx");
		
		FileInputStream stream = new FileInputStream(filePath);
		
		XSSFWorkbook workBook = new XSSFWorkbook(stream);
		XSSFSheet searchSheet = workBook.getSheet("Search");
		
		int nRows =searchSheet.getLastRowNum() +1;
		int nCols = 1;
		
		Object[][] SearchData = new Object[nRows][nCols];
		
		for(int i = 0; i < nRows ; i++) {
			
			XSSFRow row = searchSheet.getRow(i);
			for(int j = 0; j < nCols; j++) {
				
				SearchData[i][j] = row.getCell(j).toString();
			}
		}

		
		workBook.close();
		
		return SearchData;
	}
}