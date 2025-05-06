package extra;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataBackToExcel {
       public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("D:\\Rajat\\vtiger-crm-framework-m16\\src\\test\\resources\\Book1.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
	    Cell cell = wb.getSheet("demo").getRow(3).getCell(2);
	    cell.setCellValue("Cell2Row");
	    
	    FileOutputStream fos = new FileOutputStream("D:\\Rajat\\vtiger-crm-framework-m16\\src\\test\\resources\\Book1.xlsx");
        wb.write(fos);
       }
}
