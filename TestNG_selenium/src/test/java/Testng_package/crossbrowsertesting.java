package Testng_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class crossbrowsertesting {
	WebDriver driver;

  @Test
  public void firefoxbrowser() throws InterruptedException {
	  driver=new FirefoxDriver();
	  driver.get("https://www.flipkart.com/");
	  String expectedurl="https://www.flipkart.com/";
	  String actualurl=driver.getCurrentUrl();
	  Assert.assertEquals(actualurl, expectedurl, "url failed");
	  Thread.sleep(3000);
}
  @Test
  public void edgebrowser() throws InterruptedException {
	  System.setProperty("webdriver.edge.driver", "C:\\Users\\mahender reddy\\OneDrive\\Desktop\\selenium and chrome\\edgedriver_win64 (1)\"");
	  driver=new EdgeDriver();
	  driver.get("https://www.flipkart.com/");
	  String expectedurl="https://www.flipkart.com/";
	  String actualurl=driver.getCurrentUrl();
	  Assert.assertEquals(actualurl, expectedurl, "url failed");
	  Thread.sleep(3000);
}
  @Test
  public void chromebrowser() throws InterruptedException {
	  driver=new ChromeDriver();
	  driver.get("https://www.flipkart.com/");
	  String expectedurl="https://www.flipkart.com/";
	  String actualurl=driver.getCurrentUrl();
	  Assert.assertEquals(actualurl, expectedurl, "url failed");
	  Thread.sleep(3000);
  }
  

}





