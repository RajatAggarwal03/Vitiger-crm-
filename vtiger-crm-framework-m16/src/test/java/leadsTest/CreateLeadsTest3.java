package leadsTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Object_Repository.LoginPage;

public class CreateLeadsTest3 {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("http://localhost:8888/");

//		Login
		LoginPage lp = new LoginPage(driver);
		WebElement un = lp.getUn();
		driver.navigate().refresh();
		un.sendKeys("admin");

		WebElement pwd = lp.getPwd();
		pwd.sendKeys("admin");

		lp.getLoginBtn().click();

//		Create new lead
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.cssSelector("img[title='Create Lead...']")).click();

		WebElement ln = driver.findElement(By.name("lastname"));
		String lastName = "singh";
		ln.sendKeys(lastName);

		WebElement cn = driver.findElement(By.name("company"));
		String compName = "Parle-G";
		cn.sendKeys(compName);

//		save
		driver.findElement(By.cssSelector("input[class='crmButton small save']")).click();

//		verification
		String actualLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (actualLastName.equals(lastName)) {
			System.out.println("lastname passed successfully!!!");
		}

//		logout
//		hover on profile
		WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();

		driver.findElement(By.linkText("Sign Out")).click();

		Thread.sleep(2000);
		driver.close();

	}
}
