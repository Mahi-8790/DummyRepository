package Testng_package;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class NewTestparallel {
	WebDriver driver;
	
	
	@BeforeClass
	  public void beforeClass() {
		driver=new ChromeDriver();
		
		
		
	  }	
	
  @Test
  
	  public void amazon() throws InterruptedException {
		  driver.get("https://www.amazon.in");
		  String expectedurl="https://www.amazon.in/";
		  String actualurl=driver.getCurrentUrl();
		  Assert.assertEquals(actualurl, expectedurl, "url failed");
		  Thread.sleep(3000);
		  System.out.println("Thread ID"+Thread.currentThread().getId());
		  driver.quit();
		  
		}
  @Test

		public void flipkart() throws InterruptedException {
		  driver.get("https://www.flipkart.com/");
		  String expectedurl="https://www.flipkart.com/";
		  String actualurl=driver.getCurrentUrl();
		  Assert.assertEquals(actualurl, expectedurl, "url failed");
		  Thread.sleep(3000);
		  System.out.println("Thread ID"+Thread.currentThread().getId());
		  
		  driver.quit();
	
	
		}
  @Test

		public void zerobank() throws InterruptedException {

		  driver.get("http://zero.webappsecurity.com/");
		  String expectedurl="http://zero.webappsecurity.com/";
		  String actualurl=driver.getCurrentUrl();
		  Assert.assertEquals(actualurl, expectedurl, "url failed");
		  Thread.sleep(3000);
		  System.out.println("Thread ID"+Thread.currentThread().getId());
		  driver.quit();
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}

/*WebDriver driver;

@BeforeTest
  public void beforeTest() {
	driver=new ChromeDriver();
  }


@Test
public void amazon() throws InterruptedException {
  driver.get("https://www.amazon.in");
  String expectedurl="https://www.amazon.in";
  String actualurl=driver.getCurrentUrl();
  Assert.assertEquals(actualurl, expectedurl, "url failed");
  Thread.sleep(3000);
  
  
  
}

public void flipkart() throws InterruptedException {
  driver.get("https://www.flipkart.com/");
  String expectedurl="https://www.flipkart.com/";
  String actualurl=driver.getCurrentUrl();
  Assert.assertEquals(actualurl, expectedurl, "url failed");
  Thread.sleep(3000);
  
  
  
}

public void zerobank() throws InterruptedException {
  driver.get("http://zero.webappsecurity.com/");
  String expectedtitle="onlinebanking";
  String actualtitle=driver.getTitle();
  Assert.assertEquals(actualtitle, expectedtitle, "title failed");
  Thread.sleep(3000);
  
  
  
}


@AfterTest
public void afterTest() {
  driver.quit();
}

}*/