package extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class HelperAttribute5 {
	
         @Test(invocationCount = 5 , threadPoolSize = 5)
         public void a() throws InterruptedException {
             WebDriver driver = new ChromeDriver();
             Thread.sleep(1000);
             driver.close();
         }
         @Test(invocationCount = 5 , threadPoolSize = 3)
         public void b() throws InterruptedException {
             WebDriver driver = new EdgeDriver();
             Thread.sleep(1000);
             driver.close();
         }
         
         
}
