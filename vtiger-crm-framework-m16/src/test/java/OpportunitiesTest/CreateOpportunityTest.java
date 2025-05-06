package OpportunitiesTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOpportunityTest {
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
		 
		 driver.findElement(By.linkText("Opportunities")).click();
		 driver.findElement(By.cssSelector("img[title='Create Opportunity...']")).click();
		 
		 String OpportunityName ="John-2000 units";
		 String RelatedTo = "Contacts";
		 String SalesStage ="Qualification";
		 
		 
		 WebElement pn = driver.findElement(By.name("potentialname"));
		 pn.sendKeys(OpportunityName);
		 
		 WebElement rt =  driver.findElement(By.name("related_to_type"));
		 Select selrelated = new Select(rt);
		 selrelated.selectByValue("Contacts");
		 
		 driver.findElement(By.cssSelector("img[title='Select']")).click();
		 driver.findElement(By.id("search_txt"));
		 
		 
		 WebElement ss = driver.findElement(By.name("sales_stage"));
		 Select selsales = new Select(ss);
		 selsales.selectByVisibleText("Qualification");
		
	//   Save
	    // driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
	}
}
