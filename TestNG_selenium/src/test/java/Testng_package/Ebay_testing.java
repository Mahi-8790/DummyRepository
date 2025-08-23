package Testng_package;

import org.testng.annotations.Test;

import graphql.Assert;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.By;


  
 /* public void search() {
	  WebElement search=driver.findElement(By.id("gh-ac"));
	  search.sendKeys("watch");
	  search.sendKeys(Keys.ENTER);
	  driver.navigate().refresh();
	//  search.click();
	  
	  
  }
  
  @Test(priority=2)
  public void search1() {
	  WebElement search=driver.findElement(By.id("gh-ac"));
	  search.sendKeys("phone");
	  search.sendKeys(Keys.ENTER);
	  driver.navigate().refresh();
	  
  }
  
  @Test(priority=3)
  public void search2() {
	  WebElement search=driver.findElement(By.id("gh-ac"));
	  search.sendKeys("phone");
	  search.sendKeys(Keys.ENTER);
	  driver.navigate().refresh();
  }*/
 /* public void search12() throws InterruptedException {
	String[] subjects= {"phone", "watch", "shoes"};
	
	WebElement sub=driver.findElement(By.id("gh-ac"));
	for(String subject:subjects)
	{
		sub.sendKeys(subject);
		Thread.sleep(1000);
		sub.sendKeys(Keys.ENTER);
	}}
  */
	public class Ebay_testing {
		WebDriver driver;
  @Test
  
  Pageclass pg=new Pageclass(driver);
  pg.email_in();
  pg.pass_in();
  pg.con_in();
  pg.search.in();
  
  
  @BeforeTest//1
  public void beforeTest() throws InterruptedException {
	  driver=new ChromeDriver();
	  driver.get("https://www.ebay.com/");
      driver.manage().window().maximize();
      Thread.sleep(5000);
  }
  
  

  @AfterTest
  public void afterTest() {
	  Assert.assertTrue(true,"search button is not buttton working");
	  driver.close();
  }

}
