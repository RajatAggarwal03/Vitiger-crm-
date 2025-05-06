package sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Demo2  {
	
	@Test
	public void sub() throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		Thread.sleep(5000);
		driver.close();
		
	}
	

}
