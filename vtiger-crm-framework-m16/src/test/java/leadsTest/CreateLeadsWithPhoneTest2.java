package leadsTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateLeadsWithPhoneTest2 {
     public static void main(String[] args) throws IOException {
 //         Getting data from properties file   	 
		    FileInputStream fis = new FileInputStream("D:\\Rajat\\vtiger-crm-framework-m16\\src\\test\\resources\\CommonData.properties");
		    Properties pObj = new Properties();
		    pObj.load(fis);
		    
		    String BROWSER = pObj.getProperty("bro");
		    String URL = pObj.getProperty("url");
		    String USERNAME = pObj.getProperty("un");
		    String PASSWORD = pObj.getProperty("pwd");
		    
 //         Getting data from excel file
			FileInputStream fis1 = new FileInputStream("D:\\Rajat\\vtiger-crm-framework-m16\\src\\test\\resources\\Book1.xlsx");
					
			Workbook wb = WorkbookFactory.create(fis1);
			String lastName = wb.getSheet("leads").getRow(1).getCell(0).getStringCellValue();
			String compName = wb.getSheet("leads").getRow(1).getCell(1).getStringCellValue();
			String phoneNum = wb.getSheet("leads").getRow(1).getCell(2).getStringCellValue();		    
		    
		    WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
			System.out.println(BROWSER);
			
			driver.get(URL);
			
//	        Login
		    WebElement un = driver.findElement(By.name("user_name"));
		    un.sendKeys(USERNAME);
		
		    WebElement pwd = driver.findElement(By.name("user_password"));
		    pwd.sendKeys(PASSWORD);
		
		    WebElement loginBtn = driver.findElement(By.id("submitButton"));
		    loginBtn.submit();
		    
//		    Create leads with phone number
		    driver.findElement(By.linkText("Leads")).click();
		    driver.findElement(By.cssSelector("img[title='Create Lead...']")).click();
		    
//		    String lastName = "Bahadur";
//		    String compName = "Titan";
//			String phoneNum = "7894561230";
			
			WebElement ln = driver.findElement(By.name("lastname"));
			ln.sendKeys(lastName);
			
			WebElement cn= driver.findElement(By.name("company"));
			cn.sendKeys(compName);
			
			WebElement pn = driver.findElement(By.id("phone"));
			pn.sendKeys(phoneNum);
			
//	         Save
			driver.findElement(By.cssSelector("input[title='Save [Alt+S]'")).click();
			
//	        Verification
			String actualLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
			if (actualLastName.equals(lastName)) {
				System.out.println("Entered lastname successfully!!!");
			}
			
			String actualCompName = driver.findElement(By.id("dtlview_Company")).getText();
			if (actualCompName.equals(compName)) {
				System.out.println("Entered company name successfully!!!");
			}
				
		    String actualPhonNum = driver.findElement(By.id("dtlview_Phone")).getText();
		    if (actualPhonNum.equals(phoneNum)) {
				System.out.println("Entered phone number successfully!!!");
		    }
			
//	        Logout
//	        hover on profile
		    WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		    Actions act = new Actions(driver);
			act.moveToElement(profile).build().perform();

			driver.findElement(By.linkText("Sign Out")).click();
			
			driver.close();

		    
		
		
		
			
			
		}
		    
		    
		
	}

