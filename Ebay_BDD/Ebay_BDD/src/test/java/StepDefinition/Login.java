package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	WebDriver driver;
	Pageclass pg;
	@Given("login page should be open in default browser")
	public void login_page_should_be_open_in_default_browser() {
		driver = new ChromeDriver();
		pg = new Pageclass(driver);
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("page loads click on signin button")
	public void page_loads_click_on_signin_button() throws InterruptedException {
//		WebElement login=driver.findElement(By.cssSelector("span>a[_sp=\"m570.l1524\"]"));
//		  login.click();
		pg.username_click();
		  Thread.sleep(10000);  	    
	}

	@When("enter valid username and click continue")
	public void enter_valid_username_and_click_continue() throws InterruptedException {
//		WebElement username=driver.findElement(By.cssSelector("div>input[id=\"userid\"]"));
//		 
		
		pg.username_in();
		pg.cont_but();
		  
//		  WebElement cont=driver.findElement(By.id("signin-continue-btn"));
//		  cont.click();
//		  Thread.sleep(10000);
	}

	@When("enter valid password and click continue")
	public void enter_valid_password_and_click_continue() {
//		WebElement pass=driver.findElement(By.cssSelector("div>input[id=\"pass\"]"));
//		
		pg.pass_in();
		pg.signin_but();
		  
//		 driver.findElement(By.id("sgnBt")).click();
	}

	@Then("login successfully and open home page")
	public void login_successfully_and_open_home_page() {
	    driver.close();
	}

}
