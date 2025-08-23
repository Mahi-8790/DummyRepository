package Testng_package;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
@BeforeTest

public class wait {
	
WebDriver driver=new ChromeDriver();
	
	
  @Test
  public void openpage() throws InterruptedException {
	  driver.get("https://www.flipkart.com/");
	  driver.manage().window().maximize();
	  String expectedurl="https://www.flipkart.com/";
	  String actualurl=driver.getCurrentUrl();
	  Assert.assertEquals(actualurl, expectedurl, "url failed");
	  Thread.sleep(3000);
	  
	  WebElement ser=driver.findElement(By.name("q"));
	  ser.sendKeys("watch");
	  ser.sendKeys(Keys.ENTER);
	  
	  driver.close();	  
	  
  }
}

