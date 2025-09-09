package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AllCategory {
	WebDriver driver;
	Pageclass pg;
	@Given("ebay home page should be open in the default browser")
	public void ebay_home_page_should_be_open_in_the_default_browser() {
		driver = new ChromeDriver();
		pg = new Pageclass(driver);
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@When("click on All categories")
	public void click_on_all_categories() {
//		WebElement sball = driver.findElement(By.className("gh-search-categories"));
//		  sball.click();
		pg.shopallcat_dropdown_click();
	}

	@When("select any category")
	public void select_any_category() {
//		WebElement baby = driver.findElement(By.cssSelector("select>option[value=\"2984\"]"));
//		  baby.click();
//		  
//		  driver.findElement(By.className("gh-search-button__label")).click();
		pg.shopallcat_category_click();
	}

	@Then("User able to shop by all category")
	public void user_able_to_shop_by_all_category() {
	    driver.close();	}

}
