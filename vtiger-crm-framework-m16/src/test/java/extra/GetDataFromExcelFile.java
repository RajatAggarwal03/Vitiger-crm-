package extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromExcelFile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
//		create java representation object of the physical file
		FileInputStream fis = new FileInputStream("C:\\Users\\lenovo\\OneDrive\\Desktop\\Book1.xlsx");
		
//		we'll open workbook in read mode
		Workbook wb = WorkbookFactory.create(fis);
		
//		we'll get access of sheet
		Sheet sh = wb.getSheet("leads");
		
//		we'll get access of row
		Row row = sh.getRow(1);
		
//		we'll get the access of cell
		Cell cell = row.getCell(0);
		
//		we'll read the data
		String data = cell.getStringCellValue();
		System.out.println(data);
		
//	    double value = cell.getNumericCellValue();
//	    System.out.println(value);
	    
//      boolean stauts = cell.getBooleanCellValue();
//		System.out.println(stauts);
		
//		LocalDateTime time = cell.getLocalDateTimeCellValue();
//		System.out.println(time);
		
	}
}

