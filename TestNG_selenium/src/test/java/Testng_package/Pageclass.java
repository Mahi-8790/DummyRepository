package Testng_package;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Pageclass {
	By email=By.id("userid");
	By pass=By.id("pass");
	By cont=By.id("signin-continue-btn");
	By search=By.id("gh-ac");
	 WebDriver driver;
	
	
	public Pageclass(WebDriver driver) {
		this.driver=driver;
	}
	
	public void email_in() {
		driver.findElement(email).click();
		driver.findElement(email).sendKeys("abc@gmail.com");
		
	}
	public void pass_in() {
		
		driver.findElement(email).click();
		driver.findElement(email).sendKeys("8919215039@gmail.com");
		
		
	}
	
	public void con_in() {
		driver.findElement(cont).click();
		
	}
	
	public void search_in() {
		driver.findElement(search).click();
		driver.findElement(search).sendKeys("watch");
		driver.findElement(search).sendKeys(Keys.ENTER);
		
		
	}

}
