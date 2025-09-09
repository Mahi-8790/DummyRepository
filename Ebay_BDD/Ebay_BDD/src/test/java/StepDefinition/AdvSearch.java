package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AdvSearch {
	WebDriver driver;
	Pageclass pg;
	@Given("ebay page open in the default browser")
	public void ebay_page_open_in_the_default_browser() {
		driver = new ChromeDriver();
		pg = new Pageclass(driver);
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@When("User clicks on Advance serach button")
	public void user_clicks_on_advance_serach_button() {
//	    WebElement advS = driver.findElement(By.xpath("//*[@id=\"gh-f\"]/div[2]/a"));
//	    advS.click();
		pg.advance_serach_in();
	}

	@Then("User able to advance search")
	public void user_able_to_advance_search() {
	    driver.close();
	}

}
