package extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class HelperAttribute6 {
	
     @Test(invocationCount = 1)
     public void a() throws InterruptedException {
    	 WebDriver driver = new EdgeDriver();
    	 Thread.sleep(1000);
    	 driver.close();
     }
     
     @Test(enabled = false)
     public void b() throws InterruptedException {
    	 WebDriver driver = new ChromeDriver();
    	 Thread.sleep(1000);
    	 driver.close();
    	 
     }
     
     
     
}
