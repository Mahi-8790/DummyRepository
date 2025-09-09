package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Pageclass {
	WebDriver driver;
	By login = By.cssSelector("span>a[_sp=\"m570.l1524\"]");
	By username = By.cssSelector("div > input[id='userid']");
	By cont= By.id("signin-continue-btn");
	By pass = By.cssSelector("div>input[id=\"pass\"]");
	By signin = By.id("sgnBt");
	By search = By.id("gh-ac"); 
	By atc_b = By.id("atcBtn_btn_1");
	By shop_bc = By.cssSelector("div>button[aria-controls=\"s0-1-4-12-0-1-dialog\"]");
	By mens = By.cssSelector("div>a[href=\"https://www.ebay.com/b/Men/260012/bn_7116419459\"]");
	By lang = By.className("gf-flag__button");
	By au = By.linkText("Australia");
	By sball_dropdown = By.className("gh-search-categories");
	By search_but= By.className("gh-search-button__label");
	By icon = By.className("gh-cart__icon");
	By remove = By.xpath("//*[@id=\"mainContent\"]/div/div[2]/div[1]/div[1]/div/ul/li/div/div/div/div[2]/span[2]/button");
	By baby = By.cssSelector("select>option[value=\"2984\"]");
	By advS = By.xpath("//*[@id=\"gh-f\"]/div[2]/a");
	By sell = By.xpath("//*[@id=\"gh\"]/nav/div[2]/span/a");
	public Pageclass(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@Test
	public void username_click()
	{
		driver.findElement(login);
		driver.findElement(login).click();
	}
	
	@Test
	public void username_in()
	{
		driver.findElement(username).click();
		driver.findElement(username).sendKeys("mahi-8790");
	}
	
	@Test
	public void cont_but()
	{
		driver.findElement(cont).click();
	}
	
	@Test
	public void pass_in()
	{
		driver.findElement(pass).click();
		driver.findElement(pass).sendKeys("8919215039@Mk");
	}
	
	@Test
	public void signin_but()
	{
		driver.findElement(signin).click();
	}
	
	@Test
	public void search_in()
	{
			driver.findElement(search);
			driver.findElement(search).click(); 
			driver.findElement(search).sendKeys("Watch");
			driver.findElement(search).sendKeys(Keys.ENTER);
	}
	
	@Test
	public void click_search_to_atc() throws InterruptedException
	{
		  driver.findElement(search);
		  driver.findElement(search).click();
		  driver.findElement(search).sendKeys("adidas men Hoops 4.0 Shoes");
		  driver.findElement(search).sendKeys(Keys.ENTER);
	}
	
	@Test
	public void handle_window_and_atc() throws InterruptedException
	{
		String newurl = driver.getWindowHandle();
		  Thread.sleep(4000); 
		  driver.findElement(By.partialLinkText("Adidas men Hoops 4.0 Shoes - Size 10")).click();
		 
		  
		  for (String window : driver.getWindowHandles()) {
		        if (!window.equals(newurl)) {
		            driver.switchTo().window(window);
		            break;
		        }
		    }
		  driver.findElement(atc_b).click();
	}
	
	@Test
	public void sbc_in()
	{
		driver.findElement(shop_bc).click();
		
	}
	
	@Test
	public void click_on_category()
	{
		driver.findElement(mens).click();
	}
	
	@Test
	public void lang_in() throws InterruptedException
	{	  
		driver.findElement(lang).click();
		Thread.sleep(2000);
		driver.findElement(lang).click();	
	}
	
	@Test
	  public void select_country() {
		driver.findElement(au);
		driver.findElement(au).click();
	  }
	
	
	@Test
	  public void shopallcat_dropdown_click() {
		  driver.findElement(search).clear();
		  driver.findElement(sball_dropdown).click();
	  }
	
	@Test
	  public void shopallcat_category_click() {
		  driver.findElement(baby).click();
		  
		  driver.findElement(search_but).click();
	  
	  }
	
	@Test
	  public void advance_serach_in() {
		driver.findElement(advS).click();
	  }
	
	
	@Test
	  public void sell_in() {
		driver.findElement(sell).click();
	  }
	
	
	
}
