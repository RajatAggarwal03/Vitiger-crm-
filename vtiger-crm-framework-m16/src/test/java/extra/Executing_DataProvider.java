package extra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Executing_DataProvider {
          @Test(dataProvider = "getData")
     
          public void login(String un, String pwd) throws InterruptedException {
          WebDriver driver = new ChromeDriver();
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
     
          driver.get("https://www.saucedemo.com/v1/");
     
          WebElement username = driver.findElement(By.id("user-name"));
          username.sendKeys(un);
    
          WebElement password = driver.findElement(By.id("password"));
          password.sendKeys(pwd);
     
          driver.findElement(By.id("login-button")).click();
     
          // Verification
          WebElement actlogo = driver.findElement(By.className("app_logo"));
          if (actlogo.isDisplayed()) {
    	  System.out.println("Login successfully");
     }
         
     
          Thread.sleep(5000);
          driver.close();
     }
     
    
         
     
         @DataProvider
         public Object[][] getData() {
    	 Object[][] arr = new Object[4][2];
    	 arr[0][0] = "standard_user";
    	 arr[0][1] = "secret_sauce";
    	 
    	 arr[1][0] = "locked_out_user";
    	 arr[1][1] = "secret_sauce";
    	 
    	 arr[2][0] = "problem_user";
    	 arr[2][1] = "secret_sauce";
    	 
    	 arr[3][0] = "performance_glitch_user";
    	 arr[3][1] = "secret_sauce";
    	 
    	 return arr; 
     }
   
}


    
    
   
    
    

