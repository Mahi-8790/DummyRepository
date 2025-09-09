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


public class ChangeLang {
WebDriver driver;
Pageclass pg;
@Given("compulsory ebay home page is open in the default browser")
public void compulsory_ebay_home_page_is_open_in_the_default_browser() {
	driver = new ChromeDriver();
	pg = new Pageclass(driver);
	driver.get("https://www.ebay.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}

@When("User clicks on USA country flag")
public void user_clicks_on_usa_country_flag() throws InterruptedException {
//	  WebElement lan = driver.findElement(By.className("gf-flag__button"));
//	  Thread.sleep(2000);
//	  lan.click();
//	  lan.click();
	Thread.sleep(2000);
	pg.lang_in();
}

@When("User selecting which language to choose by clicking on country flag")
public void user_selecting_which_language_to_choose_by_clicking_on_country_flag() {
//	WebElement au = driver.findElement(By.linkText("Australia"));
//	  au.click();
	pg.select_country();
}

@Then("User able to change language")
public void user_able_to_change_language() {
    driver.close();
}


}
