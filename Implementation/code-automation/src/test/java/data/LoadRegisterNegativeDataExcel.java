package data;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LoadRegisterNegativeDataExcel {
  public static Object[][] getRegisterNegativeData() throws IOException{
   String filePath=System.getProperty("user.dir")+"/src/test/java/excelFile/data.xlsx";
   
   FileInputStream stream = new FileInputStream(filePath);
   
   XSSFWorkbook workBook = new XSSFWorkbook(stream);
   XSSFSheet RegisterNegativeSheet = workBook.getSheet("Register Negative");
   
   int nRows =RegisterNegativeSheet.getLastRowNum() +1;
   int nCols = 2;
   
   Object[][] RegisterNegativeData = new Object[nRows][nCols];
   
   for(int i = 0; i < nRows ; i++) {
    
    XSSFRow row = RegisterNegativeSheet.getRow(i);
    for(int j = 0; j < nCols; j++) {
     
     RegisterNegativeData[i][j] = row.getCell(j).toString();
    }
   }

   
   workBook.close();
   
   return RegisterNegativeData;
  }
}