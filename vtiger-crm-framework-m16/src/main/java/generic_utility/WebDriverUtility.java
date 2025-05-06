package generic_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
       WebDriver driver;
       Actions act;
       
       public WebDriverUtility(WebDriver driver) {
    	   this.driver = driver;
    	   this.act = new Actions(driver);   
       }
       
       public void hover(WebElement element) {
    	   act.moveToElement(element).build().perform();
       }
       
       public void selectBy(WebElement element,int index) {
    	   Select sel = new Select(element);
    	   sel.selectByIndex(index);   
       }
       
       public void selectBy(WebElement element,String value) {
    	   Select sel = new Select(element);
    	   sel.selectByValue(value);   
       }
       
       public void selectBy(String VisibleText,WebElement element) {
    	   Select sel = new Select(element);
    	   sel.selectByVisibleText(VisibleText);
       }      
       
}
