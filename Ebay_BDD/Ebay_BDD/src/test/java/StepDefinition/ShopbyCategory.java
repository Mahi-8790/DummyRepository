package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShopbyCategory {
	WebDriver driver;
	Pageclass pg;
	@Given("ebay home page should be open in default browser")
	public void ebay_home_page_should_be_open_in_default_browser() {
		driver = new ChromeDriver();
		pg = new Pageclass(driver);
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@When("click on shop by category")
	public void click_on_shop_by_category() throws InterruptedException {
//		WebElement sbc = driver.findElement(By.cssSelector("div>button[aria-controls=\"s0-1-4-12-0-1-dialog\"]"));
//		  sbc.click();	
		pg.sbc_in();
	}
	
	@When("click on any category")
	public void click_on_any_category() throws InterruptedException {
//		WebElement men = driver.findElement(By.cssSelector("div>a[href=\"https://www.ebay.com/b/Men/260012/bn_7116419459\"]"));
//		  men.click();
		pg.click_on_category();
		  
		  Thread.sleep(2000);
		
	}

	@Then("User able to shop by category")
	public void user_able_to_shop_by_category() throws InterruptedException {
		driver.close();
		
	}
	
}
