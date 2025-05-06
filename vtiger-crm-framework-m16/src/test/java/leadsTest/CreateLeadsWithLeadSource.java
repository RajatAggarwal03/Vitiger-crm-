package leadsTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateLeadsWithLeadSource 
{
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://localhost:8888/");
		
		WebElement un = driver.findElement(By.name("user_name"));
		un.sendKeys("admin");
		
		WebElement pwd = driver.findElement(By.name("user_password"));
		pwd.sendKeys("admin");
		
		WebElement loginBtn = driver.findElement(By.id("submitButton"));
		loginBtn.click();
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.cssSelector("img[title='Create Lead...']")).click();
		
		String lastName="bulletraja";
		String compName="tcs";
		String leadSource="Employee";
		
		WebElement ln = driver.findElement(By.name("lastname"));
		ln.sendKeys(lastName);
		
		WebElement cp = driver.findElement(By.name("company"));
		cp.sendKeys(compName);
		
		WebElement ls = driver.findElement(By.name("leadsource"));
		Select sellead = new Select(ls);
		sellead.selectByVisibleText("Employee");
		
   //   Save
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		
   //   Verification
		String actualLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (actualLastName.equals(lastName)) {
			System.out.println("Entered last name successfully!!!");
		}
		
		String actualCompName = driver.findElement(By.id("dtlview_Company")).getText();
		if (actualCompName.equals(compName)) {
			System.out.println("Entered company name successfully!!!");
			
	    String actualLeadSource = driver.findElement(By.id("dtlview_Lead Source")).getText();
	    if (actualLeadSource.equals(leadSource)) {
			System.out.println("Entered lead source successfully!!!");
		}
		
  //    Logout
 //     hover on profile
	    WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
	    Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();

		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.close();
		}
	}
}
		
		
		
		
		
	




