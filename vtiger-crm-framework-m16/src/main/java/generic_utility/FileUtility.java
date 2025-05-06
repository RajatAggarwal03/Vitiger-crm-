package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
      public String getDataFromPropertyFile(String key) throws IOException { 
    	  
        FileInputStream fis = new FileInputStream("D:\\Rajat\\vtiger-crm-framework-m16\\src\\test\\resources\\CommonData.properties");
        Properties pObj = new Properties();
        pObj.load(fis);
        String value = pObj.getProperty(key);
        return value;
      }
      
        public String getDataFromExcelFile( String SheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
        
        FileInputStream fis1 = new FileInputStream("D:\\Rajat\\vtiger-crm-framework-m16\\src\\test\\resources\\Book1.xlsx");
        Workbook wb = WorkbookFactory.create(fis1);
        Sheet sh = wb.getSheet(SheetName);
        Row row = sh.getRow(rowNum);
        Cell cell = row.getCell(cellNum);
        String value = cell.getStringCellValue();
        return value;
        }

}

        
           
           
           
           


