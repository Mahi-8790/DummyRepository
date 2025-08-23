package Testng_package;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Assertsdemo {
	
	WebDriver driver;
  @Test
  
	  
	  public void url() throws InterruptedException {
		  driver.get("https://www.amazon.in");
		  String expectedurl="https://www.amazon.in";
		  String actualurl=driver.getCurrentUrl();
		  System.out.println("Expectedurl="+expectedurl);
		  System.out.println("url="+actualurl);	
		  Assert.fail();
	  
  }
  @Test(dependsOnMethods= {"url"})
  public void title() throws InterruptedException {
	  driver.get("https://www.amazon.in");
	  String expectedtitle="amazon1";
	  String actualtitle=driver.getTitle();
	  System.out.println("Expectedurl="+expectedtitle);
	  System.out.println("url="+actualtitle);
	  
  }
  
  
  
  @BeforeClass
  public void beforeClass() {
	  driver=new ChromeDriver();
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
