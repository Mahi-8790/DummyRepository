package Testng_package;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Testmultiple {
	WebDriver driver;
  @Test(invocationCount=5)  
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
