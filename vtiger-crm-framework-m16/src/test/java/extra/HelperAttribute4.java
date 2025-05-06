package extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HelperAttribute4 {
	
	@Test(priority = 1)
	 public void deleteCity() {
	        WebDriver driver = new ChromeDriver();
	        System.out.println("New Delhi removed");
	        driver.close();
	}
	
	 @Test(priority = -1)
	 public void modifyCity() {
	        WebDriver driver = new ChromeDriver();
	        System.out.println("New Delhi");
	        driver.close();
	}
	 @Test(priority = 0)
	 public void createCity() {
	        WebDriver driver = new ChromeDriver();
	        System.out.println("Delhi");
	        driver.close();
	}
	 
}
