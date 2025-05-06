package leadsTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateLeadsTest2 {
     public static void main(String[] args) throws IOException {
    	 
		FileInputStream fis = new FileInputStream("D:\\Rajat\\vtiger-crm-framework-m16\\src\\test\\resources\\CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		
		String BROWSER = pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		System.out.println(BROWSER);
		
		driver.get(URL);
		
		WebElement un = driver.findElement(By.name("user_name"));
		un.sendKeys(USERNAME);
		
		WebElement pwd = driver.findElement(By.name("user_password"));
		pwd.sendKeys(PASSWORD);
		
		WebElement loginBtn = driver.findElement(By.id("submitButton"));
		loginBtn.click();
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.cssSelector("img[title='Create Lead...']")).click();
		
		String lastName ="singhania";
		String compName ="ytank";
		
		WebElement ln = driver.findElement(By.name("lastname"));
		ln.sendKeys(lastName);
		
		WebElement cp = driver.findElement(By.name("company"));
		cp.sendKeys(compName);
		
		// Save
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		
		//Verification
		String actualLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (actualLastName.equals(lastName)) {
			System.out.println("Entered lastname successfully!!!");
		}
		
		String actualCompName = driver.findElement(By.id("dtlview_Company")).getText();
		if (actualCompName.equals(compName)) {
			System.out.println("Entered company name successfully!!!");
		}
		
//      Logout
//      hover on profile
	    WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
	    Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();

		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.close();
		
		
		
		
		
	}
		

}

