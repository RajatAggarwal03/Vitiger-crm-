package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.WebDriverUtility;

public class HomePage {
      public WebDriver driver;
      
      public HomePage(WebDriver driver) {
    	  this.driver=driver;
    	  PageFactory.initElements( driver,this);
      }
      
//  	opportunity link
//  	lead link

//  	profile button
//  	signout link

//  	Logout
//  	hover on profile
  	@FindBy(css = "img[src='themes/softed/images/user.PNG']")
  	private WebElement profile;

  	@FindBy(linkText = "Sign Out")
  	private WebElement signOutLink;

  	public WebElement getProfile() {
  		return profile;
  	}

  	public WebElement getSignOutLink() {
  		return signOutLink;
  	}

  	public void logout() {
  		WebDriverUtility wdUtil = new WebDriverUtility(driver);
  		wdUtil.hover(getProfile());
  		getSignOutLink().click();
  	}
  }
      
      
      

