package extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HelperAttribute3 {
	   @Test
	   public void deleteCity() {
	        WebDriver driver = new ChromeDriver();
	        System.out.println("New Delhi removed");
	        driver.close();
	}
	   @Test
	   public void modifyCity() {
		    WebDriver driver = new ChromeDriver();
		    System.out.println("New Delhi");
		    driver.close();
	}
	   @Test
	   public void createCity() {
		    WebDriver driver = new ChromeDriver();
		    System.out.println("Delhi");
		    driver.close();
	}
}



