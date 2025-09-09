package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddtoCart {
	WebDriver driver;
	Pageclass pg;
	@Given("ebay home page is open in the default browser")
	public void ebay_home_page_is_open_in_the_default_browser() {
		driver = new ChromeDriver();
		pg = new Pageclass(driver);
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@When("User serach item in the serachbox")
	public void user_serach_item_in_the_serachbox() throws InterruptedException {
//		WebElement search = driver.findElement(By.id("gh-ac"));
//		  search.click();
//		  search.sendKeys("adidas men Hoops 4.0 Shoes");
//		  search.sendKeys(Keys.ENTER);
		pg.click_search_to_atc();
	}


	@When("new window opens and user clicks on add to cart button")
	public void new_window_opens_and_user_clicks_on_add_to_cart_button() throws InterruptedException {
//		String newurl = driver.getWindowHandle();
//		  
//		  
//		  
//		  Thread.sleep(4000); 
//		 
		pg.handle_window_and_atc();
		  Thread.sleep(3000);
	}

	@Then("User able to add item to cart")
	public void user_able_to_add_item_to_cart() {
	    driver.quit();
	}

}
