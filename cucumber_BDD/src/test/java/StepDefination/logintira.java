package StepDefination;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class logintira {
	WebDriver driver;
	
	
	@Given("page should open in browser")
	public void page_should_open_in_browser() {
		
		driver= new ChromeDriver();
		driver.get("https://www.ebay.com/?msockid=0cd5b651761860fb2f50a05777f06184");
		driver.manage().window().maximize();
		
	}
	    
	


	@Given("Enter the username and password")
	public void enter_the_username_and_password() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"gh\"]/nav/div[1]/span[1]/span/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("userid")).click();
		driver.findElement(By.id("userid")).sendKeys("ma-3515488");
		Thread.sleep(2000);
		
		driver.findElement(By.id("signin-continue-btn")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("pass")).click();
		Thread.sleep(2000);
		//driver.findElement(By.id("pass")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("pass")).sendKeys("8919215039@Mk");
			
		
		
	}

	@And("click on sign")
	public void click_on_sign() {
		
		driver.findElement(By.id("sgnBt")).click();
		driver.close();
	}
	
	

}
