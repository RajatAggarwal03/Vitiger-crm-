package leadsTest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;

public class CreateLeadsWithPhoneTest3 {
     public static void main(String[] args) throws IOException {
    	 
//          Getting data from properties file  
    	    FileUtility fUtil = new FileUtility();
    	    String BROWSER = fUtil.getDataFromPropertyFile("bro");
		    String URL = fUtil.getDataFromPropertyFile("url");
		    String USERNAME = fUtil.getDataFromPropertyFile("un");
		    String PASSWORD = fUtil.getDataFromPropertyFile("pwd"); 
		 
//          Getting data from excel file
		    String lastName = fUtil.getDataFromExcelFile("leads", 1, 0);
		    String compName = fUtil.getDataFromExcelFile("leads", 1, 1);
		    String phoneNum = fUtil.getDataFromExcelFile("leads", 1, 2);
		 
		    WebDriver driver = new ChromeDriver();
		 
		    WebDriverUtility wdUtil = new WebDriverUtility(driver);
		 
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
			
			WebDriverUtility wdUtil1 = new WebDriverUtility(driver);
			wdUtil1.hover(profile);

			driver.findElement(By.linkText("Sign Out")).click();
			
			driver.close();

		    
		
		
		
			
			
		}
	}

