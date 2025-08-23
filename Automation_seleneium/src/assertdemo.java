import org.openqa.selenium.chrome.*;

import graphql.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class assertdemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		
		Assert.assertTrue(false, "no, search button is not available on page");
		WebElement search = driver.findElement(By.id("gh-ac"));
		search.sendKeys("watch");
		search.sendKeys(Keys.ENTER);
		
         
	}

}
