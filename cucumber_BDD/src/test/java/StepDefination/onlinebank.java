package StepDefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class onlinebank {
	WebDriver driver;

@Given("zero bank home should available with browser")
public void zero_bank_home_should_available_with_browser() {
	driver=new ChromeDriver();
	driver.get("http://zero.webappsecurity.com/index.html");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    
}

@When("click on online banking hyperlink then click on online statements")
public void click_on_online_banking_hyperlink_then_click_on_online_statements() throws InterruptedException {
	driver.findElement(By.id("signin_button")).click();
	driver.findElement(By.id("user_login")).click();
	driver.findElement(By.id("user_login")).sendKeys("username");
	driver.findElement(By.id("user_password")).click();
	driver.findElement(By.id("user_password")).sendKeys("password");
	driver.findElement(By.name("submit")).click();
   
   Thread.sleep(3000);
   driver.navigate().refresh();
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("//*[@id=\"onlineBankingMenu\"]/div/strong")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("online_statements_link")).click();
	
   
}

@And("select savings fron dropdown list select year and click on statements for downloading")
public void select_savings_fron_dropdown_list_select_year_and_click_on_statements_for_downloading() {
   driver.findElement(By.xpath("//*[@id=\"os_accountId\"]/option[1]")).click();
 //  driver.findElement(By.id("os_accountId")).sendKeys(Keys.valueOf("1"));
   driver.findElement(By.id("os_accountId")).click();
   driver.findElement(By.xpath("//*[@id=\"online_statements_for_account\"]/div/div/div[2]/ul/li[3]/a")).click();
   driver.findElement(By.xpath("//*[@id=\"os_2010\"]/table/tbody/tr[1]/td[1]/a")).click();
   
}

@Then("Statement download")
public void statement_download() {
	System.out.println("statement downloaded");
	driver.close();
    
}

}
