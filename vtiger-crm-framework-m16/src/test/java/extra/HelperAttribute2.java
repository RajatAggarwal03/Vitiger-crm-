package extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HelperAttribute2 {
	
     @Test(invocationCount = 10 , threadPoolSize = 5)
     public void add() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Thread.sleep(1000);
        driver.close();
     }
}
