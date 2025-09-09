package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

public class AuctionFilter {
	WebDriver driver;
	Pageclass pg;
	@Given("ebay home page is opened in the default browser")
	public void ebay_home_page_is_opened_in_the_default_browser() {
		driver = new ChromeDriver();
		pg = new Pageclass(driver);
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@When("User search item in the search box")
	public void user_search_item_in_the_search_box() throws InterruptedException {
		WebElement sea = driver.findElement(By.id("gh-ac"));
		sea.clear(); 
		sea.sendKeys("samsung galaxy s24 ultra");
		sea.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	@And("user click on the sort filter and click any filter")
	public void user_click_on_the_sort_filter_and_click_any_filter() throws InterruptedException {
		
	    WebElement sort = driver.findElement(By.partialLinkText("Auction"));
	    sort.click();
	  
//	    WebElement end_soon = driver.findElement(By.partialLinkText("Time: ending soonest"));
//	    end_soon.click();	
//	    
	}

	@Then("User able to sort items")
	public void user_able_to_sort_items() {
	    driver.close();
	}

}
