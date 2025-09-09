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

public class Search {
	WebDriver driver;
	Pageclass pg;
@Given("home page should be open in default browser")
public void home_page_should_be_open_in_default_browser() {
	driver = new ChromeDriver();
	pg = new Pageclass(driver);
	driver.get("https://www.ebay.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}

@When("click on searchbox and type something and hit ENTER key")
public void click_on_searchbox_and_type_something_and_hit_enter_key() {
//	WebElement sea = driver.findElement(By.id("gh-ac"));
//	sea.clear(); 
//	sea.sendKeys("Watch");
//	sea.sendKeys(Keys.ENTER);
	pg.search_in();
	
}


@Then("User should be able to search")
public void user_should_be_able_to_search() {
   driver.close();
}
}
