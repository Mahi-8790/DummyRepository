package Testng_package;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class pageex {
	
	WebDriver driver;
	Loginpage loginpage;
	
	
	 @BeforeClass
	  
		 
		 public void setup() {
		        driver = new ChromeDriver();
		        driver.get("http://zero.webappsecurity.com/login.html");
		        loginpage = new Loginpage(driver);
	  }

  @Test
  public void validate() {
	  loginpage.login("username", "password");
  }
  
  
  @AfterClass
  
	  public void finish() {
		  driver.quit();
	  }
  }


