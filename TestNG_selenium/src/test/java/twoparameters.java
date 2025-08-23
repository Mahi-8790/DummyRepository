import org.testng.annotations.Test;

import org.testng.annotations.Parameters;


import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class twoparameters {
	WebDriver driver;
	
  @Test
  public void amazonurl() throws InterruptedException {
	  driver.get("https://www.amazon.in");
	  String expectedurl="https://www.amazon.in/";
	  String actualurl=driver.getCurrentUrl();
	  System.out.println("amazonurl="+actualurl);
  }
  @Test
  public void flipkarturl() throws InterruptedException {
	  driver.get("https://www.flipkart.com/");
	  String expectedurl="https://www.flipkart.com/";
	  String actualurl=driver.getCurrentUrl();
	  System.out.println("flipkarturl="+actualurl);
  }
  
  @Parameters({"flipkarturl", "amazonurl"})
  @Test
  public void Testclass(String flipkarturl, String amazonurl) {
	  System.out.println("flipcart="+flipkarturl);
	  System.out.println("amazon="+amazonurl);
	  
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
