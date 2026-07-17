package data;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LoadRegisterHappyDataExcel {
 public static Object[][] getRegisterHappyData() throws IOException{
    String filePath=System.getProperty("user.dir")+"/src/test/java/excelFile/data.xlsx";
    
    FileInputStream stream = new FileInputStream(filePath);
    
    XSSFWorkbook workBook = new XSSFWorkbook(stream);
    XSSFSheet RegisterHappySheet = workBook.getSheet("Register Happy");
    
    int nRows =RegisterHappySheet.getLastRowNum() +1;
    int nCols = 16;
    
    Object[][] RegisterHappyData = new Object[nRows][nCols];
    DataFormatter formatter = new DataFormatter();
    for(int i = 0; i < nRows ; i++) {
     
     XSSFRow row = RegisterHappySheet.getRow(i);
     for(int j = 0; j < nCols; j++) {
      
      RegisterHappyData[i][j] = formatter.formatCellValue(row.getCell(j));     }
    }

    
    workBook.close();
    
    return RegisterHappyData;
   }
}