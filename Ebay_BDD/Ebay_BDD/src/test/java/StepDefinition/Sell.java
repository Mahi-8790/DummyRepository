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

public class Sell {
WebDriver driver;
Pageclass pg;
@Given("compulsory ebay home page open in the default browser")
public void compulsory_ebay_home_page_open_in_the_default_browser() {
	driver = new ChromeDriver();
	pg = new Pageclass(driver);
	driver.get("https://www.ebay.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}

@When("User clicks on sell button")
public void user_clicks_on_sell_button() {
//    WebElement sell = driver.findElement(By.xpath("//*[@id=\"gh\"]/nav/div[2]/span/a"));
//    sell.click();
	pg.sell_in();
}

@Then("User gets redirected to sell items")
public void user_gets_redirected_to_sell_items() {
    driver.close();
}
}
